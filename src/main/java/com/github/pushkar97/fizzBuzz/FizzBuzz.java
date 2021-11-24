package com.github.pushkar97.fizzBuzz;

import java.util.StringJoiner;

public class FizzBuzz {

    public String fizzBuzz(int i) {
        var joiner = new StringJoiner("\n");
        for (int j = 1; j <= i ; j++) joiner.add(getFizzBuzz(j));
        return joiner.toString();
    }

    private String getFizzBuzz(int j) {
        var value = "";
        if (j %3==0) value = "Fizz";
        if (j %5==0) value += "Buzz";
        if(value.equals("")) return Integer.toString(j);
        return value;
    }
}
