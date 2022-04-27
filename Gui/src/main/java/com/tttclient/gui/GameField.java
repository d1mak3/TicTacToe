<<<<<<< HEAD
package com.tttclient.gui;

import com.tttclient.drawing.models.Cross;
import com.tttclient.drawing.models.Zero;
import com.tttclient.gamelogic.LogicModel;

import com.tttclient.gui.buttons.FieldButton;

import javax.swing.*;
import java.awt.*;

public class GameField extends JFrame {
    LogicModel[][] field;
    GameController game;
    JPanel grid = new JPanel();

    public GameField(int fieldSize, GameController newGame) {
        field = new LogicModel[fieldSize][fieldSize];
        game = newGame;
        grid.setLayout(new GridLayout(fieldSize, fieldSize, 1, 1));

        configure();

        // Fill the field with NULLs
        for (int i = 0; i < fieldSize; ++i) {
            for (int j = 0; j < fieldSize; ++j) {
                field[i][j] = LogicModel.NULL;
            }
        }

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
                    FieldButton newButton = new FieldButton(grid, i, j, this, game);
                    newButton.configureButton();
                    grid.add(newButton.createButton());
                }
                else {
                    CellForModel cell;
                    if (field[i][j] == LogicModel.CROSS) {
                        cell = new CellForModel(new Cross());
                    }
                    else {
                        cell = new CellForModel(new Zero());
                    }
                    grid.add(cell);
                }
            }
        }

        add(grid);
    }

    public void clearField() {
        Menu.clearFrame(grid);
    }

    private void configure() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
=======
package com.tttclient.gui;public class GameField {
>>>>>>> drawing
}
