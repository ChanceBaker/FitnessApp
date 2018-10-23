package com.fitapp.sdp.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class My_Measurements extends AppCompatActivity {

    private TextView measurementTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_measurements);
        measurementRecords(MainActivity.fitAppDb);
    }

    private void scrollView() {

        final ScrollView scrollview = ((ScrollView) findViewById(R.id.measure_records_scrollView));
        scrollview.post(new Runnable() {
            @Override
            public void run() {
                scrollview.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }

    private void measurementRecords(DatabaseHelper db) {

        TextView records = (TextView)findViewById(R.id.measurement_records);
        String dbRecords = getRecords(MainActivity.fitAppDb);
        String noRecords = "There are no records to displays";

        if(dbRecords != null)
        {
            records.setText(dbRecords);
        }
        else {
            records.setText(noRecords);
        }

        scrollView();
    }

    private String getRecords(DatabaseHelper db) {

        ArrayList<Measurement_Record> records = DatabaseHelper.getMeasurementRecords(db);
        String recordString = "";
        String resultString = "You've ";
        String overallResultString = "Overall you have\n";

        boolean noRecords = records.size() == 0;
        boolean calculate = records.size() >= 2;

        if(!noRecords)
        {
            for(Measurement_Record wr: records)
            {
                recordString += wr.toString();
            }

            if(calculate)
            {
                resultString = calculateLast2Entries(resultString, records);
                overallResultString = calculateOverAllResult(overallResultString, records);
                recordString += resultString + " since your last entry\n\n" + overallResultString;
                return recordString;
            }
            else
            {
                return recordString;
            }
        }
        else
        {
            return null;
        }
    }

    private String calculateOverAllResult(String overallResultString, ArrayList<Measurement_Record> records) {

        double first = records.get(0).getNeckWid();
        double last = records.get(records.size()-1).getNeckWid();

        boolean loss = last < first;

        double result = 0;
        if(loss)
        {
            result = first - last;
            overallResultString += String.format("decreased your neck by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                overallResultString += "had no change in your neck measurement\n";
            }
            else
            {
                result = last - first;
                overallResultString += String.format("increased your neck by %1.2f cm\n", result);
            }

        }

        /**Left Bicep**/

        first = records.get(0).getlBicep();
        last = records.get(records.size()-1).getlBicep();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            overallResultString += String.format("decreased your left bicep by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                overallResultString += "had no change in your left bicep measurement\n";
            }
            else
            {
                result = last - first;
                overallResultString += String.format("increased your left bicep by %1.2f cm\n", result);
            }

        }

        /**Right Bicep**/

        first = records.get(0).getrBicep();
        last = records.get(records.size()-1).getrBicep();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            overallResultString += String.format("decreased your right bicep by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                overallResultString += "had no change in your right bicep measurement\n";
            }
            else
            {
                result = last - first;
                overallResultString += String.format("increased your right bicep by %1.2f cm\n", result);
            }

        }

        /**Chest**/

        first = records.get(0).getChestWid();
        last = records.get(records.size()-1).getChestWid();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            overallResultString += String.format("decreased your chest by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                overallResultString += "had no change in your chest measurement\n";
            }
            else
            {
                result = last - first;
                overallResultString += String.format("increased your chest by %1.2f cm\n", result);
            }

        }

        /**Left Forearm**/

        first = records.get(0).getlForearm();
        last = records.get(records.size()-1).getlForearm();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            overallResultString += String.format("decreased your left forearm by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                overallResultString += "had no change in your left forearm measurement\n";
            }
            else
            {
                result = last - first;
                overallResultString += String.format("increased your left forearm by %1.2f cm\n", result);
            }

        }

        /**Right Forearm**/

        first = records.get(0).getrForearm();
        last = records.get(records.size()-1).getrForearm();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            overallResultString += String.format("decreased your right forearm by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                overallResultString += "had no change in your right forearm measurement\n";
            }
            else
            {
                result = last - first;
                overallResultString += String.format("increased your right forearm by %1.2f cm\n", result);
            }

        }

        /**Waist**/

        first = records.get(0).getWaistWid();
        last = records.get(records.size()-1).getWaistWid();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            overallResultString += String.format("decreased your waist by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                overallResultString += "had no change in your waist measurement\n";
            }
            else
            {
                result = last - first;
                overallResultString += String.format("increased your waist by %1.2f cm\n", result);
            }
        }

        /**Left Thigh**/

        first = records.get(0).getlThigh();
        last = records.get(records.size()-1).getlThigh();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            overallResultString += String.format("decreased your left thigh by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                overallResultString += "had no change in your left thigh measurement\n";
            }
            else
            {
                result = last - first;
                overallResultString += String.format("increased your left thigh by %1.2f cm\n", result);
            }
        }

        /**Right Thigh**/

        first = records.get(0).getrThigh();
        last = records.get(records.size()-1).getrThigh();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            overallResultString += String.format("decreased your right thigh by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                overallResultString += "had no change in your right thigh measurement\n";
            }
            else
            {
                result = last - first;
                overallResultString += String.format("increased your right thigh by %1.2f cm\n", result);
            }
        }

        /**Left Calf**/

        first = records.get(0).getlCalf();
        last = records.get(records.size()-1).getlCalf();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            overallResultString += String.format("decreased your left calf by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                overallResultString += "had no change in your left calf measurement\n";
            }
            else
            {
                result = last - first;
                overallResultString += String.format("increased your left calf by %1.2f cm\n", result);
            }
        }

        /**Right Calf**/

        first = records.get(0).getrCalf();
        last = records.get(records.size()-1).getrCalf();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            overallResultString += String.format("decreased your right calf by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                overallResultString += "had no change in your right calf measurement\n";
            }
            else
            {
                result = last - first;
                overallResultString += String.format("increased your right calf by %1.2f cm\n", result);
            }
        }

        return overallResultString;
    }

    private String calculateLast2Entries(String resultString, ArrayList<Measurement_Record> records) {

        double first = records.get(records.size()-2).getNeckWid();
        double last = records.get(records.size()-1).getNeckWid();

        boolean loss = last < first;

        double result = 0;
        if(loss)
        {
            result = first - last;
            resultString += String.format("decreased your neck by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                resultString += "had no change in your neck measurement\n";
            }
            else
            {
                result = last - first;
                resultString += String.format("increased your neck by %1.2f cm\n", result);
            }

        }

        /**Left Bicep**/

        first = records.get(records.size()-2).getlBicep();
        last = records.get(records.size()-1).getlBicep();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            resultString += String.format("decreased your left bicep by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                resultString += "had no change in your left bicep measurement\n";
            }
            else
            {
                result = last - first;
                resultString += String.format("increased your left bicep by %1.2f cm\n", result);
            }

        }

        /**Right Bicep**/

        first = records.get(records.size()-2).getrBicep();
        last = records.get(records.size()-1).getrBicep();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            resultString += String.format("decreased your right bicep by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                resultString += "had no change in your right bicep measurement\n";
            }
            else
            {
                result = last - first;
                resultString += String.format("increased your right bicep by %1.2f cm\n", result);
            }

        }

        /**Chest**/

        first = records.get(records.size()-2).getChestWid();
        last = records.get(records.size()-1).getChestWid();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            resultString += String.format("decreased your chest by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                resultString += "had no change in your chest measurement\n";
            }
            else
            {
                result = last - first;
                resultString += String.format("increased your chest by %1.2f cm\n", result);
            }

        }

        /**Left Forearm**/

        first = records.get(records.size()-2).getlForearm();
        last = records.get(records.size()-1).getlForearm();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            resultString += String.format("decreased your left forearm by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                resultString += "had no change in your left forearm measurement\n";
            }
            else
            {
                result = last - first;
                resultString += String.format("increased your left forearm by %1.2f cm\n", result);
            }

        }

        /**Right Forearm**/

        first = records.get(records.size()-2).getrForearm();
        last = records.get(records.size()-1).getrForearm();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            resultString += String.format("decreased your right forearm by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                resultString += "had no change in your right forearm measurement\n";
            }
            else
            {
                result = last - first;
                resultString += String.format("increased your right forearm by %1.2f cm\n", result);
            }

        }

        /**Waist**/

        first = records.get(records.size()-2).getWaistWid();
        last = records.get(records.size()-1).getWaistWid();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            resultString += String.format("decreased your waist by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                resultString += "had no change in your waist measurement\n";
            }
            else
            {
                result = last - first;
                resultString += String.format("increased your waist by %1.2f cm\n", result);
            }
        }

        /**Left Thigh**/

        first = records.get(records.size()-2).getlThigh();
        last = records.get(records.size()-1).getlThigh();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            resultString += String.format("decreased your left thigh by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                resultString += "had no change in your left thigh measurement\n";
            }
            else
            {
                result = last - first;
                resultString += String.format("increased your left thigh by %1.2f cm\n", result);
            }
        }

        /**Right Thigh**/

        first = records.get(records.size()-2).getrThigh();
        last = records.get(records.size()-1).getrThigh();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            resultString += String.format("decreased your right thigh by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                resultString += "had no change in your right thigh measurement\n";
            }
            else
            {
                result = last - first;
                resultString += String.format("increased your right thigh by %1.2f cm\n", result);
            }
        }

        /**Left Calf**/

        first = records.get(records.size()-2).getlCalf();
        last = records.get(records.size()-1).getlCalf();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            resultString += String.format("decreased your left calf by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                resultString += "had no change in your left calf measurement\n";
            }
            else
            {
                result = last - first;
                resultString += String.format("increased your left calf by %1.2f cm\n", result);
            }
        }

        /**Right Calf**/

        first = records.get(records.size()-2).getrCalf();
        last = records.get(records.size()-1).getrCalf();

        loss = last < first;

        if(loss)
        {
            result = first - last;
            resultString += String.format("decreased your right calf by %1.2f cm\n", result);
        }
        else
        {
            if(last == first)
            {
                resultString += "had no change in your right calf measurement\n";
            }
            else
            {
                result = last - first;
                resultString += String.format("increased your right calf by %1.2f cm\n", result);
            }
        }
        return resultString;
    }
}
