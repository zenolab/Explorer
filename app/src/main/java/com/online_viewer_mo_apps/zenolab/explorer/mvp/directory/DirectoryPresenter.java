package com.online_viewer_mo_apps.zenolab.explorer.mvp.directory;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.ItemType;
import com.online_viewer_mo_apps.zenolab.explorer.model.RootInteractor;

import java.util.List;

@InjectViewState
public class DirectoryPresenter extends MvpPresenter<DirectoryFragmentView> {

    private static final String LOG_TAG = new RuntimeException().getStackTrace()[0].getClassName();

    private List<ItemType> items;
    private RootInteractor rootInteractor;

    public DirectoryPresenter() {
        rootInteractor = new RootInteractor();
    }

    public void getDirectory(List<ItemType> items) {

        this.items = items;
        this.items.clear();
        this.items.addAll(rootInteractor.generateDirectory());
        this.items.addAll(rootInteractor.generateFile());

        getViewState().setDirectoryAdapter(this.items);

    }
}
