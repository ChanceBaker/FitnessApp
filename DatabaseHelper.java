package com.fitapp.sdp.fitnessapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * This class creates a database for storing user information. It utilizes a singleton
 * pattern to ensure that the app only has one database.
 * */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper sInstance;
    public static final String DATABASE_NAME = "fitnessapp.db";

    public static final String PROGRESS_TABLE = "progress_table";
    public static final String P_ID = "ID";
    public static final String P_WEIGHT = "WEIGHT";
    public static final String P_DATE = "DATE";

    public static final String MEASURE_TABLE = "measurements_table";
    public static final String M_ID = "ID";
    public static final String M_DATE = "DATE";
    public static final String M_NECK = "NECK";
    public static final String M_CHEST = "CHEST";
    public static final String M_L_BICEP = "L_BICEP";
    public static final String M_L_FOREARM = "L_FOREARM";
    public static final String M__R_BICEP = "R_BICEP";
    public static final String M_R_FOREARM = "R_FOREARM";
    public static final String M_WAIST = "WAIST";
    public static final String M_L_THIGH = "L_THIGH";
    public static final String M_R_THIGH = "R_THIGH";
    public static final String M_L_CALF = "L_CALF";
    public static final String M_R_CALF = "R_CALF";

    /**
     * This constructor creates a database for storing user weight and measurements information.
     * The constructor is private to prevent direct instantiation as part of the singleton pattern
     * and the getInstance method is used instead to check for an existing database or create a new
     * database if needed.
     *
     * @param context - The applications context
     * */
    private DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, 1);
    }

    /**
     * This method creates tables in the database for storing information. These tables
     * are used to track user weight loss/gain progress and body measurements.
     *
     * @param db - the database where the tables will be created
     * */
    @Override
    public void onCreate(SQLiteDatabase db) {

            String create = "CREATE TABLE IF NOT EXISTS ";

            db.execSQL(create + PROGRESS_TABLE + "(P_ID INTEGER PRIMARY KEY AUTOINCREMENT, P_WEIGHT DECIMAL(3,2), P_DATE TEXT)");
            Log.i("Fitness App","Progress Table Created");

            db.execSQL(create + MEASURE_TABLE + "(M_ID INTEGER PRIMARY KEY AUTOINCREMENT, M_DATE TEXT, M_NECK DECIMAL(3,1), M_CHEST DECIMAL(3,1) " +
                    ",M_L_BICEP DECIMAL(3,2), M_L_FOREARM DECIMAL(3,2), M_R_BICEP DECIMAL(3,1), M_R_FOREARM DECIMAL(3,1), M_WAIST DECIMAL(3,1)" +
                    ", M_L_THIGH DECIMAL(3,1), M_R_THIGH DECIMAL(3,1), M_L_CALF DECIMAL(3,1), M_R_CALF DECIMAL(3,1))");
            Log.i("Fitness App","Measurement Table Created");
    }

    /**
     * This method drops the tables in the database so that they can be upgraded. After
     * tables are dropped, onCreate method is called to create new tables.
     *
     * @param db - database to be upgraded
     * @param oldVersion - the old database version
     * @param newVersion - the new database version
     *
     * */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PROGRESS_TABLE);
        Log.i("Fitness App",PROGRESS_TABLE + " dropped");
        db.execSQL("DROP TABLE IF EXISTS " + MEASURE_TABLE);
        Log.i("Fitness App",MEASURE_TABLE + " dropped");
        onCreate(db);
    }

    /**
     * This methods implements a singleton pattern for the database to avoid
     * memory leaks and unnecessary reallocation to ensure the app has a single
     * database across it's entire lifespan.
     *
     * @param context - The applications context
     * @return synchronized - synchronized database, if the database is null, a new one is created and returned otherwise the existing databse is returned
     * */
    public static synchronized DatabaseHelper getInstance(Context context) {

        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }
}
