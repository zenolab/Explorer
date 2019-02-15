package com.online_viewer_mo_apps.zenolab.explorer.ui.file;


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
import com.online_viewer_mo_apps.zenolab.explorer.mvp.file.FileFragmentView;
import com.online_viewer_mo_apps.zenolab.explorer.mvp.file.FilePresenter;
import com.online_viewer_mo_apps.zenolab.explorer.ui.detail.DetailsActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FileFragment extends MvpAppCompatFragment implements FileFragmentView {

    private static final String LOG_TAG = new RuntimeException().getStackTrace()[0].getClassName();

    RecyclerView recyclerView;
    MultipleTypesAdapter adapter;
    List<ItemType> items = new ArrayList<>();
    View fileView;
    //-------------------- Moxy -------------
    @InjectPresenter
    FilePresenter presenter;
    //---------------------------------------

    public FileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fileView = inflater.inflate(R.layout.fragment_file, container, false);
        initList(items);
        actionOfListAdapters();
        return fileView;
    }

    //----------------------------------moxy view-----------------------------------------------
    @Override
    public void setFileAdapter(List<ItemType> list) {
        adapter.addAll(list);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public void onStart() {
        super.onStart();
        Log.i(LOG_TAG, " "+Thread.currentThread().getStackTrace()[2].getMethodName());
        presenter.getFile(items);
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.e(LOG_TAG, " "+Thread.currentThread().getStackTrace()[2].getMethodName());
//        presenter.showInfo();
//        presenter.generateData(items);

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
            public void clickOnFile(int position) {
                Toast.makeText(getActivity(), "File "+position , Toast.LENGTH_LONG).show();
                openActivityDetails();
            }
        });
    }

    void initList(List<ItemType> items) {

        recyclerView = (RecyclerView) fileView.findViewById(R.id.recyclerFile);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        LinearLayoutManager horizontalLayoutManager
//                = new LinearLayoutManager(getActivity(),
//                LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(horizontalLayoutManager);
        adapter = new MultipleTypesAdapter();
        recyclerView.setAdapter(adapter);
        //RecyclerView.RecycledViewPool pool = recyclerView.getRecycledViewPool();
       // pool.setMaxRecycledViews();

    }

    private void  openActivityDetails() {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        startActivity(intent);
    }
}
