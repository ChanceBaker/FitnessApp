package com.fitapp.sdp.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class Measurements extends AppCompatActivity {

    private double neckWid, lBicep, rBicep, chestWid,lForearm,rForearm,waistWid,lThigh,rThigh,lCalf,rCalf = 0;
    private EditText neckMes,lBicepMes,rBicepMes,chestMes,lForearmMes, rForearmMes,waistMes,lThighMes,rThighMes,lCalfMes,rCalfMes;
    private TextView saved, noValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.measurements);
        saveButton();
        setUp();
    }

    private void saveButton() {

        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveProcess();
            }
        });
    }

    private void saveProcess() {

        getValues();
         if(!noValues())
        {
            noValues.setVisibility(View.INVISIBLE);
            checkValues();
            createAndSaveRecord();
        }
        else
        {
            saved.setVisibility(View.INVISIBLE);
            noValues.setVisibility(View.VISIBLE);
        }

    }

    private void createAndSaveRecord() {

        Date date = new Date();
        String [] dateSplit = date.toString().split(" ");
        String dateString = dateSplit[0] + " " + dateSplit[1] + " " +dateSplit[2];

        Measurement_Record record = new Measurement_Record(neckWid,lBicep,rBicep,chestWid,lForearm,rForearm,waistWid,lThigh,rThigh,lCalf,rCalf,dateString);
        MainActivity.fitAppDb.addMeasurementRecord(MainActivity.fitAppDb, record);
        noValues.setVisibility(View.INVISIBLE);
        saved.setVisibility(View.VISIBLE);
        reset();
    }

    public boolean noValues()
    {
        return neckWid == 0 && lBicep == 0 && rBicep == 0 && chestWid == 0 && lForearm== 0 && rForearm== 0 &&
            waistWid== 0 && lThigh == 0 &&rThigh == 0 &&lCalf == 0 && rCalf == 0;
    }

    private void reset() {

        neckMes.setText("");
        lBicepMes.setText("");
        rBicepMes.setText("");
        chestMes.setText("");
        lForearmMes.setText("");
        rForearmMes.setText("");
        waistMes.setText("");
        lThighMes.setText("");
        rThighMes.setText("");
        lCalfMes.setText("");
        rCalfMes.setText("");
        neckWid = 0; lBicep = 0; rBicep = 0; chestWid = 0;lForearm = 0;rForearm = 0;
        waistWid = 0;lThigh = 0;rThigh = 0;lCalf = 0;rCalf = 0;
    }

    private void checkValues() {

        if(lBicep == 0 && rBicep != 0)
        {
            lBicep = rBicep;
        }
        else if(rBicep == 0 && lBicep != 0)
        {
            rBicep = lBicep;
        }

        if(lForearm == 0 && rForearm != 0)
        {
            lForearm = rForearm;
        }
        else if(rForearm == 0 && lForearm != 0)
        {
            rForearm = lForearm;
        }

        if(lThigh == 0 && rThigh != 0)
        {
            lThigh = rThigh;
        }
        else if(rThigh == 0 && lThigh != 0)
        {
            rThigh = lThigh;
        }

        if(lCalf == 0 && rCalf != 0)
        {
            lCalf = rCalf;
        }
        else if(rCalf == 0 && lCalf != 0)
        {
            rCalf = lCalf;
        }

    }

    private void getValues()
    {
        String neck = neckMes.getText().toString();
        if(!neck.equals(""))
        {
            neckWid = Double.valueOf(neck);
        }

        String lB = lBicepMes.getText().toString();
        if(!lB.equals(""))
        {
            lBicep = Double.valueOf(lB);
        }

        String rB = rBicepMes.getText().toString();
        if(!rB.equals(""))
        {
            rBicep = Double.valueOf(rB);
        }

        String chest = chestMes.getText().toString();
        if(!chest.equals(""))
        {
            chestWid = Double.valueOf(chest);
        }

        String lF = lForearmMes.getText().toString();
        if(!lF.equals(""))
        {
            lForearm = Double.valueOf(lF);
        }

        String rF = rForearmMes.getText().toString();
        if(!rF.equals(""))
        {
            rForearm = Double.valueOf(rF);
        }

        String w = waistMes.getText().toString();
        if(!w.equals(""))
        {
            waistWid = Double.valueOf(w);
        }

        String lT = lThighMes.getText().toString();
        if(!lT.equals(""))
        {
            lThigh = Double.valueOf(lT);
        }

        String rT = rThighMes.getText().toString();
        if(!rT.equals(""))
        {
            rThigh = Double.valueOf(rT);
        }

        String lC = lCalfMes.getText().toString();
        if(!lC.equals(""))
        {
            lCalf = Double.valueOf(lC);
        }

        String rC = rCalfMes.getText().toString();
        if(!rC.equals(""))
        {
            rCalf = Double.valueOf(rC);
        }
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
        saved = (TextView) findViewById(R.id.saved);
        noValues = (TextView) findViewById(R.id.noValues);
    }
}
