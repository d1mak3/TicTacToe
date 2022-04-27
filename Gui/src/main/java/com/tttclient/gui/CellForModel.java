package com.tttclient.gui;

import com.tttclient.drawing.IModel;

import javax.swing.*;
import java.awt.*;

public class CellForModel extends JPanel {
    IModel model;

    public CellForModel(IModel newModel) {
        model = newModel;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        model.setHeightOfCell(getHeight());
        model.setWidthOfCell(getWidth());
        model.draw(g);
    }
}
