package com.csl.codedemos.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.csl.codedemos.R;
import com.csl.codedemos.adapter.MyRecyclerAdapter;
import com.csl.codedemos.recyclerview.MyItemTouchHelper.ItemTouchHelperCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * author: laichangsen | create time: 2017/5/10
 */
public class RecyclerViewActivity extends BaseActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, RecyclerViewActivity.class);
        context.startActivity(intent);
    }

    private RecyclerView recyclerview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        init();
    }

    private void init() {
        List<String> datas = new ArrayList<>();
        datas.add("a");
        datas.add("b");
        datas.add("c");
        datas.add("d");
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(this, datas);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 4);
//        new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapter);

        ItemTouchHelperCallBack callback = new ItemTouchHelperCallBack();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerview);
    }

}























































