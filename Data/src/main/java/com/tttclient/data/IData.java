package com.tttclient.data;

import com.tttclient.data.models.GameData;

public interface IData {
    void save(GameData gameData);
    GameData get();
}
