package ru.dlant.cloud.storage.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.dlant.cloud.storage.common.FileInfo;
import ru.dlant.cloud.storage.common.Sender;


import java.net.URL;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;

import static ru.dlant.cloud.storage.client.FxApp.stageMain;


public class Window1Controller implements Initializable {
    public @FXML
    TextField loginField;
    public @FXML
    PasswordField passField;
    public Button button;
    @FXML
    public static Stage STAGE;
    public @FXML
    VBox authPanel;
    @FXML
    TableView<FileInfo> clientFilesTable;
    @FXML
    TableView<FileInfo> serverFilesTable;

    @FXML
    TextField serverPathField;
    @FXML
    TextField clientPathField;

    private Label clientsFileLabel;
    private Label serversFileLabel;
    private Path filePath;

    private List<Callback> callbackList;
    private Callback goToWindow2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        GUIHelper.serverFilesList = new ArrayList<>();
        callbackList = new ArrayList<>();
        Callback authOkCallback = goToWindow2;
        callbackList.add(authOkCallback);
        CountDownLatch networkStarter = new CountDownLatch(1);
        new Thread(() -> Network.getInstance().startNetwork(networkStarter, callbackList)).start();
        try {
            networkStarter.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

//    public void sendAuth(ActionEvent actionEvent)  {
//        try {
//            STAGE.close();
////            authPanel.setVisible(false);
//            new Window2();
//
////            button.getScene().getWindow().hide();
//
//
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    public @FXML
    void sendAuth() {
//        String login = loginField.getText();
//        String password = passField.getText();
        String login = "l1";
        String password = "p1";
        GUIHelper.currentServerPath = Paths.get(login);
        GUIHelper.currentClientPath = Paths.get("client", login);
        Sender.sendAuthInfo(Network.getInstance().getCurrentChannel(), login, password);
//        try {
//            STAGE.close();
////            authPanel.setVisible(false);
//            new Window2();
//
////            button.getScene().getWindow().hide();
//
//
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
    }


    public void goToWindow2 (ActionEvent actionEvent) {
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

