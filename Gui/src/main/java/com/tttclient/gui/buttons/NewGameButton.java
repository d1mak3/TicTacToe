package com.tttclient.gui.buttons;

import com.tttclient.gui.IButton;
import com.tttclient.gui.Menu;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Font;

import java.util.ArrayList;
import java.util.List;

public class NewGameButton extends Button {
    public NewGameButton(Container newParent) {
        super(newParent);
        button = new JButton("New Game");
    }

    @Override
    public void configureButton() {
        button.setFont(new Font("Arial", Font.PLAIN, 75));

        button.addActionListener(listener -> {
            List<IButton> buttons = new ArrayList<>();

            buttons.add(new NewGameWithHumanButton(parent));
            buttons.add(new NewGameWithBotButton(parent));

            Menu.clearFrame(parent);

            JPanel grid = new JPanel();
            GridLayout gridLayout = new GridLayout(buttons.size(), 0);
            grid.setLayout(gridLayout);

            for (IButton button : buttons) {
                button.configureButton();
                grid.add(button.createButton());
            }

            parent.add(grid);
        });
    }
}
