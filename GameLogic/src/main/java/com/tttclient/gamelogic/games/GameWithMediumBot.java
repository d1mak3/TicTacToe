package com.tttclient.gamelogic.games;

import com.tttclient.gamelogic.LogicModel;

import java.util.Random;

public class GameWithMediumBot extends GameWithBot{
    public GameWithMediumBot(int fieldSize, LogicModel newBotModel) {
        super(fieldSize, newBotModel);
    }

    @Override
    public void botPlay() {
//        for (int i = 0; i < field[0].length; ++i) {
//            for (int j = 0; j < field[0].length; ++j) {
//                if (field[i][j] == LogicModel.NULL) {
//                    field[i][j] = botModel;
//                    return;
//                }
//            }
//        }


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
