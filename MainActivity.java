package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    public static DatabaseHelper fitAppDb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fitAppDb = DatabaseHelper.getInstance(this);
//        fitAppDb.onUpgrade(fitAppDb.getWritableDatabase(),1,2);
        ExercisesButton();
        WorkoutsButton();
        MyProgressButton();
        NutritionButton();
        TipsButton();
        SettingsButton();

    }

    private void SettingsButton() {
        Button settings = (Button) findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Settings.class));
            }
        });
    }

    private void TipsButton() {

        Button tips = (Button) findViewById(R.id.tipsButton);
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Tips.class));
            }
        });
    }

    private void NutritionButton() {
        Button nutrition = (Button) findViewById(R.id.nutrition);
        nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Nutrition.class));
            }
        });

    }


    private void MyProgressButton() {
        Button progress = (Button) findViewById(R.id.my_progress);
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MyProgress.class));
            }
        });
    }

    private void WorkoutsButton() {
        Button workouts = (Button) findViewById(R.id.workouts);
        workouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Workouts.class));
            }
        });

    }


    private void ExercisesButton() {

        Button exercises = (Button) findViewById(R.id.exercises);
        exercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Exercise_Body_Parts.class));
            }
        });
    }
}
