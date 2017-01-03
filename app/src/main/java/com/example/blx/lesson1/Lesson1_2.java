package com.example.blx.lesson1;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lesson1_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1_2);
        init();
    }

    private void init() {
        final TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
        final EditText first = (EditText) findViewById(R.id.firstEditText);
        final EditText second = (EditText) findViewById(R.id.secondEditText);

        Button add = (Button) findViewById(R.id.buttonAdd);
        Button substract = (Button) findViewById(R.id.buttonSubstract);
        Button multiply = (Button) findViewById(R.id.buttonMultiply);
        Button divide = (Button) findViewById(R.id.buttonDivide);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Long firstValue = Long.valueOf(first.getText().toString());
                    Long secondValue = Long.valueOf(second.getText().toString());
                    if (firstValue != null && secondValue != null) {
                        resultTextView.setText(String.valueOf(firstValue+secondValue));
                    }
                } catch (NumberFormatException e) {
                    // show error?
                    System.out.println(e);
                }
            }
        });

        substract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Long firstValue = Long.valueOf(first.getText().toString());
                    Long secondValue = Long.valueOf(second.getText().toString());
                    if (firstValue != null && secondValue != null) {
                        resultTextView.setText(String.valueOf(firstValue-secondValue));
                    }
                } catch (NumberFormatException e) {
                    // show error?
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Long firstValue = Long.valueOf(first.getText().toString());
                    Long secondValue = Long.valueOf(second.getText().toString());
                    if (firstValue != null && secondValue != null) {
                        resultTextView.setText(String.valueOf(firstValue*secondValue));
                    }
                } catch (NumberFormatException e) {
                    // show error?
                }
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Long firstValue = Long.valueOf(first.getText().toString());
                    Long secondValue = Long.valueOf(second.getText().toString());
                    if (firstValue != null && secondValue != null && secondValue != 0) {
                        Float result = (float)firstValue / (float)secondValue;
                        resultTextView.setText(String.valueOf(result));
                    } else if (secondValue == 0) {
                        resultTextView.setText(getString(R.string.errorDivideByZero));
                    }
                } catch (NumberFormatException e) {
                    // show error?
                }
            }
        });
    }
}
