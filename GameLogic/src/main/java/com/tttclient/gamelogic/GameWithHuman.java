package com.tttclient.gamelogic;

public class GameWithHuman extends Game {
    public GameWithHuman(int fieldSize) {
        super(fieldSize);
    }

    @Override
    public void place(int x, int y) {
        if (turnOfCrosses) {
            field[x][y] = Model.CROSS;
        }
        else {
            field[x][y] = Model.ZERO;
        }
        turnOfCrosses = !turnOfCrosses;
    }
}
