package libcoll.libcollections;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.text.TextUtils.isEmpty;

public class LibCollDBInterfaces {
    private LibCollDBHelper dbHelper;
    private SQLiteDatabase db;

    public LibCollDBInterfaces(Context context) {
        dbHelper = new LibCollDBHelper(context, "LibCollections.db",
                null, 1);
        db =  dbHelper.getWritableDatabase();
    }

    public boolean categoryExists (String name) {
        Cursor cursor = db.rawQuery(
            "SELECT * FROM category WHERE name = ?", new String[] {name}
        );
        if (cursor.moveToFirst()) return true;
        return false;
    }

    public boolean addCategory(String name) {
        if (categoryExists(name)) return false;
        db.execSQL(
            "INSERT INTO category (name) VALUES (?)", new String[] {name}
        );
        return true;
    }

    public boolean bookExists (String isbn) {
        Cursor cursor = db.rawQuery(
                "SELECT * FROM book WHERE isbn = ?", new String[] {isbn}
        );
        if (cursor.moveToFirst()) return true;
        return false;
    }

    public boolean addBook(String isbn) {
        if (bookExists(isbn)) return false;

        new Thread(() -> {
            try {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                    .url("https://projects.kingsleyxie.cn/book_location_api.php?isbn=" + isbn)
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
                    "INSERT INTO book (isbn, callno, location) VALUES (?, ?, ?)",
                    new String[] {isbn, bl.getCallno(), bl.getLocation()}
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        return true;
    }

    public boolean remarkBook(String isbn, String remark) {
        if (!bookExists(isbn)) return false;

        db.execSQL(
            "UPDATE book SET remark = ? WHERE isbn = ?",
            new String[] {remark, isbn}
        );
        return true;
    }

    public boolean categoryBook(String book_isbn, String category_name) {
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
}
