package com.tttclient.data.savers;

import com.tttclient.data.IData;
import com.tttclient.data.models.GameData;
import com.tttclient.gamelogic.IGame;

import java.io.*;

public class FileDataSaver implements IData {
    private final String dirPath = "./save/";
    private final String filePath = ".save";

    @Override
    public void save(GameData gameData) {
        try {
            createSaveFileIfNotCreated();

            FileOutputStream outputStream = new FileOutputStream(dirPath + filePath);
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
            createSaveFileIfNotCreated();

            File save = new File(dirPath + filePath);
            if (!save.exists()) {
                boolean resultOfCreation = save.createNewFile();
            }

            FileInputStream inputStream = new FileInputStream(dirPath + filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            gameData = (GameData) objectInputStream.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return gameData;
    }

    @Override
    public boolean isSaveEmpty() {
        try {
            File save = new File(dirPath + filePath);
            if (!save.exists()) {
                createSaveFileIfNotCreated();
                return true;
            }

            FileInputStream inputStream = new FileInputStream(dirPath + filePath);
            return inputStream.read() == -1;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void deleteSavedGame(IGame gameToDelete) {
        try {
            new PrintWriter(dirPath + filePath).close(); // Clearing the file
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void createSaveFileIfNotCreated() throws IOException {
        File dir = new File(dirPath);
        File file = new File(dirPath + filePath);
        if (!dir.exists()) {
            boolean resultOfCreation = dir.mkdir();
        }
        if (!file.exists()) {
            boolean resultOfCreation = file.createNewFile();
        }
    }
}
