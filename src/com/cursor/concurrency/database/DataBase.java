package com.cursor.concurrency.database;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataBase {
    private static final int START_VALUE_OF_LIST = 0;
    private static final int LAST_VALUE_OF_LIST = 200_000;
    private static DataBase instance;
    private CopyOnWriteArrayList<Integer> listOfNumbers;

    private DataBase() {
        List<Integer> range = IntStream.rangeClosed(START_VALUE_OF_LIST, LAST_VALUE_OF_LIST)
                .boxed().collect(Collectors.toList());

        this.listOfNumbers = new CopyOnWriteArrayList<>();
        this.listOfNumbers.addAll(range);
    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public void addNumberToList(Integer number) {
        listOfNumbers.add(number);
    }

    public Integer getNumberIfPresetOrNull(Integer number) {
        Integer integerToReturn = null;

        if (listOfNumbers.contains(number)) {
            int indexOfNumber = listOfNumbers.indexOf(number);
            integerToReturn = listOfNumbers.get(indexOfNumber);
        }
        return integerToReturn;
    }

    public static int getLastValueOfList() {
        return LAST_VALUE_OF_LIST;
    }
}