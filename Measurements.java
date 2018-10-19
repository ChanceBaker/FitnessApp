package com.fitapp.sdp.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Measurements extends AppCompatActivity {

    private float neckWid, lBicep, rBicep, chestWid,lForearm,rForearm,waistWid,lThigh,rThigh,lCalf,rCalf;
    private EditText neckMes,lBicepMes,rBicepMes,chestMes,lForearmMes, rForearmMes,waistMes,lThighMes,rThighMes,lCalfMes,rCalfMes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.measurements);
        setUp();
    }

    private void setUp() {

        neckMes = (EditText) findViewById(R.id.neckMes);
        lBicepMes = (EditText) findViewById(R.id.lBicepMes);
        rBicepMes = (EditText) findViewById(R.id.rBicepMes);
        chestMes = (EditText) findViewById(R.id.chestMes);
        lForearmMes = (EditText) findViewById(R.id.lForearmMes);
        rForearmMes = (EditText) findViewById(R.id.rForearmMes);
        waistMes = (EditText) findViewById(R.id.waistMes);
        lThighMes = (EditText) findViewById(R.id.lThighMes);
        rThighMes = (EditText) findViewById(R.id.rThighMes);
        lCalfMes = (EditText) findViewById(R.id.lCalfMes);
        rCalfMes = (EditText) findViewById(R.id.rCalfMes);

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
    }
}
