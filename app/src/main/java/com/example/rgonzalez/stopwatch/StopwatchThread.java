package com.example.rgonzalez.stopwatch;

import static java.lang.Thread.sleep;

/**
 * Created by rgonzalez on 1/17/17.
 */

public class StopwatchThread extends Thread {
    private StopwatchInterface stopwatchView;
    private boolean isRunning;


    public StopwatchThread(StopwatchInterface stopwatchInterface) {
        this.stopwatchView = stopwatchInterface;
    }
    public void run() {
        super.run();
        isRunning = true;
        long startTime = System.currentTimeMillis();
        while(isRunning) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stopwatchView.displayTime(System.currentTimeMillis() - startTime);
        }
    }

    public void pause() {
        isRunning = false;
    }
}
