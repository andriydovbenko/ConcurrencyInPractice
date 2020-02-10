package com.cursor.concurrency.model;

import com.cursor.concurrency.database.DataBase;

public class ThreadForWriting implements Runnable {
    private final int RANGE_OF_ITERATION = 100;
    private Counter counter;
    private DataBase db = DataBase.getInstance();
    private int newStartingValue = DataBase.getLastValueOfList();
    private int lastIterationValue = newStartingValue + RANGE_OF_ITERATION;

    public ThreadForWriting(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = newStartingValue; i < lastIterationValue; i++) {
            counter.incrementCurrentValue();
            int count = counter.getCounter();
            System.out.println("added to DB " + count);
            db.addNumberToList(count);
        }
    }
}