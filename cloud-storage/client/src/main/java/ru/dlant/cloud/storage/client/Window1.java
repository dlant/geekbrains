package ru.dlant.cloud.storage.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Window1 extends Application {

    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/window1.fxml"));
        AnchorPane load = loader.load();

        load.setStyle("-fx-background-color: #9999ff;");
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.setTitle("Window 1");
        Window1Controller.STAGE=stage;
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}