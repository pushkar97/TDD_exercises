package com.github.pushkar97.integerToRoman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Attempt1Test {

    Attempt1 attempt1;

    @BeforeEach
    public void init(){
        attempt1 = new Attempt1();
    }

    @Test
    public void testIntegerToRoman() {
        assertEquals("I", attempt1.integerToRoman(1));
        assertEquals("II", attempt1.integerToRoman(2));
        assertEquals("III", attempt1.integerToRoman(3));
        assertEquals("IV", attempt1.integerToRoman(4));
        assertEquals("V", attempt1.integerToRoman(5));
        assertEquals("VI", attempt1.integerToRoman(6));
        assertEquals("VII", attempt1.integerToRoman(7));
        assertEquals("VIII", attempt1.integerToRoman(8));
        assertEquals("IX", attempt1.integerToRoman(9));
        assertEquals("X", attempt1.integerToRoman(10));
        assertEquals("XII", attempt1.integerToRoman(12));
        assertEquals("XIV", attempt1.integerToRoman(14));
        assertEquals("XVI", attempt1.integerToRoman(16));
        assertEquals("XIX", attempt1.integerToRoman(19));
        assertEquals("XX", attempt1.integerToRoman(20));
        assertEquals("XL", attempt1.integerToRoman(40));
        assertEquals("L", attempt1.integerToRoman(50));
        assertEquals("XC", attempt1.integerToRoman(90));
        assertEquals("C", attempt1.integerToRoman(100));
        assertEquals("M", attempt1.integerToRoman(1000));
        assertEquals("MX", attempt1.integerToRoman(1010));
    }

    @Test
    public void testGetDigitCount() {
        assertEquals(2, attempt1.getDigitCount(32));
        assertEquals(3, attempt1.getDigitCount(100));
        assertEquals(1, attempt1.getDigitCount(3));
    }
}
