package com.tttclient.gui;

import com.tttclient.gamelogic.IGame;
import com.tttclient.gamelogic.LogicModel;

import javax.swing.*;

public class GameController {
    IGame game;
//    int countOfModelsInARowRequiredForWin = 3;

    public GameController(IGame newGame) {
        game = newGame;
        game.setWinCondition(3);
    }

    public void place(int x, int y) {
        game.place(x, y);
    }

    public LogicModel[][] getField() {
        return game.getField();
    }

    public LogicModel checkWin() {
        LogicModel winnerOfTheGame = game.checkWin();
        if (winnerOfTheGame != LogicModel.NULL) {
            String winnerTitle = winnerOfTheGame.name();
            winnerTitle = winnerTitle.toLowerCase();
            winnerTitle = winnerTitle.replace(winnerTitle.charAt(0), winnerTitle.toUpperCase().charAt(0)) + "es";

            JOptionPane.showMessageDialog(null, winnerTitle + " have won");
        }

        return winnerOfTheGame;
    }
}
