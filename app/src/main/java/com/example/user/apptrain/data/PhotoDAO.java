package com.example.user.apptrain.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
/**
 * Created by user on 15/09/2017.
 */

@Dao
public interface PhotoDAO {
    @Insert(onConflict = OnConflictStrategy.ROLLBACK)
    public void insert(PhotoEntity... photo);

    @Update
    public void update(PhotoEntity... photo);

    @Delete
    public void delete(PhotoEntity... photo);

}
