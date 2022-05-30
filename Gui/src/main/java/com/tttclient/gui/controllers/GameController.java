package com.tttclient.gui.controllers;

import com.tttclient.gamelogic.IGame;
import com.tttclient.gamelogic.LogicModel;

import javax.swing.*;

public class GameController {
    private final IGame game;
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

            return winnerOfTheGame;
        }

        if (checkDraw()) {
            winnerOfTheGame = LogicModel.ZERO; // The winner doesn't matter in usage of this method. It just has to be not NULL
            JOptionPane.showMessageDialog(null, "Draw");
        }

        return winnerOfTheGame;
    }

    public IGame getGame() {
        return game;
    }

    private boolean checkDraw() {
        LogicModel[][] field = getField();
        int counter = 0;
        int fieldSize = field[0].length;

        for (int i = 0; i < fieldSize; ++i) {
            for (int j = 0; j < fieldSize; ++j) {
                if (field[i][j] != LogicModel.NULL) {
                    ++counter;
                }
            }
        }

        return counter == fieldSize * fieldSize;
    }
}
