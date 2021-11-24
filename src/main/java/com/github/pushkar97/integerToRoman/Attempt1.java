package com.github.pushkar97.integerToRoman;

import java.util.Arrays;
import java.util.Map;

public class Attempt1 {

    public String integerToRoman(int i) {
        StringBuilder output = new StringBuilder();
        Map<Integer, String> values = Map.of(1,"I", 5, "V", 10, "X", 50, "L", 100, "C", 500, "D", 1000, "M");
        Integer[] sortedKeys = values.keySet().toArray(new Integer[0]);
        Arrays.sort(sortedKeys, (i1, i2) -> Integer.compare(i2, i1));
        for (int num : sortedKeys){
            if(i >= num) {
                output.append(values.get(num).repeat(Math.max(0, i / num)));
                i %= num;
            }
            int k = (int) Math.pow(10, getDigitCount(num*2) - 2);
            if(i != 0 && i + k == num) {
                output.append(values.get(k)).append(values.get(num));
                i -= num;
            }
        }
        return output.toString();
    }

    public int getDigitCount(int num) {
        int out = 0;
        while(num > 0) {
            num /= 10;
            out++;
        }
        return out;
    }
}
