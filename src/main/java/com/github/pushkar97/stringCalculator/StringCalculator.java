package com.github.pushkar97.stringCalculator;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class StringCalculator {

    private final String DELIMITER_FORMAT = "//";
    private final String DEFAULT_DELIMITER = ",+|\\n+";
    private final Predicate<String> DELIMITER_SPECIFIED = s -> s.startsWith(DELIMITER_FORMAT);

    public int add(String s) {
        if(s.isEmpty()) return 0;
        return Stream
                .of(getInput(s).split(getDelimiter(s)))
                .filter(v -> !v.isEmpty())
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private String getInput(String s) {
        if (DELIMITER_SPECIFIED.test(s)) return s.substring(s.indexOf("\n")+1);
        return s;
    }

    private String getDelimiter(String s) {
        if (DELIMITER_SPECIFIED.test(s)) return s.substring(2, s.indexOf("\n"))+"+|\\n+";
        return DEFAULT_DELIMITER;
    }
}
