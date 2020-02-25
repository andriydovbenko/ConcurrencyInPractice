package concurrency.controller;

import concurrency.model.Counter;
import concurrency.model.ThreadForReading;
import concurrency.model.ThreadForWriting;

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