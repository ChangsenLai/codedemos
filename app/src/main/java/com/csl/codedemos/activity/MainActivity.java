package com.csl.codedemos.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.csl.codedemos.R;
import com.csl.codedemos.activity.coordingtorlayout.CoordingtorMainActivity;
import com.csl.codedemos.common.User;
import com.csl.codedemos.databinding.ActivityMainBinding;
import com.csl.codedemos.gson.GsonConvert;
import com.google.gson.reflect.TypeToken;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dataBinding.setEvent(new Event());
        RecyclerViewActivity.start(this);
        fromJson();
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
    }

    private void fromJson() {
        String data = "";
        User o = GsonConvert.newInstance().fromJson(data, new TypeToken<User>() {
        }.getType());
        Log.i("MainActivity", o.toString());
    }

    private void toIconViewActivity() {
        IconViewActivity.toActivity(this);
    }

    public void testFragment() {
        FragmentActivity.start(MainActivity.this, FragmentActivity.TYPE_HOME);
    }


}
































