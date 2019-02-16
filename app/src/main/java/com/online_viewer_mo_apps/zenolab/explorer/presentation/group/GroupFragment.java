package com.online_viewer_mo_apps.zenolab.explorer.presentation.group;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.online_viewer_mo_apps.zenolab.explorer.R;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.ItemType;
import com.online_viewer_mo_apps.zenolab.explorer.presentation.detail.DetailsActivity;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class GroupFragment extends MvpAppCompatFragment implements GroupFragmentView,GroupGridAdapter.ItemClickListener {

    private static final String LOG_TAG = new RuntimeException().getStackTrace()[0].getClassName();

    GroupGridAdapter adapter;

    View groupView;

    //-------------------- Moxy -------------
    @InjectPresenter
    GroupPresenter presenter;
    //---------------------------------------

    public GroupFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        groupView = inflater.inflate(R.layout.fragment_group, container, false);

        // set up the RecyclerView
        RecyclerView recyclerView = groupView.findViewById(R.id.rvNumbers);
        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
//        LinearLayoutManager horizontalLayoutManager
//                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(horizontalLayoutManager);
        adapter = new GroupGridAdapter(getActivity(), presenter.getGroup());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return groupView;

    }

    @Override
    public void setAdapterUserGroup(List<ItemType> list) {

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getActivity(), "Press on position :"+position, Toast.LENGTH_LONG).show();
        openActivityDetails();

    }

    private void  openActivityDetails() {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        startActivity(intent);
    }

}
