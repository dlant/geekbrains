package sample;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class Window1 extends Application {


    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Window1.fxml"));
        AnchorPane load = (AnchorPane) loader.load();

        load.setStyle("-fx-background-color: #9999ff;");
        Scene scene = new Scene(load);
        stage.setScene(scene);
        Window1Controller.STAGE=stage;
        stage.setTitle("Window 1");
        stage.show();

    }


    public static void main(String[] args)
    {
        launch(args);
    }
}