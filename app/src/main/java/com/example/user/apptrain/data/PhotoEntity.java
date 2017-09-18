package com.example.user.apptrain.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
/**
 * Created by user on 14/09/2017.
 */

@Entity(tableName = PhotoEntity.TABLE_NAME)
public class PhotoEntity {
    public static final String TABLE_NAME = "PHOTO";
    public static final String ID_COLUMN = "ID";
    public static final String TITLE_COLUMN = "TITLE";
    public static final String DATE_COLUMN = "DATE";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID_COLUMN)
    public long id;

    @ColumnInfo(name = TITLE_COLUMN)
    public String title;

    @ColumnInfo(name = DATE_COLUMN)
    public String date;

    @ColumnInfo(name = "DATA")
    public String localPath;

    public PhotoEntity(long id, String title, String date, String localPath) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.localPath = localPath;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getIdColumn() {
        return ID_COLUMN;
    }

    public static String getTitleColumn() {
        return TITLE_COLUMN;
    }

    public static String getDateColumn() {
        return DATE_COLUMN;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
