package com.tttclient.gui;

import com.tttclient.gui.buttons.NewGameButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    JFrame menuFrame = new JFrame("TicTacToe");

    public static void clearFrame(Container container) {
        // Clear the window
        container.removeAll();
        container.revalidate();
        container.repaint();
    }

    public Menu() {
        configureMenu();
    }

    private void configureMenu() {
        JPanel grid = new JPanel();
        List<IButton> buttons = new ArrayList<>();

        buttons.add(new NewGameButton(grid));

        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout gridLayout = new GridLayout(buttons.size(), 1);
        grid.setLayout(gridLayout);

        for (IButton button : buttons) {
            button.configureButton();
            grid.add(button.createButton());
        }

        menuFrame.add(grid);
        menuFrame.setSize(1280, 600);
        menuFrame.setVisible(true);
    }
}
