package Filtros;

import Clases.Medico;

public class FiltroEspecialidad  extends Filtro{
	private String especialidad;

	public FiltroEspecialidad(String especialidad) {
		super();
		this.especialidad = especialidad;
	}
	
	@Override 
	public boolean cumple(Medico m) {
		return m.getEspecialidad().equalsIgnoreCase(especialidad);
	}
	
}
