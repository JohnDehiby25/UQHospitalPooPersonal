package  co.edu.uniquindio.poo.controller;


import java.time.LocalDateTime;

import co.edu.uniquindio.poo.SceneManager;
import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.CitaMedica;
import co.edu.uniquindio.poo.model.Paciente;
import co.edu.uniquindio.poo.model.Sala;
import co.edu.uniquindio.poo.model.TipoSala;
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

        CitaMedica cita = new CitaMedica(LocalDateTime.of(2025, 12, 5, 6, 30), "Control general", "sala 23 piso 1", "Sara Salazar", "Malestar general y vomito",false, true, "Ana Sofia Perez");

        CitaMedica cita2= new CitaMedica(LocalDateTime.of(2025, 12, 5, 6, 30), "Control general", "sala 23 piso 1", "Andres López", "Malestar general y vomito",false, true, "Ana Sofia Perez");

        administrador.getListCitasMedicas().add(cita);
        administrador.getListCitasMedicas().add(cita2);

        txtAreaCambioCitas.setText("La cita nueva del paciente " + cita2.getIdPaciente() + " es " + administrador.cambioCita(cita, LocalDateTime.of(2025, 12, 5, 6, 30)));

    }

    @FXML
    void limpiarCampos(ActionEvent event) {

    }

    @FXML
    void notificarUsuario(ActionEvent event) {
        String mensaje = txtAreaNotificaciones.getText();

        Administrador admin = new Administrador("Admin", "12232", "admin@gmail.com", "555-0001", 34);
        admin.notificarUsuario(paciente, mensaje);
        
        txtAreaNotificaciones.setText("Notificacion enviada a: " + paciente.getNombre() + "\n" +"Id:" + paciente.getId() + ":\n" + "Mensaje enviado: " + mensaje);
    }


    @FXML
    void regresarVentanaPrincipal(ActionEvent event) {
        SceneManager.cambiarEscena(Paths.ADMINISTRADOR_VIEW);
    }

    @FXML
    void reportarCitas(ActionEvent event) {

        CitaMedica cita = new CitaMedica(LocalDateTime.of(2025, 12, 5, 6, 30), "Control general", "sala 23 piso 1", "Sara Salazar", "Malestar general y vomito",false, true, "Ana Sofia Perez");

        CitaMedica cita2 = new CitaMedica(LocalDateTime.of(2025, 12, 5, 6, 30), "Cita para cirugia", "sala 2 piso 4", "Pedro Palacios", "Cita de control antes de la cirguia esperada",false, false, "Ana Sofia Perez");

        administrador.getListCitasMedicas().add(cita);
        administrador.getListCitasMedicas().add(cita2);
        
        String texto = "Citas médicas disponibles:\n\n";
        for (CitaMedica c : administrador.reportarCitasMedicasDisponibles()) {
            texto += "Horario: " + c.getHorario() + "\n";
            texto += "Especialidad: " + c.getEspecialidad() + "\n";
            texto += "Sala: " + c.getSala() + "\n";
            texto += "Médico: " + c.getMedico() + "\n";
            texto += "Paciente id: " + c.getIdPaciente() + "\n";
            texto += "--------------------------\n";
    }

    txtAreaReporteCitasMedicas.setText(texto);
    }

    @FXML
    void reportarOcupacion(ActionEvent event) {

        //txtReportarOcupacionHospital

        Sala sala1 = new Sala(21, false, TipoSala.PACIENTESGENERAL);
        Sala sala2 = new Sala(3, true, TipoSala.PACIENTESPRIORITARIOS);
        Sala sala3 = new Sala(4, true, TipoSala.PACIENTESGENERAL);

        administrador.getListSalas().add(sala1);
        administrador.getListSalas().add(sala2);
        administrador.getListSalas().add(sala3);

        String texto=administrador.reportarOcupacionHospital();

        txtAreaReporteOcupacionHospital.setText(texto);


    }
    @FXML
    void initialize(){
      paciente = new Paciente("Juan Pérez", "12345", "juan@email.com", "555-1234", 30);
      txtAreaReporteCitasMedicas.setEditable(false);

    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    

}

