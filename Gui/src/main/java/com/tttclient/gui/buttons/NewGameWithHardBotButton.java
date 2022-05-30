package com.tttclient.gui.buttons;

import com.tttclient.gamelogic.LogicModel;
import com.tttclient.gamelogic.games.GameWithHardBot;
import com.tttclient.gui.controllers.GameController;
import com.tttclient.gui.GameField;
import com.tttclient.gui.Menu;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class NewGameWithHardBotButton extends Button {
    public NewGameWithHardBotButton(Container parent) {
        super(parent);
        button = new JButton("Play with hard bot");
    }

    @Override
    public void configureButton() {
        button.setFont(new Font("Arial", Font.PLAIN, 75));

        button.addActionListener(listener -> {
            Random randomizer = new Random();
            LogicModel botModel;

            if (randomizer.nextBoolean()) {
                botModel = LogicModel.CROSS;
            }
            else {
                botModel = LogicModel.ZERO;
            }

            GameField field = new GameField(3,
                    new GameController(new GameWithHardBot(3, botModel, randomizer.nextBoolean())));
            field.setVisible(true);
            field.setSize(1200, 600);
            Menu.getMenuFrame().setVisible(false);
        });
    }
}
