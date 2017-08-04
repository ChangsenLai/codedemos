package com.csl.codedemos.activity;

import com.csl.codedemos.glide.GlideActivity;


public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutRes() {
        return 0;
    }

    @Override
    protected void init() {
        toGlide();
    }

    public void toGlide() {
        GlideActivity.start(this);
    }


}
































