package com.example.user.apptrain;

import android.arch.lifecycle.ViewModel;

import com.example.user.apptrain.data.PhotoEntity;
import com.example.user.apptrain.data.PhotoRepository;

import java.io.File;
import java.io.IOException;

/**
 * Created by user on 14/09/2017.
 */

public class AddPhotoViewModel extends ViewModel {

    private String tempPhotoPath;
    private PhotoRepository photoRepository;
    private PhotoEntity toPersist;

    public File createTempImageFile() throws IOException {
        File image = photoRepository.createTempFile();
        tempPhotoPath = image.getAbsolutePath();
        return image;
    }

    class ImageMissingException extends IllegalArgumentException {

    }

    public void setDescription(String description) {
        toPersist.setTitle(description);
    }
}
