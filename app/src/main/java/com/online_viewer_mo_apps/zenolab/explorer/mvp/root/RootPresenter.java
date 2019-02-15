package com.online_viewer_mo_apps.zenolab.explorer.mvp.root;

import android.util.Log;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.online_viewer_mo_apps.zenolab.explorer.adapter.ItemType;
import com.online_viewer_mo_apps.zenolab.explorer.model.RootInteractor;
import com.online_viewer_mo_apps.zenolab.explorer.model.RootCallbackInteractorImpl;
import com.online_viewer_mo_apps.zenolab.explorer.mvp.root.RootFragmentView;

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
       // rootCallbackInteractor = new RootCallbackInteractorImpl();
        //rootCallbackInteractor.registerInterfaceCallback(this);
    }

    public void showInfo() {
        Log.d(LOG_TAG, " -- Moxy Root PRESENTER ");
    }

    public void generateData(List<ItemType> items){

        this.items = items;
        this.items.clear();
        //--------------------------1 composition------------------------------
        rootInteractor.generateUserGroup();
        rootInteractor.generateDirectory();
        rootInteractor.generateFile();

      //  this.items.addAll(rootInteractor.generateRandomData());
        this.items.addAll(rootInteractor.getData());
        //-----------------------2 callbaks------------------------------
//        rootCallbackInteractor.generateUserGroup();
//        rootCallbackInteractor.generateDirectory();
//        rootCallbackInteractor.generateFile();

        // rootCallbackInteractor.generateRandomData();

        getViewState().setRootAdapter(this.items);
    }

    //-----------------------------Interactor Callbacks-------------------------------------------------
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
        /*
        Когда метод clone вызывается для массива, он возвращает ссылку на новый массив,
         который содержит (или ссылки) те же элементы, что и исходный массив.
          Итак, в вашем примере int [] a - это отдельный экземпляр объекта,
          созданный в куче, а int [] b - отдельный экземпляр объекта, созданный в куче.
          (Помните, что все массивы являются объектами).
         */
        this.group = array.clone();
        return null;
    }

    @Override
    public List<ItemType> setRandomData(List<ItemType> typeList) {
        this.items.addAll(typeList);
        return null;
    }


}
