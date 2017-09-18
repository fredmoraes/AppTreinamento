package com.example.user.apptrain.data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.VisibleForTesting;

/**
 * Created by user on 18/09/2017.
 */
@Database(entities = {PhotoEntity.class}, version = 1)
@TypeConverters({DateConverter.class})

public abstract class PhotoRepoDatabase extends RoomDatabase {
    public static final int UNSET_ID = 0;
    private static PhotoRepoDatabase INSTANCE;
    private static final Object sLock = new Object();

    public abstract PhotoDAO photoDao();

    public static PhotoRepoDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        PhotoRepoDatabase.class, "sugar_database.db")
                        .build();
            }
            return INSTANCE;
        }
    }
}
