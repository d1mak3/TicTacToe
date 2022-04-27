package com.tttclient.gamelogic;

public interface IGame {
    void place(int x, int y);
    Winner checkWin();
    void setWinCondition(int countOfModelsInARow);
    LogicModel[][] getField();
}
