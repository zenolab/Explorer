package com.online_viewer_mo_apps.zenolab.explorer.model;

import android.util.Log;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.ItemType;
import com.online_viewer_mo_apps.zenolab.explorer.model.pojo.DirectoryEntity;
import com.online_viewer_mo_apps.zenolab.explorer.model.pojo.FileEntity;
import com.online_viewer_mo_apps.zenolab.explorer.model.pojo.GroupEntity;
import com.online_viewer_mo_apps.zenolab.explorer.model.pojo.UserGroupsEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RootInteractor {

    private static final String LOG_TAG = new RuntimeException().getStackTrace()[0].getClassName();

    List<ItemType> items = new ArrayList<>();

    String[] group = new String[]{};
    Random rnd = new Random(9966);

    public RootInteractor() {
        group = new String[25];
    }

    public List<ItemType> generateUserGroup() {
        items.add(new UserGroupsEntity("UserGroup " + String.valueOf(0L)));
        return items;
    }

    public List<ItemType> generateDirectory() {
        items.add(new DirectoryEntity(1L, "item" + String.valueOf(1L)));
        items.add(new DirectoryEntity(2L, "item" + String.valueOf(2L)));
        items.add(new DirectoryEntity(3L, "item" + String.valueOf(3L)));
        items.add(new DirectoryEntity(4L, "item" + String.valueOf(4L)));
        items.add(new DirectoryEntity(5L, "item" + String.valueOf(5L)));
        items.add(new DirectoryEntity(6L, "item" + String.valueOf(6L)));
        items.add(new DirectoryEntity(7L, "item" + String.valueOf(7L)));
        items.add(new DirectoryEntity(8L, "item" + String.valueOf(8L)));
        items.add(new DirectoryEntity(9L, "item" + String.valueOf(9L)));
        return items;
    }

    public List<ItemType> generateFile() {
        items.add(new FileEntity(10L, "pic # " + String.valueOf(10L), "txt" + String.valueOf(10L)));
        items.add(new FileEntity(11L, "pic # " + String.valueOf(11L), "txt" + String.valueOf(11L)));
        items.add(new FileEntity(12L, "pic # " + String.valueOf(12L), "txt" + String.valueOf(12L)));
        items.add(new FileEntity(13L, "pic # " + String.valueOf(13L), "txt" + String.valueOf(13L)));
        items.add(new FileEntity(14L, "pic # " + String.valueOf(14L), "txt" + String.valueOf(14L)));
        items.add(new FileEntity(15L, "pic # " + String.valueOf(15L), "txt" + String.valueOf(15L)));
        items.add(new FileEntity(16L, "pic # " + String.valueOf(16L), "txt" + String.valueOf(16L)));
        items.add(new FileEntity(17L, "pic # " + String.valueOf(17L), "txt" + String.valueOf(17L)));
        items.add(new FileEntity(18L, "pic # " + String.valueOf(18L), "txt" + String.valueOf(18L)));
        items.add(new FileEntity(19L, "pic # " + String.valueOf(19L), "txt" + String.valueOf(19L)));
        return items;
    }

    public String [] generateGroup() {
        group[0] = "Group #1";
        group[1] = "Group #2";
        group[2] = "Group #3";
        group[3] = "Group #4";
        group[4] = "Group #5";
        group[5] = "Group #5";
        group[6] = "Group #6";
        group[7] = "Group #7";
        group[8] = "Group #8";
        group[9] = "Group #9";
        group[10] = "Group #10";
        group[11] = "Group #11";
        group[12] = "Group #12";
        group[13] = "Group #13";
        group[14] = "Group #14";
        group[15] = "Group #15";
        group[16] = "Group #16";
        group[17] = "Group #17";
        group[18] = "Group #18";
        group[19] = "Group #19";
        group[20] = "Group #20";
        group[21] = "Group #21";
        group[22] = "Group #22";
        group[23] = "Group #23";
        group[24] = "Group #24";
        return group;
    }

    public List<ItemType> generateRandomData() {
        items.clear();
        for (long i = 0; i < 15; i++) {
            switch (rnd.nextInt(3)) {
                case 0:
                    items.add(new UserGroupsEntity("Group # " + String.valueOf(i)));

                    break;
                case 1:
                    items.add(new DirectoryEntity(i, "item" + String.valueOf(i)));
                    break;
                case 2:
                    items.add(new FileEntity(i, "pic # " + String.valueOf(i), "txt" + String.valueOf(i)));
            }
        }
        return items;
    }

    public List<ItemType> getData(){
        return this.items;
    }

}
