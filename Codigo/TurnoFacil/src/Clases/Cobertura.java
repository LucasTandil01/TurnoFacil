package Clases;

public class Cobertura {
	private ObraSocial obraSocial;
	private int porcentaje;
	
	
	public ObraSocial getObrasocial() {
		return obraSocial;
	}
	public void setObrasocial(ObraSocial obraSocial) {
		this.obraSocial = obraSocial;
	}
	public int getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	public Cobertura(ObraSocial obraSocial, int porcentaje) {
		this.obraSocial = obraSocial;
		this.porcentaje = porcentaje;
	}
}
