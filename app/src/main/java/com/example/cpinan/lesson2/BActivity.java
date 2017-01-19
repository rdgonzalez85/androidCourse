package com.example.cpinan.lesson2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BActivity extends AppCompatActivity {

    private CustomReceiver mReceiver;

    private TextView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Button buttonC = (Button) findViewById(R.id.button);
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BActivity.this, CActivity.class);
                startActivity(intent);
            }
        });

        Button buttonD = (Button) findViewById(R.id.button2);
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BActivity.this, DActivity.class);
                startActivity(intent);
            }
        });

        Button buttonE = (Button) findViewById(R.id.button3);
        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BActivity.this, EActivity.class);
                startActivity(intent);
            }
        });

        Button buttonService = (Button) findViewById(R.id.buttonService);
        buttonService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BActivity.this, MyIntentService.class);
                intent.setAction("action");
                startService(intent);
            }
        });

        messageView = (TextView) findViewById(R.id.textView2);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        IntentFilter intentFilter = new IntentFilter(
                "android.intent.action.MAIN");

        mReceiver = new CustomReceiver();
        mReceiver.activity = this;
        //registering our receiver
        this.registerReceiver(mReceiver, intentFilter);
    }
    public void showMessage(String message) {
        messageView.setText(message);
    }
}

class CustomReceiver extends BroadcastReceiver {
    public BActivity activity;
    @Override
    public void onReceive(Context context, Intent intent) {
        //extract our message from intent
        String msg_for_me = intent.getStringExtra("some_msg");
        //log our message value
        Log.i("InchooTutorial", msg_for_me);
        activity.showMessage(msg_for_me);
    }
}
