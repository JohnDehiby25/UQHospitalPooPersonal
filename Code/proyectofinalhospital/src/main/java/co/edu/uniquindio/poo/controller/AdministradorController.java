package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.SceneManager;
import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.utils.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
 


public class AdministradorController  {

    @FXML
    private TextArea txtArea;

    private Administrador administrador;

    @FXML
    void registroDatosPersonales(ActionEvent event) {
        
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
    public void initialize() {

    administrador = new Administrador("Sin nombre", "0", "sin@email.com", "0000", 0);

    }

    @FXML
    void onActualizarDatosPersonales(ActionEvent event) {
        actualizarDatos();
    }

    public void actualizarDatos() {
    String nuevoNombre = txtNombre.getText();
    String nuevoId = txtId.getText();
    String nuevoCorreo = txtCorreo.getText();
    String nuevoTelefono = txtTelefono.getText();
    int nuevaEdad = Integer.parseInt(txtEdad.getText());

    String mensaje = administrador.actualizarDatosPersonales(nuevoNombre, nuevoId, nuevoCorreo, nuevoTelefono, nuevaEdad);

    txtArea.setText(mensaje);
    }
    @FXML
    void regresarMenuPrincipal(ActionEvent event) {
        SceneManager.cambiarEscena(Paths.MENU_PRINCIPAL_VIEW);
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    @FXML
    void irInfoAdicionalAdministrador(ActionEvent event) {
        SceneManager.cambiarEscena(Paths.INFO_ADICIONAL_ADMIN);
    }
    @FXML
    void limpiarCampos(ActionEvent event) {
        txtArea.setText("");
        txtCorreo.setText("");
        txtEdad.setText("");
        txtId.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");

    }

}
