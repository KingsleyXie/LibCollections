package libcoll.libcollections;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LibCollDBInterfaces {
    private LibCollDBHelper dbHelper;
    private SQLiteDatabase db;

    public LibCollDBInterfaces(Context context) {
        dbHelper = new LibCollDBHelper(context, "LibCollections.db",
                null, 1);
        db =  dbHelper.getWritableDatabase();
    }

    public boolean categoryDuplicates (String name) {
        Cursor cursor = db.rawQuery(
            "SELECT * FROM category WHERE name = ?", new String[] {name}
        );
        if (cursor.moveToFirst()) return true;
        return false;
    }

    public boolean addCategory(String name) {
        if (categoryDuplicates(name)) return false;
        db.execSQL(
            "INSERT INTO category (name) VALUES (?)", new String[] {name}
        );
        return true;
    }

    public boolean bookDuplicates (String isbn) {
        Cursor cursor = db.rawQuery(
                "SELECT * FROM book WHERE isbn = ?", new String[] {isbn}
        );
        if (cursor.moveToFirst()) return true;
        return false;
    }

    public boolean addBook(String isbn) {
        if (bookDuplicates(isbn)) return false;

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
                Log.d("book ok", bl.isOk() ? "OK" : "NOPE");
                Log.d("book callno", bl.getCallno());
                Log.d("book location", bl.getLocation());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

//        db.execSQL(
//                "INSERT INTO book (isbn) VALUES (?)", new String[] {isbn}
//        );
        return true;
    }
}
