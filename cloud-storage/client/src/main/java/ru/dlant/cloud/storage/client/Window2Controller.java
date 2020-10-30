package ru.dlant.cloud.storage.client;

import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Window2Controller implements Window22Controller {
    public Button button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void closeWindow2(javafx.event.ActionEvent actionEvent) {
        try {
            new Window1();

            button.getScene().getWindow().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    }

