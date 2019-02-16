package com.online_viewer_mo_apps.zenolab.explorer.domain.pojo;

import com.online_viewer_mo_apps.zenolab.explorer.adapter.ItemType;

public class DirectoryEntity  implements ItemType {

    Long id;
    String title;

    public DirectoryEntity(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    // boilerplate
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getItemViewType() {
        return ItemType.DIRECTORY_ROW_TYPE;
    }


}
