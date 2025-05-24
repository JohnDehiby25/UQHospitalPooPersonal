/* 
 * Proyecto final de sistema de gestion de hospital
 * 
 * Integrantes
 * John Dehiby Morales Guzmán
 * Version: 1.0 Abril 2025
 */
package co.edu.uniquindio.poo.model;

import java.time.LocalDateTime;

public class HistorialMedico {
	private LocalDateTime fecha;
	private String estado;
	private int numeroMedicamentos;
	private String enfermedad;
	private String antecedentes;
	private int edad;
	private String diagnostico;
	private String tratamiento;
	
	public HistorialMedico(LocalDateTime fecha,String estado,int numeroMedicamentos,String enfermedad,String antecedentes, int edad, String diagnostico,String tratamiento) {
		
		this.fecha=fecha;
		this.estado=estado;
		this.numeroMedicamentos=numeroMedicamentos;
		this.enfermedad=enfermedad;
		this.antecedentes=antecedentes;
		this.edad=edad;
		this.diagnostico=diagnostico;
		this.tratamiento=tratamiento;
		
		
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha=fecha;
	}
	public void setEstado(String estado) {
		this.estado=estado;
	}
	public void setNumeroMedicamentos(int numeroMedicamentos) {
		this.numeroMedicamentos=numeroMedicamentos;
	}
	public void setEnfermedad(String enfermedad) {
		this.enfermedad=enfermedad;
	}
	public void setAntecedentes(String antecedentes) {
		this.antecedentes=antecedentes;
	}
	public void setEdad(int edad) {
		this.edad=edad;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico=diagnostico;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento=tratamiento;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public String getEstado() {
		return estado;
	}
	public int getNumeroMedicamentos() {
		return numeroMedicamentos;
	}
	public String getEnfermedad() {
		return enfermedad;
	}
	public String getAntecedentes() {
		return antecedentes;
	}
	public int getEdad() {
		return edad;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	@Override
	public String toString() {
		return "Fecha: " + fecha +
			", Estado: " + estado +
			", Numero de medicamentos: " + numeroMedicamentos +
			", Enfermedad: " + enfermedad +
			", Antecedentes: " + antecedentes +
			", Edad: " + edad +
			", Diagnostico: " + diagnostico +
			", Tratamiento: " + tratamiento + "\n";
	}
	
}