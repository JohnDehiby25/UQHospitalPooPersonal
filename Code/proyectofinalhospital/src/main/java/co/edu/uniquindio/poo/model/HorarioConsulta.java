/* 
 * Proyecto final de sistema de gestion de hospital
 * 
 * Integrantes
 * John Dehiby Morales Guzmán
 * Version: 1.0 Abril 2025
 */
package co.edu.uniquindio.poo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface HorarioConsulta {
	
	void establecerHorarioDisponible(LocalDateTime horario);
	ArrayList<LocalDateTime> obtenerHorariosDisponibles();


}