/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;
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
}
