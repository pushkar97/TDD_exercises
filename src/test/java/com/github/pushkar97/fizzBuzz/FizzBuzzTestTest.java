package com.github.pushkar97.fizzBuzz;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class FizzBuzzTestTest {

    FizzBuzz app;

    @BeforeEach
    public void setup() {
        app = new FizzBuzz();
    }

    @Test
    public void appNotNull() {
        assertNotNull(app);
    }

    @Test
    public void testFizzBuzz() {
        String output = app.fizzBuzz(20);
        String[] outputLines = output.split("\n");
        assertEquals("1", outputLines[0], "fizzbuzz(1)");
        assertEquals("2", outputLines[1], "fizzbuzz(2)");
        assertEquals("Fizz", outputLines[2], "fizzbuzz(3)");
        assertEquals("Buzz", outputLines[4], "fizzbuzz(5)");
        assertEquals("FizzBuzz", outputLines[14], "fizzbuzz(15)");
        assertEquals("Buzz", outputLines[19], "fizzbuzz(20)");
    }
}
