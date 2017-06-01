package com.csl.codedemos.ui.everyadapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * EveryAdapter的Holder
 */
public class EveryHolder {

    private SparseArray<View> views;
    private View mConvertView;

    private EveryHolder(Context context, int layout) {
        this.views = new SparseArray<>();
        this.mConvertView = LayoutInflater.from(context).inflate(layout, null, false);
        this.mConvertView.setTag(this);
    }

    /**
     * init holder
     */
    static EveryHolder getHolder(Context context, int layout, View convertView) {
        EveryHolder holder;
        if (null == convertView) {
            holder = new EveryHolder(context, layout);
        } else {
            holder = (EveryHolder) convertView.getTag();
        }
        return holder;
    }

    View getmConvertView() {
        return mConvertView;
    }


    /**
     * get view by id
     */
    private View getView(int viewId) {
        View view = views.get(viewId);
        if (null == view) {
            view = mConvertView.findViewById(viewId);
            views.put(viewId, view);
        }
        return view;
    }

    public View getItemView(int viewId) {
        return getView(viewId);
    }

    public Button getButton(int viewId) {
        return (Button) getView(viewId);
    }

    public TextView getTextView(int viewId) {
        return (TextView) getView(viewId);
    }

    public EditText getEditText(int viewId) {
        return (EditText) getView(viewId);
    }

    public ImageView getImageView(int viewId) {
        return (ImageView) getView(viewId);
    }

    public ImageButton getImageButton(int viewId) {
        return (ImageButton) getView(viewId);
    }

    public LinearLayout getLinearLayout(int viewId) {
        return (LinearLayout) getView(viewId);
    }

    public RelativeLayout getRelativeLayout(int viewId) {
        return (RelativeLayout) getView(viewId);
    }

    public FrameLayout getFrameLayout(int id) {
        return (FrameLayout) getView(id);
    }

    public CheckBox getCheckBox(int viewId) {
        return (CheckBox) getView(viewId);
    }
}
