package Clases;

public class ObraSocial {
      private String nombre;
      private double diferencial;
     // private Calculador

	
    public ObraSocial(String nom) {
    	this.nombre = nom;
    }   
    
    public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
      
	public boolean cobraDiferencial() {
		// hacer
		return false;
	}
	
	public double getDiferencial() {
		return diferencial;
	}
}
