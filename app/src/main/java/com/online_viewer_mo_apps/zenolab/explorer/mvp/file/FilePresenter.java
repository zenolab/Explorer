package com.online_viewer_mo_apps.zenolab.explorer.mvp.file;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.ItemType;
import com.online_viewer_mo_apps.zenolab.explorer.model.RootInteractor;
import com.online_viewer_mo_apps.zenolab.explorer.model.RootCallbackInteractorImpl;

import java.util.List;

@InjectViewState
public class FilePresenter extends MvpPresenter<FileFragmentView> implements RootCallbackInteractorImpl.RootInteractorListener {


    private List<ItemType> items;
    private RootInteractor rootInteractor;

    private RootCallbackInteractorImpl rootCallbackInteractor;

    private static final String LOG_TAG = new RuntimeException().getStackTrace()[0].getClassName();

    public FilePresenter() {

        rootInteractor =new RootInteractor();

//        rootInteractor = new RootCallbackInteractorImpl();
//        rootInteractor.registerInterfaceCallback(this);
    }

    public void getFile(List<ItemType> items){
        this.items = items;
        this.items.clear();

        this.items.addAll(rootInteractor.generateFile());

        getViewState().setFileAdapter(items);

    }


    @Override
    public List<ItemType> setFile(List<ItemType> typeList) {
        this.items.addAll(typeList);
        return null;
    }

}
