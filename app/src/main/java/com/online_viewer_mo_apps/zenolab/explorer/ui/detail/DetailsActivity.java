package com.online_viewer_mo_apps.zenolab.explorer.ui.detail;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.online_viewer_mo_apps.zenolab.explorer.R;
import com.online_viewer_mo_apps.zenolab.explorer.mvp.details.DetailsActivityView;
import com.online_viewer_mo_apps.zenolab.explorer.mvp.details.DetailsPresenter;
import com.online_viewer_mo_apps.zenolab.explorer.ui.BaseActivity;


public class DetailsActivity extends BaseActivity implements DetailsActivityView {

    private static final String LOG_TAG = new RuntimeException().getStackTrace()[0].getClassName();

    //-------------------- Moxy -------------
    @InjectPresenter
    DetailsPresenter presenter;
    //---------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

}
