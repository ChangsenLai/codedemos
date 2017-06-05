package com.csl.codedemos.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.csl.codedemos.R;
import com.csl.codedemos.activity.coordingtorlayout.CoordingtorMainActivity;
import com.csl.codedemos.databinding.ActivityMainBinding;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dataBinding.setEvent(new Event());
        init();
    }

    private void init() {
    }

    public class Event {
        public void testDrawableTextViewActivity() {
            DrawableTextViewActivity.toActivity(MainActivity.this);
        }

        public void testIconView() {
            IconViewActivity.toActivity(MainActivity.this);
        }

        public void testCoordingtorLayout() {
            CoordingtorMainActivity.start(MainActivity.this);
        }

        public void testFragment() {
            FragmentActivity.start(MainActivity.this, FragmentActivity.TYPE_HOME);
        }
    }


}
































