package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Window2Controller  {
    public Button button;

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//    }

    public void closeWindow2(javafx.event.ActionEvent actionEvent) {
        try {
            new Window1();

            Stage stage = (Stage) button.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    }

