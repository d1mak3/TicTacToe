package com.tttclient.data.savers;

import com.tttclient.data.IData;
import com.tttclient.data.models.GameData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileDataSaver implements IData {
    private final String path = "save/.saving";

    @Override
    public void save(GameData gameData) {
        try {
            FileOutputStream outputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(gameData);
            objectOutputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public GameData get() {
        GameData gameData = null;

        try {
            FileInputStream inputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            gameData = (GameData) objectInputStream.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return gameData;
    }
}
