package com.github.pushkar97.helloWorld;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GreetingsTest {

    @Test
    public void greetingShouldBeHello_World(){
        assertThat(Greeting.getMessage()).isEqualTo("Hello world!");
    }

    @Test
    public void greetingShouldBeHello_Input_forGivenInput(){
        assertThat(Greeting.getMessage("John")).isEqualTo("Hello John!");
        assertThat(Greeting.getMessage("Jina")).isEqualTo("Hello Jina!");
    }

    @Test
    public void greetingShouldBeHello_world_ifGivenInputIsNullOrEmpty(){
        assertThat(Greeting.getMessage("")).isEqualTo("Hello world!");
        assertThat(Greeting.getMessage(" ")).isEqualTo("Hello world!");
        assertThat(Greeting.getMessage(null)).isEqualTo("Hello world!");
    }
}
