package org.example.clock;

import org.example.clock.Readable;

public class Clock implements Readable {
    private int hour;
    private int min;
    private int sec;

    public Clock(){};

    public Clock(int hour, int min, int sec){
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("Wrong hour: " + hour);
        }
        if (min < 0 || min >= 61) {
            throw new IllegalArgumentException("Wrong min: " + min);
        }
        if (sec < 0 || sec >= 61) {
            throw new IllegalArgumentException("Wrong sec: " + sec);
        }
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }

    @Override
    public String toString() {
        return "Clock{" +
                "hour=" + hour +
                ", min=" + min +
                ", sec=" + sec +
                '}';
    }

    public void tick(){
        sec++;
        if (sec == 60) {
            min++;
            sec = 0;
        }
        if (min == 60) {
            hour++;
            min = 0;
        }
        if (hour == 24) {
            hour = 0;
        }
    };

    @Override
    public void readTime(){
        System.out.println("The current time is " + this.toString());

    }


}
