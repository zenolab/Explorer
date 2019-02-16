package com.online_viewer_mo_apps.zenolab.explorer.domain.interactor;

import android.util.Log;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.ItemType;
import com.online_viewer_mo_apps.zenolab.explorer.domain.pojo.DirectoryEntity;
import com.online_viewer_mo_apps.zenolab.explorer.domain.pojo.FileEntity;
import com.online_viewer_mo_apps.zenolab.explorer.domain.pojo.UserGroupsEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RootCallbackInteractorImpl implements RootCallbackInteractor {

    private static final String LOG_TAG = new RuntimeException().getStackTrace()[0].getClassName();

    List<ItemType> items = new ArrayList<>();

    List<ItemType> items1 = new ArrayList<>();
    List<ItemType> items2 = new ArrayList<>();
    List<ItemType> items3 = new ArrayList<>();

    String[] group = new String[]{};
    Random rnd = new Random(9966);

    public RootCallbackInteractorImpl() {
        group = new String[15];
    }

    public RootCallbackInteractorImpl(List<ItemType> items) {
        this.items = items;
    }

    @Override
    public void generateUserGroup() {
        items1.add(new UserGroupsEntity("UserGroup " + String.valueOf(0L)));
        rootInteractorListener.setUserGroup(items1);
        Log.d(LOG_TAG, " -- generateUserGroup() IS "+items1);
    }

    @Override
    public void generateDirectory() {
        // items.clear();
        items2.add(new DirectoryEntity(1L, "item" + String.valueOf(1L)));
        items2.add(new DirectoryEntity(2L, "item" + String.valueOf(2L)));
        items2.add(new DirectoryEntity(3L, "item" + String.valueOf(3L)));
        items2.add(new DirectoryEntity(4L, "item" + String.valueOf(4L)));
        items2.add(new DirectoryEntity(5L, "item" + String.valueOf(5L)));
        items2.add(new DirectoryEntity(6L, "item" + String.valueOf(6L)));
        items2.add(new DirectoryEntity(7L, "item" + String.valueOf(7L)));
        items2.add(new DirectoryEntity(8L, "item" + String.valueOf(8L)));
        items2.add(new DirectoryEntity(9L, "item" + String.valueOf(9L)));
        rootInteractorListener.setDirectory(items2);
        Log.d(LOG_TAG, " -- generateDirectory IS "+items2);
    }

    @Override
    public void generateFile() {
        //items.clear();
        items3.add(new FileEntity(10L, "pic # " + String.valueOf(10L), "txt" + String.valueOf(10L)));
        items3.add(new FileEntity(11L, "pic # " + String.valueOf(11L), "txt" + String.valueOf(11L)));
        items3.add(new FileEntity(12L, "pic # " + String.valueOf(12L), "txt" + String.valueOf(12L)));
        items3.add(new FileEntity(13L, "pic # " + String.valueOf(13L), "txt" + String.valueOf(13L)));
        items3.add(new FileEntity(14L, "pic # " + String.valueOf(14L), "txt" + String.valueOf(14L)));
        items3.add(new FileEntity(15L, "pic # " + String.valueOf(15L), "txt" + String.valueOf(15L)));
        items3.add(new FileEntity(16L, "pic # " + String.valueOf(16L), "txt" + String.valueOf(16L)));
        items3.add(new FileEntity(17L, "pic # " + String.valueOf(17L), "txt" + String.valueOf(17L)));
        items3.add(new FileEntity(18L, "pic # " + String.valueOf(18L), "txt" + String.valueOf(18L)));
        items3.add(new FileEntity(19L, "pic # " + String.valueOf(19L), "txt" + String.valueOf(19L)));
        rootInteractorListener.setFile(items3);
        Log.d(LOG_TAG, " -- generateFile "+items3);
    }

    @Override
    public void generateGroup() {
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
        rootInteractorListener.setGroup(group);
        Log.d(LOG_TAG, " -- generateGroup IS "+group);
    }

    @Override
    public void generateRandomData() {
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
        rootInteractorListener.setRandomData(items);
    }

    //------------------------------------------------------------------------------------
    public   interface RootInteractorListener {

        default List<ItemType> setUserGroup(List<ItemType> typeList){
            return null;
        }

        default List<ItemType> setDirectory(List<ItemType> typeList){
            return null;
        }

        default List<ItemType> setFile(List<ItemType> typeList){
            return null;
        }

        default String[] setGroup(String[] array){
            return null;
        }

        default List<ItemType> setRandomData(List<ItemType> typeList){
            return null;
        }

    }

    private  RootInteractorListener rootInteractorListener;

    public void registerInterfaceCallback(RootInteractorListener rootInteractorListener) {
        this.rootInteractorListener = rootInteractorListener;
    }
}
