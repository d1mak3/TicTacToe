package com.tttclient.gui;

import com.tttclient.data.savers.FileDataSaver;
import com.tttclient.drawing.models.Cross;
import com.tttclient.drawing.models.Zero;
import com.tttclient.gamelogic.LogicModel;

import com.tttclient.gui.buttons.FieldButton;
import com.tttclient.gui.controllers.GameController;
import com.tttclient.gui.controllers.SaveController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameField extends JFrame {
    LogicModel[][] field;
    GameController gameController;
    JPanel grid = new JPanel();

    public GameField(int fieldSize, GameController newGameController) {
        gameController = newGameController;
        field = gameController.getField();
        grid.setLayout(new GridLayout(fieldSize, fieldSize, 1, 1));
        configure();
        drawField();
    }

    public void setField(LogicModel[][] newField) {
        field = newField;
    }

    public void drawField() {
        int fieldSize = field[0].length;

        for (int i = 0; i < fieldSize; ++i) {
            for (int j = 0; j < fieldSize; ++j) {
                if (field[i][j] == LogicModel.NULL) {
                    FieldButton newButton = new FieldButton(grid, i, j, gameController, this);
                    newButton.configureButton();
                    grid.add(newButton.createButton());
                }
                else {
                    CellForModel cell;
                    if (field[i][j] == LogicModel.CROSS) {
                        cell = new CellForModel(new Cross());
                    } else {
                        cell = new CellForModel(new Zero());
                    }
                    grid.add(cell);
                }
            }
        }

        add(grid);
    }

    public void resetField(LogicModel[][] newField) {
        setField(newField);
        clearField();
        drawField();
    }

    public void clearField() {
        Menu.clearFrame(grid);
    }

    private void configure() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);

                SaveController saveController = new SaveController(new FileDataSaver());
                saveController.save(gameController.getGame());

                Menu.getMenuFrame().setVisible(true);
            }
        });
    }
}
