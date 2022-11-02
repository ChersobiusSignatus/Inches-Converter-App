package com.example.inchesconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText editTextInches;
    private Button calculateButton;
    private TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inchesString = editTextInches.getText().toString();

                if (inchesString.isEmpty()) {
                    //code if empty block
                    Toast.makeText(MainActivity.this, "Please, enter a number!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    //code if not empty block
                    double result = calculateHeight(inchesString);

                    displayResult(result);
                }
            }
        });
    }

    private void findViews() {
        editTextInches = findViewById(R.id.edit_text_inches);
        calculateButton = findViewById(R.id.button_calculate);
        resultTextView = findViewById(R.id.text_view_result);
    }

    private double calculateHeight(String inchesString) {
        //converting 'strings' into 'int' variables
        int inches = Integer.parseInt(inchesString);
        //calculating
        return inches * 0.0254;
    }


    private void displayResult(double result) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String resultString = myDecimalFormatter.format(result);
        resultTextView.setText(resultString + " meters");
    }


}