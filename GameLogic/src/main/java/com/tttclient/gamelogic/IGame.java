package com.tttclient.gamelogic;

public interface IGame {
    void place(int x, int y);
    LogicModel checkWin();
    void setWinCondition(int countOfModelsInARow);
    LogicModel[][] getField();
}
