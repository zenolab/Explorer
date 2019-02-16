package com.online_viewer_mo_apps.zenolab.explorer.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.factory.ViewHolderFactory;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.listener.ItemActionListener;

import java.util.ArrayList;
import java.util.List;

public class MultipleTypesAdapter  extends RecyclerView.Adapter<GenericViewHolder>{

    private List<ItemType> dataSet;

    private ItemActionListener itemActionListener;
    public void registerActionListener(ItemActionListener itemActionListener) {
        this.itemActionListener = itemActionListener;
    }

    public MultipleTypesAdapter() {
            this.dataSet = new ArrayList<>();
            this.dataSet.clear();
    }

    @Override
    public int getItemViewType(int position) {
        return dataSet.get(position).getItemViewType();
    }

    @NonNull
    @Override
    public GenericViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ViewHolderFactory.create(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
        holder.setDataOnView(holder,position,dataSet,itemActionListener);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void addAll(List<ItemType> dataSet){
        if (this.dataSet!=null) {
            this.dataSet.clear();
            this.dataSet.addAll(dataSet);
        }
    }
}
