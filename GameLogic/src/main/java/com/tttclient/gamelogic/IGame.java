package com.tttclient.gamelogic;

import java.io.Serializable;

public interface IGame extends Serializable {
    void place(int x, int y);
    LogicModel checkWin();
    void setWinCondition(int countOfModelsInARow);
    LogicModel[][] getField();
}
