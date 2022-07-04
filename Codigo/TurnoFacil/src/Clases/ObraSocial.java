package Clases;

public class ObraSocial {
	private String nombre;	
	//No implemento calculador porque tomo 1 solo metodo de calcular diferencial
	
	public ObraSocial(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
