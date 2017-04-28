package com.csl.codedemos.activity.coordingtorlayout;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;

import com.csl.codedemos.R;
import com.csl.codedemos.activity.BaseActivity;
import com.csl.codedemos.databinding.ActivityCoordingtorMainBinding;

import static android.support.design.widget.Snackbar.LENGTH_SHORT;

/**
 * Created by laichangsen on 2017/4/28.
 *
 */

public class CoordingtorMainActivity extends BaseActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, CoordingtorMainActivity.class);
        context.startActivity(intent);
    }

    private ActivityCoordingtorMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coordingtor_main);
        showSnackbar();
    }

    public class Event {
        public void testBase() {

        }
    }

    private void showSnackbar() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Snackbar.make(binding.fab, "this is snackbar", LENGTH_SHORT).show();
            }
        }, 500L);
    }
}
