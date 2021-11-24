package com.github.pushkar97.anagrams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Anagram {

    public List<String> findAnagrams(String s) {
        if (s.length() == 0) return Collections.emptyList();
        if (s.length() == 1) return Collections.singletonList(s);

        return IntStream.range(0, s.length()).boxed()
                .flatMap(i -> findAnagrams(skipLetterAtI(s, i)).stream().map(v -> s.charAt(i) + v))
                .distinct()
                .collect(Collectors.toList());
    }

    private String skipLetterAtI(String s, Integer i) {
        return s.substring(0, i) + s.substring(Math.min(i + 1, s.length()));
    }
}
