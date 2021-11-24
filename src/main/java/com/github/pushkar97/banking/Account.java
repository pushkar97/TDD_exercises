package com.github.pushkar97.banking;

import java.time.LocalDate;

public class Account {

    private int balance;
    private final ITransactionHistoryPort historyPort;

    public Account(ITransactionHistoryPort historyPort) {
        balance = 0;
        this.historyPort = historyPort;
    }

    public void deposit(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("amount should be greater than 0");
        balance+=amount;
        this.addTransactionHistory(amount);
    }

    public void withdraw(int amount){
        if (amount <= 0) throw new IllegalArgumentException("amount should be greater than 0");
        if (amount > balance) throw new IllegalArgumentException("amount should be less than balance");
        balance-=amount;
        this.addTransactionHistory(-amount);
    }

    public void printStatement(){
        System.out.println(historyPort.getTransactionHistory());
    }

    private void addTransactionHistory(int amount) {

        historyPort.addTransaction(amount);
    }
}
