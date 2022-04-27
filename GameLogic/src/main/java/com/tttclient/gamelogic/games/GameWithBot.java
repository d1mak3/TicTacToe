package com.tttclient.gamelogic.games;

import com.tttclient.gamelogic.LogicModel;

public abstract class GameWithBot extends Game {
    LogicModel botModel;

    public GameWithBot(int fieldSize, LogicModel newBotModel) {
        super(fieldSize);
        botModel = newBotModel;
    }

    @Override
    public void place(int x, int y) {
        placeModel(x, y);

        botPlay();
    }

    public abstract void botPlay();
}
