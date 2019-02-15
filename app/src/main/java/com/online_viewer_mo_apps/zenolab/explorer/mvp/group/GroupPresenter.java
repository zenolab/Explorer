package com.online_viewer_mo_apps.zenolab.explorer.mvp.group;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.online_viewer_mo_apps.zenolab.explorer.model.RootInteractor;

@InjectViewState
public class GroupPresenter extends MvpPresenter<GroupFragmentView> {

    private static final String LOG_TAG = new RuntimeException().getStackTrace()[0].getClassName();

    public GroupPresenter() {
    }

    public String[] getGroup() {
        return new RootInteractor().generateGroup();
    }

}
