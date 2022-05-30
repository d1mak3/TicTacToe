package com.tttclient.gamelogic;

import java.io.Serializable;

public interface IGame extends Serializable {
    long serialVersionUID = 42L;
    void place(int x, int y);
    LogicModel checkWin();
    void setWinCondition(int countOfModelsInARow);
    LogicModel[][] getField();
}
