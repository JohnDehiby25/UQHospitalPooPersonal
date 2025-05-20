package co.edu.uniquindio.poo.controller;

import java.io.IOException;


import co.edu.uniquindio.poo.App;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}