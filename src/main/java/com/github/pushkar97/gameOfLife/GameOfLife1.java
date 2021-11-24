package com.github.pushkar97.gameOfLife;

import java.io.IOException;

public class GameOfLife1 {

    GameRulesPort rulesPort;

    public GameOfLife1(GameRulesPort rulesPort) {
        this.rulesPort = rulesPort;
    }

    public long play(Board board) throws IOException {
        long time = 0;
        do {
            board = rulesPort.calculateNextStep(board);
            System.out.println("\n\nTime : " + ++time);
            board.print(System.out);
//            sleep(250);
        } while (board.getPopulation() > 0);
        return time;
    }
}
