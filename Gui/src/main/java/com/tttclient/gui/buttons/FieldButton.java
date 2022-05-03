package com.tttclient.gui.buttons;

import com.tttclient.gamelogic.Winner;
import com.tttclient.gui.GameController;
import com.tttclient.gui.GameField;
import com.tttclient.gui.Menu;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class FieldButton extends Button {
    int x, y;
    GameController game;
    GameField field;

    public FieldButton(Container newParent, int newX, int newY, GameField newField, GameController gameController) {
        super(newParent);
        x = newX;
        y = newY;
        button = new JButton();
        game = gameController;
        field = newField;
    }

    @Override
    public void configureButton() {
        button.setBorder(BorderFactory.createLineBorder(Color.black));

        button.addActionListener(listener -> {
            field.setField(game.place(x, y));
            field.clearField();
            field.drawField();

            Winner winnerOfTheGame = game.checkWin();
            if (winnerOfTheGame != Winner.NOBODY) {
                String winnerTitle = winnerOfTheGame.name();
                winnerTitle = winnerTitle.toLowerCase();
                winnerTitle = winnerTitle.replace(winnerTitle.charAt(0), winnerTitle.toUpperCase().charAt(0)) + "es";

                JOptionPane.showMessageDialog(null, winnerTitle + " have won");
                Menu.configureMenu();
                field.dispose();
            }
        });
    }
}
