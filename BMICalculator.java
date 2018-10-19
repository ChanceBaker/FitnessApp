package com.fitapp.sdp.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMICalculator extends AppCompatActivity {

    private float weight, height;
    private EditText weightInput,heightInput;
    private TextView outputBMI;
    private Button calcBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_calc);
        setUpBMI();
    }

    private void setUpBMI() {


        weightInput = (EditText) findViewById(R.id.weightInput);
        heightInput = (EditText) findViewById(R.id.heightInput);
        outputBMI = (TextView) findViewById(R.id.outputBMI);
        calcBMI = (Button) findViewById(R.id.calcBMI);

        calcBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sWeight = weightInput.getText().toString();
                String sHeight = heightInput.getText().toString();

                if(!sWeight.equals("") && !sHeight.equals(""))
                {
                    weight = Float.valueOf(sWeight);
                    height = Float.valueOf(sHeight);

                    height = (height >= 2.5) ? height/100 : height;

                    float BMI = weight / (height * height);
                    String bmiString =  String.format("BMI = %1.2f",(double)BMI);
                    outputBMI.setText(bmiString);
                }
            }
        });
    }
}
