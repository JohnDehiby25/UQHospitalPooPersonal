package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.SceneManager;
import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.Paciente;
import co.edu.uniquindio.poo.utils.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CrudPacienteController {

    @FXML
    private TableColumn<Paciente, String> colCorreo;

    @FXML
    private TableColumn<Paciente, String> colEdad;

    @FXML
    private TableColumn<Paciente, String> colId;

    @FXML
    private TableColumn<Paciente, String> colNombre;

    @FXML
    private TableColumn<Paciente, String> colTelefono;

    @FXML
    private TableView<Paciente> tblPacientes;

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

    private Administrador administrador;

    @FXML
    void actualizarPaciente(ActionEvent event) {
        Paciente paciente = new Paciente("juadssdd", "3sdsd43", "efededed", "23323", 40);

        paciente.setId(txtId.getText());
        paciente.setNombre(txtNombre.getText());
        paciente.setCorreo(txtCorreo.getText());
        paciente.setEdad(Integer.parseInt(txtEdad.getText()));
        paciente.setTelefono(txtTelefono.getText());

        administrador.modificarPaciente(paciente.getId(), paciente);


        limpiarCampos();
        actualizarTabla();
    }
    @FXML
    void eliminarPaciente(ActionEvent event) {
        eliminarPaciente();
    }
    public void eliminarPaciente(){
        Paciente paciente = tblPacientes.getSelectionModel().getSelectedItem();

        administrador.eliminarPaciente(paciente.getId());

        actualizarTabla();
    }
    @FXML
    void regresarMenuPrincipal(ActionEvent event) {
        SceneManager.cambiarEscena(Paths.MENU_PRINCIPAL_VIEW);
    }

    @FXML
    void guardarPaciente(ActionEvent event) {
        guardarPaciente();

    }
    public void guardarPaciente(){

        Paciente paciente = new Paciente("Jorge","23442220","jorgeramirez@gmail.com","3245643202",40);

        paciente.setNombre(txtNombre.getText());
        paciente.setTelefono(txtTelefono.getText());
        paciente.setCorreo(txtCorreo.getText());
        paciente.setId(txtId.getText());
        paciente.setEdad(Integer.parseInt(txtEdad.getText()));

        administrador.registrarpaciente(paciente.getNombre(),paciente.getId(),paciente.getCorreo(),paciente.getTelefono(),paciente.getEdad());

        actualizarTabla();

        limpiarCampos();
        SceneManager.setPacienteController(this);
    }
    private void actualizarTabla(){
        tblPacientes.getItems().clear();
        tblPacientes.getItems().addAll(administrador.getListPacientes());
        tblPacientes.refresh();
    }
    private void limpiarCampos(){

        txtCorreo.setText("");
        txtEdad.setText("");
        txtId.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");

        txtId.setEditable(true);
    }
    

    @FXML
    void initialize(){

        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));

        if(administrador != null) {
        actualizarTabla();
    }

        tblPacientes.setOnMouseClicked(mouseEvent -> {

            if(tblPacientes.getSelectionModel().getSelectedItem() != null) cargarCampos();
        });

    }
    private void cargarCampos(){

        Paciente paciente = tblPacientes.getSelectionModel().getSelectedItem();

        txtCorreo.setText(paciente.getCorreo());
        txtEdad.setText(String.valueOf(paciente.getEdad()));
        txtId.setText(paciente.getId());
        txtNombre.setText(paciente.getNombre());
        txtTelefono.setText(paciente.getTelefono());

        txtId.setEditable(false);
    }
    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

}
