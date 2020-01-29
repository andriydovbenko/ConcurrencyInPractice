package com.cursor.transaction.model;

import com.cursor.transaction.db.DataBase;

public class Counter {
    private int counter = DataBase.getLastValueOfList();
    private DataBase db = DataBase.getInstance();

    public void incrementCurrentValue() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}