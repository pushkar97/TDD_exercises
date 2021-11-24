package com.github.pushkar97.integerToRoman;

import java.util.Map;

public class Attempt3 {
    public String integerToRoman(int num) {
        StringBuilder out = new StringBuilder();
        int[] nums = new int[]{1000, 500, 100, 50, 10, 5};
        Map<Integer,String> intToRoman = Map.of(1000, "M",500,"D",100, "C", 50, "L",10,"X", 5, "V", 1, "I");
        Map<Integer,Integer> intCarry = Map.of(1000, 100, 500, 100, 100, 10, 50, 10, 10,1, 5, 1);
        for (int n : nums){
            if(num >= n) {
                out.append(intToRoman.get(n).repeat(num/n));
                num %= n;
            }
            if(num + intCarry.get(n) >= n){
                out.append(intToRoman.get(intCarry.get(n))).append(intToRoman.get(n));
                num-= n-intCarry.get(n);
            }
        }

        out.append("I".repeat(num));
        return out.toString();
    }
}
