package com.online_viewer_mo_apps.zenolab.explorer.presentation.root;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.*;
import android.widget.Toast;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.online_viewer_mo_apps.zenolab.explorer.R;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.ItemType;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.MultipleTypesAdapter;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.listener.ItemActionListener;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.listener.common.RecyclerTouchListener;
import com.online_viewer_mo_apps.zenolab.explorer.presentation.directory.DirectoryFragment;
import com.online_viewer_mo_apps.zenolab.explorer.presentation.file.FileFragment;
import com.online_viewer_mo_apps.zenolab.explorer.presentation.group.GroupFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RootFragment extends MvpAppCompatFragment implements RootFragmentView {

    private static final String LOG_TAG = new RuntimeException().getStackTrace()[0].getClassName();

    //-------------------- Moxy -------------
    @InjectPresenter
    RootPresenter presenter;
    //---------------------------------------

    View rootView;

    RecyclerView recyclerView;
    MultipleTypesAdapter adapter;
    List<ItemType> items = new ArrayList<>();

    public RootFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_root, container, false);
        initList();
        initListClickListener( recyclerView );
        actionOfListAdapters();

        return rootView;
    }

    void initList() {

         recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerContent);
         recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
         adapter = new MultipleTypesAdapter();
         recyclerView.setAdapter(adapter);

//         RecyclerView.RecycledViewPool pool = recyclerView.getRecycledViewPool();
//         pool.setMaxRecycledViews();

    }

    //----------------------------------moxy view-----------------------------------------------

    @Override
    public void setRootAdapter(List<ItemType> list) {
        Log.i(LOG_TAG, "--setRootAdapter "+list);
        adapter.addAll(list);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public void onStart() {
        super.onStart();
        Log.i(LOG_TAG, "--onStart "+Thread.currentThread().getStackTrace()[2].getMethodName());
        presenter.showInfo();
       presenter.generateData(items);
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
            public void clickOnGroup(int position) {
                Toast.makeText(getActivity(), "Group "+position , Toast.LENGTH_LONG).show();
                Log.d(LOG_TAG,"ActionListener");
                openNewFragment(1);
            }

            @Override
            public void clickOnDirectory(int position) {
                Toast.makeText(getActivity(), "Directory "+position , Toast.LENGTH_LONG).show();
                openNewFragment(2);
            }

            @Override
            public void clickOnFile(int position) {
                Toast.makeText(getActivity(), "File "+position , Toast.LENGTH_LONG).show();
                openNewFragment(3);
            }
        });

    }
    //------------------------------------------------------------------------------------------------------------------
    private void openNewFragment(int value) {
        Fragment fragment = new Fragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (value == 1) {
            fragment = new GroupFragment();
        }
        if (value == 2) {
            fragment = new DirectoryFragment();
        }
        if (value == 3) {
            fragment = new FileFragment();
        }
        fragmentTransaction.replace(R.id.fragment, fragment, "tag_detail");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    //------------------------------------------------------------------------------------------------------------------
    private void initListClickListener(RecyclerView recyclerView ) {
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(),
                recyclerView, (view, position) -> Toast.makeText(getActivity(), "Click "+position , Toast.LENGTH_LONG).show()));
    }

}
