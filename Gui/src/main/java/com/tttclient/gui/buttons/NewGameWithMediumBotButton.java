package com.tttclient.gui.buttons;

import com.tttclient.gamelogic.LogicModel;
import com.tttclient.gamelogic.games.GameWithMediumBot;
import com.tttclient.gui.controllers.GameController;
import com.tttclient.gui.GameField;
import com.tttclient.gui.Menu;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class NewGameWithMediumBotButton extends Button {
    public NewGameWithMediumBotButton(Container parent) {
        super(parent);
        button = new JButton("Play with medium bot");
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
                    new GameController(new GameWithMediumBot(3, botModel)));
            field.setVisible(true);
            field.setSize(1200, 600);
            Menu.getMenuFrame().setVisible(false);
        });
    }
}
