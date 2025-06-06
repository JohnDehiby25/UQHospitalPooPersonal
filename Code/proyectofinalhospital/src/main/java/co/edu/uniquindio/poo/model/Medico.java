/* 
 * Proyecto final de sistema de gestion de hospital
 * 
 * Integrantes
 * John Dehiby Morales Guzmán
 * Version: 1.0 Abril 2025
 */
package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.time.*;

public class Medico extends Usuario implements HorarioConsulta{
	private ArrayList<Paciente> listPacientes;
	private ArrayList<HistorialMedico> listHistorialMedico;
	private ArrayList<LocalDateTime> listHorariosDisponibles;

	public Medico(String nombre,String id, String correo, String telefono, int edad) {
		
		super(nombre,id,correo,telefono,edad);
		this.listPacientes=new ArrayList<>();
		this.listHistorialMedico= new ArrayList<>();
		this.listHorariosDisponibles=new ArrayList<>();
	}
	@Override
	public String registrarDatosPersonales() {
		return ("\n Registro de datos Administrador \n" +
		"Nombre: " + nombre + "\n Id: " + id + "\n Correo: " + correo + 
		"\n Telefono: " + telefono +
		"\n Edad: " + edad);	
	}
	@Override
	public String actualizarDatosPersonales(String nuevoNombre, String nuevoId, String nuevoCorreo, String nuevoTelefono, int nuevaEdad) {
    setNombre(nuevoNombre);
    setId(nuevoId);
    setCorreo(nuevoCorreo);
    setTelefono(nuevoTelefono);
    setEdad(nuevaEdad);
    return "Datos actualizados correctamente:\n" + registrarDatosPersonales(); 
	}
    @Override
	public void establecerHorarioDisponible(LocalDateTime horario) {
		listHorariosDisponibles.add(horario);
	}

	@Override
	public ArrayList<LocalDateTime> obtenerHorariosDisponibles(){
		return listHorariosDisponibles;
	}
    public HistorialMedico registrarDiagnostico(String idpacientebuscar, String diagnosticonuevo){
		for(Paciente p:listPacientes) {
			if(p.getId().equals(idpacientebuscar)){
				for(HistorialMedico h: p.getListHistorialmedico()) {
					h.setDiagnostico(diagnosticonuevo);
					return h;
				}
			}
		}
		return null;
	}
	public HistorialMedico registrarTratamiento(String idpacientebuscar, String nuevoTratamiento){
		for(Paciente p:listPacientes) {
			if(p.getId().equals(idpacientebuscar)) {
				for(HistorialMedico h: p.getListHistorialmedico()) {
					h.setTratamiento(nuevoTratamiento);
					return h;
				}
			}
		}return null;
	}
	//Se implementa la interfaz notificaciones pero es para que el medico reciba el el mensaje
	@Override
	public String notificar(String mensaje) {
		return "El Medico: " + getNombre() + " recibió el mensaje " + mensaje;
	}
	
	public ArrayList<Paciente> getlistPacientesDisponibles(){
		return listPacientes;
	}
	public ArrayList<HistorialMedico> getListHistorialMedico(){
		return listHistorialMedico;
	}
	
}