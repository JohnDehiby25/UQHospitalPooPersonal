package  co.edu.uniquindio.poo.controller;


import co.edu.uniquindio.poo.SceneManager;
import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.Paciente;
import co.edu.uniquindio.poo.utils.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class InfoAdicionalAdministrador {

    private Administrador administrador;

    private Paciente paciente;

    @FXML
    private TextArea txtAreaCambioCitas;

    @FXML
    private TextArea txtAreaNotificaciones;

    @FXML
    private TextArea txtAreaReporteCitasMedicas;

    @FXML
    private TextArea txtAreaReporteOcupacionHospital;

    @FXML
    void cambiarCitas(ActionEvent event) {

    }

    @FXML
    void limpiarCampos(ActionEvent event) {

    }

    @FXML
    void notificarUsuario(ActionEvent event) {
        String mensaje = txtAreaNotificaciones.getText();
        
        Administrador admin = new Administrador("Admin", "001", "admin@hospital.com", "555-0001", 40);
        admin.notificarUsuario(paciente, mensaje);
        
        txtAreaNotificaciones.setText(" Mensaje enviado a " + paciente.getNombre() + ":\n" + mensaje);
    }


    @FXML
    void regresarVentanaPrincipal(ActionEvent event) {
        SceneManager.cambiarEscena(Paths.ADMINISTRADOR_VIEW);
    }

    @FXML
    void reportarCitas(ActionEvent event) {

    }

    @FXML
    void reportarOcupacion(ActionEvent event) {

    }
    @FXML
    void initialize(){
      paciente = new Paciente("Juan Pérez", "12345", "juan@email.com", "555-1234", 30);

    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    

}

