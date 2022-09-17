package entry;

import java.io.File;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class SmetaController {

    Smeta smeta = new Smeta();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button calculate_costs_button;

    @FXML
    private MenuItem exit_button;

    @FXML
    private MenuItem load_button;

    @FXML
    private MenuItem save_as_button;

    @FXML
    private MenuItem save_button;

    @FXML
    private TextField text_air_duct;

    @FXML
    private TextField text_electric_cable;

    @FXML
    private TextField text_from_home_to_septik;

    @FXML
    private TextField text_from_septik_to_trench;

    @FXML
    private TextField total_costs;

    @FXML
    void initialize() {


    }

    public void handleCalculateButton(ActionEvent actionEvent) {

        smeta.lengthFromHomeToSeptik = Integer.parseInt(text_from_home_to_septik.getText());
        smeta.priceFromHomeToSeptik = smeta.lengthFromHomeToSeptik*1700;

        smeta.lengthFromSeptikToTrench = Integer.parseInt(text_from_septik_to_trench.getText());
        smeta.priceFromSeptikToTrench = smeta.lengthFromSeptikToTrench*1700;

        smeta.lengthAirDuct = Integer.parseInt(text_air_duct.getText());
        smeta.priceAirDuct = smeta.lengthAirDuct*100;

        smeta.lengthElectricCable = Integer.parseInt(text_electric_cable.getText());
        smeta.priceElectricCable = smeta.lengthElectricCable*570;

        smeta.totalCosts = smeta.priceFromHomeToSeptik + smeta.priceFromSeptikToTrench
                + smeta.priceAirDuct + smeta.priceElectricCable;

        total_costs.setText(Integer.toString(smeta.totalCosts));
    }

    public void handleSaveAsButton(ActionEvent actionEvent) throws JAXBException {
        Stage stage = (Stage) calculate_costs_button.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        smeta.fileSource = fileChooser.showSaveDialog(stage);

        JAXBContext context = JAXBContext.newInstance(Smeta.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(smeta, smeta.fileSource);

    }

    public void handleSaveButton(ActionEvent actionEvent) throws JAXBException {
        if (smeta.fileSource==null) {
            Stage stage = (Stage) calculate_costs_button.getScene().getWindow();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialFileName("smeta.xml");
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("XML files", "*.xml")
            );
            smeta.fileSource = fileChooser.showSaveDialog(stage);

            JAXBContext context = JAXBContext.newInstance(Smeta.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(smeta, smeta.fileSource);
        }
        else {
            JAXBContext context = JAXBContext.newInstance(Smeta.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(smeta, smeta.fileSource);
        }
    }

    public void handleLoadButton(ActionEvent actionEvent) {
    }

    public void handleExitButton(ActionEvent actionEvent) {
        Stage stage = (Stage) calculate_costs_button.getScene().getWindow();
        stage.close();
    }
}
