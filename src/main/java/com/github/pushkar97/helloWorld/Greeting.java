package com.github.pushkar97.helloWorld;

import static java.util.Objects.isNull;

public class Greeting {

    public static final String GREETING_FORMAT = "Hello %s!";
    public static String getMessage() {
        return getMessage("world");
    }

    public static String getMessage(String name) {
        if(empty(name)) return getMessage();
        return String.format(GREETING_FORMAT, name);
    }

    private static boolean empty(String name) {
        return isNull(name) || name.isBlank();
    }
}
