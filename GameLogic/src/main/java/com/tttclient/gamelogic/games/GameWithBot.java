package com.tttclient.gamelogic.games;

import com.tttclient.gamelogic.LogicModel;
import com.tttclient.gamelogic.Winner;

public abstract class GameWithBot extends Game {
    LogicModel botModel;

    public GameWithBot(int fieldSize, LogicModel newBotModel) {
        super(fieldSize);
        botModel = newBotModel;
    }

    @Override
    public void place(int x, int y) {
        if (botModel == LogicModel.CROSS) {
            turnOfCrosses = false;
        }
        else {
            turnOfCrosses = true;
        }

        placeModel(x, y);

        if (checkWin() != Winner.NOBODY) {
            return;
        }

        botPlay();
    }

    public abstract void botPlay();
}
