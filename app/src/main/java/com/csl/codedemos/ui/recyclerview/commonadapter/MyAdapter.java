package com.csl.codedemos.ui.recyclerview.commonadapter;

import android.content.Context;

import com.csl.codedemos.R;

import java.util.List;

public class MyAdapter extends CommonRecycleAdapter<Data> implements MultiTypeSupport<Data> {

    private CommonViewHolder.EventCallback commonClickListener;

    public MyAdapter(Context context, List<Data> dataList) {
        super(context, dataList, R.layout.item_left);
    }

    public MyAdapter(Context context, List<Data> dataList, CommonViewHolder.EventCallback commonClickListener) {
        super(context, dataList, R.layout.item_left);
        this.commonClickListener = commonClickListener;
        this.multiTypeSupport = this;
    }

    @Override
    public void bindData(CommonViewHolder holder, Data data) {
        holder.setText(R.id.tv_title, data.getTitle())
                .setText(R.id.tv_content, data.getContent())
                .setCallback(commonClickListener);
    }

    @Override
    public int getLayoutId(Data item, int position) {
        if (item.getLocation().equals("left")) {
            return R.layout.item_left;
        }
        return R.layout.item_right;
    }

}
