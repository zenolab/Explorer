package com.online_viewer_mo_apps.zenolab.explorer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.listener.ItemActionListener;

import java.util.Collection;
import java.util.List;

public abstract class GenericViewHolder extends RecyclerView.ViewHolder {

    public GenericViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setDataOnView(GenericViewHolder holder, int position,
                                       List<ItemType> dataSet,ItemActionListener itemActionListener);
}