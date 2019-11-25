package com.lidorz_itaig.ex1;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.widget.TextView;

public class Timer {

    private boolean timeRun;
    private long time;
    private String display;

    Timer (final TextView txvTime){

        timeRun = true;
        time = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    SystemClock.sleep(1000);
                    if(timeRun)
                        time ++;
                    String ss, mm;
                    long sec = time % 60;
                    long min = time / 60;
                    mm = String.format("%02d", min);
                    ss = String.format("%02d", sec);
                    display = mm+":"+ss;

                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            txvTime.setText(display);
                        }
                    });
                }
            }
        }).start();
    }

    public void start(){
        timeRun = true;
    }

    public void pause(){
        timeRun = false;

    }
    public void reset(){
        time = -1;
    }

}
