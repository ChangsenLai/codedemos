package com.csl.codedemos.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.csl.codedemos.R;
import com.csl.codedemos.util.ScreenUtil;

/**
 * Created by laichangsen on 2017/4/27.
 */

public class IconView extends FrameLayout {

    private ImageView imageView;
    private TextView textView;
    private Context mContext;

    public IconView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IconView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;
        View rootView = LayoutInflater.from(context).inflate(R.layout.icon_view, this);
        this.imageView = (ImageView) rootView.findViewById(R.id.image);
        this.textView = (TextView) rootView.findViewById(R.id.text);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.IconView);
        initText(typedArray);
        initImageView(typedArray);
        typedArray.recycle();
    }

    private void initImageView(TypedArray typedArray) {
        Drawable drawable = typedArray.getDrawable(R.styleable.IconView_image);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        int imageWidth = typedArray.getDimensionPixelOffset(R.styleable.IconView_image_width, 0);
        int imageHeight = typedArray.getDimensionPixelOffset(R.styleable.IconView_image_height, 0);
        if (imageWidth != 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = imageWidth;
            imageView.setLayoutParams(layoutParams);
        }
        if (imageHeight != 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.height = imageHeight;
            imageView.setLayoutParams(layoutParams);
        }
        // todo scaleType
    }

    private void initText(TypedArray typedArray) {
        int marginTop = typedArray.getDimensionPixelOffset((R.styleable.IconView_text_marginTop), 0);
        if (marginTop > 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.topMargin = marginTop;
            textView.setLayoutParams(layoutParams);
        }
        textView.setText(typedArray.getString(R.styleable.IconView_text));
        int textSize = typedArray.getDimensionPixelOffset(R.styleable.IconView_text_size, 0);
        if (textSize != 0) {
            textView.setTextSize(ScreenUtil.px2sp(mContext, textSize));
        }
        int textColor = typedArray.getColor(R.styleable.IconView_text_color, -1);
        if (textColor != -1) {
            textView.setTextColor(textColor);
        }
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTextView() {
        return textView;
    }
}


























