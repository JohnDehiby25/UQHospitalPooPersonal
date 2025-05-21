package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.SceneManager;
import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.Medico;
import co.edu.uniquindio.poo.utils.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CrudMedicoController {

    @FXML
    private TableColumn<Medico, String> colCorreo;

    @FXML
    private TableColumn<Medico, Integer> colEdad;

    @FXML
    private TableColumn<Medico, String> colId;

    @FXML
    private TableColumn<Medico, String> colNombre;

    @FXML
    private TableColumn<Medico, String> colTelefono;

    @FXML
    private TableView<Medico> tblMedicos;

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
    void actualizarMedico(ActionEvent event) {

        Medico medico = new Medico("juan", "343", "efedede", "23323", 43);

        medico.setId(txtId.getText());
        medico.setNombre(txtNombre.getText());
        medico.setCorreo(txtCorreo.getText());
        medico.setEdad(Integer.parseInt(txtEdad.getText()));
        medico.setTelefono(txtTelefono.getText());

        administrador.modificarMedico(medico.getId(), medico);


        limpiarCampos();
        actualizarTabla();


    }

    @FXML
    void eliminarMedico(ActionEvent event) {
        eliminarMedico();

    }
    public void eliminarMedico(){
        Medico medico = tblMedicos.getSelectionModel().getSelectedItem();

        administrador.eliminarMedico(medico.getId());

        actualizarTabla();
    }

    @FXML
    void guardarMedico(ActionEvent event) {

        guardarMedico();

    }

    public void guardarMedico(){

        Medico medico = new Medico("Jorge","23442220","jorgeramirez@gmail.com","3245643202",40);

        medico.setNombre(txtNombre.getText());
        medico.setTelefono(txtTelefono.getText());
        medico.setCorreo(txtCorreo.getText());
        medico.setId(txtId.getText());
        medico.setEdad(Integer.parseInt(txtEdad.getText()));

        administrador.registrarmedico(medico.getNombre(),medico.getId(),medico.getCorreo(),medico.getTelefono(),medico.getEdad());

        actualizarTabla();

        limpiarCampos();
    }

    private void actualizarTabla(){
        tblMedicos.getItems().clear();
        tblMedicos.getItems().addAll(administrador.getListMedicos());
        tblMedicos.refresh();

        

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

        tblMedicos.setOnMouseClicked(mouseEvent -> {

            if(tblMedicos.getSelectionModel().getSelectedItem() != null) cargarCampos();
        });

    }
     @FXML
    void cambiarMenuPrincipal(ActionEvent event) {
        SceneManager.cambiarEscena(Paths.MENU_PRINCIPAL_VIEW);

    }
    private void cargarCampos(){

        Medico medico = tblMedicos.getSelectionModel().getSelectedItem();

        txtCorreo.setText(medico.getCorreo());
        txtEdad.setText(String.valueOf(medico.getEdad()));
        txtId.setText(medico.getId());
        txtNombre.setText(medico.getNombre());
        txtTelefono.setText(medico.getTelefono());

        txtId.setEditable(false);
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    
}
