package libcoll.libcollections;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class LibCollDBHelper extends SQLiteOpenHelper {
    private static final String CREATE_BOOK =
    "CREATE TABLE IF NOT EXISTS book (" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "isbn TEXT UNIQUE NOT NULL," +
        "callno TEXT NOT NULL," +
        "location TEXT NOT NULL," +
        "remark TEXT DEFAULT NULL" +
    ")";

    private static final String CREATE_CATEGORY =
    "CREATE TABLE IF NOT EXISTS category (" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "name TEXT UNIQUE NOT NULL" +
    ")";

    private static final String CREATE_BOOK_CATEGORY =
    "CREATE TABLE IF NOT EXISTS book_category (" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "book_id INTEGER NOT NULL," +
        "category_id INTEGER NOT NULL," +
        "FOREIGN KEY (book_id) REFERENCES book(id)," +
        "FOREIGN KEY (category_id) REFERENCES category(id)" +
    ")";

    private Context cont;

    public LibCollDBHelper(Context context, String name,
                           SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        cont = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        db.execSQL(CREATE_BOOK_CATEGORY);

        Toast.makeText(cont, "Database Tables Created Successfully!",
            Toast.LENGTH_SHORT).show();
    }

    public void onUpgrade(SQLiteDatabase db,
        int oldVersion, int newVersion) {
        Toast.makeText(cont, "Dropping Existing Database Tables",
                Toast.LENGTH_SHORT).show();

        db.execSQL("DROP TABLE IF EXISTS book");
        db.execSQL("DROP TABLE IF EXISTS category");
        db.execSQL("DROP TABLE IF EXISTS book_category");

        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db,
                          int oldVersion, int newVersion) {
        Toast.makeText(cont, "Dropping Existing Database Tables",
            Toast.LENGTH_SHORT).show();

        db.execSQL("DROP TABLE IF EXISTS book");
        db.execSQL("DROP TABLE IF EXISTS category");
        db.execSQL("DROP TABLE IF EXISTS book_category");

        onCreate(db);
    }
}
