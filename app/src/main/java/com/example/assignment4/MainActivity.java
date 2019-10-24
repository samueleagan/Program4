package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static double tipTotal = 0.0, mealTotal = 0.0,  finalMealTotal = 0.0;
    public final static int requestCode = 1;
    public final static int successful = 0;

    public void onSaveInstanceState(Bundle saved) {
        super.onSaveInstanceState(saved);
        saved.putDouble("tipTotal", tipTotal);
        saved.putDouble("mealTotal", finalMealTotal);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            tipTotal = savedInstanceState.getDouble("tipTotal", -1);
            finalMealTotal = savedInstanceState.getDouble("mealTotal", -1);
        }
    }

    public void onClickIntentAction (View v) {
        EditText enterTotal = findViewById(R.id.enterMealAmount);
        TextView mealTotalResult = findViewById(R.id.mealTotalText);
        tipTotal = Double.parseDouble(enterTotal.getText().toString());

        try {
            Double storeTipAmount = Double.parseDouble(enterTotal.getText().toString());
        }
        catch (Exception e) {
            mealTotalResult.setText(e.toString());
        }


        Intent ini = new Intent(this, TipCalcActivity.class);
        ini.putExtra("tipTotal", tipTotal);
        ini.putExtra("mealTotal", tipTotal);


        startActivityForResult(ini, requestCode);

    }

    public void onActivityResult(int testRequestCode, int resultCode, Intent d) {
        if (testRequestCode == requestCode) {
            if (resultCode == successful) {
                EditText enterTotal = findViewById(R.id.enterMealAmount);
                TextView calculateTip = findViewById(R.id.tipAmount);
                TextView mealTotalResult = findViewById(R.id.mealTotalDisplay);

                tipTotal = d.getDoubleExtra("tipCalculated",-1.0);
                finalMealTotal = d.getDoubleExtra("finalCalculated", -1.0);

                calculateTip.setText("Tip Amount: " + tipTotal);
                mealTotalResult.setText("Meal Total: " + finalMealTotal);

            }
        }
    }
}
