package com.csl.codedemos.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.csl.codedemos.R;
import com.csl.codedemos.util.ScreenUtil;

/**
 * Created by laichangsen on 2017/4/27.
 * 带可控图片大小的textview
 */

public class DrawableTextView extends android.support.v7.widget.AppCompatTextView {

    private Context mContext;
    private Drawable topDrawable, bottomDrawable, leftDrawable , rightDrawable;
    private int drawableWithPx, drawableHeightPx;
    private static final int DEFAULT_SIZE = 50;

    public DrawableTextView(Context context) {
        this(context, null);
    }

    public DrawableTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawableTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs) {
        this.mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DrawableTextView);
        this.topDrawable = typedArray.getDrawable(R.styleable.DrawableTextView_top_drawable);
        this.bottomDrawable = typedArray.getDrawable(R.styleable.DrawableTextView_bottom_drawable);
        this.leftDrawable = typedArray.getDrawable(R.styleable.DrawableTextView_left_drawable);
        this.rightDrawable = typedArray.getDrawable(R.styleable.DrawableTextView_right_drawable);
        drawableWithPx = typedArray.getDimensionPixelOffset(R.styleable.DrawableTextView_drawable_width , getDefaultWidth(context));
        drawableHeightPx = typedArray.getDimensionPixelOffset(R.styleable.DrawableTextView_drawable_height ,getDefaultHeight(context));
        typedArray.recycle();
    }

    private int getDefaultWidth(Context context) {
        return ScreenUtil.dip2px(context, DEFAULT_SIZE);
    }

    private int getDefaultHeight(Context context) {
        return ScreenUtil.dip2px(context, DEFAULT_SIZE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setDrawableBounds(topDrawable);
        setDrawableBounds(bottomDrawable);
        setDrawableBounds(leftDrawable);
        setDrawableBounds(rightDrawable);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.setCompoundDrawables(leftDrawable, topDrawable, rightDrawable, bottomDrawable);
    }

    private void setDrawableBounds(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, drawableWithPx, drawableHeightPx);
        }
    }

//    /**
//     * 设置右侧图片并重绘
//     */
//    public void setDrawableTop(int drawableTopRes) {
//        this.topDrawable = mContext.getResources().getDrawable(drawableTopRes);
//        invalidate();
//    }
}





























