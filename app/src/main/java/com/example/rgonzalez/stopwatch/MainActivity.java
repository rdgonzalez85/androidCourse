package com.example.rgonzalez.stopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements StopwatchInterface {

    private TextView timeView;
    private StopwatchThread stopwatchThread;
    private boolean isRunning = false;
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("mm:ss:SS");
    private long totalTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeView = (TextView) findViewById(R.id.stopwatchTextView);

        final Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRunning) {
                    isRunning = true;
                    stopwatchThread = new StopwatchThread(MainActivity.this, totalTime);
                    stopwatchThread.start();
                    startButton.setText(R.string.pause);
                } else {
                    isRunning = false;
                    stopwatchThread.pause();
                    startButton.setText(R.string.start);
                }
            }
        });

        final Button stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stopwatchThread != null){
                    stopwatchThread.pause();
                }
                totalTime = 0;
                startButton.setText(R.string.start);
                isRunning = false;
                timeView.setText(R.string.startTimer);
            }
        });
    }

    @Override
    public void displayTime(final long millis) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                timeView.setText(timeFormat.format(new Date(millis)));
                totalTime = millis;
            }
        });
    }
}
