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
        "title TEXT NOT NULL," +
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

        db.execSQL("INSERT INTO category(name) VALUES('互联网')");
        db.execSQL("INSERT INTO category(name) VALUES('数据库')");
        db.execSQL("INSERT INTO category(name) VALUES('设计模式')");
        db.execSQL("INSERT INTO category(name) VALUES('计算机')");
        db.execSQL("INSERT INTO category(name) VALUES('科普')");
        db.execSQL("INSERT INTO category(name) VALUES('随笔')");
        db.execSQL("INSERT INTO category(name) VALUES('散文')");
        db.execSQL("INSERT INTO category(name) VALUES('爱情')");
        db.execSQL("INSERT INTO category(name) VALUES('哲学')");

        Toast.makeText(cont, "已成功初始化数据库",
            Toast.LENGTH_SHORT).show();
    }

    public void onUpgrade(SQLiteDatabase db,
        int oldVersion, int newVersion) {
        Toast.makeText(cont, "删库跑路中......",
                Toast.LENGTH_SHORT).show();

        db.execSQL("DROP TABLE IF EXISTS book");
        db.execSQL("DROP TABLE IF EXISTS category");
        db.execSQL("DROP TABLE IF EXISTS book_category");

        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db,
                          int oldVersion, int newVersion) {
        Toast.makeText(cont, "删库跑路中......",
            Toast.LENGTH_SHORT).show();

        db.execSQL("DROP TABLE IF EXISTS book");
        db.execSQL("DROP TABLE IF EXISTS category");
        db.execSQL("DROP TABLE IF EXISTS book_category");

        onCreate(db);
    }
}
