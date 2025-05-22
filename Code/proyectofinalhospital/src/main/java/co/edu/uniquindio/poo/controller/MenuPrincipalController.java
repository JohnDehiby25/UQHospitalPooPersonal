package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.SceneManager;
import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.utils.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuPrincipalController {
    private Administrador administrador;
    
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    @FXML
    void cambiarEscena(ActionEvent event) {
        SceneManager.cambiarEscena(Paths.GESTIONAR_MEDICOS_VIEW);
    }
    @FXML
    void cambiarEscenaPacientesCrud(ActionEvent event) {
        SceneManager.cambiarEscena(Paths.GESTIONAR_PACIENTES_VIEW);

    }
}
