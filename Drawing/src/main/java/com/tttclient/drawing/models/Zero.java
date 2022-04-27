package com.tttclient.drawing.models;

import java.awt.*;

public class Zero extends Model {
    @Override
    public void draw(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.setStroke(new BasicStroke(2));
        if (widthOfCell > heightOfCell) {
            graphics.drawOval(0, 0, widthOfCell / 2, widthOfCell / 2);
        }
        else {
            graphics.drawOval(0, 0, heightOfCell / 2, heightOfCell / 2);
        }
    }
}
