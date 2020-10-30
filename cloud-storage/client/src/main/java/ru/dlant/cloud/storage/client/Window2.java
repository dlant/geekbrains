package ru.dlant.cloud.storage.client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Window2 {

    public Window2() throws Exception
    {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/window2.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/window2.fxml"));

        AnchorPane load = (AnchorPane) loader.load();
        load.setStyle("-fx-background-color: #9999ff;");
        Stage stage = new Stage();
        stage.setTitle("Window 2");
        Scene scene = new Scene(load,800,600);
        stage.setScene(scene);
        stage.show();

//        scene = new Scene(root,800,600);
//        stage.setScene(scene);
//        Controller controller = loader.getController();
//        stage.setOnHidden(e -> controller.shutdown());
//        stage.show();
//        stage.setResizable(true);

    }

}