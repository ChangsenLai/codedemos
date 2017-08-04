package com.csl.codedemos.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import com.csl.codedemos.R;
import com.csl.codedemos.ui.recyclerview.ItemTouchHelperCallBack;
import com.csl.codedemos.ui.recyclerview.commonadapter.CommonRecycleAdapter;
import com.csl.codedemos.ui.recyclerview.commonadapter.CommonViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * author: laichangsen | create time: 2017/5/10
 */
public class RecyclerViewActivity extends BaseActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, RecyclerViewActivity.class);
        context.startActivity(intent);
    }

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_recyclerview;
    }

    protected void init() {
        List<String> datas = new ArrayList<>();
        datas.add("a");
        datas.add("b");
        datas.add("c");
        datas.add("d");
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 4);
//        new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(getAdapter(datas));

        ItemTouchHelperCallBack callback = new ItemTouchHelperCallBack();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerview);
    }

    private RecyclerView.Adapter getAdapter(List<String> datas) {
        CommonRecycleAdapter<String> adapter = new CommonRecycleAdapter<String>(this, datas, R.layout.item_recycler_view) {
            @Override
            public void bindData(CommonViewHolder holder, String data) {
                holder.setText(R.id.text, data);
                holder.setCallback(new CommonViewHolder.EventCallback() {
                    @Override
                    public void onItemClickListener(int position) {
                        Toast.makeText(getApplicationContext(), "click:" + String.valueOf(position), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemLongClickListener(int position) {
                        Toast.makeText(getApplicationContext(), "long click:" + String.valueOf(position), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        return adapter;
    };

}























































