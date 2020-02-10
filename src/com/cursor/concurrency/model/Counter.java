package com.cursor.concurrency.model;

import com.cursor.concurrency.database.DataBase;

public class Counter {
    private int counter = DataBase.getLastValueOfList();

    void incrementCurrentValue() {
        counter++;
    }

    int getCounter() {
        return counter;
    }
}