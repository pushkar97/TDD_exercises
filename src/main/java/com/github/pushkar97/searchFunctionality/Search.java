package com.github.pushkar97.searchFunctionality;

import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import java.util.function.Predicate;

public class Search {

    ICityPort cityPort;

    public Search(ICityPort cityPort) {
        this.cityPort = cityPort;
    }

    public Collection<String> searchCity(String s) {
        if(s.equals("*")) return cityPort.getAllCities();

        if (s.trim().length() < 2) return Collections.emptyList();

        return cityPort.getAllCities().stream()
                .filter(startsWith(s).or(contains(s)))
                .toList();
    }

    private Predicate<String> contains(String s) {
        return c -> c.toLowerCase(Locale.ROOT).trim().contains(s.toLowerCase(Locale.ROOT));
    }

    private Predicate<String> startsWith(String s) {
        return c -> c.toLowerCase(Locale.ROOT).trim().startsWith(s.toLowerCase(Locale.ROOT));
    }
}
