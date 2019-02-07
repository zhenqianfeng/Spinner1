package com.concordia.cejv669.spinner1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner sp = findViewById(R.id.spinner_tip);
        final TextView tv_result = findViewById(R.id.text_result);
        final EditText edit_amount = findViewById(R.id.editText);
        Button b = findViewById(R.id.btn_calc);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amount = Double.valueOf(edit_amount.getText().toString());
                String spinnerValue = sp.getSelectedItem().toString();

                double tipAmount = 0.0;
                switch (spinnerValue){
                    case "Large - 25%": tipAmount = 0.25; break;
                    case "Normal Service - 20%": tipAmount = 0.2; break;
                    case "Not that great - 15%": tipAmount = 0.15; break;
                    case "Not good - 10%": tipAmount = 0.1; break;
                }
                NumberFormat currency = NumberFormat.getCurrencyInstance();
                tv_result.setText(currency.format(amount*tipAmount));
            }
        });
    }
}
