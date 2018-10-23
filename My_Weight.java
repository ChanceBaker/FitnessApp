package com.fitapp.sdp.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class My_Weight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_weight);
        saveButton();
        weightRecords();
        scrollView();
    }

    private void scrollView() {

        final ScrollView scrollview = ((ScrollView) findViewById(R.id.weight_records_scrollView));
        scrollview.post(new Runnable() {
            @Override
            public void run() {
                scrollview.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }

    private void weightRecords() {

        TextView records = (TextView)findViewById(R.id.weight_records);
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

        ArrayList<Weight_Record> records = db.getWeightRecords(db);
        String recordString = "";
        String resultString = "You've ";
        String overallResultString = "Overall you've ";
        double result = 0;

        boolean noRecords = records.size() == 0;
        boolean calculate = records.size() >= 2;

        if(!noRecords)
        {
            for(Weight_Record wr: records)
            {
                recordString += wr.toString();
            }

            if(calculate)
            {
                resultString = calculateLast2Entries(resultString, result, records);
                overallResultString = calculateOverAllResult(overallResultString,result,records);
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

    private String calculateOverAllResult(String overallResultString, double result, ArrayList<Weight_Record> records) {

        double firstWeight = records.get(0).getWeight();
        double lastWeight = records.get(records.size()-1).getWeight();

        boolean loss = (lastWeight < firstWeight)? true:false;

        if(loss)
        {
            result = firstWeight - lastWeight;
            overallResultString += String.format("lost %1.2f kgs",result);
        }
        else
        {
            if(lastWeight == firstWeight)
            {
                overallResultString += "had no change in your weight";
            }
            else
            {
                result = lastWeight - firstWeight;
                overallResultString += String.format("gained %1.2f kgs",result);
            }

        }

        return overallResultString;
    }

    private String calculateLast2Entries(String resultString, double result, ArrayList<Weight_Record> records) {

        double currentWeight = records.get(records.size()-1).getWeight();
        double lastWeight = records.get(records.size()-2).getWeight();

        boolean loss = currentWeight < lastWeight;

        if(loss)
        {
            result = lastWeight - currentWeight;
            resultString += String.format("lost %1.2f kgs",result);
        }
        else
        {
            if(lastWeight==currentWeight)
            {
                resultString += "had no change in weight";
            }
            else
            {
                result = currentWeight - lastWeight;
                resultString += String.format("gained %1.2f kgs",result);
            }

        }
        return resultString;

    }

    private void saveButton() {

        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText weightInput = findViewById(R.id.my_weight);
                String weightString =  weightInput.getText().toString();

                boolean empty = weightString.isEmpty();

                if(!empty)
                {
                    Double weight = Double.valueOf(weightString);
                    TextView error = (TextView) findViewById(R.id.weightInputErrorMessage);
                    if(weight < 1 || weight > 1000)                    {

                        error.setVisibility(View.VISIBLE);
                    }
                    else {

                        error.setVisibility(View.INVISIBLE);
                        SimpleDateFormat isoFormat = new SimpleDateFormat("dd-MM-yyyy");
                        isoFormat.setTimeZone(TimeZone.getTimeZone("NZST"));
                        Date date = null;
                        try {
                            date = isoFormat.parse("22-10-2018");
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        String [] dateSplit = date.toString().split(" ");
                        String dateString = dateSplit[0] + " " + dateSplit[1] + " " +dateSplit[2] + " " + dateSplit[5];
                        Log.i("Date String", "onClick: Date" + dateString + "\nWeight " + weightString);
                        Weight_Record record = new Weight_Record(weight,dateString);
                        MainActivity.fitAppDb.addWeightRecord(MainActivity.fitAppDb, record);
                        weightRecords();
                    }
                }
                weightInput.setText("");
                scrollView();
            }
        });


    }
}
