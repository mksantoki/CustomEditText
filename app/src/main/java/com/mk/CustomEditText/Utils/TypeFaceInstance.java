package com.mk.CustomEditText.Utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import com.mk.CustomEditText.R;

/**
 * Created by user on 6/27/2017.
 */

public class TypeFaceInstance {
    private static Context context;
    public static Typeface regularFont, boldFont, lightFont;


    public TypeFaceInstance(Context c) {
        if (context == null) {
            this.context = c;
            Log.e(context.getClass().getSimpleName(),"fonts/" + getResourcesData.getString(context, R.string.regularFont));
            regularFont = Typeface.createFromAsset(context.getAssets(), "fonts/" + getResourcesData.getString(context, R.string.regularFont));
            boldFont = Typeface.createFromAsset(context.getAssets(), "fonts/" + getResourcesData.getString(context, R.string.boldFont));
            lightFont = Typeface.createFromAsset(context.getAssets(), "fonts/" + getResourcesData.getString(context, R.string.lightFont));
        }
    }

    public static Typeface getRegularFont(Context context) {
        if (regularFont == null) {
            new TypeFaceInstance(context);
        }
        return regularFont;
    }

    public static Typeface getBoldFont(Context context) {
        if (regularFont == null) {
            new TypeFaceInstance(context);
        }
        return boldFont;
    }

    public static Typeface getLightFont(Context context) {
        if (regularFont == null) {
            new TypeFaceInstance(context);
        }
        return lightFont;
    }
}
