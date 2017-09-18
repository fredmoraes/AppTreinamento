package com.example.user.apptrain;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.user.apptrain.NavigationController.*;

public class MainActivity extends AppCompatActivity {

    NavigationController nvControl = new NavigationController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nvControl.navigateToLogin();
        //NavigationController.navigateToLogin();
    }


}






