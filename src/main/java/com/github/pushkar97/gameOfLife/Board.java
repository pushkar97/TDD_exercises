package com.github.pushkar97.gameOfLife;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Board {

    private byte[][] board;

    public Board(byte[][] board) {
        setBoard(board);
    }

    public void setBoard(byte[][] board) {
        if (board.length == 0) throw new IllegalArgumentException();
        for (byte[] row : board) {
            if (row.length == 0) throw new IllegalArgumentException();
            for (byte val : row)
                if (val != 1 && val != 0) throw new IllegalArgumentException();
        }
        this.board = board;
    }

    public byte[][] getBoard() {
        return board;
    }

    public int getPopulation() {
        int population = 0;
        for (byte[] row : board)
            for (byte val : row)
                population += val;
        return population;
    }

    public void print(OutputStream out) throws IOException {
        byte[] board = Stream.of(this.board)
                .map(Arrays::toString)
                .collect(Collectors.joining("\n"))
                .getBytes(StandardCharsets.UTF_8);
        byte[] population = String.format("Population: %d\n", getPopulation()).getBytes(StandardCharsets.UTF_8);
        out.write(population);
        out.write(board);
        out.flush();
    }

    public int getNeighbours(int row, int col) {
        if (!isValidPosition(row, col)) throw new IllegalArgumentException();
        byte left = getOrDefault(row, col - 1);
        byte right = getOrDefault(row, col + 1);
        byte top = getOrDefault(row - 1, col);
        byte bottom = getOrDefault(row + 1, col);
        byte topLeft = getOrDefault(row - 1, col - 1);
        byte topRight = getOrDefault(row - 1, col + 1);
        byte bottomLeft = getOrDefault(row + 1, col - 1);
        byte bottomRight = getOrDefault(row + 1, col + 1);
        return left + right + top + bottom + topLeft + topRight + bottomLeft + bottomRight;
    }

    private byte getOrDefault(int row, int col) {
        return isValidPosition(row, col) ? board[row][col] : 0;
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[row].length;
    }

    public boolean isLive(int row, int col) {
        if (!isValidPosition(row, col)) throw new IllegalArgumentException();
        return board[row][col] == 1;
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + Arrays.deepToString(board) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Board board1)) return false;
        return Arrays.deepEquals(getBoard(), board1.getBoard());
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(getBoard());
    }
}
