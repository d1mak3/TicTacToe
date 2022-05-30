package com.tttclient.drawing;

import java.awt.*;

public interface IModel {
    void draw(Graphics g);
    void setHeightOfCell(int newHeightOfCell);
    void setWidthOfCell(int newWidthOfCell);
}
