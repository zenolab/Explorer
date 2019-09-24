package com.online_viewer_mo_apps.zenolab.explorer.presentation.root;

import android.util.Log;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.ItemType;
import com.online_viewer_mo_apps.zenolab.explorer.domain.interactor.RootInteractor;
import com.online_viewer_mo_apps.zenolab.explorer.domain.interactor.RootCallbackInteractorImpl;

import java.util.List;
import java.util.Random;

@InjectViewState
public class RootPresenter  extends MvpPresenter<RootFragmentView> implements RootCallbackInteractorImpl.RootInteractorListener {

    private static final String LOG_TAG = new RuntimeException().getStackTrace()[0].getClassName();

    List<ItemType> items;

    String[] group = new String[]{};
    Random rnd = new Random(9966);

    private RootInteractor rootInteractor;
    private RootCallbackInteractorImpl rootCallbackInteractor;

    public RootPresenter() {
        rootInteractor = new RootInteractor();
    }

    public void showInfo() {
        Log.d(LOG_TAG, "Moxy Root PRESENTER ");
    }

    public void generateData(List<ItemType> items){
        this.items = items;
        this.items.clear();
        this.items.addAll(rootInteractor.getData());
        getViewState().setRootAdapter(this.items);
    }


    @Override
    public List<ItemType> setUserGroup(List<ItemType> typeList) {
        this.items.addAll(typeList);
        return null;
    }

    @Override
    public List<ItemType> setDirectory(List<ItemType> typeList) {
        this.items.addAll(typeList);
        return null;
    }

    @Override
    public List<ItemType> setFile(List<ItemType> typeList) {
        this.items.addAll(typeList);
        return null;
    }

    @Override
    public String[] setGroup(String[] array) {
        this.group = array.clone();
        return null;
    }

    @Override
    public List<ItemType> setRandomData(List<ItemType> typeList) {
        this.items.addAll(typeList);
        return null;
    }


}
