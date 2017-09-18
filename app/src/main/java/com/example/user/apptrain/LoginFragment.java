
package com.example.user.apptrain;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by user on 13/09/2017.
 */

public class LoginFragment extends Fragment {

    NavigationController nvControl;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        nvControl = new NavigationController((MainActivity) getActivity());
        return inflater.inflate(R.layout.login_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText tbEmail = getView().findViewById(R.id.tb_email);

        Button btClick = getView().findViewById(R.id.bt_enter);
        btClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("email", tbEmail.getText().toString());
                nvControl.navigateToPhotoList(bundle);
            }
        });
    }


}
