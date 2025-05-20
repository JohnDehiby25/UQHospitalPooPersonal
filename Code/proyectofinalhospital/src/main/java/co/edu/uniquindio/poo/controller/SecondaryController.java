package co.edu.uniquindio.poo.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import co.edu.uniquindio.poo.App; 

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}