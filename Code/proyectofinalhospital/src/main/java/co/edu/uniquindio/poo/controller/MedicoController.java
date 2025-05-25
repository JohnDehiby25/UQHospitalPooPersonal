package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.SceneManager;
import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.utils.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MedicoController {

    private Administrador administrador;
    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    void actualizarInformacion(ActionEvent event) {
        actualizarInformacion();
    }
    public void actualizarInformacion(){
        String nombre = txtNombre.getText();
        String id = txtId.getText();
        String correo = txtCorreo.getText();
        String telefono = txtTelefono.getText();
        int edad = Integer.parseInt(txtEdad.getText());

        administrador.setNombre(nombre);
        administrador.setId(id);
        administrador.setCorreo(correo);
        administrador.setTelefono(telefono);
        administrador.setEdad(edad);

        txtArea.setText(administrador.registrarDatosPersonales());

    }
    @FXML
    public void initialize() {

    administrador = new Administrador("Sin nombre", "0", "sin@email.com", "0000", 0);

    }

    @FXML
    void registrarInfo(ActionEvent event) {
        registrarInfo();

    }
    public void registrarInfo(){
        
        String nombre = txtNombre.getText();
        String id = txtId.getText();
        String correo = txtCorreo.getText();
        String telefono = txtTelefono.getText();
        int edad = Integer.parseInt(txtEdad.getText());

        administrador.setNombre(nombre);
        administrador.setId(id);
        administrador.setCorreo(correo);
        administrador.setTelefono(telefono);
        administrador.setEdad(edad);

        txtArea.setText(administrador.registrarDatosPersonales());

    }

    @FXML
    void regresarVentanaPrincipal(ActionEvent event) {
        regresarVentanaPrincipal();
    }
    public void regresarVentanaPrincipal(){
        SceneManager.cambiarEscena(Paths.MENU_PRINCIPAL_VIEW);

    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    @FXML
    void InfoAdicionalMedico(ActionEvent event) {
        SceneManager.cambiarEscena(Paths.INFO_ADICIONAL_MEDICO);
    }
    

}
