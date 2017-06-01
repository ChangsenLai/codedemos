package com.csl.codedemos.ui.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * author: laichangsen | create time: 2017/5/10
 */
public class ItemTouchHelperCallBack extends ItemTouchHelper.Callback {


    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(ItemTouchHelper.START|ItemTouchHelper.END, 0);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        /*
         if (recyclerView.getAdapter() instanceof OnItemMoveListener) {
         OnItemMoveListener listener = ((OnItemMoveListener) recyclerView.getAdapter());
         listener.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
         }
         */
        return true;  //  配合 RecyclerView 的 adapter 的 notifyItemMoved(int fromPosition, int toPosition)
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;  //  todo 长按支持拖动
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return false;  //  不支持滑动
    }
}
