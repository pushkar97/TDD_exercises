package com.github.pushkar97.primes;

import org.junit.jupiter.api.Test;

import static com.github.pushkar97.primes.Prime2.isPrime;
import static org.assertj.core.api.Assertions.assertThat;

public class Prime2Test {

    @Test
    public void numbersLessThan2ShouldNotBePrime() {
        assertThat(isPrime(1)).isFalse();
    }

    @Test
    public void when2_thenPrime() {
        assertThat(isPrime(2)).isTrue();
    }

    @Test
    public void whenDivisibleBy2_thenNotPrime() {
        assertThat(isPrime(4)).isFalse();
        assertThat(isPrime(6)).isFalse();
        assertThat(isPrime(8)).isFalse();
    }

    @Test
    public void shouldNotBePrime_whenDivisibleBy3() {
        assertThat(isPrime(9)).isFalse();
        assertThat(isPrime(15)).isFalse();
        assertThat(isPrime(21)).isFalse();
    }

    @Test
    public void shouldNotBePrime_whenDivisibleBy5() {
        assertThat(isPrime(25)).isFalse();
        assertThat(isPrime(75)).isFalse();
        assertThat(isPrime(125)).isFalse();
    }

    @Test
    public void shouldNotBePrime() {
        assertThat(isPrime(Integer.MAX_VALUE)).isTrue();
        assertThat(isPrime(Integer.MAX_VALUE - 3)).isFalse();
        assertThat(isPrime(Integer.MAX_VALUE - 7)).isFalse();
        assertThat(isPrime(Integer.MAX_VALUE - 31)).isFalse();
    }
}
