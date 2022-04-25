package com.tttclient.gui.buttons;

import com.tttclient.gui.GameController;

import javax.swing.*;
import java.awt.*;

public class NewGameWithEasyBotButton extends Button {
    public NewGameWithEasyBotButton(Container parent) {
        super(parent);
        button = new JButton("Play with easy bot");
    }

    @Override
    public void configureButton() {
        button.setFont(new Font("Arial", Font.PLAIN, 75));

        button.addActionListener(listener -> {
            GameController newGameController = new GameController();
            newGameController.startGameWithEasyBot();
        });
    }
}
