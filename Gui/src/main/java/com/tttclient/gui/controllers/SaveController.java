package com.tttclient.gui.controllers;

import com.tttclient.data.IData;
import com.tttclient.data.models.GameData;
import com.tttclient.gamelogic.IGame;

public class SaveController {
    private final IData saver;

    public SaveController(IData newSaver) {
        saver = newSaver;
    }

    public void save(IGame game) {
        GameData gameToSave = new GameData();
        gameToSave.game = game;

        saver.save(gameToSave);
    }

    public IGame getGameData() {
        GameData gameFromSaving = saver.get();
        return gameFromSaving.game;
    }

    public boolean isSaveEmpty() {
        return saver.isSaveEmpty();
    }

    public void deleteSavedGame(IGame gameToDelete) {
        saver.deleteSavedGame(gameToDelete);
    }
}
