package fxApp;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static fxApp.FxApp.stageMain;

public class PanelController implements Initializable {
    @FXML
    TableView filesTable;

    @FXML
    ComboBox<String> disksBox;

    @FXML
    TextField pathField;
    @FXML
    TextField discSpace;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stageMain.setTitle("Browser Panel");

        TableColumn<FileInfo, String> fileTypeColumn = new TableColumn<>();
        fileTypeColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getType().getName()));
        fileTypeColumn.setPrefWidth(24);

        TableColumn<FileInfo, String> filenameColumn = new TableColumn<>("name");
        filenameColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getFilename()));
        filenameColumn.setPrefWidth(240);

        TableColumn<FileInfo, Long> fileSizeColumn = new TableColumn<>("Size");
        fileSizeColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getSize()));


        fileSizeColumn.setCellFactory(column ->{
            return new TableCell<FileInfo, Long>(){
                @Override
                protected void updateItem(Long item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null|| empty){
                        setText(null);
                        setStyle("");
                    } else{
                        String text = String.format("%,d bytes", item);
                        if(item == -1L){
                            text ="[DIR]";
                        }
                        setText(text);
                    }
                }
            };
        });

        fileSizeColumn.setPrefWidth(120);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        TableColumn<FileInfo, String> fileDateColumn = new TableColumn<>("last modified");
        fileDateColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getLastModified().format(dtf)));
        fileDateColumn.setPrefWidth(120);

        filesTable.getColumns().addAll(fileTypeColumn, filenameColumn, fileSizeColumn,fileDateColumn);
        filesTable.getSortOrder().add(fileTypeColumn);

        disksBox.getItems().clear();
        for(Path p: FileSystems.getDefault().getRootDirectories()){
            disksBox.getItems().add(p.toString());
        }
        disksBox.getSelectionModel().select(0);

        filesTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount()==2){
                    FileInfo fileInfo = (FileInfo) filesTable.getSelectionModel().getSelectedItem();
                    if(fileInfo !=null){
                        Path path = Paths.get(pathField.getText());
                        path= path.resolve(((FileInfo) filesTable.getSelectionModel().getSelectedItem()).getFilename());

                        System.out.println(path);
//                   Path path = Paths.get(pathField.getText()).resolve(filesTable.getSelectionModel().getSelectedItem().toString());
                    if(Files.isDirectory(path)){
                        updateList(path);
                    }
                    }
                }
            }
        });


        updateList(Paths.get("."));
    }

    public void updateList(Path path) {
        try {
            pathField.setText(path.normalize().toAbsolutePath().toString());

            filesTable.getItems().clear();

            filesTable.getItems().addAll(Files.list(path).map(FileInfo::new).collect(Collectors.toList()));
            filesTable.sort();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "не удалось обновить список файлов", ButtonType.OK);
            alert.showAndWait();
        }
    }

    public void btnPathUpAction(ActionEvent actionEvent) {
        Path upperPath = Paths.get(pathField.getText()).getParent();
        if(upperPath !=null){
            updateList(upperPath);
        }
    }

    public void selectDiskAction(ActionEvent actionEvent) {
        ComboBox<String> element = (ComboBox<String>)actionEvent.getSource();
        updateList(Paths.get(element.getSelectionModel().getSelectedItem()));

        File file = new File(String.valueOf(Paths.get(element.getSelectionModel().getSelectedItem())));
        long totalSpace = file.getTotalSpace(); // общее дисковое пространство в байтах.
        long freeSpace = file.getFreeSpace(); // нераспределенное / свободное дисковое пространство в байтах.
        discSpace.setText("Свободное место на диске " + String.valueOf(file.getFreeSpace()/1024/1024 +" mb") +" из "+ String.valueOf(file.getTotalSpace()/1024/1024+ " mb"));
        System.out.println(" === Partition Detail ===");

        System.out.println(" === bytes ===");
        System.out.println("Total size : " + totalSpace + " bytes");
        System.out.println("Space free : " + freeSpace + " bytes");

        System.out.println(" === mega bytes ===");
        System.out.println("Total size : " + totalSpace /1024 /1024 + " mb");
        System.out.println("Space free : " + freeSpace /1024 /1024 + " mb");
    }

    public String getSelectedFilename(){
        if(!filesTable.isFocused()){
            return null;
        }
        return ((FileInfo)filesTable.getSelectionModel().getSelectedItem()).getFilename();
    }

    public String getCurrentPath(){
        return pathField.getText();
    }
}
