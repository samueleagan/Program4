package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.assignment4.MainActivity.mealTotal;
import static com.example.assignment4.MainActivity.tipTotal;

public class TipCalcActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calc);

        Button btnOne = findViewById(R.id.tip15);
        btnOne.setOnClickListener(this);
        Button btnTwo = findViewById(R.id.tip18);
        btnTwo.setOnClickListener(this);
        Button btnThree = findViewById(R.id.tip20);
        btnThree.setOnClickListener(this);


    }

    public void onClick(View v) {

        Intent ini = getIntent();
        double tipAmount = ini.getDoubleExtra("tipTotal", -1.0);
        double totalAmount = ini.getDoubleExtra("mealTotal", -1.0);
        Intent returnIntent = new Intent();

        switch (v.getId()) {
            case R.id.tip15:
                double calculateTip15 = 0.15 * totalAmount;
                double finalAmountCalculated15 = totalAmount + calculateTip15;
                returnIntent.putExtra("tipCalculated", calculateTip15);
                returnIntent.putExtra("finalCalculated", finalAmountCalculated15);
                setResult(MainActivity.successful, returnIntent);
                finish();
                break;
            case R.id.tip18:
                double calculateTip18 = 0.18 * totalAmount;
                double finalAmountCalculated18 = totalAmount + calculateTip18;
                returnIntent.putExtra("tipCalculated", calculateTip18);
                returnIntent.putExtra("finalCalculated", finalAmountCalculated18);
                setResult(MainActivity.successful, returnIntent);
                finish();
                break;
            case R.id.tip20:
                double calculateTip20 = 0.20 * totalAmount;
                double finalAmountCalculated20 = totalAmount + calculateTip20;
                returnIntent.putExtra("tipCalculated", calculateTip20);
                returnIntent.putExtra("finalCalculated", finalAmountCalculated20);
                setResult(MainActivity.successful, returnIntent);
                finish();
                break;

        }

    }
}