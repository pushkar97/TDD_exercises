package com.github.pushkar97.gameOfLife;

public interface GameRulesPort {

    Board calculateNextStep(Board board);
}
