package com.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private int balance = 0;
    private List<Transaction> transactionHistory = new ArrayList<>();

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        recordTransaction("Deposit", amount);
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
        recordTransaction("Withdrawal", -amount);
    }

    public int getBalance() {
        return balance;
    }

    public String printStatement() {
        StringBuilder statement = new StringBuilder("Date | Operation | Amount | Balance\n");
        for (Transaction transaction : transactionHistory) {
            statement.append(transaction.toString()).append("\n");
        }
        return statement.toString().trim();
    }

    private void recordTransaction(String operation, int amount) {
        LocalDate date = LocalDate.now();
        transactionHistory.add(new Transaction(date, operation, amount, balance));
    }
}
