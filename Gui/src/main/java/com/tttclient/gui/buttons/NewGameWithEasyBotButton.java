package com.tttclient.gui.buttons;

import com.tttclient.gui.GameController;
import com.tttclient.gui.GameField;

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
            //GameField field = new GameField(3, )
        });
    }
}
