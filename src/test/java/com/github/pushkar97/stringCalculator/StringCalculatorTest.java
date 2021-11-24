package com.github.pushkar97.stringCalculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringCalculatorTest {

    StringCalculator calculator;

    @BeforeAll
    public void setup() {
        calculator = new StringCalculator();
    }

    @Test
    public void testSetup() {
        assertThat(calculator.add("")) .isEqualTo(0);
        assertThat(calculator.add("1")).isEqualTo(1);
        assertThat(calculator.add("3")).isEqualTo(3);
        assertThat(calculator.add("5,3")).isEqualTo(8);
        assertThat(calculator.add("4,8")).isEqualTo(12);
        assertThat(calculator.add("4,8,2")).isEqualTo(14);
        assertThat(calculator.add("4,3,6")).isEqualTo(13);
        assertThat(calculator.add("8,1,2")).isEqualTo(11);
        assertThat(calculator.add("8,1\n1")).isEqualTo(10);
        assertThat(calculator.add("//\\.\n8.1\n6")).isEqualTo(15);
        assertThat(calculator.add("//\\|\n1|2|3")).isEqualTo(6);
        assertThat(calculator.add("//sep\n2sep5")).isEqualTo(7);
    }
}
