package com.tttclient.gamelogic.games;

import com.tttclient.gamelogic.LogicModel;

import java.util.Random;

public class GameWithHardBot extends GameWithBot {
    public GameWithHardBot(int fieldSize, LogicModel newBotModel, boolean botTurn) {
        super(fieldSize, newBotModel, botTurn);
    }

    @Override
    public void botPlay() {
        int length = field[0].length;

        // Check if there are any win conditions
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < length; ++j) {
                if (field[j][i] == LogicModel.NULL) {
                    field[j][i] = botModel;

                    if (checkWin() == botModel) {
                        return;
                    }

                    field[j][i] = LogicModel.NULL;
                }
            }
        }

        for (int i = 0; i < field[0].length * field[0].length; ++i) {
            Random positionGenerator = new Random();
            int newX = positionGenerator.nextInt(0, field[0].length);
            int newY = positionGenerator.nextInt(0, field[0].length);

            if (field[newY][newX] == LogicModel.NULL) {
                field[newY][newX] = botModel;
                return;
            }
        }
    }
}
