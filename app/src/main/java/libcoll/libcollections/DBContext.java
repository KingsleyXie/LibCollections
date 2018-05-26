package libcoll.libcollections;

import android.content.Context;

public class DBContext {
    private static Context ctx;

    public static Context getCtx() {
        return ctx;
    }

    public static void setCtx(Context c) {
        ctx = c;
    }
}
