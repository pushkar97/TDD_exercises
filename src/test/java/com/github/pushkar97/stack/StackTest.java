package com.github.pushkar97.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StackTest {

    Stack stack;

    @BeforeEach
    public void setup() {
        int stackSize = 2;
        stack = new Stack(stackSize);
    }

    @Test
    public void shouldBeEmpty_whenStackIsNew() {
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    public void shouldNotBeEmpty_whenELementAdded() {
        stack.push(2);
        assertThat(stack.isEmpty()).isFalse();
    }

    @Test
    public void whenElementPushedThenPopped_thenStackIsEmpty() {
        stack.push(2);
        stack.pop();
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    public void when2ElementsPushedThen1Popped_thenStackIsNotEmpty() {
        stack.push(1);
        stack.push(2);
        stack.pop();
        assertThat(stack.isEmpty()).isFalse();
    }

    @Test
    public void whenPoppingEmptyStack_throwStackUnderflowException() {
        assertThatExceptionOfType(Stack.StackUnderflowException.class)
                .isThrownBy(() -> stack.pop());
    }

    @Test
    public void whenPushingMoreThanSize_throwStackOverflowException() {
        stack.push(1);
        stack.push(1);
        assertThatExceptionOfType(Stack.StackOverflowException.class)
                .isThrownBy(() -> stack.push(1));
    }

    @Test
    public void whenElementPushed_thenOnPopReturnLastPushedElement() {
        stack.push(2);
        assertThat(stack.pop()).isEqualTo(2);
    }

    @Test
    public void whenElementsPushed_thenOnPopReturnElementsInReverseOrder() {
        stack.push(1);
        stack.push(2);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(1);
    }
}
