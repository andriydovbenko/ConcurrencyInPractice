package com.cursor.transaction.model;

import com.cursor.transaction.db.DataBase;

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
            System.out.println("added to DB " + counter.getCounter());
            db.addNumberToList(counter.getCounter());
        }
    }
}