package co.edu.uniquindio.poo.model;
import java.util.ArrayList;
import java.util.Scanner;


public class Paciente extends Usuario{
	
	private ArrayList<HistorialMedico> listHistorialMedico;
	private ArrayList<CitaMedica> listCitasMedicas;
	
	public Paciente (String nombre,String id,String correo, String telefono,int edad) {
		
		super(nombre,id,correo,telefono,edad);
		
		this.listCitasMedicas= new ArrayList<>();
		this.listHistorialMedico = new ArrayList<>();
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
}