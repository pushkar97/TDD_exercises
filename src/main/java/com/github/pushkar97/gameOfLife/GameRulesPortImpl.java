package com.github.pushkar97.gameOfLife;

public class GameRulesPortImpl implements GameRulesPort {
    @Override
    public Board calculateNextStep(Board board) {
        byte[][] nextstep = new byte[board.getBoard().length][];
        for (int i = 0; i < board.getBoard().length; i++) {
            nextstep[i] = new byte[board.getBoard()[i].length];
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                nextstep[i][j] = evaluateCell(i,j,board);
            }
        }
        return new Board(nextstep);
    }

    private byte evaluateCell(int row, int col, Board board) {
        int neighboursCount = board.getNeighbours(row, col);
        if (board.isLive(row, col))
            return neighboursCount < 2 || neighboursCount > 3 ? (byte) 0 : 1;
        return neighboursCount == 3 ? (byte) 1 : 0;
    }
}
