package com.github.pushkar97.searchFunctionality;

import java.util.Arrays;
import java.util.Collection;

public class DummyCityPort implements ICityPort {

    private final String CITIES = "Paris, Budapest, Skopje, Rotterdam, Valencia, Vancouver, Amsterdam, Vienna, Sydney, New York City, London, Bangkok, Hong Kong, Dubai, Rome, Istanbul";

    @Override
    public Collection<String> getAllCities() {
        return Arrays.stream(CITIES.split(",")).map(String::trim).toList();
    }
}
