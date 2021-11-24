package com.github.pushkar97.integerToRoman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Attempt2Test {

    Attempt2 attempt2;

    @BeforeEach
    public void init() {
        attempt2 = new Attempt2();
    }

    @Test
    public void testIntegerToRoman() {
        assertEquals("I", attempt2.integerToRoman(1));
        assertEquals("II", attempt2.integerToRoman(2));
        assertEquals("III", attempt2.integerToRoman(3));
        assertEquals("IV", attempt2.integerToRoman(4));
        assertEquals("V", attempt2.integerToRoman(5));
        assertEquals("VI", attempt2.integerToRoman(6));
        assertEquals("VIII", attempt2.integerToRoman(8));
        assertEquals("IX", attempt2.integerToRoman(9));
        assertEquals("X", attempt2.integerToRoman(10));
        assertEquals("XII", attempt2.integerToRoman(12));
        assertEquals("XIV", attempt2.integerToRoman(14));
        assertEquals("XV", attempt2.integerToRoman(15));
        assertEquals("XVII", attempt2.integerToRoman(17));
        assertEquals("XIX", attempt2.integerToRoman(19));
        assertEquals("XX", attempt2.integerToRoman(20));
        assertEquals("XL", attempt2.integerToRoman(40));
        assertEquals("L", attempt2.integerToRoman(50));
        assertEquals("LXVI", attempt2.integerToRoman(66));
        assertEquals("XCIX", attempt2.integerToRoman(99));
        assertEquals("C", attempt2.integerToRoman(100));
        assertEquals("CCXCIV", attempt2.integerToRoman(294));
        assertEquals("CD", attempt2.integerToRoman(400));
        assertEquals("DCXC", attempt2.integerToRoman(690));
        assertEquals("MMX", attempt2.integerToRoman(2010));

        assertThrows(IllegalArgumentException.class, () -> attempt2.integerToRoman(-10));
    }
}
