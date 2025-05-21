package co.edu.uniquindio.poo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface HorarioConsulta {
	
	void establecerHorarioDisponible(LocalDateTime horario);
	ArrayList<LocalDateTime> obtenerHorariosDisponibles();


}