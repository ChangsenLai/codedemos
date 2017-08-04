package com.csl.codedemos.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by laichangsen on 2017/4/28.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindLayout(getLayoutRes());
        init();
    }

    private void bindLayout(int layoutRes) {
        if (layoutRes > 0) {
            setContentView(layoutRes);
            ButterKnife.bind(this);
        }
    }

    protected abstract int getLayoutRes();

    protected abstract void init();
}
