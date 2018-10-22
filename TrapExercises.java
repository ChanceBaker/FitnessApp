package com.fitapp.sdp.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrapExercises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trap_exercises);
        smithMachineShrugButton();
        leverageShrugButton();
        barbellShrugButton();
        sumoHighPullButton();
        calfShoulderShrug();
    }

    private void smithMachineShrugButton() {
        Button smithMachineShrug = (Button) findViewById(R.id.smithMachineShrug);
        smithMachineShrug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrapExercises.this, t1SmithMachineShrug.class));
            }
        });
    }

    private void leverageShrugButton() {
        Button leverageShrug = (Button) findViewById(R.id.leverageShrug);
        leverageShrug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrapExercises.this, t2LeverageShrug.class));
            }
        });
    }

    private void barbellShrugButton() {
        Button barbellShrug = (Button) findViewById(R.id.barbellShrugs);
        barbellShrug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrapExercises.this, t3BarbellShrugs.class));
            }
        });
    }

    private void sumoHighPullButton() {
        Button sumoHighPull = (Button) findViewById(R.id.highPull);
        sumoHighPull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrapExercises.this, t4SumoHighPull.class));
            }
        });
    }

    private void calfShoulderShrug() {
        Button plateNeckResist = (Button) findViewById(R.id.shoulderShrug);
        plateNeckResist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TrapExercises.this, t5CalfShoulderShrug.class));
            }
        });
    }
}
