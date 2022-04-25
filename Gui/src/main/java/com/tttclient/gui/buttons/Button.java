package com.tttclient.gui.buttons;

import com.tttclient.gui.IButton;

import javax.swing.JButton;

import java.awt.Container;

public abstract class Button implements IButton {
    JButton button;
    Container parent;

    public Button(Container newParent) {
        parent = newParent;
    }

    @Override
    public JButton createButton() {
        return button;
    }
}
