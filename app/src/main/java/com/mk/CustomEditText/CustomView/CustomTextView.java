package com.mk.CustomEditText.CustomView;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.mk.CustomEditText.R;
import com.mk.CustomEditText.Utils.TypeFaceInstance;

import static com.mk.CustomEditText.Utils.GradientDrawable.setDrawableBackGround;

/**
 * Created by user on 6/27/2017.
 */

public class CustomTextView extends AppCompatTextView implements CustomTextViewHandler {
    private Context context;
    private TypedArray typedArray;

    private int txtDeafultBgColor;
    private int txtPressBgColor;
    private int txtBorderColor;
    private int txtBorderStroke;

    private float txtLeftTopRadius;
    private float txtRightTopRadius;
    private float txtRightBottomRadius;
    private float txtLeftBottomRadius;

    private int txtDeafultTxtColor;
    private int txtPressTxtColor;
    private int txtTypeface;

    private StateListDrawable states;

    public static final int FONT_REGULAR = 0;
    public static final int FONT_BOLD = 1;
    public static final int FONT_LIGHT = 2;

    public CustomTextView(Context context) {
        super(context);
        this.context = context;
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    @Override
    public void init(Context context, AttributeSet attrs) {
        this.context = context;

        typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomTextView,
                0, 0);

        intiValues();
        updateTextTypeFace();
        updateCustomTextColor();
        updateBackGroundStates();
    }

    @Override
    public void intiValues() {
        txtDeafultBgColor = typedArray.getColor(R.styleable.CustomTextView_txtDeafultBgColor, 0);
        txtPressBgColor = typedArray.getColor(R.styleable.CustomTextView_txtPressBgColor, 0);
        txtBorderColor = typedArray.getColor(R.styleable.CustomTextView_txtBorderColor, 0);
        txtBorderStroke = typedArray.getInt(R.styleable.CustomTextView_txtBorderStroke, 0);
        txtDeafultTxtColor = typedArray.getColor(R.styleable.CustomTextView_txtDeafultTxtColor, 0);
        txtPressTxtColor = typedArray.getColor(R.styleable.CustomTextView_txtPressTxtColor, 0);
        txtBorderColor = typedArray.getColor(R.styleable.CustomTextView_txtBorderColor, 0);
        txtLeftTopRadius = typedArray.getDimension(R.styleable.CustomTextView_txtLeftTopRadius, 0);
        txtRightTopRadius = typedArray.getDimension(R.styleable.CustomTextView_txtRightTopRadius, 0);
        txtRightBottomRadius = typedArray.getDimension(R.styleable.CustomTextView_txtRightBottomRadius, 0);
        txtLeftBottomRadius = typedArray.getDimension(R.styleable.CustomTextView_txtLeftBottomRadius, 0);
        txtTypeface = typedArray.getInt(R.styleable.CustomTextView_txtTypeface, 0);
    }

    @Override
    public void updateTextTypeFace() {
        if (txtTypeface == FONT_BOLD) {
            setTypeface(TypeFaceInstance.getBoldFont(context));
        } else if (txtTypeface == FONT_LIGHT) {
            setTypeface(TypeFaceInstance.getLightFont(context));
        } else {
            setTypeface(TypeFaceInstance.getRegularFont(context));
        }
    }

    @Override
    public CustomTextView updateCustomTextColor() {
        int[][] colorStates = new int[][]{
                new int[]{}, // enabled
                new int[]{android.R.attr.state_pressed}  // pressed
        };
        int[] colors = new int[]{
                txtDeafultTxtColor, txtPressTxtColor
        };

        ColorStateList colorStateList = new ColorStateList(colorStates, colors);
        setTextColor(colorStateList);
        return this;
    }

    @Override
    public CustomTextView updateBackGroundStates() {
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[]{android.R.attr.state_pressed}, setDrawableBackGround(txtPressBgColor, txtBorderColor, txtBorderStroke, txtLeftTopRadius, txtRightTopRadius, txtRightBottomRadius, txtLeftBottomRadius));
        states.addState(new int[]{android.R.attr.state_selected}, setDrawableBackGround(txtPressBgColor, txtBorderColor, txtBorderStroke, txtLeftTopRadius, txtRightTopRadius, txtRightBottomRadius, txtLeftBottomRadius));
        states.addState(new int[]{}, setDrawableBackGround(txtDeafultBgColor, txtBorderColor, txtBorderStroke, txtLeftTopRadius, txtRightTopRadius, txtRightBottomRadius, txtLeftBottomRadius));
        setBackground(states);
        return this;
    }

    public CustomTextView setTxtDeafultBgColor(int txtDeafultBgColor) {
        this.txtDeafultBgColor = txtDeafultBgColor;
        return this;
    }

    public CustomTextView setTxtPressBgColor(int txtPressBgColor) {
        this.txtPressBgColor = txtPressBgColor;
        return this;
    }

    public CustomTextView setTxtBorderColor(int txtBorderColor) {
        this.txtBorderColor = txtBorderColor;
        return this;
    }

    public CustomTextView setTxtBorderStroke(int txtBorderStroke) {
        this.txtBorderStroke = txtBorderStroke;
        return this;
    }

    public CustomTextView setTxtLeftTopRadius(float txtLeftTopRadius) {
        this.txtLeftTopRadius = txtLeftTopRadius;
        return this;
    }

    public CustomTextView setTxtRightTopRadius(float txtRightTopRadius) {
        this.txtRightTopRadius = txtRightTopRadius;
        return this;
    }

    public CustomTextView setTxtRightBottomRadius(float txtRightBottomRadius) {
        this.txtRightBottomRadius = txtRightBottomRadius;
        return this;
    }

    public CustomTextView setTxtLeftBottomRadius(float txtLeftBottomRadius) {
        this.txtLeftBottomRadius = txtLeftBottomRadius;
        return this;
    }

    public CustomTextView setTxtDeafultTxtColor(int txtDeafultTxtColor) {
        this.txtDeafultTxtColor = txtDeafultTxtColor;
        return this;
    }

    public CustomTextView setTxtPressTxtColor(int txtPressTxtColor) {
        this.txtPressTxtColor = txtPressTxtColor;
        return this;
    }

    public CustomTextView setTxtTypeface(int txtTypeface) {
        this.txtTypeface = txtTypeface;
        return this;
    }
}
