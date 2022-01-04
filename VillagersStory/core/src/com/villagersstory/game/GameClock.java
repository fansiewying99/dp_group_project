package com.villagersstory.game;

import java.util.Timer;
import java.util.TimerTask;

public class GameClock extends TimerTask {
    private static GameClock clock = new GameClock();
    public int day,hour,min;
    public int i = 0;
    static Timer timer;

    private GameClock(){

    }
    public void startTime() throws InterruptedException {
        day = 0;
        hour = 0;
        min = 0;
        TimerTask timerTask = getInstance();
        timer = new Timer(false);
        timer.scheduleAtFixedRate(timerTask, 0, 5 * 200);
    }
    public static GameClock getInstance(){
        return clock;
    }

    @Override
    public void run(){
        i++;
        min = i;
        if (min == 60) {
            min=0;
            i=0;
            hour++;
            //timer.cancel();
        }
        if (hour == 24) {
            hour=0;
            day++;
        }
    }

    private void checkHour() {
        if(min==60) {
            hour++;
            min=0;
        }
    }
    private void checkDay(){
        if(hour==24){
            day++;
            hour=0;
        }
    }

    public static Timer getTimer() {
        return timer;
    }
}
