package concurrency.model;

import concurrency.database.DataBase;

public class Counter {
    private int counter = DataBase.getLastValueOfList();

    void incrementCurrentValue() {
        counter++;
    }

    int getCounter() {
        return counter;
    }
}