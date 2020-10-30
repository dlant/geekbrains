package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Window2 {

    public Window2() throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Window2.fxml"));

        AnchorPane load = (AnchorPane) loader.load();
        Stage stage = new Stage();
        stage.setTitle("Window 2");
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
    }
}