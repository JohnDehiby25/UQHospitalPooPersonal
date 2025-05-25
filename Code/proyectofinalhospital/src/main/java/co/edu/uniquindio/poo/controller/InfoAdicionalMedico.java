package co.edu.uniquindio.poo.controller;

import java.time.LocalDateTime;

import co.edu.uniquindio.poo.SceneManager;
import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.HistorialMedico;
import co.edu.uniquindio.poo.model.Medico;
import co.edu.uniquindio.poo.model.Paciente;
import co.edu.uniquindio.poo.utils.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class InfoAdicionalMedico {
    private Administrador administrador;
    @FXML
    private TextArea txtAreaDiagnostico;

    @FXML
    private TextArea txtAreaTratamiento;

    @FXML
    void regresarVistamedico(ActionEvent event) {
        SceneManager.cambiarEscena(Paths.MEDICO_VIEW);
    }
    public Administrador getAdministrador() {
        return administrador;
    }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    @FXML
    void registrarDiagnostico(ActionEvent event) {

    Paciente paciente = new Paciente("Pacho", "3222322", "pachogmail.com", "324543222", 34);
    
    Medico medico = new Medico("Andres", "7854822", "andres@gmail.com", "342222", 45);
    
    String nuevoDiagnostico = "Se recomienda ir a la clinica por un cambio de medicamentos";

    medico.registrarDiagnostico(paciente.getId(), nuevoDiagnostico);
    
    HistorialMedico historial = new HistorialMedico(
        LocalDateTime.now(), 
        "Consulta General", 
        2, 
        "Gripe", 
        "dolor de cabeza", 
        20, 
        "tomar acetaminofen cada 8 horas", 
        nuevoDiagnostico 
    );
    
    paciente.getListHistorialmedico().add(historial);
    StringBuilder texto = new StringBuilder();
    texto.append("El nuevo diagnostico del doctor " + medico.getNombre() + " es: \n");
    
    texto.append(nuevoDiagnostico).append("\n");
    
    txtAreaDiagnostico.setText(texto.toString());
}
    @FXML
    void registrarTratamiento(ActionEvent event) {
        
    Paciente paciente = new Paciente("Pacho", "3222322", "pachogmail.com", "324543222", 34);
    
    Medico medico = new Medico("Andres", "7854822", "andres@gmail.com", "342222", 45);
    
    String nuevoDiagnostico = "Se debe bajar la cafeína";

    medico.registrarTratamiento(paciente.getId(), nuevoDiagnostico);
    
    HistorialMedico historial = new HistorialMedico(
        LocalDateTime.now(), 
        "Consulta General", 
        2, 
        "Gripe", 
        "dolor de cabeza", 
        20, 
        "tomar acetaminofen cada 8 horas", 
        nuevoDiagnostico 
    );
    
    paciente.getListHistorialmedico().add(historial);
    StringBuilder texto = new StringBuilder();
    texto.append("El nuevo diagnostico del doctor " + medico.getNombre() + " es: \n");
    
    texto.append(nuevoDiagnostico).append("\n");
    
    txtAreaTratamiento.setText(texto.toString());


    }
}
