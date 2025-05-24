/* 
 * Proyecto final de sistema de gestion de hospital
 * 
 * Integrantes
 * John Dehiby Morales Guzmán
 * Version: 1.0 Abril 2025
 */
package co.edu.uniquindio.poo.model;

import java.time.LocalDateTime;

public class CitaMedica {
	private LocalDateTime horario;
	private String especialidad;
	private String sala;
	private String medico;
	private String motivoConsulta;
	private boolean atendida;
	private boolean disponibilidad;
	private String idPaciente;
	
	
	public CitaMedica(LocalDateTime horario,String especialidad,String sala,String medico,String motivoConsulta,boolean atendida,boolean disponibilidad,String idPaciente) {
		this.horario=horario;
		this.especialidad=especialidad;
		this.sala=sala;
		this.medico=medico;
		this.motivoConsulta=motivoConsulta;
		this.atendida=atendida;
		this.disponibilidad=disponibilidad;
		this.idPaciente=idPaciente;
	}
	public void setHorario(LocalDateTime horario) {
		this.horario=horario;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad=especialidad;
	}
	public void setSala(String sala) {
		this.sala=sala;
	}
	public void setMedico(String medico) {
		this.medico=medico;
	}
	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta=motivoConsulta;
	}
	public void setAtendida(boolean atendida) {
		this.atendida=atendida;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad=disponibilidad;
	}
	public LocalDateTime getHorario() {
		return horario;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public String getSala() {
		return sala;
	}
	public String getMedico() {
		return medico;
	}
	public String getMotivoConsulta() {
		return motivoConsulta;
	}
	public boolean getAtendida() {
		return atendida;
	}
	public boolean getDisponibilidad() {
		return disponibilidad;
	}
	public String getIdPaciente() {
		return idPaciente;
	}
	@Override
	public String toString() {
    return "Fecha: " + horario +
           ", Especialidad: " + especialidad +
           ", Médico: " + medico +
           ", Motivo Consulta: " + motivoConsulta +
           ", Paciente: " + idPaciente;
	}
	
	
	

}