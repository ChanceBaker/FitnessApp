package com.fitapp.sdp.fitnessapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;

/**
 * This class creates a database for storing user information. It utilizes a singleton
 * pattern to ensure that the app only has one database.
 * */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper sInstance;
    public static final String DATABASE_NAME = "fitnessapp.db";

    public static final String PROGRESS_TABLE = "progress_table";
    public static final String P_ID = "P_ID";
    public static final String P_WEIGHT = "P_WEIGHT";
    public static final String P_DATE = "P_DATE";

    public static final String MEASURE_TABLE = "measurements_table";
    public static final String M_ID = "M_ID";
    public static final String M_DATE = "M_DATE";
    public static final String M_NECK = "M_NECK";
    public static final String M_CHEST = "M_CHEST";
    public static final String M_L_BICEP = "M_L_BICEP";
    public static final String M_L_FOREARM = "M_L_FOREARM";
    public static final String M__R_BICEP = "M_R_BICEP";
    public static final String M_R_FOREARM = "M_R_FOREARM";
    public static final String M_WAIST = "M_WAIST";
    public static final String M_L_THIGH = "M_L_THIGH";
    public static final String M_R_THIGH = "M_R_THIGH";
    public static final String M_L_CALF = "M_L_CALF";
    public static final String M_R_CALF = "M_R_CALF";

    public static final String WORKOUT_TABLE = "workout_table";
    public static final String W_ID = "W_ID";
    public static final String W_DATE = "W_DATE";
    public static final String W_DETAILS = "W_DETAILS";


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

        db.execSQL(create + PROGRESS_TABLE + "(P_ID INTEGER PRIMARY KEY AUTOINCREMENT, P_WEIGHT DOUBLE(3,2), P_DATE TEXT)");
        Log.i("Fitness App","Progress Table Created");

        db.execSQL(create + MEASURE_TABLE + "(M_ID INTEGER PRIMARY KEY AUTOINCREMENT, M_DATE TEXT, M_NECK DECIMAL(3,1), M_L_BICEP DECIMAL(3,1) " +
                ",M_R_BICEP DECIMAL(3,2), M_CHEST DECIMAL(3,2), M_L_FOREARM DECIMAL(3,1), M_R_FOREARM DECIMAL(3,1), M_WAIST DECIMAL(3,1)" +
                ", M_L_THIGH DECIMAL(3,1), M_R_THIGH DECIMAL(3,1), M_L_CALF DECIMAL(3,1), M_R_CALF DECIMAL(3,1))");
        Log.i("Fitness App","Measurement Table Created");

        db.execSQL(create + WORKOUT_TABLE + "(W_ID INTEGER PRIMARY KEY AUTOINCREMENT, W_DATE TEXT, W_DETAILS TEXT)");
        Log.i("Fitness App","Workout Table Created");
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
        db.execSQL("DROP TABLE IF EXISTS " + WORKOUT_TABLE);
        Log.i("Fitness App",WORKOUT_TABLE + " dropped");
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

    public static ArrayList<Weight_Record> getWeightRecords(DatabaseHelper db)
    {
        ArrayList<Weight_Record> weightRecords = new ArrayList<>();

        String [] columns = {"P_ID","P_WEIGHT","P_DATE"};
        Cursor cursor = db.getReadableDatabase().query(PROGRESS_TABLE, columns, null, null, null, null, null);

        cursor.moveToFirst();
        boolean notNull = false;
        if(cursor.getCount() > 0)
        {
             notNull = !cursor.isNull(cursor.getColumnIndex("P_ID"));
        }

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast() && notNull)  {
                double weight = cursor.getDouble(cursor.getColumnIndex(P_WEIGHT));
                String date = cursor.getString(cursor.getColumnIndex(P_DATE));
                Weight_Record record = new Weight_Record(weight,date);
                weightRecords.add(record);
                cursor.moveToNext();
            }
        }

        cursor.close();
        return weightRecords;
    }

    public static ArrayList<Workout_Complete> getWorkoutRecords(DatabaseHelper db)
    {
        ArrayList<Workout_Complete> workoutRecords = new ArrayList<>();

        String [] columns = {"W_ID","W_DATE","W_DETAILS"};
        Cursor cursor = db.getReadableDatabase().query(WORKOUT_TABLE, columns, null, null, null, null, null);

        cursor.moveToFirst();
        boolean notNull = false;
        if(cursor.getCount() > 0)
        {
            notNull = !cursor.isNull(cursor.getColumnIndex("W_ID"));
        }

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast() && notNull)  {
                String date = cursor.getString(cursor.getColumnIndex(W_DATE));
                String details = cursor.getString(cursor.getColumnIndex(W_DETAILS));
                Workout_Complete record = new Workout_Complete(date, details);
                workoutRecords.add(record);
                cursor.moveToNext();
            }
        }

        cursor.close();
        return workoutRecords;
    }

    public static ArrayList<Measurement_Record> getMeasurementRecords(DatabaseHelper db)
    {
        ArrayList<Measurement_Record> measurementRecords = new ArrayList<>();

        String [] columns = {"M_ID", "M_DATE", "M_NECK" , "M_L_BICEP", "M_R_BICEP", "M_CHEST", "M_L_FOREARM", "M_R_FOREARM", "M_WAIST","M_L_THIGH", "M_R_THIGH", "M_L_CALF", "M_R_CALF"};

        Cursor cursor = db.getReadableDatabase().query(MEASURE_TABLE, columns, null, null, null, null, null);

        cursor.moveToFirst();
        boolean notNull = false;
        if(cursor.getCount() > 0)
        {
            notNull = !cursor.isNull(cursor.getColumnIndex("M_ID"));
        }

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast() && notNull)  {
                double neck = cursor.getDouble(cursor.getColumnIndex(M_NECK));
                double lBicep = cursor.getDouble(cursor.getColumnIndex(M_L_BICEP));
                double rBicep = cursor.getDouble(cursor.getColumnIndex(M__R_BICEP));
                double chest = cursor.getDouble(cursor.getColumnIndex(M_CHEST));
                double lForearm = cursor.getDouble(cursor.getColumnIndex(M_L_FOREARM));
                double rForearm = cursor.getDouble(cursor.getColumnIndex(M_R_FOREARM));
                double waist = cursor.getDouble(cursor.getColumnIndex(M_WAIST));
                double lThigh = cursor.getDouble(cursor.getColumnIndex(M_L_THIGH));
                double rThigh = cursor.getDouble(cursor.getColumnIndex(M_R_THIGH));
                double lCalf = cursor.getDouble(cursor.getColumnIndex(M_L_CALF));
                double rCalf = cursor.getDouble(cursor.getColumnIndex(M_R_CALF));
                String date = cursor.getString(cursor.getColumnIndex(M_DATE));

                Measurement_Record record = new Measurement_Record(neck,lBicep,rBicep,chest,lForearm,rForearm,waist,lThigh,rThigh,lCalf,rCalf,date);
                measurementRecords.add(record);
                cursor.moveToNext();
            }
        }

        cursor.close();
        return measurementRecords;
    }

    public static void addWeightRecord(DatabaseHelper db, Weight_Record record) {

        String [] columns = {"P_ID","P_WEIGHT","P_DATE"};
        Cursor cursor = db.getReadableDatabase().query(PROGRESS_TABLE, columns, null, null, null, null, null);
        int rowID = cursor.getCount()+1;
        cursor.close();

        String query = "INSERT INTO "+PROGRESS_TABLE+ " VALUES("+rowID+","+record.getWeight() + ",\"" +record.getDate()+ "\")";
        db.getWritableDatabase().execSQL(query);
        Log.i("Weight Record Added", query);
    }

    public static void addWorkoutRecord(DatabaseHelper db, Workout_Complete record) {

        String [] columns = {"W_ID","W_DATE","W_DETAILS"};
        Cursor cursor = db.getReadableDatabase().query(WORKOUT_TABLE, columns, null, null, null, null, null);
        int rowID = cursor.getCount()+1;
        cursor.close();

        String query = "INSERT INTO "+WORKOUT_TABLE+ " VALUES("+rowID+",\""+record.getDate()+"\"" + ",\"" +record.getWorkoutDetails()+ "\")";
        db.getWritableDatabase().execSQL(query);
        Log.i("Weight Record Added", query);
    }

    public static void addMeasurementRecord(DatabaseHelper db, Measurement_Record record) {

        String [] columns = {"M_ID", "M_DATE", "M_NECK" , "M_L_BICEP", "M_R_BICEP", "M_CHEST", "M_L_FOREARM", "M_R_FOREARM", "M_WAIST","M_L_THIGH", "M_R_THIGH", "M_L_CALF", "M_R_CALF"};
        Cursor cursor = db.getReadableDatabase().query(MEASURE_TABLE, columns, null, null, null, null, null);
        int rowID = cursor.getCount()+1;
        cursor.close();

        String query = "INSERT INTO "+MEASURE_TABLE+ " VALUES("+rowID+",\""+record.getDate()+"\","+record.getNeckWid() + "," +record.getlBicep()+ "," +record.getrBicep()+","
                +record.getChestWid() +  "," +record.getlForearm()+ "," +record.getrForearm()+ "," +record.getWaistWid()+ "," +record.getlThigh()+ ","
                +record.getrThigh()+ "," +record.getlCalf()+ "," +record.getrCalf()+ ")";
        db.getWritableDatabase().execSQL(query);
        Log.i("Weight Record Added", query);
    }

    public static void resetMeasureTable(SQLiteDatabase db)
    {
        String create = "CREATE TABLE IF NOT EXISTS ";
        db.execSQL("DROP TABLE IF EXISTS " + MEASURE_TABLE);
        Log.i("Fitness App",MEASURE_TABLE + " dropped");
        db.execSQL(create + MEASURE_TABLE + "(M_ID INTEGER PRIMARY KEY AUTOINCREMENT, M_DATE TEXT, M_NECK DECIMAL(3,1), M_L_BICEP DECIMAL(3,1) " +
                ",M_R_BICEP DECIMAL(3,2), M_CHEST DECIMAL(3,2), M_L_FOREARM DECIMAL(3,1), M_R_FOREARM DECIMAL(3,1), M_WAIST DECIMAL(3,1)" +
                ", M_L_THIGH DECIMAL(3,1), M_R_THIGH DECIMAL(3,1), M_L_CALF DECIMAL(3,1), M_R_CALF DECIMAL(3,1))");
        Log.i("Fitness App","Measurement Table Created");

    }

    public static void resetWorkoutTable(SQLiteDatabase db)
    {
        db.execSQL("DROP TABLE IF EXISTS " + WORKOUT_TABLE);
        Log.i("Fitness App",WORKOUT_TABLE + " dropped");
        String create = "CREATE TABLE IF NOT EXISTS ";
        db.execSQL(create + WORKOUT_TABLE + "(W_ID INTEGER PRIMARY KEY AUTOINCREMENT, W_DATE TEXT, W_DETAILS TEXT)");
        Log.i("Fitness App","Workout Table Created");

    }

    public static void resetWeightTable(SQLiteDatabase db)
    {
        db.execSQL("DROP TABLE IF EXISTS " + PROGRESS_TABLE);
        Log.i("Fitness App",PROGRESS_TABLE + " dropped");
        String create = "CREATE TABLE IF NOT EXISTS ";
        db.execSQL(create + PROGRESS_TABLE + "(P_ID INTEGER PRIMARY KEY AUTOINCREMENT, P_WEIGHT DOUBLE(3,2), P_DATE TEXT)");
        Log.i("Fitness App","Progress Table Created");

    }

    public static void resetApp(SQLiteDatabase db)
    {
        db.execSQL("DROP TABLE IF EXISTS " + PROGRESS_TABLE);
        Log.i("Fitness App",PROGRESS_TABLE + " dropped");
        db.execSQL("DROP TABLE IF EXISTS " + MEASURE_TABLE);
        Log.i("Fitness App",MEASURE_TABLE + " dropped");
        db.execSQL("DROP TABLE IF EXISTS " + WORKOUT_TABLE);
        Log.i("Fitness App",WORKOUT_TABLE + " dropped");

        String create = "CREATE TABLE IF NOT EXISTS ";

        db.execSQL(create + PROGRESS_TABLE + "(P_ID INTEGER PRIMARY KEY AUTOINCREMENT, P_WEIGHT DOUBLE(3,2), P_DATE TEXT)");
        Log.i("Fitness App","Progress Table Created");

        db.execSQL(create + MEASURE_TABLE + "(M_ID INTEGER PRIMARY KEY AUTOINCREMENT, M_DATE TEXT, M_NECK DECIMAL(3,1), M_L_BICEP DECIMAL(3,1) " +
                ",M_R_BICEP DECIMAL(3,2), M_CHEST DECIMAL(3,2), M_L_FOREARM DECIMAL(3,1), M_R_FOREARM DECIMAL(3,1), M_WAIST DECIMAL(3,1)" +
                ", M_L_THIGH DECIMAL(3,1), M_R_THIGH DECIMAL(3,1), M_L_CALF DECIMAL(3,1), M_R_CALF DECIMAL(3,1))");
        Log.i("Fitness App","Measurement Table Created");

        db.execSQL(create + WORKOUT_TABLE + "(W_ID INTEGER PRIMARY KEY AUTOINCREMENT, W_DATE TEXT, W_DETAILS TEXT)");
        Log.i("Fitness App","Workout Table Created");

    }

}
