package com.example.user.apptrain.data;

import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * Created by user on 14/09/2017.
 */

public class PhotoRepository {

    public File createTempFile() throws IOException {
        // Create an image file name
        String imageFileName = "tmp_receipt_" + System.currentTimeMillis();
        File storageDir = new File(Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                .getAbsolutePath() + "/Espresso/");
        storageDir.mkdirs();
        return File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
    }
}
