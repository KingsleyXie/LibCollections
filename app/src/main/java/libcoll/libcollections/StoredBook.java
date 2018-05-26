package libcoll.libcollections;

import android.database.Cursor;

public class StoredBook {
    public int id;
    public String isbn;
    public String callno;
    public String location;
    public String remark;

    public StoredBook(Cursor cursor) {
        id = cursor.getInt(cursor.getColumnIndex("id"));
        isbn = cursor.getString(cursor.getColumnIndex("isbn"));
        callno = cursor.getString(cursor.getColumnIndex("callno"));
        location = cursor.getString(cursor.getColumnIndex("location"));
        remark = cursor.getString(cursor.getColumnIndex("remark"));
    }
}
