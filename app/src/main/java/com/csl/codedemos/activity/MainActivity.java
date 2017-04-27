package com.csl.codedemos.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.csl.codedemos.R;
import com.csl.codedemos.databinding.ActivityMainBinding;
import com.csl.codedemos.view.CoordingtorLayoutActivity;

/**
 * Created by ChangsenLai on 2017/4/21.
 *
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dataBinding.setEvent(new Event());
    }

    public class Event {
        public void testDrawableTextViewActivity() {
            toDrawableTextViewActivity();
        }
        public void testIconView() {
            toIconViewActivity();
        }
        public void testCoordingtorLayout() {
            toCoordingtorLayoutActivity();
        }
    }

    private void toIconViewActivity() {
        IconViewActivity.toActivity(this);
    }

    private void init() {
    }

    private void toDrawableTextViewActivity() {
        DrawableTextViewActivity.toActivity(this);
    }

    private void toCoordingtorLayoutActivity() {
        CoordingtorLayoutActivity.start(this);
    }



}
































