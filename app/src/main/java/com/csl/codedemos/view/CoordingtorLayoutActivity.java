package com.csl.codedemos.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.csl.codedemos.R;
import com.csl.codedemos.adapter.CoordingtorRecyclerAdapter;
import com.csl.codedemos.databinding.ActivityCoordingtorlayoutBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChangsenLai on 2017/4/26.
 */

public class CoordingtorLayoutActivity extends Activity {

    public static void start(Context context) {
        Intent intent = new Intent(context, CoordingtorLayoutActivity.class);
        context.startActivity(intent);
    }

    private ActivityCoordingtorlayoutBinding binding;
    private List<String> datas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coordingtorlayout);
        initDatas();
        initRecyclerView();
        initAppBarLayout();
    }

    private void initDatas() {
        this.datas = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            datas.add("data " + i);
        }
    }

    private CollapsingToolbarLayoutState state;

    private enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE
    }

    private void initAppBarLayout() {
        binding.appbarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    showTollBar();
                } else {
                    hideToolBar();
                }

//                if (verticalOffset == 0) {  //  完全展开
//                    if (state != CollapsingToolbarLayoutState.EXPANDED) {
//                        state = CollapsingToolbarLayoutState.EXPANDED;  //  修改状态标记为展开
//                        showTollBar();
//                    }
//                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
//                    if (state != CollapsingToolbarLayoutState.COLLAPSED) {
//                        state = CollapsingToolbarLayoutState.COLLAPSED;  //  修改状态标记为折叠
////                        hideToolBar();
//                    }
//                } else {
//                    if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
//                        if (state == CollapsingToolbarLayoutState.COLLAPSED) {  //  由折叠变为中间状态时
//
//
//                        }
//                        state = CollapsingToolbarLayoutState.INTERNEDIATE;//修改状态标记为中间
//                    }
//                }
            }
        });
    }

    private void hideToolBar() {
        if (binding.toolbar.getVisibility() != View.GONE) {
            binding.toolbar.setVisibility(View.GONE);
        }
    }

    private void showTollBar() {
        if (binding.toolbar.getVisibility() != View.VISIBLE) {
            binding.toolbar.setVisibility(View.VISIBLE);
        }
    }

    private void initRecyclerView() {
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.recyclerview.setAdapter(new CoordingtorRecyclerAdapter(this, datas));
    }

}
