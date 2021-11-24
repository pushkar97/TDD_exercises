package com.github.pushkar97.searchFunctionality;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SearchTest {

    Search search;

    @BeforeAll
    public void setup() {
        search = new Search(new DummyCityPort());
    }

    @Test
    public void testSetup(){
        assertThat(search).isNotNull();
    }

    @Test
    public void whenInputIsLessThan2Chars_ThenNoResult(){
        assertThat(search.searchCity("")).isEmpty();
    }

    @Test
    public void whenInputIs2CharsOrMore_ThenMatchedCitiesSHouldReturn(){
        assertThat(search.searchCity("Va"))
                .isNotEmpty()
                .contains("Valencia", "Vancouver");
    }

    @Test
    public void whenInputIs2CharsOrMore_ThenMatchedCitiesSHouldReturn_ContainsPredicate(){
        assertThat(search.searchCity("est"))
                .isNotEmpty()
                .contains("Budapest");
    }

    @Test
    public void whenAsterisk_ThenAllCities(){
        final String CITIES = "Paris, Budapest, Skopje, Rotterdam, Valencia, Vancouver, Amsterdam, Vienna, Sydney, New York City, London, Bangkok, Hong Kong, Dubai, Rome, Istanbul";
        assertThat(search.searchCity("*"))
                .isNotEmpty()
                .contains(CITIES.split(", "));
    }
}
