package com.tttclient.drawing.models;

import java.awt.*;

public class Zeroes extends Model {
    public Zeroes(int newHeightOfCell, int newWidthOfCell) {
        super(newHeightOfCell, newWidthOfCell);
    }

    @Override
    public void Draw(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        if (widthOfCell > heightOfCell) {
            graphics.drawOval(widthOfCell / 2, heightOfCell / 2, widthOfCell, widthOfCell);
        }
        else {
            graphics.drawOval(widthOfCell / 2, heightOfCell / 2, heightOfCell, heightOfCell);
        }
    }
}
