package com.example.cpinan.lesson2;

import android.app.IntentService;
import android.content.Intent;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();

            if (action.equals("action")) {
                handleAction();
            }
        }
    }

    /**
     * Handle action in the provided background thread with the provided
     * parameters.
     */
    private void handleAction() {
        this.broadcastMessage("I will be sent!");
    }

    // broadcast a custom intent.

    public void broadcastMessage(String message){
        Intent i = new Intent("android.intent.action.MAIN").putExtra("some_msg", message);
        this.sendBroadcast(i);
    }
}
