package com.hymane.materialhome.utils.common;

import android.widget.Toast;

import com.hymane.materialhome.BaseApplication;

public class ToastUtils {
    public static void showShort(String msg) {
        Toast.makeText(BaseApplication.getApplication(), msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(String msg) {
        Toast.makeText(BaseApplication.getApplication(), msg, Toast.LENGTH_LONG).show();
    }
}
