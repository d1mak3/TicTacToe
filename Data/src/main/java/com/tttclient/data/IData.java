package com.tttclient.data;

import com.tttclient.data.models.GameData;
import com.tttclient.gamelogic.IGame;

public interface IData {
    void save(GameData gameData);
    GameData get();
    boolean isSaveEmpty();
    void deleteSavedGame(IGame game);
}
