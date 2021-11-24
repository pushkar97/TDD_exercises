package com.github.pushkar97.gameOfLife;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BoardTest {

    @Test
    public void testValidBoard() {
        byte[][] input = {{0}};
        Board board = new Board(input);
        assertThat(board.getBoard()).isEqualTo(input);
    }
    @Test
    public void shouldThrowException_whenInputIsInvalid() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Board(new byte[][]{}));
        assertThatIllegalArgumentException().isThrownBy(() -> new Board(new byte[][]{{}}));
        assertThatIllegalArgumentException().isThrownBy(() -> new Board(new byte[][]{{-1}}));
        assertThatIllegalArgumentException().isThrownBy(() -> new Board(new byte[][]{{2}}));
    }

    @Test
    public void shouldReturnNumberOfLives_whenValidBoardIsGiven() {
        assertThat(new Board(new byte[][]{{0,0},{0,0}}).getPopulation()).isEqualTo(0);
        assertThat(new Board(new byte[][]{{0,1},{1,0}}).getPopulation()).isEqualTo(2);
        assertThat(new Board(new byte[][]{{1,1},{1,1}}).getPopulation()).isEqualTo(4);
    }

    @Test
    public void shouldThrowException_whenInvalidRowOrColumn() {
        Board board = new Board(new byte[][]{{0, 0}, {0, 0}});
        assertThatIllegalArgumentException().isThrownBy(() -> board.getNeighbours(-1, 0));
        assertThatIllegalArgumentException().isThrownBy(() -> board.getNeighbours(0, -1));
        assertThatIllegalArgumentException().isThrownBy(() -> board.getNeighbours(2, 0));
        assertThatIllegalArgumentException().isThrownBy(() -> board.getNeighbours(0, 2));
    }

    @Test
    public void shouldReturnNumberOfNeighbourLives_whenValidRowAndColumn() {
        assertThat(new Board(new byte[][]{{0,0},{0,0}}).getNeighbours(0,0)).isEqualTo(0);
        assertThat(new Board(new byte[][]{{0,1},{1,0}}).getNeighbours(0,0)).isEqualTo(2);
        assertThat(new Board(new byte[][]{{1,1},{1,1}}).getNeighbours(0,0)).isEqualTo(3);
        assertThat(new Board(new byte[][]{{1,1,1},{1,1,1},{1,1,1}}).getNeighbours(1,1)).isEqualTo(8);
    }

    @Test
    public void isliveCellTest() {
        Board board = new Board(new byte[][]{{0, 1}, {0, 0}});
        assertThat(board.isLive(0,0)).isEqualTo(false);
        assertThat(board.isLive(0,1)).isEqualTo(true);
        assertThatIllegalArgumentException().isThrownBy(() -> board.isLive(0,2));
        assertThatIllegalArgumentException().isThrownBy(() -> board.isLive(2,0));
    }

    @Test
    public void shouldPrintBoard() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        new Board(new byte[][]{{0,0},{0,0}}).print(outputStream);
        assertThat(outputStream.toString()).isEqualTo("Population: 0\n[0, 0]\n[0, 0]");
    }

    @Test
    public void testBoardEquality() {
        var board1 = new Board(new byte[][]{{0, 1}, {0, 0}});
        var board2 = new Board(new byte[][]{{0, 1}, {0, 0}});
        assertThat(board1).isEqualTo(board2);
    }
}