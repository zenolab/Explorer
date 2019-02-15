package com.online_viewer_mo_apps.zenolab.explorer.adapter;

import android.support.v7.widget.RecyclerView;

public interface  ItemType {

    static int  GROUP_ROW_TYPE = 0;
    static int FILE_ROW_TYPE = 1;
    static int DIRECTORY_ROW_TYPE = 2;

    int getItemViewType();

}
