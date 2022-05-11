package com.tttclient.gui;

import com.tttclient.gui.buttons.ContinueGameButton;
import com.tttclient.gui.buttons.NewGameButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static JFrame menuFrame;

    public static void clearFrame(Container container) {
        // Clear the container
        container.removeAll();
        container.revalidate();
        container.repaint();
    }

    public static JFrame getMenuFrame() {
        return menuFrame;
    }

    public static void configureMenu() {
        menuFrame = new JFrame("TicTacToe");
        JPanel grid = new JPanel();
        List<IButton> buttons = new ArrayList<>();

        buttons.add(new NewGameButton(menuFrame.getContentPane())); // TODO: Rework buttons to use MenuFrame instead of grid and set new grid all the time
        buttons.add(new ContinueGameButton(menuFrame.getContentPane()));

        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout gridLayout = new GridLayout(buttons.size(), 1);
        grid.setLayout(gridLayout);

        for (IButton button : buttons) {
            button.configureButton();
            grid.add(button.createButton());
        }

        menuFrame.add(grid);
        menuFrame.setSize(1200, 600);
        menuFrame.setVisible(true);
    }
}
