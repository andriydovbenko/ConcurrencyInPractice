package com.cursor.transaction.execution;

import com.cursor.transaction.model.Counter;
import com.cursor.transaction.model.ThreadForReading;
import com.cursor.transaction.model.ThreadForWriting;

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