package libcoll.libcollections;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import libcoll.libcollections.LibCollDBHelper;

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
}
