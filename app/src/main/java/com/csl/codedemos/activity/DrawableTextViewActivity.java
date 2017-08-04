package com.csl.codedemos.activity;

import android.content.Context;
import android.content.Intent;

import com.csl.codedemos.R;

/**
 * Created by laichangsen on 2017/4/27.
 */

public class DrawableTextViewActivity extends BaseActivity {

    public static void toActivity(Context context) {
        Intent intent = new Intent(context, DrawableTextViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_drawable_textview;
    }

    @Override
    protected void init() {

    }
}
