package ru.dlant.cloud.storage.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static ru.dlant.cloud.storage.client.FxApp.stageMain;

public class FXMLForm1Controller implements Initializable {

    @FXML
    private TextField textFieldName;

    @FXML
    // Кнопка вперед
    private void sendAuth(ActionEvent event) throws IOException {
//        namePerson = textFieldName.getText(); // Считывания из поля значения в общую переменную
        stageMain.setScene(new SceneBuilder().getScene("/main.fxml")); // Переход на второе окно
    }

    @FXML
    // Кнопка выхода
    private void doExit(ActionEvent event) {
        stageMain.close(); // Закрытие программы
    }

    @Override
    public void initialize(URL url, ResourceBundle resources) {stageMain.setTitle("Login Panel");
    }

}
