package com.tttclient.gui.buttons;

import com.tttclient.gamelogic.LogicModel;
import com.tttclient.gui.controllers.GameController;
import com.tttclient.gui.GameField;
import com.tttclient.gui.Menu;

import javax.swing.*;
import java.awt.*;

public class FieldButton extends Button {
    private final int x, y;
    private final GameController game;
    private final GameField field;

    public FieldButton(Container newParent, int newX, int newY, GameController newGame, GameField newField) {
        super(newParent);
        x = newX;
        y = newY;
        button = new JButton();
        game = newGame;
        field = newField;
    }

    @Override
    public void configureButton() {
        button.setBorder(BorderFactory.createLineBorder(Color.black));

        button.addActionListener(listener -> {
            game.place(x, y);
            field.resetField(game.getField());

            if (game.checkWin() != LogicModel.NULL) {
                Menu.configureMenu();
                field.dispose();
            }
        });
    }
}
