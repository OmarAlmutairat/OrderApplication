package com.trichain.orderapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView res;
    EditText prints;
    Button orderButton;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = findViewById(R.id.resultsTv);
        prints = findViewById(R.id.numberOfPrints);
        orderButton = findViewById(R.id.orderButton);
        radioGroup = findViewById(R.id.rG);


        orderButton.setOnClickListener(v -> {
            if (prints.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter some number", Toast.LENGTH_SHORT).show();
            } else if (radioGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Please select the size", Toast.LENGTH_SHORT).show();
            } else {
                int printsNumber = Integer.parseInt(prints.getText().toString());
                double selectedAmount;
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.firstPrint: {
                        selectedAmount = 19;
                        break;
                    }
                    case R.id.secondPrint: {
                        selectedAmount = 49;
                        break;
                    }
                    default: {
                        selectedAmount = 79;
                        break;
                    }
                }
                double totalCost = printsNumber * selectedAmount / 100;
                res.setText("The order cost is $ " + totalCost);

            }
        });

    }
}