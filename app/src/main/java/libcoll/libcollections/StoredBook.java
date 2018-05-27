package libcoll.libcollections;

import android.database.Cursor;

public class StoredBook {
    public int id;
    public String isbn;
    public String title;
    public String callno;
    public String location;
    public String remark;

    public StoredBook(Cursor cursor) {
        id = cursor.getInt(cursor.getColumnIndex("id"));
        isbn = escapeNull(
            cursor.getString(cursor.getColumnIndex("isbn"))
        );
        title = escapeNull(
            cursor.getString(cursor.getColumnIndex("title"))
        );
        callno = escapeNull(
            cursor.getString(cursor.getColumnIndex("callno"))
        );
        location = escapeNull(
            cursor.getString(cursor.getColumnIndex("location"))
        );
        remark = escapeNull(
            cursor.getString(cursor.getColumnIndex("remark"))
        );
    }

    public String escapeNull(String s) {
        if (s == null) return "";
        return s;
    }
}
