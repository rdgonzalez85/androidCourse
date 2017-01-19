package com.example.cpinan.lesson2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private static final int maxImages = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = (LinearLayout) findViewById(R.id.container);


        View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BActivity.class);
                startActivity(intent);
            }
        };

        for (int i=0; i < maxImages; i++) {
            ImageView img = new ImageView(this);
            img.setImageResource(R.drawable.logo);
            img.setOnClickListener(onClick);
            layout.addView(img);
        }
    }
}
