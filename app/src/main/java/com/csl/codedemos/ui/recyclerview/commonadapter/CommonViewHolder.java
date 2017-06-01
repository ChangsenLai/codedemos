package com.csl.codedemos.ui.recyclerview.commonadapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CommonViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {

    private SparseArray<View> viewSparseArray;

    private EventCallback callback;

    public CommonViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
        viewSparseArray = new SparseArray<>();
    }

    public <T extends View> T getView(int viewId) {
        View view = viewSparseArray.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            viewSparseArray.put(viewId, view);
        }
        return (T) view;
    }

    public CommonViewHolder setText(int viewId, CharSequence text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public CommonViewHolder setViewVisibility(int viewId, int visibility) {
        getView(viewId).setVisibility(visibility);
        return this;
    }

    public CommonViewHolder setImageResource(int viewId, int resourceId) {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(resourceId);
        return this;
    }

    public interface EventCallback {

        void onItemClickListener(int position);

        void onItemLongClickListener(int position);

    }

    public void setCallback(EventCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onClick(View v) {
        if (callback != null) {
            callback.onItemClickListener(getAdapterPosition());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (callback != null) {
            callback.onItemLongClickListener(getAdapterPosition());
        }
        return false;
    }
}
