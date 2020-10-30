package ru.dlant.cloud.storage.client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * КЛАСС СОЗДАНИЯ "СЦЕНЫ"
 */
public class SceneBuilder {

    /**
     * Получение объекта сцены
     * @param num Номер окна, шаблон "FXMLForm*"
     * @return сцена
     * @throws IOException
     */
    public Scene getScene(String num) throws IOException {
        return new Scene(FXMLLoader.load(getClass().getResource(num)));
    }
}