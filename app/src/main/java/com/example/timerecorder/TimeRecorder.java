package com.example.timerecorder;

import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeRecorder {
    private String name;
    public Date startingTime , finishingTime;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public TimeRecorder(String name){
        this.name = name;

    }



    @RequiresApi(api = Build.VERSION_CODES.N)

    /**
     * Returns total recorded time
     */

    public long getTimeInDays(){
        if (this.startingTime == null) {
            return 0;
        }
        long time;
        if(finishingTime != null) {
            time = this.finishingTime.getTime() - this.startingTime.getTime();
        }
        else {
            time = Calendar.getInstance().getTime().getTime() - this.startingTime.getTime();
        }
        long timeInDays = TimeUnit.MILLISECONDS.toDays(time);
        return timeInDays;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)

    /**
     * Starts recording time
     */

    public void startRecordingTime() {
        this.startingTime = Calendar.getInstance().getTime();
    }

}
