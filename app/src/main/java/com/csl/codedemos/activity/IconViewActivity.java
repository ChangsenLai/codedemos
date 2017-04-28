package com.csl.codedemos.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.csl.codedemos.R;

/**
 * Created by laichangsen on 2017/4/27.
 */

public class IconViewActivity extends BaseActivity {

    public static void toActivity(Context context) {
        Intent intent = new Intent(context, IconViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_view);
    }
}
