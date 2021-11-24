package com.github.pushkar97.gameOfLife;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;

@ExtendWith(MockitoExtension.class)
public class GameOfLife1Test {

    @Spy
    GameRulesPort rulesPort = new GameRulesPortImpl();
    GameOfLife1 game;

    @BeforeEach
    public void setup() {
        game = new GameOfLife1(rulesPort);
    }

    @Test
    public void gameShouldStop_whenBoardIsEmpty() {
        var board = new Board(new byte[][]{{0}});
        Assertions.assertTimeout(Duration.ofMillis(450), () -> game.play(board));
    }
}
