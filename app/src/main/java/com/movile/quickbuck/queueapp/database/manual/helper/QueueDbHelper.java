package com.movile.quickbuck.queueapp.database.manual.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.movile.quickbuck.queueapp.database.manual.DatabaseConfiguration;
import com.movile.quickbuck.queueapp.database.manual.entity.UserEntity;


public class QueueDbHelper extends SQLiteOpenHelper {

    public QueueDbHelper(Context context) {
        super(context, DatabaseConfiguration.NAME, null, DatabaseConfiguration.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(UserEntity.FavoriteEntityFields.createSql());
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL(UserEntity.FavoriteEntityFields.dropSql());
        onCreate(database);
    }

}