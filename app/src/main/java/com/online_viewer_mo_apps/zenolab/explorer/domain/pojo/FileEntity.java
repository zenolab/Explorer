package com.online_viewer_mo_apps.zenolab.explorer.domain.pojo;

import com.online_viewer_mo_apps.zenolab.explorer.adapter.ItemType;

public class FileEntity  implements ItemType {

    Long id;
    String title;
    String body;

    public FileEntity(Long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    // //boilerplate
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    @Override
    public int getItemViewType() {
        return ItemType.FILE_ROW_TYPE;
    }

}
