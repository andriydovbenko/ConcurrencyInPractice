package com.cursor.transaction.model;

import com.cursor.transaction.db.DataBase;

import java.util.Random;

public class ThreadForReading implements Runnable {
    private static final int ITERATION_VALUE = 10;
    private static final int RANGE_OF_VALUE = 400_000;
    private DataBase db = DataBase.getInstance();

    @Override
    public void run() {
        for (int i = 1; i < ITERATION_VALUE; i++) {
            int randomValue = new Random().nextInt(RANGE_OF_VALUE);
            System.out.println("Operation number " + i + ". Reading from Data Base.");

            if (db.getNumberIfPresetOrNull(randomValue) == null) {
                System.out.println("Number " + randomValue + " doesn't exist");
            } else {
                System.out.println("Number " + randomValue + " does exist");
            }
        }
    }
}