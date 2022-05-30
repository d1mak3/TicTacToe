package com.tttclient.gamelogic.games;

import com.tttclient.gamelogic.LogicModel;

public class GameWithEasyBot extends GameWithBot{
    public GameWithEasyBot(int fieldSize, LogicModel newBotModel, boolean botTurn) {
        super(fieldSize, newBotModel, botTurn);
    }

    @Override
    public void botPlay() {
        for (int i = 0; i < field[0].length; ++i) {
            for (int j = 0; j < field[0].length; ++j) {
                if (field[i][j] == LogicModel.NULL) {
                    field[i][j] = botModel;
                    return;
                }
            }
        }
    }
}
