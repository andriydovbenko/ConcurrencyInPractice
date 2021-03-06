package concurrency.model;

import concurrency.database.DataBase;

import java.util.Random;

public class ThreadForReading implements Runnable {
    private static final int ITERATION_VALUE = 10;
    private static final int RANGE_OF_VALUE = 400_000;
    private DataBase db = DataBase.getInstance();
    private static  int randomValue = new Random().nextInt(RANGE_OF_VALUE);

    @Override
    public void run() {
        for (int i = 1; i < ITERATION_VALUE; i++) {
            System.out.println("Operation number " + i + ". Reading from Data Base.");
            if (db.getNumberIfPresetOrNull(randomValue) == null) {
                System.out.println("Number " + randomValue + " doesn't exist");
            } else {
                System.out.println("Number " + randomValue + " does exist");
            }
        }
    }
}