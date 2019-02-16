package com.online_viewer_mo_apps.zenolab.explorer.domain.pojo;

import com.online_viewer_mo_apps.zenolab.explorer.adapter.ItemType;

public class UserGroupsEntity implements ItemType {

    String title;

    public UserGroupsEntity( String title) {
        this.title = title;
    }

    //boilerplate code
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public int getItemViewType() {
        return ItemType.GROUP_ROW_TYPE;
    }

}
