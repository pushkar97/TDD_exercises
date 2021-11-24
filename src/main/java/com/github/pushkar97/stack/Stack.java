package com.github.pushkar97.stack;

public class Stack {

    private static final int DEFAULT_SIZE = 16;
    private final int size;
    private int count = 0;
    private final int[] val;

    public Stack() {
        this(DEFAULT_SIZE);
    }

    public Stack(int size) {
        this.size = size;
        val = new int[size];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }

    public void push(int i) {
        if (isFull()) throw new StackOverflowException();
        val[count++] = i;
    }

    public int pop() {
        if (isEmpty()) throw new StackUnderflowException();
        return val[--count];
    }

    public static class StackUnderflowException extends RuntimeException {

    }

    public static class StackOverflowException extends RuntimeException{
    }
}
