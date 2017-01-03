package com.example.blx.lesson1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class Lesson1_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1_3);
        init();
    }

    private void init() {
        final EditText editText = (EditText) findViewById(R.id.editText1_3);
        final TextView textView = (TextView) findViewById(R.id.textView1_3);

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
                        textView.setText("");
                        for(int i=1; i<=val; i++) {
                            textView.append(getString(R.string.line) + " " + i + "\n");
                        }
                    }
                } catch (NumberFormatException e) {
                    // show error?
                }
            }
        });
    }
}
