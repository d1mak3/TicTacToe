package com.tttclient.drawing.models;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Zero extends Model {
    @Override
    public void draw(Graphics g) {
        try {
            Image image = ImageIO.read(new File("./resources/Zero.png"));
            image = image.getScaledInstance(widthOfCell, heightOfCell, Image.SCALE_SMOOTH);
            g.drawImage(image, 0, 0, null);
        }
        catch (Exception e) {

        }
    }
}
