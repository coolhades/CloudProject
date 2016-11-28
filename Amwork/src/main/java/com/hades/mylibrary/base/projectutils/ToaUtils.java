package com.hades.mylibrary.base.projectutils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Hades on 16/9/27.
 */

public class ToaUtils {
    private static Toast toast = null;

    public static void showTextToast(int msg, Context context) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    public static void showTextToast(String msg, Context context) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

}
