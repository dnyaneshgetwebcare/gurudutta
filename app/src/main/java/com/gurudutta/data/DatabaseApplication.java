package com.gurudutta.data;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

public class DatabaseApplication {
    private Context mCtx;
    private static DatabaseApplication mInstance;

    AppDatabase myDatabase;
    private DatabaseApplication(Context mCtx) {
        this.mCtx=mCtx;

        myDatabase = Room.databaseBuilder(mCtx, AppDatabase.class, AppDatabase.NAME).allowMainThreadQueries().build();
    }
    public static synchronized DatabaseApplication getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseApplication(mCtx);
        }
        return mInstance;
    }
    public AppDatabase getMyDatabase() {
        return myDatabase;
    }


}
