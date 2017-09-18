package com.example.user.apptrain;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;


import java.io.File;
import java.io.IOException;
import java.util.zip.Inflater;

import static android.app.Activity.RESULT_OK;

/**
 * Created by user on 14/09/2017.
 */

public class AddPhotoFragment extends Fragment {

    protected AddPhotoViewModel viewModel;
    private static final int REQUEST_WRITE_PERMISSION = 6;
    private ImageView mImageView;
    Toolbar tbAddphoto;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.addphoto_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mImageView = getView().findViewById(R.id.iv_photo);
        tbAddphoto = getActivity().findViewById(R.id.tb_addphoto);
        tbAddphoto.inflateMenu(R.menu.menu_salvar);

        dispatchTakePictureIntent();

        String descr = getView().findViewById(R.id.tb_descr).toString();
        Button btSalvarClick = getView().findViewById(R.id.bt_salvar);
        btSalvarClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    viewModel.setDescription(descr);
                    
                } catch (AddPhotoViewModel.ImageMissingException e) {

                }
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_salvar, menu);

        Button btClick = getView().findViewById(R.id.bt_salvar);
        btClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "SALVAR TESTE", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
    }

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_IMPORT_IMAGE = 4;

    private boolean checkWritePermission() {
        int permissionResult = ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return permissionResult == PackageManager.PERMISSION_GRANTED;
    }


}
