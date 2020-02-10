package com.cursor.concurrency.controller;

import com.cursor.concurrency.model.ThreadForWriting;
import com.cursor.concurrency.model.Counter;
import com.cursor.concurrency.model.ThreadForReading;

public class Executor {

    public void runApplication() {
        Counter counter = new Counter();

        new ThreadForWriting(counter).run();
        new ThreadForReading().run();
        new ThreadForWriting(counter).run();
        new ThreadForReading().run();
        new ThreadForWriting(counter).run();
        new ThreadForReading().run();
        new ThreadForWriting(counter).run();
        new ThreadForReading().run();
        new ThreadForWriting(counter).run();
        new ThreadForReading().run();
    }
}