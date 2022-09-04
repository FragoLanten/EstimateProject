package entry;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    void initialize() {


    }

}