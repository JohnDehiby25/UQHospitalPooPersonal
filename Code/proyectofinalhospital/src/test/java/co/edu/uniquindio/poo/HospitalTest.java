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
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.CitaMedica;

/**
 * Unit test for simple App.
 */
public class HospitalTest {
    private static final Logger LOG = Logger.getLogger(HospitalTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @Test
    public void TestParaValidarTamañoListaCitaMedica() {
        LOG.info("Iniciado test TestParaValidarTamañoListaCitaMedica");
        
        Administrador admin = new Administrador("Parra", "2324-2323", "admingmail.com", "3234242", 23);

        CitaMedica citaMedica = new CitaMedica();

        CitaMedica citaMedica2 = new CitaMedica();

        CitaMedica citaMedica3 = new CitaMedica();

        admin.getListCitasMedicas().add(citaMedica);

        admin.getListCitasMedicas().add(citaMedica2);

        admin.getListCitasMedicas().add(citaMedica3);

        assertEquals(3, admin.getListCitasMedicas().size());

        LOG.info("Finalizando test TestParaValidarTamañoListaCitaMedica");
    }
    @Test
    public void TestParaValidarListasNoVacias() {
        LOG.info("Iniciado test TestParaValidarListasNoVacias");
        
        Administrador admin = new Administrador("Parra", "2324-2323", "admingmail.com", "3234242", 23);

        CitaMedica citaMedica = new CitaMedica();

        CitaMedica citaMedica2 = new CitaMedica();

        CitaMedica citaMedica3 = new CitaMedica();

        admin.getListCitasMedicas().add(citaMedica);

        admin.getListCitasMedicas().add(citaMedica2);

        admin.getListCitasMedicas().add(citaMedica3);

        assertNotNull(admin.getListCitasMedicas());

        LOG.info("Finalizando test TestParaValidarListasNoVacias");
    }
    @Test
    public void TestParaValidarMetodoCambioCitaAdministrador() {
        LOG.info("Iniciado test TestParaValidarMetodoCambioCitaAdministrador");
        
        Administrador admin = new Administrador("Parra", "2324-2323", "admingmail.com", "3234242", 23);

        CitaMedica cita = new CitaMedica(LocalDateTime.of(2025, 12, 5, 6, 30), "Control general", "sala 23 piso 1", "Sara Salazar", "Malestar general y vomito",false, true, "Ana Sofia Perez");

        
        CitaMedica cita2 = new CitaMedica(LocalDateTime.of(2025, 12, 5, 6, 30), "Cita para cirugia", "sala 2 piso 4", "Pedro Palacios", "Cita de control antes de la cirguia esperada",false, false, "Ana Sofia Perez");

        CitaMedica citaMedica3 = new CitaMedica();

        admin.getListCitasMedicas().add(cita);

        admin.getListCitasMedicas().add(cita2);

        admin.getListCitasMedicas().add(citaMedica3);

        boolean resultado = admin.cambioCita(cita2, LocalDateTime.of(2025, 11, 5, 6, 30)) != null;

        assertFalse(resultado, "No debería poder cambiar una cita si la fecha no está en la lista");

        LOG.info("Finalizando test TestParaValidarMetodoCambioCitaAdministrador");
    }

}
