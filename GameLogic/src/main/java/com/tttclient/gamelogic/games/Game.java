package com.tttclient.gamelogic.games;

import com.tttclient.gamelogic.IGame;
import com.tttclient.gamelogic.LogicModel;


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
    public LogicModel checkWin() {
        LogicModel winner = LogicModel.NULL;

        for (int i = 0; i < field[0].length; ++i) {
            for (int j = 0; j < field[0].length; ++j) {
                boolean resultRDW = checkReverseDiagonalWin(i, j), resultSDW = checkStraightDiagonalWin(i, j),
                resultHW = checkHorizontalWin(i, j), resultVW = checkVerticalWin(i, j);

                // Checking for each turn (for game with bot)
                if (resultHW || resultRDW || resultVW || resultSDW) {
                    winner = selectModel();
                }

                turnOfCrosses = !turnOfCrosses;
                resultRDW = checkReverseDiagonalWin(i, j);
                resultSDW = checkStraightDiagonalWin(i, j);
                resultHW = checkHorizontalWin(i, j);
                resultVW = checkVerticalWin(i, j);

                if (resultHW || resultRDW || resultVW || resultSDW) {
                    winner = selectModel();
                }

                turnOfCrosses = !turnOfCrosses;
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

        LogicModel currentModel = selectModel();
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

        LogicModel currentModel = selectModel();
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
        if (y + countOfModelsInARowRequiredForWin > field[0].length) {
            return false;
        }

        LogicModel currentModel = selectModel();
        for (int i = 0; i < countOfModelsInARowRequiredForWin; ++i) {
            if (field[y][x] != currentModel) {
                return false;
            }
            else {
                ++y;
            }
        }

        return true;
    }

    private boolean checkHorizontalWin(int x, int y)  {
        if (x + countOfModelsInARowRequiredForWin > field[0].length) {
            return false;
        }

        LogicModel currentModel = selectModel();
        for (int i = 0; i < countOfModelsInARowRequiredForWin; ++i) {
            if (field[y][x] != currentModel) {
                return false;
            }
            else {
                ++x;
            }
        }

        return true;
    }

    private LogicModel selectModel() {
        if (turnOfCrosses) {
            return LogicModel.ZERO; // Checking ZERO on the turn of crosses, because we check after we place a model (so the flag will be already changed)
        }
        else {
            return LogicModel.CROSS;
        }
    }
}
