package ru.dlant.cloud.storage.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Scene scene;


    @Override
    public void start(Stage stage) {

        try {
            stage.setTitle("Cloud Storage");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));

            Parent root;
            root = loader.load();
            root.setStyle("-fx-background-color: #9999ff;");

            scene = new Scene(root,800,600);
            stage.setScene(scene);
            Controller controller = loader.getController();
            stage.setOnHidden(e -> controller.shutdown());
            stage.show();
            stage.setResizable(false);
        } catch (IOException e) {
            GUIHelper.showError(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
    }
