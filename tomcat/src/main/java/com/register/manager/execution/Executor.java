package com.register.manager.execution;

import com.register.manager.model.CurrentCallableThread;
import com.register.manager.model.CurrentRunnableThread;
import com.register.manager.model.Login;
import com.register.manager.service.AccountRecorder;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Executor {
    private AccountRecorder accountRecorder = AccountRecorder.getInstance();
    private final int transformationFactor = 1;

    public void startApp() {
        createRunnableThreads();
        ExecutorService executorService = Executors.newCachedThreadPool();
        int indexOfAccount = accountRecorder.getAmountOfAccounts() - transformationFactor;
        for (int i = indexOfAccount; i > 0; i--) {
            Future<String> response = executorService.submit(new CurrentCallableThread(i));
            try {
                System.out.println(response.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

    public void createRunnableThreads() {
        new CurrentRunnableThread("First Thread", Login.GUFFAW.toString().toLowerCase()).run();
        new CurrentRunnableThread("Second Thread", Login.HITHERTO.toString().toLowerCase()).run();
        new CurrentRunnableThread("Third Thread", Login.LIGATURE.toString().toLowerCase()).run();
        new CurrentRunnableThread("Fourth Thread", Login.GUIDON.toString().toLowerCase()).run();
        new CurrentRunnableThread("Fifth Thread", Login.HOARY.toString().toLowerCase()).run();
        new CurrentRunnableThread("Sixth Thread", Login.LIMNER.toString().toLowerCase()).run();
        new CurrentRunnableThread("Seventh Thread", Login.GUILLOCHE.toString().toLowerCase()).run();
        new CurrentRunnableThread("Eighth Thread", Login.HOBBLEDEHOY.toString().toLowerCase()).run();
        new CurrentRunnableThread("Ninth Thread", Login.TITMOUSE.toString().toLowerCase()).run();
        new CurrentRunnableThread("Tenth Thread", Login.HOLYSTONE.toString().toLowerCase()).run();
    }
}