package com.tttclient.gui;

import com.tttclient.gamelogic.IGame;
import com.tttclient.gamelogic.LogicModel;

public class GameController {
    IGame game;
//    int countOfModelsInARowRequiredForWin = 3;

    public GameController(IGame newGame) {
        game = newGame;
        game.setWinCondition(3);
    }

    public LogicModel[][] place(int x, int y) {
        game.place(x, y);
        return game.getField();
    }

    public LogicModel checkWin() {
        return game.checkWin();
    }
}
