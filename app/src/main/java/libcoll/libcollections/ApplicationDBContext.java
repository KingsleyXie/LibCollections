package libcoll.libcollections;

import android.app.Application;
import android.content.Context;

public class ApplicationDBContext extends Application {
    private static ApplicationDBContext instance;

    public ApplicationDBContext()
    {
        instance = this;
    }

    public static Context getContext() {
        return instance;
    }
}
