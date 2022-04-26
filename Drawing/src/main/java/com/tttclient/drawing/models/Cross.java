package com.tttclient.drawing.models;

import java.awt.*;

public class Cross extends Model {
    public Cross(int newHeightOfCell, int newWidthOfCell) {
        super(newHeightOfCell, newWidthOfCell);
    }

    @Override
    public void Draw(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;

        graphics.drawLine(0, 0, widthOfCell, heightOfCell);
        graphics.drawLine(widthOfCell, 0, 0, heightOfCell);
    }
}
