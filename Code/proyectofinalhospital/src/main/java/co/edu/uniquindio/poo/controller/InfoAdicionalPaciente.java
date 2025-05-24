package co.edu.uniquindio.poo.controller;


import co.edu.uniquindio.poo.SceneManager;
import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.utils.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class InfoAdicionalPaciente {
    private Administrador administrador;
    @FXML
    void regresarPacienteVista(ActionEvent event) {
        SceneManager.cambiarEscena(Paths.PACIENTE_VIEW);

    }
    public Administrador getAdministrador() {
        return administrador;
    }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    
}
