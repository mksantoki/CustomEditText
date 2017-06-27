package com.mk.CustomEditText.CustomView;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by user on 6/27/2017.
 */

public abstract interface CustomTextViewHandler {

    void init(Context context, AttributeSet attrs);

    void intiValues();

    void updateTextTypeFace();

    CustomTextView updateCustomTextColor();

    CustomTextView updateBackGroundStates();
}
