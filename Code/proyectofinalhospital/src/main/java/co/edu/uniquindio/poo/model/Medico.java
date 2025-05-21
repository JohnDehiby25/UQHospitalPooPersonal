/* 
 * Proyecto final de sistema de gestion de hospital
 * 
 * Integrantes
 * John Dehiby Morales Guzmán
 * Version: 1.0 Abril 2025
 */
package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Scanner;
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
	public void registrarDatosPersonales() {
		System.out.println("\n Registro de datos Medico");
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
	
	public ArrayList<Paciente> getlistPacientesDisponibles(){
		return listPacientes;
	}
	public ArrayList<HistorialMedico> getListHistorialMedico(){
		return listHistorialMedico;
	}
	
}