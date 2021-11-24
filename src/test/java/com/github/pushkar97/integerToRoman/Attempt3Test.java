package com.github.pushkar97.integerToRoman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Attempt3Test {

    Attempt3 attempt3;

    @BeforeEach
    public void setup() {
        attempt3 = new Attempt3();
    }
    @Test
    public void integerToRamanTest() {
        Assertions.assertEquals("I", attempt3.integerToRoman(1));
        Assertions.assertEquals("III", attempt3.integerToRoman(3));
        Assertions.assertEquals("IV", attempt3.integerToRoman(4));
        Assertions.assertEquals("V", attempt3.integerToRoman(5));
        Assertions.assertEquals("VI", attempt3.integerToRoman(6));
        Assertions.assertEquals("VIII", attempt3.integerToRoman(8));
        Assertions.assertEquals("IX", attempt3.integerToRoman(9));
        Assertions.assertEquals("X", attempt3.integerToRoman(10));
        Assertions.assertEquals("XVI", attempt3.integerToRoman(16));
        Assertions.assertEquals("XIX", attempt3.integerToRoman(19));
        Assertions.assertEquals("XX", attempt3.integerToRoman(20));
        Assertions.assertEquals("XX", attempt3.integerToRoman(20));
        Assertions.assertEquals("XXIV", attempt3.integerToRoman(24));
        Assertions.assertEquals("XXX", attempt3.integerToRoman(30));
        Assertions.assertEquals("L", attempt3.integerToRoman(50));
        Assertions.assertEquals("XC", attempt3.integerToRoman(90));
        Assertions.assertEquals("C", attempt3.integerToRoman(100));
        Assertions.assertEquals("D", attempt3.integerToRoman(500));
        Assertions.assertEquals("CD", attempt3.integerToRoman(400));
        Assertions.assertEquals("CM", attempt3.integerToRoman(900));
        Assertions.assertEquals("M", attempt3.integerToRoman(1000));
        Assertions.assertEquals("MCMXCIV", attempt3.integerToRoman(1994));
    }
}
