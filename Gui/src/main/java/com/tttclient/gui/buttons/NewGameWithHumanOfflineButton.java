package com.tttclient.gui.buttons;

import com.tttclient.gui.GameController;

import javax.swing.JButton;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameWithHumanOfflineButton extends Button {
    public NewGameWithHumanOfflineButton(Container newParent) {
        super(newParent);
        button = new JButton("Play Offline");
    }

    @Override
    public void configureButton() {
        button.setFont(new Font("Arial", Font.PLAIN, 75));

        button.addActionListener(listener -> {
            GameController newGameController = new GameController();
            newGameController.startGameWithHumanOffline();
        });
    }
}
