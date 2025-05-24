package  co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.SceneManager;
import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.Usuario;
import co.edu.uniquindio.poo.utils.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class InfoAdicionalAdministrador {

    private Administrador administrador;

    private Usuario usuario;

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

        if(usuario != null && administrador != null){
            administrador.notificarUsuario(usuario, mensaje);
            txtAreaNotificaciones.appendText("\nMensaje enviada correctamente");
        }else{
            txtAreaNotificaciones.appendText("\n No hay administrador o usuario definido");
        }

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
        usuario = null;
        administrador = null;

    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    

}

