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
import java.util.Scanner;

public class Administrador extends Usuario {
	private ArrayList<Medico> listMedicos;
	private ArrayList<Paciente> listPacientes;
	private ArrayList<Sala> listSalas;
	private ArrayList<CitaMedica> listCitasMedicas;
	
	public Administrador(String nombre,String id, String correo, String telefono, int edad) {
		super(nombre,id,correo,telefono,edad);
		this.listMedicos=new ArrayList<>();
		this.listPacientes=new ArrayList<>();
		this.listSalas = new ArrayList<>();
		this.listCitasMedicas= new ArrayList<>();
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
	public void reportarOcupacionHospital() {
		boolean hayDisponibles = false;
		for(Sala s: listSalas) {
			if(s.getEstado()) {
				hayDisponibles = true;
				break;
			}
		}
		if(hayDisponibles) {
			System.out.println("La ocupacion del hospital esta disponible en algunas salas");
		}else {
			System.out.print("No hay salas disponibles en el hospital");
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
	public void registrarDatosPersonales() {
		System.out.println("\n Registro de datos Administrador");
		System.out.println("Nombre: " + nombre);
		System.out.println("Id: " + id);
		System.out.println("Correo: " + correo);
		System.out.println("Telefono: " + telefono);
		System.out.println("Edad: " + edad);


		
	}
	@Override
	public void actualizarDatosPersonales() {
		Scanner actualizacionDatos = new Scanner(System.in);
		
		System.out.println("Actualice su nombre:");
		setNombre(actualizacionDatos.nextLine());
		
		System.out.println("Actualice su id:");
		setId(actualizacionDatos.nextLine());
		
		System.out.println("Actualice su correo:");
		setCorreo(actualizacionDatos.nextLine());
		
		System.out.println("Actualice su telefono:");
		setTelefono(actualizacionDatos.nextLine());
		
		System.out.println("Actualice su edad:");
		setEdad(actualizacionDatos.nextInt());
		
		actualizacionDatos.nextLine();
		System.out.println("Sus datos fueron actualizados correctamente");
		
		actualizacionDatos.close();
	}
    public boolean modificarMedico(String idmedicoBuscar,Medico newMedico) {
		for(int i=0; i<listMedicos.size();i++) {
			Medico m = listMedicos.get(i);
			if(m.getId().equals(idmedicoBuscar)) {
				listMedicos.set(i, newMedico);
				return true;
			}
		}return false;
		
	}
	public boolean registrarmedico(String nombre,String id, String correo, String telefono, int edad){
		for(Medico m:listMedicos) {
			if(m.getId().equals(id)) {
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
			}
		}
		return true;
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
		
		for(Paciente m:listPacientes) {
			if(m.getId().equals(id)) {
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
			}
		}return true;
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
}