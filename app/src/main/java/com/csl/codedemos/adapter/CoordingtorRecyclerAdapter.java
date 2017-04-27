package com.csl.codedemos.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by laichangsen on 2017/4/27.
 */

public class CoordingtorRecyclerAdapter extends RecyclerView.Adapter<CoordingtorRecyclerAdapter.InnerViewHolder> {

    private List<String> datas;
    private Context context;

    public CoordingtorRecyclerAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public InnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new InnerViewHolder(new TextView(context));
    }

    @Override
    public void onBindViewHolder(InnerViewHolder holder, int position) {
        holder.textView.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    static class InnerViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public InnerViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }


    }
}
