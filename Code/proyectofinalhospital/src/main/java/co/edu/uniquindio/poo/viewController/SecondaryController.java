package co.edu.uniquindio.poo.viewController;

import java.io.IOException;
import javafx.fxml.FXML;
import scala.App;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}