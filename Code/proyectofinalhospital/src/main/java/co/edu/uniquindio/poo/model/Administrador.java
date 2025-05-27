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


public class Administrador extends Usuario {
	private ArrayList<Medico> listMedicos;
	private ArrayList<Paciente> listPacientes;
	private ArrayList<Sala> listSalas;
	private ArrayList<CitaMedica> listCitasMedicas;
	private ArrayList<Usuario> listUsuarios;
	
	public Administrador(String nombre,String id, String correo, String telefono, int edad) {
		super(nombre,id,correo,telefono,edad);
		this.listMedicos=new ArrayList<>();
		this.listPacientes=new ArrayList<>();
		this.listSalas = new ArrayList<>();
		this.listCitasMedicas= new ArrayList<>();
	}
	//Notifica al medico o paciente de cualquier novedad
	public void notificarUsuario(Notificacion usuario,String mensaje) {
		usuario.notificar(mensaje);
	}
    public ArrayList<CitaMedica> reportarCitasMedicasDisponibles(){
		ArrayList<CitaMedica> citasMedicasDisponibles = new ArrayList<>();
		for(CitaMedica c:listCitasMedicas) {
			boolean disponibilidad = true;
			if(c.getDisponibilidad() == disponibilidad) {
				citasMedicasDisponibles.add(c);
			}
		}
		return citasMedicasDisponibles;
	}
	public String reportarOcupacionHospital() {
		StringBuilder reporte = new StringBuilder();
    	boolean hayDisponibles = false;

    for (Sala sala : listSalas) {
        if (sala.getEstado()) {  
            hayDisponibles = true;
            reporte.append("Sala disponible: ")
                   .append(sala.getNumeroSala())
                   .append(" Estado: ").append(sala.getEstado())
                   .append("\n");
        }
    }

    if (hayDisponibles) {
        return "Salas disponibles en el hospital:\n" + reporte.toString();
    } else {
        return "No hay salas disponibles en el hospital.";
    }
		
	}
	public CitaMedica cambioCita(CitaMedica newCita, LocalDateTime horarioBuscar) {
	    for (int i = 0; i < listCitasMedicas.size(); i++) {
	        CitaMedica cita = listCitasMedicas.get(i);
	        if (cita.getHorario().isEqual(horarioBuscar)) {
	            listCitasMedicas.set(i, newCita); 
	            return newCita;
	        }
	    }
	    return null;
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
	//Metodo para cambiar un medico por otro y reemplazarlo
    public boolean modificarMedico(String idmedicoBuscar,Medico newMedico) {
		for(int i=0; i<listMedicos.size();i++) {
			Medico m = listMedicos.get(i);
			if(m.getId().equals(idmedicoBuscar)) {
				listMedicos.set(i, newMedico);
				return true;
			}
		}return false;
		
	}
	//Metodo para cregistrar un medico de acuerdo al id, y hay que agregar una prueba para que la edad no sea negativa
	public boolean registrarmedico(String nombre,String id, String correo, String telefono, int edad){
		if (edad <= 0) {
        return false; 
    	}
		for(Medico m:listMedicos) {
			if(m.getId().equals(id) || m.getEdad()<0) {
				return false;
			}
		}
		Medico medicoNuevo = new Medico(nombre,id,correo,telefono,edad);
		return listMedicos.add(medicoNuevo);
	}
	public boolean eliminarMedico(String idMedicoEliminar) {
		for(int i=0; i<listMedicos.size();i++) {
			if(listMedicos.get(i).getId().equals(idMedicoEliminar)) {
				listMedicos.remove(i);
				return true;
			}
		}
		return false;
	}
	public boolean modificarPaciente(String idPacienteModificar,Paciente newPaciente) {
		for(int i=0; i<listPacientes.size();i++) {
			Paciente paciente= listPacientes.get(i);
			if(paciente.getId().equals(idPacienteModificar)) {
				listPacientes.set(i, newPaciente);
				return true;
			}
		}
		return false;
	}
	public boolean registrarpaciente(String nombre,String id,String correo, String telefono,int edad){
		if (edad <= 0 || nombre == null || nombre.isBlank()) {
        return false;
    }
		for(Paciente m:listPacientes) {
			if(m.getId().equals(id) || m.getEdad()<0) {
				return false;
			}
		}
		Paciente newPaciente = new Paciente(nombre,id,correo,telefono,edad);
		listPacientes.add(newPaciente);
		return true;
	}
	public boolean eliminarPaciente(String idPacienteEliminar) {
		for(int i=0;i<listPacientes.size();i++) {
			if(listPacientes.get(i).getId().equals(idPacienteEliminar)) {
				listPacientes.remove(i);
				return true;
			}
		}return false;
	}
	public ArrayList<Paciente> getListPacientes(){
		return listPacientes;
	}
	public ArrayList<Medico> getListMedicos(){
		return listMedicos;
	}
	public ArrayList<CitaMedica> getListCitasMedicas(){
		return listCitasMedicas;
	}
	public ArrayList<Usuario> getListUsuarios() {
		return listUsuarios;
	}
	public void setListUsuarios(ArrayList<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}
	public ArrayList<Sala> getListSalas() {
		return listSalas;
	}
	public void setListSalas(ArrayList<Sala> listSalas) {
		this.listSalas = listSalas;
	}
	
	
	
}