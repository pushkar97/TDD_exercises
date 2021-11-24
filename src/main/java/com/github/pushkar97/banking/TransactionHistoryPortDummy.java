package com.github.pushkar97.banking;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionHistoryPortDummy implements ITransactionHistoryPort {

    List<TransactionHistory> transactionHistory;

    @Override
    public List<TransactionHistory> getTransactionHistory() {
        return transactionHistory;
    }

    @Override
    public void addTransaction(int amount) {
        transactionHistory.add(new TransactionHistory(amount, LocalDateTime.now()));
    }

    class TransactionHistory {
        int amt;
        LocalDateTime transactionTime;

        public TransactionHistory(int amt, LocalDateTime transactionTime) {
            this.amt = amt;
            this.transactionTime = transactionTime;
        }

        public int getAmt() {
            return amt;
        }

        public void setAmt(int amt) {
            this.amt = amt;
        }

        public LocalDateTime getTransactionTime() {
            return transactionTime;
        }

        public void setTransactionTime(LocalDateTime transactionTime) {
            this.transactionTime = transactionTime;
        }
    }
}
