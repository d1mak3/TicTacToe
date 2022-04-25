package com.tttclient.gui.buttons;

import com.tttclient.gui.IButton;
import com.tttclient.gui.Menu;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Font;

import java.util.ArrayList;
import java.util.List;

public class NewGameWithHumanButton extends Button {
    public NewGameWithHumanButton(Container newParent) {
        super(newParent);
        button = new JButton("Play with another player");
    }

    @Override
    public void configureButton() {
        button.setFont(new Font("Arial", Font.PLAIN, 75));

        button.addActionListener(listener -> {
            List<IButton> buttons = new ArrayList<>();

            buttons.add(new NewGameWithHumanOfflineButton(parent));

            Menu.clearFrame(parent);

            JPanel grid = new JPanel();
            GridLayout gridLayout = new GridLayout(buttons.size() + 1, 0);
            grid.setLayout(gridLayout);

            for (IButton button : buttons) {
                button.configureButton();
                grid.add(button.createButton());
            }

            JLabel announcementLabel = new JLabel("More game modes are in development");
            announcementLabel.setFont(new Font("Arial", Font.PLAIN, 60));
            announcementLabel.setHorizontalAlignment(SwingConstants.CENTER);
            grid.add(announcementLabel);

            parent.add(grid);
        });
    }
}
