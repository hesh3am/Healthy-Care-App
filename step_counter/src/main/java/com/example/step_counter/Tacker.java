package com.example.step_counter;

/**
 * Created by Hesham on 26-May-19.
 */

public class Tacker {

    public static int value;
    private static Runnable runnable;

    public static void setValue(int x) {
        value = x;
    }

    public static int getValue() {
        return value;
    }

    public static void reset() {
        value = 0;
    }

    public static int increment() {
        value = value + 1;
        return value;
    }

    public static void setOnIncrementListener(Runnable runnable) {
        Tacker.runnable = runnable;
    }

    public static void callOnIncrement() {
        runnable.run();
    }
}
