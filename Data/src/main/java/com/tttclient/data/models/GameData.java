package com.tttclient.data.models;

import com.tttclient.gamelogic.IGame;

import java.io.Serializable;

public class GameData implements Serializable {
    public IGame game;
    public Class<IGame> gameType;
}
