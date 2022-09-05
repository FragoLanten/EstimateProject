package entry;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button create_button;

    @FXML
    private Button edit_button;

    @FXML
    private Button exit_button;

    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) exit_button.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void handleCreateSmetaAction(ActionEvent event) throws IOException {
        System.out.println("new stage");
        Parent smeta_parent = FXMLLoader.load(getClass().getResource("/entry/Smeta.fxml"));
        Scene smeta_scene = new Scene(smeta_parent);
        Stage smeta_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        smeta_stage.hide();
        smeta_stage.setScene(smeta_scene);
        smeta_stage.show();
    }

    @FXML
    void initialize() {
//        create_button.setOnAction(event -> {
//            create_button.getScene().getWindow().hide();
//
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("/entry/total.fxml"));
//            try {
//                loader.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();
//
//        });

    }

}