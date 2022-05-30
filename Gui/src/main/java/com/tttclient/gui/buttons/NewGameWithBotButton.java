package com.tttclient.gui.buttons;

import com.tttclient.gui.IButton;
import com.tttclient.gui.Menu;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NewGameWithBotButton extends Button {
    public NewGameWithBotButton(Container newParent) {
        super(newParent);
        button = new JButton("Play with bot");
    }

    @Override
    public void configureButton() {
        button.setFont(new Font("Arial", Font.PLAIN, 75));

        button.addActionListener(e -> {
            List<IButton> buttons = new ArrayList<>();

            buttons.add(new NewGameWithEasyBotButton(parent));
            buttons.add(new NewGameWithMediumBotButton(parent));
            buttons.add(new NewGameWithHardBotButton(parent));

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
