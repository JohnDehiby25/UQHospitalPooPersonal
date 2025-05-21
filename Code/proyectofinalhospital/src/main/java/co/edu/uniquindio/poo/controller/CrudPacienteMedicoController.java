package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.Medico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CrudPacienteMedicoController {

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

    }

    @FXML
    void eliminarMedico(ActionEvent event) {

    }

    @FXML
    void guardarMedico(ActionEvent event) {

        Medico medico = new Medico("Jorge","23442220","jorgeramirez@gmail.com","3245643202",40);

        medico.setNombre(txtNombre.getText());
        medico.setTelefono(txtTelefono.getText());
        medico.setCorreo(txtCorreo.getText());
        medico.setId(txtId.getText());
        medico.setEdad(Integer.parseInt(txtEdad.getText()));

        administrador.registrarmedico(medico.getNombre(),medico.getId(),medico.getCorreo(),medico.getTelefono(),medico.getEdad());

        actualizarTabla();
    }

    private void actualizarTabla(){
        tblMedicos.getItems().clear();
        tblMedicos.getItems().addAll(administrador.getListMedicos());
        tblMedicos.refresh();

    }
    @FXML
    void initialize(){

    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    
}
