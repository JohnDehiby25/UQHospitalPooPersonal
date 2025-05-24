package co.edu.uniquindio.poo.controller;


import java.time.LocalDateTime;

import co.edu.uniquindio.poo.SceneManager;
import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.CitaMedica;
import co.edu.uniquindio.poo.model.HistorialMedico;
import co.edu.uniquindio.poo.model.Paciente;
import co.edu.uniquindio.poo.utils.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

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
    @FXML
    private TextArea txtAreaCancelacion;

    @FXML
    private TextArea txtAreaCitasAct;

    @FXML
    private TextArea txtAreaConsulta;

    @FXML
    private TextArea txtAreaSolicitud;

    @FXML
    void cancelarCitasMedicas(ActionEvent event) {

        CitaMedica CitaMedica = new CitaMedica(LocalDateTime.of(2025, 12, 23, 5, 25), "Optometria", "220", "Jaramillo", "Cambio de gafas", false, true, "232323232");

        CitaMedica CitaMedica2 = new CitaMedica(LocalDateTime.of(2025, 11, 3, 5, 25), "Dentista", "220", "Martinez", "Control brackets", false, true, "453322");

        var paciente = new Paciente("Jonathan", "544323232", "jo@gmail.com", "324433", 22);

        paciente.getListCitasMedicas().add(CitaMedica);
        paciente.getListCitasMedicas().add(CitaMedica2);

        paciente.cancelarCitasMedicas(LocalDateTime.of(2025, 12, 23, 5, 25));

        StringBuilder texto = new StringBuilder();

        texto.append("La citas medicas actuales son: ");

        for(CitaMedica citaMedica: paciente.solicitarCitasMedicas()){
            texto.append(citaMedica.toString());
        }
        txtAreaCancelacion.setText(texto.toString());


    }

    @FXML
    void consultarHistorialMedico(ActionEvent event) {
        HistorialMedico historial = new HistorialMedico(LocalDateTime.of(2025, 10, 31, 7, 10), "Consulta General", 2, "Gripe", "dolor de cabeza", 20, "tomar acetaminofen cada 8 horas", "cada mañana hacerlo hasta que el dolor pase");

        HistorialMedico historial2 = new HistorialMedico(LocalDateTime.of(2022, 4, 30, 7, 10), "Psicologia", 8, "Ansiedad", "estres y peleas familiares", 22, "ir a las citas de psicologia cada semana", "hacer yoga y salir mas a menudo");

        var paciente = new Paciente("Jonathan", "544323232", "jo@gmail.com", "324433", 22);

        paciente.getListHistorialmedico().add(historial);
        paciente.getListHistorialmedico().add(historial2);

       HistorialMedico encontrado = paciente.consultarHistorialMedico(LocalDateTime.of(2025, 10, 31, 7, 10));

        if (encontrado != null) {
            txtAreaConsulta.setText(encontrado.toString()); 
        } else {
            txtAreaConsulta.setText("No se encontró historial médico en esa fecha.");
        }
    }
    @FXML
    void obtenerCitasMedicasActuales(ActionEvent event) {
        CitaMedica CitaMedica = new CitaMedica(LocalDateTime.of(2025, 12, 23, 5, 25), "Optometria", "220", "Jaramillo", "Cambio de gafas", false, true, "232323232");
        CitaMedica CitaMedica2 = new CitaMedica(LocalDateTime.of(2025, 12, 23, 5, 25), "Dentista", "220", "Martinez", "Control brackets", false, true, "453322");
        CitaMedica CitaMedica3 = new CitaMedica(LocalDateTime.of(2024, 12, 23, 5, 25), "Consulta general", "220", "Zapata", "Dolor de espalda", false, true, "453393");

        Administrador admin = new Administrador("Morales", "65432", "morales@hotmail.com", "3054849574", 30);

        admin.getListCitasMedicas().add(CitaMedica);
        admin.getListCitasMedicas().add(CitaMedica2);
        admin.getListCitasMedicas().add(CitaMedica3);

        var paciente = new Paciente("Jonathan", "544323232", "jo@gmail.com", "324433", 22);

        StringBuilder texto = new StringBuilder();

        texto.append("Las citas medicas actuales son: \n");

        for(CitaMedica citaMedica4:paciente.obtenerCitasMedicasNuevas(admin)){
            texto.append(citaMedica4.toString());
            texto.append("\n");
        }

        txtAreaCitasAct.setText(texto.toString());

    }

    @FXML
    void solicitarCitasMedicas(ActionEvent event) {

        CitaMedica CitaMedica = new CitaMedica(LocalDateTime.of(2025, 12, 23, 5, 25), "Optometria", "220", "Jaramillo", "Cambio de gafas", false, true, "232323232");

        CitaMedica CitaMedica2 = new CitaMedica(LocalDateTime.of(2025, 12, 23, 5, 25), "Dentista", "220", "Martinez", "Control brackets", false, true, "453322");

        var paciente = new Paciente("Jonathan", "544323232", "jo@gmail.com", "324433", 22);
        
        paciente.getListCitasMedicas().add(CitaMedica);
        paciente.getListCitasMedicas().add(CitaMedica2);
        
        StringBuilder texto = new StringBuilder();
        texto.append("Las citas médicas del paciente ").append(paciente.getNombre()).append(" son las siguientes:\n");

        for (CitaMedica cita : paciente.solicitarCitasMedicas()) {
            texto.append(cita.toString()).append("\n");
        }

        txtAreaSolicitud.setText(texto.toString());


    }
    
}
