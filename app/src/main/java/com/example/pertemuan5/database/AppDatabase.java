package com.example.pertemuan5.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DataDiri.class},version = 1)

public abstract  class AppDatabase extends RoomDatabase {

    public abstract  DataDiriDAO dao();
    private static AppDatabase appdatabase;

    public static AppDatabase intDB(Context context) {
        if(appdatabase == null)
            appdatabase= Room.databaseBuilder(context, AppDatabase.class, "dbDataDiri").allowMainThreadQueries().build();

        return appdatabase;
    }

}
