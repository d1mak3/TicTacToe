package com.tttclient.gamelogic;

public abstract class GameWithBot extends Game {
    Model botModel;

    public GameWithBot(int fieldSize, Model newBotModel) {
        super(fieldSize);
        botModel = newBotModel;
    }

    public abstract void botPlay();
}
