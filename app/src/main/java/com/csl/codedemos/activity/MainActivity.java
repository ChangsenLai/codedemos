package com.csl.codedemos.activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by ChangsenLai on 2017/4/21.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        testDrawableTextView();
    }

    private void init() {
    }

    private void test() {
    }

    private void testDrawableTextView() {
        DrawableTextViewActivity.toActivity(this);
    }



}
































