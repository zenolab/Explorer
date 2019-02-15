package com.online_viewer_mo_apps.zenolab.explorer.mvp.group;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.ItemType;

import java.util.List;

public interface GroupFragmentView extends MvpView {

    @StateStrategyType(SkipStrategy.class)
    void setAdapterUserGroup(List<ItemType> list);
}
