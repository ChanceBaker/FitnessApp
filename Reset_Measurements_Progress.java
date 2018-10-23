package com.fitapp.sdp.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Reset_Measurements_Progress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_measurements_progress);
        yesButton();
    }

    private void yesButton() {
        Button yes = (Button) findViewById(R.id.yes_button);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseHelper.resetMeasureTable(MainActivity.fitAppDb.getWritableDatabase());
                TextView message = (TextView) findViewById(R.id.message);
                message.setVisibility(View.VISIBLE);
            }
        });
    }
}
