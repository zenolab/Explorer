package com.online_viewer_mo_apps.zenolab.explorer.presentation.file;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.ItemType;

import java.util.List;

public interface FileFragmentView extends MvpView {

    @StateStrategyType(SkipStrategy.class)
    void setFileAdapter(List<ItemType> list);
}
