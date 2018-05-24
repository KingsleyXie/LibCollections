package libcoll.libcollections;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class LibCollDBHelper extends SQLiteOpenHelper {
    private static final String CREATE_CATEGORY =
    "CREATE TABLE IF NOT EXISTS category (" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "name NVARCHAR(60) NOT NULL," +
        "remark NVARCHAR(60) NOT NULL" +
    ")";

    private static final String CREATE_TAG =
    "CREATE TABLE IF NOT EXISTS tag (" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "name NVARCHAR(60) NOT NULL," +
        "remark NVARCHAR(60) NOT NULL" +
    ")";

    private static final String CREATE_BOOK =
    "CREATE TABLE IF NOT EXISTS book (" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "isbn NVARCHAR(15) UNIQUE DEFAULT NULL," +
        "title NVARCHAR(60) NOT NULL," +
        "author NVARCHAR(60) NOT NULL," +
        "publisher NVARCHAR(60) NOT NULL," +
        "pubdate NVARCHAR(15) NOT NULL," +
        "category INTEGER NOT NULL," +
        "cover NVARCHAR(100)," +
        "FOREIGN KEY (category) REFERENCES category(id)" +
    ")";

    private static final String CREATE_BOOK_TAG =
    "CREATE TABLE IF NOT EXISTS book_tag (" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "book_id INTEGER NOT NULL," +
        "tag_id INTEGER NOT NULL," +
        "FOREIGN KEY (book_id) REFERENCES book(id)," +
        "FOREIGN KEY (tag_id) REFERENCES tag(id)" +
    ")";

    private Context cont;

    public LibCollDBHelper(Context context, String name,
                           SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        cont = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CATEGORY);
        db.execSQL(CREATE_TAG);
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_BOOK_TAG);

        Toast.makeText(cont, "Database Tables Created", Toast.LENGTH_SHORT).show();
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(cont, "Droping Existing Database Tables",
                Toast.LENGTH_SHORT).show();

        db.execSQL("DROP TABLE IF EXISTS category");
        db.execSQL("DROP TABLE IF EXISTS tag");
        db.execSQL("DROP TABLE IF EXISTS book");
        db.execSQL("DROP TABLE IF EXISTS book_tag");
        onCreate(db);
    }
}
