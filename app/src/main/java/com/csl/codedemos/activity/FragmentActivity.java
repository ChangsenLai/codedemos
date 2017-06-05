package com.csl.codedemos.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.csl.codedemos.R;
import com.csl.codedemos.ui.fragment.HomeFragment;
import com.csl.codedemos.ui.fragment.NextFragment;

/**
 * author:ChangsenLai | time:2017/6/5
 */

public class FragmentActivity extends BaseActivity {

    private static final String KEY_TYPE = "KEY_TYPE";

    public static final int TYPE_HOME = 1;
    public static final int TYPE_NEXT = 2;

    private Fragment fragment;

    public static void start(Context context, int type) {
        Intent intent = new Intent(context, FragmentActivity.class);
        intent.putExtra(KEY_TYPE, type);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        renderFragment();
    }

    private void renderFragment() {
        switch (getIntent().getIntExtra(KEY_TYPE, 0)) {
            case TYPE_HOME:
                fragment = new HomeFragment();
                break;
            case TYPE_NEXT:
                fragment = new NextFragment();
                break;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_layout, fragment);
        transaction.commit();
    }
}


















