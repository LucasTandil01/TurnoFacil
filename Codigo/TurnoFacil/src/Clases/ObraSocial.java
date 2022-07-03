package Clases;

public class ObraSocial {
	private String nombre;
	private boolean cumple;
	private double diferencial; // porcentaje
	//No implemento calculador porque tomo 1 solo metodo de calcular diferencial
	
	public ObraSocial(String nombre) {
		this.nombre = nombre;
		diferencial = 0;
	}
	
	public ObraSocial(String nombre, double diferencial) {
		this.nombre = nombre;
		this.diferencial = diferencial;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isCumple() {
		return cumple;
	}

	public void setCumple(boolean cumple) {
		this.cumple = cumple;
	}

	public double getDiferencial() {
		return diferencial;
	}

	public void setDiferencial(double diferencial) {
		this.diferencial = diferencial;
	}

}
