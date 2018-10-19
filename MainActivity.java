package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{

    public DatabaseHelper fitAppDb;

//    private float weight, height, neckWid, lBicep, rBicep,
//    chestWid,lForearm,rForearm,waistWid,lThigh,rThigh,lCalf,rCalf;
//
//    private EditText weightInput,heightInput,outputBMI;
//
//    private EditText neckMes,lBicepMes,rBicepMes,chestMes,lForearmMes,
//    rForearmMes,waistMes,lThighMes,rThighMes,lCalfMes,rCalfMes;
//
//    private Button calcBMI;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fitAppDb = DatabaseHelper.getInstance(this);
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

//    public void measurementInput(View view) {
//        setContentView(R.layout.measurements);
//
//        neckMes = (EditText) findViewById(R.id.neckMes);
//        lBicepMes = (EditText) findViewById(R.id.lBicepMes);
//        rBicepMes = (EditText) findViewById(R.id.rBicepMes);
//        chestMes = (EditText) findViewById(R.id.chestMes);
//        lForearmMes = (EditText) findViewById(R.id.lForearmMes);
//        rForearmMes = (EditText) findViewById(R.id.rForearmMes);
//        waistMes = (EditText) findViewById(R.id.waistMes);
//        lThighMes = (EditText) findViewById(R.id.lThighMes);
//        rThighMes = (EditText) findViewById(R.id.rThighMes);
//        lCalfMes = (EditText) findViewById(R.id.lCalfMes);
//        rCalfMes = (EditText) findViewById(R.id.rCalfMes);
//
//        neckWid = Float.valueOf(neckMes.getText().toString());
//        lBicep = Float.valueOf(lBicepMes.getText().toString());
//        rBicep = Float.valueOf(rBicepMes.getText().toString());
//        chestWid = Float.valueOf(chestMes.getText().toString());
//        lForearm = Float.valueOf(lForearmMes.getText().toString());
//        rForearm = Float.valueOf(rForearmMes.getText().toString());
//        waistWid = Float.valueOf(neckMes.getText().toString());
//        lThigh = Float.valueOf(neckMes.getText().toString());
//        rThigh = Float.valueOf(neckMes.getText().toString());
//        lCalf = Float.valueOf(neckMes.getText().toString());
//        rCalf = Float.valueOf(neckMes.getText().toString());
//
//    }

//    public void openBMICalculator(View view)
//    {
//        setContentView(R.layout.bmi_calc);
//        weightInput = (EditText) findViewById(R.id.weightInput);
//        heightInput = (EditText) findViewById(R.id.heightInput);
//        outputBMI = (EditText) findViewById(R.id.outputBMI);
//        calcBMI = (Button) findViewById(R.id.calcBMI);
//
//        calcBMI.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String sWeight = weightInput.getText().toString();
//                String sHeight = heightInput.getText().toString();
//
//                if(!sWeight.equals("") && !sHeight.equals(""))
//                {
//                    weight = Float.valueOf(sWeight);
//                    height = Float.valueOf(sHeight);
//
//                    float BMI = weight / (height * height);
//                    String bmiString = ""+BMI;
//                    outputBMI.setText(bmiString);
//                }
//            }
//        });
//    }
}
