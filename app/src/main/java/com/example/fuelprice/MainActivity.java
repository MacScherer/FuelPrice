package com.example.fuelprice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextAlcohol;
    private EditText editTextGasoline;
    private TextView textViewResult;
    private Button buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAlcohol = findViewById(R.id.editTextNumberAlcohol);
        editTextGasoline = findViewById(R.id.editTextNumberGas);
        textViewResult = findViewById(R.id.textViewConfirmation);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String priceAlcohol = editTextAlcohol.getText().toString();
                String priceGasoline = editTextGasoline.getText().toString();

                boolean booleanValidation = verifyField(priceAlcohol, priceGasoline);
                if (booleanValidation == true){
                    Double priceAlcoholDouble = Double.parseDouble(priceAlcohol);
                    Double priceGasDouble = Double.parseDouble(priceGasoline);

                    Double resultValue = priceAlcoholDouble / priceGasDouble;
                    if (resultValue >= 0.7){
                        textViewResult.setText("Better use Gas.");
                    }else {
                        textViewResult.setText("Better use alcohol.");
                    }
                }else {
                    textViewResult.setText("Type at the fields first!");
                }
            }
        });
    }

    private boolean verifyField(String fieldAlcohol, String fieldGas) {
        boolean booleanValidation = true;
        if (fieldAlcohol == null || fieldAlcohol.equals("")){
            booleanValidation = false;
        } else if (fieldGas == null || fieldGas.equals("")) {
            booleanValidation = false;
        }
        return booleanValidation;
    }
}