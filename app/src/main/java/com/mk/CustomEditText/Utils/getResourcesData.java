package com.mk.CustomEditText.Utils;

import android.content.Context;
import android.util.Log;

/**
 * Created by user on 6/27/2017.
 */

public class getResourcesData {

    public static String getString(Context context, int id) {
        try {
            return context.getString(id);
        } catch (Exception e) {
            Log.e(context.getClass().getSimpleName(), e.getMessage());
        }
        return "";
    }
}
