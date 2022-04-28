package com.tttclient.gamelogic.games;

import com.tttclient.gamelogic.IGame;
import com.tttclient.gamelogic.LogicModel;
import com.tttclient.gamelogic.Winner;


public abstract class Game implements IGame {
    LogicModel[][] field;
    boolean turnOfCrosses = false;
    int countOfModelsInARowRequiredForWin;

    public Game(int fieldSize) {
        field = new LogicModel[fieldSize][fieldSize];

        // Fill the field with NULLs
        for (int i = 0; i < fieldSize; ++i) {
            for (int j = 0; j < fieldSize; ++j) {
                field[i][j] = LogicModel.NULL;
            }
        }
    }

    @Override
    public void place(int x, int y) {
        placeModel(x, y);
    }

    @Override
    public Winner checkWin() {
        Winner winner = Winner.NOBODY;

        for (int i = 0; i < field[0].length; ++i) {
            for (int j = 0; j < field[0].length; ++j) {
                boolean resultRDW = checkReverseDiagonalWin(j, i), resultSDW = checkStraightDiagonalWin(j, i),
                resultHW = checkHorizontalWin(j, i), resultVW = checkVerticalWin(j, i);

                if (resultHW || resultRDW || resultVW || resultSDW) {
                    if (turnOfCrosses) {
                        winner = Winner.CROSS;
                    }
                    else {
                        winner = Winner.ZERO;
                    }
                }
            }
        }

        return winner;
    }

    @Override
    public void setWinCondition(int countOfModelsInARow) {
        countOfModelsInARowRequiredForWin = countOfModelsInARow;
    }

    @Override
    public LogicModel[][] getField() {
        return field;
    }

    protected void placeModel(int x, int y) {
        if (turnOfCrosses) {
            field[x][y] = LogicModel.CROSS;
        }
        else {
            field[x][y] = LogicModel.ZERO;
        }
        turnOfCrosses = !turnOfCrosses;
    }

    private boolean checkStraightDiagonalWin(int x, int y) {
        if (x + countOfModelsInARowRequiredForWin > field[0].length || y + countOfModelsInARowRequiredForWin > field[0].length) {
            return false;
        }

        LogicModel currentModel;
        if (turnOfCrosses) {
            currentModel = LogicModel.CROSS;
        }
        else {
            currentModel = LogicModel.ZERO;
        }

        for (int i = 0; i < countOfModelsInARowRequiredForWin; ++i) {
            if (field[x][y] != currentModel) {
                return false;
            }
            else {
                ++x;
                ++y;
            }
        }

        return true;
    }

    private boolean checkReverseDiagonalWin(int x, int y) {
        if (x - countOfModelsInARowRequiredForWin + 1 < 0 || y + countOfModelsInARowRequiredForWin > field[0].length) {
            return false;
        }

        LogicModel currentModel;
        if (turnOfCrosses) {
            currentModel = LogicModel.CROSS;
        }
        else {
            currentModel = LogicModel.ZERO;
        }

        for (int i = 0; i < countOfModelsInARowRequiredForWin; ++i) {
            if (field[x][y] != currentModel) {
                return false;
            }
            else {
                --x;
                ++y;
            }
        }

        return true;
    }

    private boolean checkVerticalWin(int x, int y) {
        if (x + countOfModelsInARowRequiredForWin > field[0].length) {
            return false;
        }

        LogicModel currentModel;
        if (turnOfCrosses) {
            currentModel = LogicModel.CROSS;
        }
        else {
            currentModel = LogicModel.ZERO;
        }

        for (int i = 0; i < countOfModelsInARowRequiredForWin; ++i) {
            if (field[x][y] != currentModel) {
                return false;
            }
            else {
                ++x;
            }
        }

        return true;
    }

    private boolean checkHorizontalWin(int x, int y) {
        if (y + countOfModelsInARowRequiredForWin > field[0].length) {
            return false;
        }

        LogicModel currentModel;
        if (turnOfCrosses) {
            currentModel = LogicModel.CROSS;
        }
        else {
            currentModel = LogicModel.ZERO;
        }

        for (int i = 0; i < countOfModelsInARowRequiredForWin; ++i) {
            if (field[x][y] != currentModel) {
                return false;
            }
            else {
                ++y;
            }
        }

        return true;
    }
}
