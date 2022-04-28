package com.tttclient.drawing.models;

import java.awt.*;

public class Cross extends Model {
    @Override
    public void draw(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;

        graphics.setColor(Color.BLACK);
        graphics.setStroke(new BasicStroke(2));
        graphics.drawLine(0, 0, widthOfCell / 2, heightOfCell / 2);
        graphics.drawLine(widthOfCell / 2, 0, 0, heightOfCell / 2);
    }
}
