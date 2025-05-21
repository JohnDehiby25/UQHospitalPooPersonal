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
import java.time.LocalDateTime;

public class Paciente extends Usuario{
	
	private ArrayList<HistorialMedico> listHistorialMedico;
	private ArrayList<CitaMedica> listCitasMedicas;
	
	public Paciente (String nombre,String id,String correo, String telefono,int edad) {
		
		super(nombre,id,correo,telefono,edad);
		
		this.listCitasMedicas= new ArrayList<>();
		this.listHistorialMedico = new ArrayList<>();
	}
	//Se implementa la interfaz notificable pero es para que el paciente en este caso reciba cualquier novedad desde administrador
	public void notificar(String mensaje) {
		System.out.println("El paciente " + getNombre() + " recibió el mensaje" + mensaje);
	}
	
	@Override
	public void registrarDatosPersonales() {
		System.out.println("\n Registro de datos Paciente");
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
    public ArrayList<CitaMedica> solicitarCitasMedicas(){
		ArrayList<CitaMedica> listaCitasMedicasSolicitadas = new ArrayList<>();
		for(int i=0; i<listCitasMedicas.size();i++) {
			listaCitasMedicasSolicitadas.add(listCitasMedicas.get(i));
		}
		return listaCitasMedicasSolicitadas;
		
	}	
	public ArrayList<CitaMedica> cancelarCitasMedicas(LocalDateTime fechaCitaEliminar){
		for(int i=0;i<listCitasMedicas.size();i++) {
			if(listCitasMedicas.get(i).getHorario().isEqual(fechaCitaEliminar)) {
				listCitasMedicas.remove(i);
			}
		}
		return listCitasMedicas;
		
	}
	
	public ArrayList<CitaMedica> obtenerCitasMedicasNuevas(Administrador admin){
		ArrayList<CitaMedica> listCitasMedicas=new ArrayList<>();
		for(CitaMedica c: admin.getListCitasMedicas()) {
			if(c.getIdPaciente().equals(c.getIdPaciente())) {
				listCitasMedicas.add(c);
			}
		}
		return listCitasMedicas;
	}
	public HistorialMedico consultarHistorialMedico(LocalDateTime fechabuscar){
		for(int i=0; i<listHistorialMedico.size();i++) {
			if(listHistorialMedico.get(i).getFecha().equals(fechabuscar)) {
				return listHistorialMedico.get(i);
			}
		}
		return null;
		
	}
	public void notificarCita(LocalDateTime fechabuscar) {
		for(CitaMedica c:listCitasMedicas) {
			if(c.getHorario().isBefore(fechabuscar)){
				System.out.println("La fecha de su cita medica se esta acercando");
			}
		}
	}
	public ArrayList<HistorialMedico> getListHistorialmedico(){
		return listHistorialMedico;
	}
}