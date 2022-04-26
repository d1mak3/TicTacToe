package com.tttclient.drawing.models;

import com.tttclient.drawing.IModel;

public abstract class Model implements IModel {
    int heightOfCell, widthOfCell;

    public Model(int newHeightOfCell, int newWidthOfCell) {
        heightOfCell = newHeightOfCell;
        widthOfCell = newWidthOfCell;
    }

    public void setHeightOfCell(int newHeightOfCell) {
        heightOfCell = newHeightOfCell;
    }

    public void setWidthOfCell(int newWidthOfCell) {
        widthOfCell = newWidthOfCell;
    }
}
