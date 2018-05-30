package libcoll.libcollections;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LibCollDBInterface {

    private static LibCollDBHelper dbHelper;
    private static SQLiteDatabase db;

    public LibCollDBInterface(Context context) {
        dbHelper = new LibCollDBHelper(
            context,"LibCollections.db",
            null, 1);
        db =  dbHelper.getWritableDatabase();
    }

    public static boolean categoryExists (String name) {
        if (name == null) name = "";
        Cursor cursor = db.rawQuery(
            "SELECT * FROM category WHERE name = ?",
            new String[] {name}
        );
        if (cursor.moveToFirst()) return true;
        return false;
    }

    public static boolean addCategory(String name) {
        if (categoryExists(name)) return false;
        db.execSQL(
            "INSERT INTO category (name) VALUES (?)",
            new String[] {name}
        );
        return true;
    }

    public static boolean bookExists (String input) {
        if (input == null) input = "";
        Cursor cursor = db.rawQuery(
                "SELECT * FROM book WHERE isbn = ? OR title = ?",
            new String[] {input, input}
        );
        if (cursor.moveToFirst()) return true;
        return false;
    }

    public static boolean addBook(String isbn, String title, String press) {
        if (isbn == null || bookExists(isbn)) return false;
        new Thread(() -> {
            try {
                String url = "https://projects.kingsleyxie.cn/book_location_api.php" +
                    "?title=" + title + "&press=" + press;
                OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .writeTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(1, TimeUnit.MINUTES)
                    .build();
                Request request = new Request.Builder()
                    .url(url)
                    .build();
                Response response = client.newCall(request).execute();

                Gson gson = new Gson();
                BookLocation bl = gson.fromJson(
                    response.body().string(), BookLocation.class
                );

                if (!bl.isOk()) {
                    bl.setCallno("非图书馆藏书");
                    bl.setLocation("暂无该书位置信息");
                }

                db.execSQL(
                    "INSERT INTO book (isbn, title, callno, location) VALUES (?, ?, ?, ?)",
                    new String[] {isbn, title, bl.getCallno(), bl.getLocation()}
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        return true;
    }

    public static boolean remarkBook(String input, String remark) {
        if (input == null) input = "";
        if (remark == null) remark = "";
        if (!bookExists(input)) return false;

        db.execSQL(
            "UPDATE book SET remark = ? WHERE isbn = ? OR title = ?",
            new String[] {remark, input, input}
        );
        return true;
    }

    public static boolean categoryBook(String book_isbn, String category_name) {
        Cursor cursor = db.rawQuery(
            "SELECT * " +
                "FROM book_category " +
                "WHERE book_id = (SELECT id FROM book WHERE isbn = ?) " +
                "AND category_id = (SELECT id FROM category WHERE name = ?)",
            new String[] {book_isbn, category_name}
        );
        if (cursor.moveToFirst()
            || !bookExists(book_isbn)
            || !categoryExists(category_name))
            return false;

        db.execSQL(
            "INSERT INTO book_category(book_id, category_id) " +
                "VALUES (" +
                    "(SELECT id FROM book WHERE isbn = ?), " +
                    "(SELECT id FROM category WHERE name = ?)" +
                ")",
            new String[] {book_isbn, category_name}
        );
        return true;
    }

    public static ArrayList<String> getCategories() {
        Cursor cursor = db.rawQuery(
            "SELECT * FROM category", null
        );

        ArrayList<String> categories = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                categories.add(
                    cursor.getString(cursor.getColumnIndex("name"))
                );
            } while (cursor.moveToNext());
            cursor.close();
        }
        return categories;
    }

    public static ArrayList<StoredBook> getBooks() {
        Cursor cursor = db.rawQuery(
            "SELECT * FROM book", null
        );

        ArrayList<StoredBook> books = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                books.add(new StoredBook(cursor));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return books;
    }

    public static ArrayList<StoredBook> getBooksByCategory(String name) {
        Cursor cursor = db.rawQuery(
            "SELECT * FROM book " +
                "JOIN book_category " +
                "ON book_id = book.id " +
                "AND category_id = category.id " +
                "AND category.name = ?",
            new String[] {name}
        );

        ArrayList<StoredBook> books = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                books.add(new StoredBook(cursor));
            } while (cursor.moveToNext());
            cursor.close();
        }
        return books;
    }

    public static StoredBook getBookByISBN(String isbn) {
        if (isbn == null) isbn = "";
        Cursor cursor = db.rawQuery(
            "SELECT * FROM book WHERE isbn = ?",
            new String[] {isbn}
        );

        StoredBook book = null;
        if (cursor.moveToFirst()) {
            book = new StoredBook(cursor);
            cursor.close();
        }
        return book;
    }
}
