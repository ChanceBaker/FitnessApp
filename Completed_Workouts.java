package com.fitapp.sdp.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class Completed_Workouts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_workouts);
        workoutRecords(MainActivity.fitAppDb);
    }

    private void scrollView() {

        final ScrollView scrollview = ((ScrollView) findViewById(R.id.workout_records_scrollView));
        scrollview.post(new Runnable() {
            @Override
            public void run() {
                scrollview.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }

    private void workoutRecords(DatabaseHelper db) {

        ArrayList<Workout_Complete> records = DatabaseHelper.getWorkoutRecords(MainActivity.fitAppDb);
        TextView recordText = (TextView)findViewById(R.id.workout_records);
        String recordsString = "";

        for(Workout_Complete wc: records)
        {
            recordsString += wc.toString() + "\n\n";
        }

        String noRecords = "There are no records to displays";

        if(records.size() > 0)
        {
            recordText.setText(recordsString);
        }
        else {
            recordText.setText(noRecords);
        }

        scrollView();
    }
}
