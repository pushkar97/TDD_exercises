package com.github.pushkar97.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@ExtendWith(MockitoExtension.class)
public class AccountTest {

    @Mock
    ITransactionHistoryPort historyPort;

    Account account;

    @BeforeEach
    public void setup() {
        account = new Account(historyPort);
    }

    @Test
    public void shouldThrowException_whenDepositedLessThanOrEqZero() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> account.deposit(0))
                .withMessage("amount should be greater than 0");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> account.deposit(-1000))
                .withMessage("amount should be greater than 0");
    }

    @Test
    public void shouldThrowException_whenWithdrawnLessThanOrEqZero() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> account.withdraw(0))
                .withMessage("amount should be greater than 0");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> account.withdraw(-1000))
                .withMessage("amount should be greater than 0");
    }

    @Test
    public void shouldThrowException_whenWithdrawnMoreThanBalance() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> account.withdraw(1))
                .withMessage("amount should be less than balance");
    }

    @Test
    public void givenAmountDeposited_whenWithdrawnLessAmt_thenNoExceptionShouldThrow() {
        account.deposit(1000);
        account.withdraw(500);
    }

    @Test
    public void givenAmountDeposited_whenWithdrawnMoreAmt_thenExceptionShouldThrow() {
        account.deposit(1000);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> account.withdraw(1001))
                .withMessage("amount should be less than balance");
    }

    @Test
    public void deposit_withdraw_withdraw() {
        account.deposit(1000);
        account.withdraw(500);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> account.withdraw(501))
                .withMessage("amount should be less than balance");
    }
    @Test
    public void shouldHave1000_whenDeposited1000() {
        account.deposit(1000);
        account.printStatement();
    }
}
