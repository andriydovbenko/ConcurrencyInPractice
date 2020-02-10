package com.register.manager.model;

import java.util.UUID;

public class Account {
    private String login;
    private String passWord;

    public Account(String login) {
        this.login = login;
        this.passWord = String.format("%s%s", "ww",
                UUID.randomUUID().getMostSignificantBits() * (-1));
    }

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}