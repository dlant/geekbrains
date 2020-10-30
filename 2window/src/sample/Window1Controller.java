package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URL;
import java.util.ResourceBundle;

public class Window1Controller implements Initializable {

    @FXML
    public static Stage STAGE;

    public @FXML
    VBox authPanel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void sendAuth(ActionEvent actionEvent) {
        try {
              STAGE.close();
//            authPanel.setVisible(false);
            new Window2();

//            button.getScene().getWindow().hide();


        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

