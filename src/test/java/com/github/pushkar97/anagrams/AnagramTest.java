package com.github.pushkar97.anagrams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnagramTest {

    Anagram anagram;

    @BeforeEach
    public void setup() {
        anagram = new Anagram();
    }

    @Test
    public void shouldReturnEmptyOutput_whenEmptyString() {
        assertThat(anagram.findAnagrams("")).isEmpty();
    }

    @Test
    public void shouldReturnSingleValue_whenSingleLetterString() {
        assertThat(anagram.findAnagrams("a"))
                .isNotEmpty()
                .contains("a")
                .size().isEqualTo(1);
    }

    @Test
    public void shouldReturn2Values_when2LetterString() {
        assertThat(anagram.findAnagrams("ab"))
                .isNotEmpty()
                .contains("ab","ba")
                .size().isEqualTo(2);
    }

    @Test
    public void shouldReturn1Value_when2IdenticalLetterString() {
        assertThat(anagram.findAnagrams("aa"))
                .isNotEmpty()
                .contains("aa")
                .size().isEqualTo(1);
    }

    @Test
    public void shouldReturnAllValues_when4LetterString() {
        assertThat(anagram.findAnagrams("biro"))
                .isNotEmpty()
                .contains("biro", "bior", "brio", "broi", "boir", "bori", "ibro", "ibor", "irbo", "irob", "iobr", "iorb",
                        "rbio", "rboi", "ribo", "riob", "roib", "robi", "obir", "obri", "oibr", "oirb", "orbi", "orib")
                .size().isEqualTo(24);
    }

    @Test
    public void shouldReturnAllValues_when3LetterStringAnd2LetterIdentical() {
        assertThat(anagram.findAnagrams("aab"))
                .isNotEmpty()
                .contains("aab", "aba", "baa")
                .size().isEqualTo(3);
    }
}
