package com.example.blx.lesson1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class Lesson1_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1_1);
        init();
    }

    protected void init() {
        final TextView textView = (TextView) findViewById(R.id.textView);
        final EditText editText = (EditText) findViewById(R.id.editText);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    Integer val = Integer.valueOf(s.toString());
                    if (val != null) {
                        textView.setText(monthFromNumber(val));
                    }
                } catch (NumberFormatException e) {
                    // show error?
                }
            }

            private String monthFromNumber(Integer month) {
                String monthString;
                switch (month) {
                    case 1:  monthString = getString(R.string.january);
                        break;
                    case 2:  monthString = getString(R.string.february);
                        break;
                    case 3:  monthString = getString(R.string.march);
                        break;
                    case 4:  monthString = getString(R.string.april);
                        break;
                    case 5:  monthString = getString(R.string.may);
                        break;
                    case 6:  monthString = getString(R.string.june);
                        break;
                    case 7:  monthString = getString(R.string.july);
                        break;
                    case 8:  monthString = getString(R.string.august);
                        break;
                    case 9:  monthString = getString(R.string.september);
                        break;
                    case 10: monthString = getString(R.string.october);
                        break;
                    case 11: monthString = getString(R.string.november);
                        break;
                    case 12: monthString = getString(R.string.december);
                        break;
                    default: monthString = getString(R.string.invalidMonth);
                        break;
                }
                return monthString;
            }
        });
    }

}
