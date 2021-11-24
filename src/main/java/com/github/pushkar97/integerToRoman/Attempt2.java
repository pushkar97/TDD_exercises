package com.github.pushkar97.integerToRoman;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Attempt2 {

    public String integerToRoman(int i) {
        if (i < 1) throw new IllegalArgumentException("Input cannot be less than 1");

        StringBuilder out = new StringBuilder();
        Map<Integer, String> intToRoman = Map.of(1, "I", 5, "V", 10, "X", 50, "L", 100, "C", 500, "D", 1000, "M");
        Map<Integer, Integer> sub = Map.of(5, 1, 10, 1, 50, 10, 100, 10, 500, 100, 1000, 100);
        for (int num : Stream.of(1000, 500, 100, 50, 10, 5).collect(Collectors.toList())) {
            if (i >= num) {
                out.append(intToRoman.get(num).repeat(i / num));
                i %= num;
            }
            if (i >= num - sub.get(num)) {
                out.append(intToRoman.get(sub.get(num))).append(intToRoman.get(num));
                i -= (num - sub.get(num));
            }
        }
        out.append("I".repeat(i));
        return out.toString();
    }
}
