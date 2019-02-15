package com.online_viewer_mo_apps.zenolab.explorer.ui.directory;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.online_viewer_mo_apps.zenolab.explorer.R;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.ItemType;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.MultipleTypesAdapter;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.listener.ItemActionListener;
import com.online_viewer_mo_apps.zenolab.explorer.mvp.directory.DirectoryFragmentView;
import com.online_viewer_mo_apps.zenolab.explorer.mvp.directory.DirectoryPresenter;
import com.online_viewer_mo_apps.zenolab.explorer.ui.detail.DetailsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DirectoryFragment extends MvpAppCompatFragment implements DirectoryFragmentView {

    private static final String LOG_TAG = new RuntimeException().getStackTrace()[0].getClassName();

    //-------------------- Moxy -------------
    @InjectPresenter
    DirectoryPresenter presenter;
    //---------------------------------------

    RecyclerView recyclerView;
    MultipleTypesAdapter adapter;
    List<ItemType> items = new ArrayList<>();
    View directoryView;

    public DirectoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        directoryView = inflater.inflate(R.layout.fragment_directory, container, false);
        initList();
        actionOfListAdapters();
        return directoryView;
    }

    void initList() {

        recyclerView = (RecyclerView) directoryView.findViewById(R.id.recyclerDirectory);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MultipleTypesAdapter();
        recyclerView.setAdapter(adapter);
        //RecyclerView.RecycledViewPool pool = recyclerView.getRecycledViewPool();
        //pool.setMaxRecycledViews();

    }

    @Override
    public void setDirectoryAdapter(List<ItemType> list) {
        adapter.addAll(list);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public void onStart() {
        super.onStart();
        Log.i(LOG_TAG, " "+Thread.currentThread().getStackTrace()[2].getMethodName());
        presenter.getDirectory(items);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(LOG_TAG, " "+Thread.currentThread().getStackTrace()[2].getMethodName());

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(LOG_TAG, " "+Thread.currentThread().getStackTrace()[2].getMethodName());
        //presenter.detachView();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(LOG_TAG, " "+Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(LOG_TAG, " "+Thread.currentThread().getStackTrace()[2].getMethodName());
        //presenter.destroy();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(LOG_TAG, " "+Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(LOG_TAG, " "+Thread.currentThread().getStackTrace()[2].getMethodName());
    }
    //------------------------------------------------------------------------------------------------------------------
    private void actionOfListAdapters() {

        adapter.registerActionListener(new ItemActionListener(){

            @Override
            public void clickOnDirectory(int position) {
                Toast.makeText(getActivity(), "Directory "+position , Toast.LENGTH_LONG).show();
                openActivityDetails();
            }

            @Override
            public void clickOnFile(int position) {
                Toast.makeText(getActivity(), "File "+position , Toast.LENGTH_LONG).show();
                openActivityDetails();
            }
        });

    }
    //------------------------------------------------------------------------------------------------------------------

    private void  openActivityDetails() {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        startActivity(intent);
    }


}
