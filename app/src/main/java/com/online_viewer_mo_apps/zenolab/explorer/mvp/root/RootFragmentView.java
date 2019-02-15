package com.online_viewer_mo_apps.zenolab.explorer.mvp.root;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.ItemType;

import java.util.ArrayList;
import java.util.List;

public interface RootFragmentView extends MvpView {

    @StateStrategyType(SkipStrategy.class)
    void setRootAdapter(List<ItemType> list);

}
