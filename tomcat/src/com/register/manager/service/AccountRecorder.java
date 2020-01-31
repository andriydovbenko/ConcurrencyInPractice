package com.register.manager.service;

import com.register.manager.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountRecorder {

    private static AccountRecorder instance;
    private List<Account> accountRepository = new ArrayList<>();
    private final String procedure = "Printing information about account: ";

    private AccountRecorder() {
    }

    public static AccountRecorder getInstance() {
        if (instance == null) {
            synchronized (AccountRecorder.class) {
                if (instance == null) {
                    instance = new AccountRecorder();
                }
            }
        }
        return instance;
    }

    public void addAccountToRepo(Account account) {
        this.accountRepository.add(account);
        System.out.println("\nAccount: " + account.hashCode() + " was added to repository");
    }

    public String getAccountInformation(int indexOfAccount) {
        Account accountFromRepo = accountRepository.get(indexOfAccount);
        return String.format("%s%s%s%s%s", "\n", procedure, accountFromRepo.hashCode(), "\n",
                accountFromRepo.toString());
    }

    public int getAmountOfAccounts() {
        return accountRepository.size();
    }
}