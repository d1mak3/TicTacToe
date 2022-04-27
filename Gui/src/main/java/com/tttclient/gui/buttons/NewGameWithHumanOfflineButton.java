package com.tttclient.gui.buttons;

import com.tttclient.gamelogic.games.GameWithHuman;
import com.tttclient.gui.GameController;
import com.tttclient.gui.GameField;
import com.tttclient.gui.Menu;

import javax.swing.JButton;

import java.awt.Container;
import java.awt.Font;

public class NewGameWithHumanOfflineButton extends Button {
    public NewGameWithHumanOfflineButton(Container newParent) {
        super(newParent);
        button = new JButton("Play Offline");
    }

    @Override
    public void configureButton() {
        button.setFont(new Font("Arial", Font.PLAIN, 75));

        button.addActionListener(listener -> {
            GameField field = new GameField(3,
                    new GameController(new GameWithHuman(3)));
            field.setVisible(true);
            field.setSize(1200, 600);
            Menu.getMenuFrame().setVisible(false);
        });
    }
}
