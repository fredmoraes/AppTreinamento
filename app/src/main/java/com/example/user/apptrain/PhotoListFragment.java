package com.example.user.apptrain;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by user on 13/09/2017.
 */

public class PhotoListFragment extends Fragment {

    String emailLogin;
    NavigationController nvControl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        emailLogin = getArguments().getString("email");
        nvControl = new NavigationController((MainActivity) getActivity());
        return inflater.inflate(R.layout.photolist_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton btClick = getView().findViewById(R.id.fab_addPhoto);
        btClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("email", emailLogin);
                nvControl.navigateToAddPhoto(bundle);
            }
        });
    }
}
