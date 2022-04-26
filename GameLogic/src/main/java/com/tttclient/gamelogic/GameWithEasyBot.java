package com.tttclient.gamelogic;

public class GameWithEasyBot extends GameWithBot{
    public GameWithEasyBot(int fieldSize, Model newBotModel) {
        super(fieldSize, newBotModel);
    }

    @Override
    public void botPlay() {
        for (int i = 0; i < field[0].length; ++i) {
            for (int j = 0; j < field[0].length; ++j) {
                if (field[i][j] == Model.NULL) {
                    field[i][j] = botModel;
                }
            }
        }
    }
}
