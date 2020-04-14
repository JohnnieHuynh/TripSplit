package com.example.tripsplit.Model;

import android.content.Context;
/*


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

 */

import com.example.tripsplit.MainActivity;

/**
 * Room Database that is used to access and link each our tables within the database
 * ** DEPRECIATED **
 */

/*
@Database(entities = {
        //All Tables (Currently Placeholderss)
        MainActivity.class

}, version = 1, exportSchema = false)

public abstract class AppDatabase extends RoomDatabase {

    //AppDatabase Instance Variable
    private static AppDatabase INSTANCE;

    //Table Names
    public static final String ACCOUNT_TABLE="accountTable";

    //Funcs

    //Create Instance of Room DB if not already active
    public static AppDatabase getAppDatabase(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    "db-tripsplit")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
 */
