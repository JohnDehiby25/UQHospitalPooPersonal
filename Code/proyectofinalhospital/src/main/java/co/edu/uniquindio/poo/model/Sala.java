package co.edu.uniquindio.poo.model;

public class Sala {
	private int numeroSala;
	private boolean estado;
	private TipoSala tipoSala;
	
	public Sala(int numeroSala,boolean estado, TipoSala tipoSala) {
		this.numeroSala=numeroSala;
		this.estado=estado;
		this.tipoSala=tipoSala;
		
	}
	public void setNumeroSala(int numeroSala) {
		this.numeroSala=numeroSala;
	}
	public void setEstado(boolean estado) {
		this.estado=estado;
	}
	public void setTipoSala(TipoSala tipoSala) {
		this.tipoSala=tipoSala;
	}
	public int getNumeroSala() {
		return numeroSala;
	}
	public boolean getEstado() {
		return estado;
	}
	public TipoSala tipoSala() {
		return tipoSala;
	}
	

}