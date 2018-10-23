package com.fitapp.sdp.fitnessapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Chest_Workout_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_workout_1);
        saveButton();
    }

    private void saveButton() {

        Button save = (Button) findViewById(R.id.save_workout_button);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox ex1Check = (CheckBox) findViewById(R.id.exercise_1_checkbox);
                CheckBox ex2Check = (CheckBox) findViewById(R.id.exercise_2_checkbox);
                CheckBox ex3Check = (CheckBox) findViewById(R.id.exercise_3_checkbox);
                TableRow message = (TableRow) findViewById(R.id.message);
                TextView messageText = (TextView) findViewById(R.id.messageText);
                if(ex1Check.isChecked() || ex2Check.isChecked() || ex3Check.isChecked())
                {

                    String workoutDetails = "";

                    TextView ex1Text = (TextView) findViewById(R.id.exercise_1_textview);


                    if(ex1Check.isChecked())
                    {
                        workoutDetails += ex1Text.getText()+ "\n";
                    }

                    TextView ex2Text = (TextView) findViewById(R.id.exercise_2_textview);

                    if(ex2Check.isChecked())
                    {
                        workoutDetails += ex2Text.getText() + "\n";
                    }

                    TextView ex3Text = (TextView) findViewById(R.id.exercise_3_textview);

                    if(ex3Check.isChecked())
                    {
                        workoutDetails += ex3Text.getText();
                    }

                    SimpleDateFormat isoFormat = new SimpleDateFormat("dd-MM-yyyy");
                    isoFormat.setTimeZone(TimeZone.getTimeZone("NZST"));
                    Date date = null;
                    try {
                        date = isoFormat.parse("22-10-2018");
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    String[] dateSplit = date.toString().split(" ");
                    String dateString = dateSplit[0] + " " + dateSplit[1] + " " + dateSplit[2] + " " + dateSplit[5];

                    Workout_Complete wc = new Workout_Complete(dateString, workoutDetails);
                    DatabaseHelper.addWorkoutRecord(MainActivity.fitAppDb, wc);
                    messageText.setText("Workout saved");
                    messageText.setTextColor(Color.GREEN);
                    message.setVisibility(View.VISIBLE);
                    ex1Check.setChecked(false);
                    ex2Check.setChecked(false);
                    ex3Check.setChecked(false);
                }
                else{

                    messageText.setText("You must check at least 1 exercise to save");
                    messageText.setTextColor(Color.RED);
                    message.setVisibility(View.VISIBLE);
                }


            }
        });
    }
}
