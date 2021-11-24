package com.github.pushkar97.primes;

import java.util.Arrays;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;
import static java.util.stream.IntStream.rangeClosed;

public class Prime {
    public boolean isPrime(int i) {
        if (i < 2) return false;
        for (int j = 2; j <= Math.floor(Math.sqrt(i)); j++)
            if(i % j == 0) return false;
        return true;
    }

    public boolean isPrime_withStream(int i) {
        if (i < 2) return false;
        return rangeClosed(2, (int) floor(sqrt(i)))
                .filter(j -> i % j == 0).findFirst()
                .isEmpty();
    }

    public boolean isPrime_withSieveOfEratosthenes(int i) {
        if (i < 2) return false;
        int limit = (int) Math.floor(Math.sqrt(i));
        boolean[] sieve = new boolean[limit+1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;
        for (int j = 2; j <= limit; j++) {
            if(sieve[j]){
                if(i % j == 0) return false;
                for (int k = j*j; k < limit; k+=j) {
                    if(sieve[k]) sieve[k] = false;
                }
            }
        }
        return true;
    }
}
