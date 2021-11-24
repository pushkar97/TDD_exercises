package com.github.pushkar97.banking;

import java.util.List;

public interface ITransactionHistoryPort {

    List<TransactionHistoryPortDummy.TransactionHistory> getTransactionHistory();

    void addTransaction(int amount);
}
