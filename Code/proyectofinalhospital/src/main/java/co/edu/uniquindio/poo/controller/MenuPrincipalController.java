package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.SceneManager;
import co.edu.uniquindio.poo.utils.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuPrincipalController {
    
    @FXML
    void cambiarEscena(ActionEvent event) {
        SceneManager.cambiarEscena(Paths.GESTIONAR_MEDICOS_VIEW);

    }
}
