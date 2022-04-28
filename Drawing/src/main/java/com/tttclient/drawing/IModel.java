package com.tttclient.drawing;

import java.awt.*;

public interface IModel {
    void draw(Graphics g);
    public void setHeightOfCell(int newHeightOfCell);
    public void setWidthOfCell(int newWidthOfCell);
}
