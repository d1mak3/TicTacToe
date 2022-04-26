package com.tttclient.gamelogic;

public abstract class Game implements IGame {
    Model[][] field = null;
    boolean turnOfCrosses = false;
    int countOfModelsInARowRequiredForWin;

    public Game(int fieldSize) {
        field = new Model[fieldSize][fieldSize];

        // Fill the field with NULLs
        for (int i = 0; i < fieldSize; ++i) {
            for (int j = 0; j < fieldSize; ++j) {
                field[i][j] = Model.NULL;
            }
        }
    }

    @Override
    public void place(int x, int y) {
        if (turnOfCrosses) {
            field[x][y] = Model.CROSS;
        }
        else {
            field[x][y] = Model.ZERO;
        }
        turnOfCrosses = !turnOfCrosses;
    }

    @Override
    public Winner checkWin() {
        Winner winner = Winner.GAME_IS_NOT_OVER;

        for (int i = 0; i < field[0].length; ++i) {
            for (int j = 0; j < field[0].length; ++j) {
                if (checkReverseDiagonalWin(i, j) ||
                    checkStraightDiagonalWin(i, j) ||
                    checkHorizontalWin(i, j) ||
                    checkVerticalWin(i, j)) {
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

    private boolean checkStraightDiagonalWin(int x, int y) {
        if (x + countOfModelsInARowRequiredForWin > field[0].length || y + countOfModelsInARowRequiredForWin > field[0].length) {
            return false;
        }

        Model currentModel;
        if (turnOfCrosses) {
            currentModel = Model.CROSS;
        }
        else {
            currentModel = Model.ZERO;
        }

        for (int i = 0; i < countOfModelsInARowRequiredForWin - 1; ++i) {
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
        if (x - countOfModelsInARowRequiredForWin < 0 || y + countOfModelsInARowRequiredForWin > field[0].length) {
            return false;
        }

        Model currentModel;
        if (turnOfCrosses) {
            currentModel = Model.CROSS;
        }
        else {
            currentModel = Model.ZERO;
        }

        for (int i = 0; i < countOfModelsInARowRequiredForWin - 1; ++i) {
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

    private boolean checkHorizontalWin(int x, int y) {
        if (x + countOfModelsInARowRequiredForWin > field[0].length) {
            return false;
        }

        Model currentModel;
        if (turnOfCrosses) {
            currentModel = Model.CROSS;
        }
        else {
            currentModel = Model.ZERO;
        }

        for (int i = 0; i < countOfModelsInARowRequiredForWin - 1; ++i) {
            if (field[x][y] != currentModel) {
                return false;
            }
            else {
                ++x;
            }
        }

        return true;
    }

    private boolean checkVerticalWin(int x, int y) {
        if (y + countOfModelsInARowRequiredForWin > field[0].length) {
            return false;
        }

        Model currentModel;
        if (turnOfCrosses) {
            currentModel = Model.CROSS;
        }
        else {
            currentModel = Model.ZERO;
        }

        for (int i = 0; i < countOfModelsInARowRequiredForWin - 1; ++i) {
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
