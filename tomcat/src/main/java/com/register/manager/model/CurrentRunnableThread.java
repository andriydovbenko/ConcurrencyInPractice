package com.register.manager.model;

import com.register.manager.service.AccountRecorder;

public class CurrentRunnableThread implements Runnable {
    private String threadName;
    private String userLoginName;
    private AccountRecorder accountRecorder = AccountRecorder.getInstance();

    public CurrentRunnableThread(String threadName, String loginName) {
        this.threadName = threadName;
        this.userLoginName = loginName;
        Thread.currentThread().setName(threadName);
    }

    @Override
    public void run() {
        System.out.println("Thread " + this.threadName + " has started to work");
        Account account = new Account(this.userLoginName);
        accountRecorder.addAccountToRepo(account);
        System.out.println("Current Runnable thread " + threadName + " id dead");
    }
}