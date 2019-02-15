package com.online_viewer_mo_apps.zenolab.explorer.model.pojo;

import android.support.v7.widget.RecyclerView;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.ItemType;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.factory.ViewHolderFactory;

public class GroupEntity {

    /**
     * long = 9 Квинтиллионов(quintillion) = 18 нулей
     * long: The long data type is a 64-bit two's complement integer.
     * The signed long has a minimum value of -2in(63) and a maximum value of 2in(63)-1. In Java SE 8 and later,
     * you can use the long data type to represent an unsigned 64-bit long,
     * which has a minimum value of 0 and a maximum value of 2 in (64)-1.
     * Use this data type when you need a range of values wider than those provided by int.
     * The Long class also contains methods like compareUnsigned,
     * divideUnsigned etc to support arithmetic operations for unsigned long.
     */
    long id;
    String title;
    boolean rule;

    public GroupEntity(Long id, String title, boolean rule) {
        this.id = id;
        this.title = title;
        this.rule = rule;
    }

    //boilerplate
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

    public boolean getRule() {
        return rule;
    }

    public void setRule(boolean rule) {
        this.rule = rule;
    }


}
