package com.tttclient.gamelogic.games;

import com.tttclient.gamelogic.LogicModel;

public abstract class GameWithBot extends Game {
    protected LogicModel botModel;
    protected boolean isBotTurnFirst;

    public GameWithBot(int fieldSize, LogicModel newBotModel, boolean botTurn) {
        super(fieldSize);
        botModel = newBotModel;
        isBotTurnFirst = botTurn;
    }

    @Override
    public void place(int x, int y) {
        turnOfCrosses = botModel != LogicModel.CROSS;

        if (checkWin() != LogicModel.NULL) {
            return;
        }

        if (isBotTurnFirst)
        {
            botPlay();
            placeModel(x, y);
            return;
        }

        placeModel(x, y);
        botPlay();
    }

    public abstract void botPlay();
}
