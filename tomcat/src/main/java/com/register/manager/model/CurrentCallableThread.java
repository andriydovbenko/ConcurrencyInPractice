package com.register.manager.model;

import com.register.manager.service.AccountRecorder;

import java.util.concurrent.Callable;

public class CurrentCallableThread implements Callable<String> {
    private AccountRecorder accountRecorder = AccountRecorder.getInstance();
    private int accountIndex;

    public CurrentCallableThread(int accountIndex) {
        this.accountIndex = accountIndex;
    }

    @Override
    public String call() {
        return accountRecorder.getAccountInformation(accountIndex);
    }
}