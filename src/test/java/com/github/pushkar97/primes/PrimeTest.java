package com.github.pushkar97.primes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimeTest {
    Prime prime;

    @BeforeEach
    public void setup() {
        prime = new Prime();
    }

    @Test
    public void shouldBeFalse_whenNumberIsNegative() {
        boolean actual = prime.isPrime(-1);
        assertThat(actual).isFalse();
    }

    @Test
    public void shouldReturnCorrectValues_whenPositiveIntegerInput() {
        assertThat(prime.isPrime(1)).isFalse();
        assertThat(prime.isPrime(2)).isTrue();
        assertThat(prime.isPrime(4)).isFalse();
        assertThat(prime.isPrime(5)).isTrue();
        assertThat(prime.isPrime(6)).isFalse();
        assertThat(prime.isPrime(9)).isFalse();
        assertThat(prime.isPrime(9)).isFalse();
        assertThat(prime.isPrime(25)).isFalse();
        assertThat(prime.isPrime(49)).isFalse();
        assertThat(prime.isPrime(113)).isTrue();
        assertThat(prime.isPrime(117)).isFalse();
        assertThat(prime.isPrime(121)).isFalse();
        assertThat(prime.isPrime(2_147_483_641)).isFalse();
        assertThat(prime.isPrime(Integer.MAX_VALUE)).isTrue();

    }

    @Test
    public void testPrimeWithStream() {
        assertThat(prime.isPrime_withStream(1)).isFalse();
        assertThat(prime.isPrime_withStream(2)).isTrue();
        assertThat(prime.isPrime_withStream(4)).isFalse();
        assertThat(prime.isPrime_withStream(5)).isTrue();
        assertThat(prime.isPrime_withStream(6)).isFalse();
        assertThat(prime.isPrime_withStream(9)).isFalse();
        assertThat(prime.isPrime_withStream(9)).isFalse();
        assertThat(prime.isPrime_withStream(25)).isFalse();
        assertThat(prime.isPrime_withStream(49)).isFalse();
        assertThat(prime.isPrime_withStream(113)).isTrue();
        assertThat(prime.isPrime_withStream(117)).isFalse();
        assertThat(prime.isPrime_withStream(121)).isFalse();
        assertThat(prime.isPrime_withStream(2_147_483_641)).isFalse();
        assertThat(prime.isPrime_withStream(Integer.MAX_VALUE)).isTrue();
    }

    @Test
    public void testPrimeWithSieveOfEratosthenes() {
        assertThat(prime.isPrime_withSieveOfEratosthenes(1)).isFalse();
        assertThat(prime.isPrime_withSieveOfEratosthenes(2)).isTrue();
        assertThat(prime.isPrime_withSieveOfEratosthenes(4)).isFalse();
        assertThat(prime.isPrime_withSieveOfEratosthenes(5)).isTrue();
        assertThat(prime.isPrime_withSieveOfEratosthenes(6)).isFalse();
        assertThat(prime.isPrime_withSieveOfEratosthenes(9)).isFalse();
        assertThat(prime.isPrime_withSieveOfEratosthenes(9)).isFalse();
        assertThat(prime.isPrime_withSieveOfEratosthenes(25)).isFalse();
        assertThat(prime.isPrime_withSieveOfEratosthenes(49)).isFalse();
        assertThat(prime.isPrime_withSieveOfEratosthenes(113)).isTrue();
        assertThat(prime.isPrime_withSieveOfEratosthenes(117)).isFalse();
        assertThat(prime.isPrime_withSieveOfEratosthenes(121)).isFalse();
        assertThat(prime.isPrime_withSieveOfEratosthenes(2_147_483_641)).isFalse();
        assertThat(prime.isPrime_withSieveOfEratosthenes(Integer.MAX_VALUE)).isTrue();
    }
}
