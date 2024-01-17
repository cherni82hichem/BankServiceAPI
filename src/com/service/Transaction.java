package com.service;

import java.time.LocalDate;

public class Transaction {
    private final LocalDate date;
    private final String operation;
    private final int amount;
    private final int balance;

    public Transaction(LocalDate date, String operation, int amount, int balance) {
        this.date = date;
        this.operation = operation;
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return date + " | " + operation + " | " + amount + " | " + balance;
    }
}
