package com.example.user.apptrain;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by user on 13/09/2017.
 */

public class NavigationController {
    private final int containerId;
    private final FragmentManager fragmentManager;


    public NavigationController(MainActivity mainActivity) {
        this.containerId = R.id.content_0;
        this.fragmentManager = mainActivity.getSupportFragmentManager();
    }

    public void navigateToLogin(){
        LoginFragment fragment = new LoginFragment();
        fragmentManager.beginTransaction().replace(containerId, fragment, "LOGIN")
            .addToBackStack("LOGIN").commitAllowingStateLoss();
        //remover o estado inicial da activity do backstack
    }

    //passar o texto digitado no login para o próximo fragment
    public void navigateToPhotoList(Bundle bundle){
        PhotoListFragment fragment = new PhotoListFragment();
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction().replace(containerId, fragment, "PHOTO_LIST")
                .addToBackStack("PHOTO_LIST").commitAllowingStateLoss();
        //remover o login do backstack
    }

    public void navigateToAddPhoto(Bundle bundle){
        AddPhotoFragment fragment = new AddPhotoFragment();
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction().replace(containerId, fragment, "ADD_PHOTO")
                .addToBackStack("ADD_PHOTO").commitAllowingStateLoss();
        //remover o login do backstack
    }

}
