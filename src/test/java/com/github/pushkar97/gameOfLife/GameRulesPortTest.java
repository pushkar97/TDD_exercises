package com.github.pushkar97.gameOfLife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameRulesPortTest {

    GameRulesPort port;

    @BeforeEach
    public void setup() {
        port = new GameRulesPortImpl();
    }

    @Test
    public void testRulesPort() {
        Board board = new Board(new byte[][]{{0, 0}, {0, 0}});
        assertThat(port.calculateNextStep(board)).isEqualTo(board);
    }

    @Test
    public void liveCellShouldDie_whenLessThan2Neighbours() {
        Board board = new Board(new byte[][]{{1, 0}, {0, 0}});
        assertThat(port.calculateNextStep(board)).isEqualTo(new Board(new byte[][]{{0, 0}, {0, 0}}));
    }

    @Test
    public void liveCellShouldLive_when2or3Neighbours() {
        Board board = new Board(new byte[][]{{1, 1}, {1, 0}});
        assertThat(port.calculateNextStep(board).getBoard()[0][0]).isOne();
    }

    @Test
    public void liveCellShouldDie_whenMoreThan3Neighbours() {
        Board board = new Board(new byte[][]{{1, 1, 1}, {1, 1, 1}});
        assertThat(port.calculateNextStep(board).getBoard()[1][1]).isZero();
    }

    @Test
    public void deadCellShouldLive_whenExactly3Neighbours() {
        Board board = new Board(new byte[][]{{1, 1}, {1, 0}});
        assertThat(port.calculateNextStep(board).getBoard()[1][1]).isOne();
    }
}