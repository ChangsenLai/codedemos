package com.csl.codedemos.ui.everyadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * this is every listview adapter
 */
public abstract class EveryAdapter<T> extends BaseAdapter {
	
	private List<T> infos;
	private Context mContext;
	protected int layout;

	protected EveryAdapter(Context context, List<T> datas, int layout) {
		this.mContext = context;
		this.infos = datas;
		this.layout = layout;
	}

	@Override
	public int getCount() {
		return infos.size();
	}

	@Override
	public T getItem(int position) {
		return infos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		EveryHolder holder = EveryHolder.getHolder(mContext, layout, convertView);
		bindView(holder, infos.get(position), position);
		return holder.getmConvertView();
	}
	
	public abstract void bindView(EveryHolder holder, T itemInfo, int position);
	
}
