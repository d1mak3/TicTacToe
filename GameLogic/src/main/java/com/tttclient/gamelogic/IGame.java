package com.tttclient.gamelogic;

enum Model {
    NULL,
    CROSS,
    ZERO,
}

enum Winner {
    CROSS,
    ZERO,
    GAME_IS_NOT_OVER,
}

public interface IGame {
    void place(int x, int y);
    Winner checkWin();
    void setWinCondition(int countOfModelsInARow);
}
