/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.CitaMedica;
import co.edu.uniquindio.poo.model.Medico;
import co.edu.uniquindio.poo.model.Paciente;
import co.edu.uniquindio.poo.model.Sala;
import co.edu.uniquindio.poo.model.TipoSala;

/**
 * Unit test for simple App.
 */
public class AdministradorTest {
    private static final Logger LOG = Logger.getLogger(AdministradorTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    private Administrador admin;

    @BeforeEach
    public void setUp() {
        admin = new Administrador("Carlos", "1", "carlos@admin.com", "123456789", 40);
    }

    @Test
    public void testRegistrarMedicoValido() {
        boolean registrado = admin.registrarmedico("Juan", "123", "juan@correo.com", "11111", 35);
        assertTrue(registrado);
        assertEquals(1, admin.getListMedicos().size());
        assertEquals("Juan", admin.getListMedicos().get(0).getNombre());
    }

    @Test
    public void testRegistrarMedicoEdadNegativa() {
        boolean registrado = admin.registrarmedico("Ana", "124", "ana@correo.com", "22222", -5);
        assertFalse(registrado);
        assertEquals(0, admin.getListMedicos().size());
    }

    @Test
    public void testModificarMedico() {
        admin.registrarmedico("Pedro", "123", "pedro@correo.com", "33333", 40);
        Medico nuevo = new Medico("Carlos", "123", "carlos@correo.com", "44444", 45);
        boolean modificado = admin.modificarMedico("123", nuevo);
        assertTrue(modificado);
        assertEquals("Carlos", admin.getListMedicos().get(0).getNombre());
    }

    @Test
    public void testModificarMedicoInexistente() {
        Medico nuevo = new Medico("Carlos", "999", "carlos@correo.com", "44444", 45);
        boolean modificado = admin.modificarMedico("999", nuevo);
        assertFalse(modificado);
    }

    @Test
    public void testEliminarMedico() {
        admin.registrarmedico("Laura", "321", "laura@correo.com", "55555", 32);
        boolean eliminado = admin.eliminarMedico("321");
        assertTrue(eliminado);
        assertEquals(0, admin.getListMedicos().size());
    }

    @Test
    public void testEliminarMedicoInexistente() {
        boolean eliminado = admin.eliminarMedico("000");
        assertFalse(eliminado);
    }

    @Test
    public void testRegistrarPacienteValido() {
        boolean registrado = admin.registrarpaciente("Mario", "P1", "mario@correo.com", "99999", 25);
        assertTrue(registrado);
        assertEquals(1, admin.getListPacientes().size());
        assertEquals("Mario", admin.getListPacientes().get(0).getNombre());
    }

    @Test
    public void testRegistrarPacienteEdadCero() {
        boolean registrado = admin.registrarpaciente("Lina", "P2", "lina@correo.com", "88888", 0);
        assertFalse(registrado);
        assertEquals(0, admin.getListPacientes().size());
    }

    @Test
    public void testModificarPaciente() {
        admin.registrarpaciente("Andrés", "P1", "andres@correo.com", "77777", 30);
        Paciente nuevo = new Paciente("Camilo", "P1", "camilo@correo.com", "66666", 31);
        boolean modificado = admin.modificarPaciente("P1", nuevo);
        assertTrue(modificado);
        assertEquals("Camilo", admin.getListPacientes().get(0).getNombre());
    }

    @Test
    public void testModificarPacienteInexistente() {
        Paciente nuevo = new Paciente("Camilo", "PX", "camilo@correo.com", "66666", 31);
        boolean modificado = admin.modificarPaciente("PX", nuevo);
        assertFalse(modificado);
    }

    @Test
    public void testEliminarPaciente() {
        admin.registrarpaciente("Julia", "P1", "julia@correo.com", "12345", 20);
        boolean eliminado = admin.eliminarPaciente("P1");
        assertTrue(eliminado);
        assertEquals(0, admin.getListPacientes().size());
    }

    @Test
    public void testEliminarPacienteInexistente() {
        boolean eliminado = admin.eliminarPaciente("XYZ");
        assertFalse(eliminado);
    }

    @Test
    public void testReportarOcupacionConSalaDisponible() {
        Sala salaDisponible = new Sala(1, true, TipoSala.PACIENTESGENERAL);
        admin.getListSalas().add(salaDisponible);
        String reporte = admin.reportarOcupacionHospital();
        assertTrue(reporte.contains("Salas disponibles"));
    }

    @Test
    public void testReportarOcupacionSinSalasDisponibles() {
        Sala salaOcupada = new Sala(1, false, TipoSala.PACIENTESPRIORITARIOS);
        admin.getListSalas().add(salaOcupada);
        String reporte = admin.reportarOcupacionHospital();
        assertTrue(reporte.contains("No hay salas disponibles"));
    }

    @Test
    public void testCambioCitaMedica() {
        LocalDateTime horario = LocalDateTime.of(2025, 5, 28, 10, 0);
        CitaMedica original = new CitaMedica(horario, "Pediatría", "Sala 1", "Dr. López", "Dolor de cabeza", false, true, "P123");
        admin.getListCitasMedicas().add(original);

        CitaMedica nueva = new CitaMedica(horario, "Pediatría", "Sala 1", "Dr. López", "Dolor de cabeza", false, false, "P123");
        CitaMedica resultado = admin.cambioCita(nueva, horario);

        assertNotNull(resultado);
        assertFalse(admin.getListCitasMedicas().get(0).getDisponibilidad());
    }

    @Test
    public void testCambioCitaInexistente() {
        LocalDateTime horario = LocalDateTime.of(2025, 6, 1, 9, 0);
        CitaMedica nueva = new CitaMedica(horario, "Medicina General", "Sala 2", "Dra. Pérez", "Chequeo general", false, false, "P456");
        CitaMedica resultado = admin.cambioCita(nueva, horario);
        assertNull(resultado);
    }

}
