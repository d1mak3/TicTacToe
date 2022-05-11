package com.tttclient.gui.buttons;

import com.tttclient.data.savers.FileDataSaver;
import com.tttclient.gui.GameField;
import com.tttclient.gui.Menu;
import com.tttclient.gui.controllers.GameController;
import com.tttclient.gui.controllers.SaveController;

import javax.swing.*;
import java.awt.*;

public class ContinueGameButton extends Button {
    public ContinueGameButton(Container newParent) {
        super(newParent);
        button = new JButton("Continue Game");
    }

    @Override
    public void configureButton() {
        SaveController saveController = new SaveController(new FileDataSaver());

        button.setFont(new Font("Arial", Font.PLAIN, 75));

        button.addActionListener(listener -> {
            if (saveController.isSaveEmpty()) {
                JOptionPane.showMessageDialog(null, "There is no saved game");
                return;
            }

            Menu.getMenuFrame().setVisible(false);
            GameField field = new GameField(3, new GameController(saveController.getGameData()));
            field.setVisible(true);
            field.setSize(1200, 600);
            parent.setVisible(false); // Set Menu visibility to false
            saveController.deleteSavedGame(saveController.getGameData());
        });
    }
}
