package Filtros;

import Clases.Medico;

public class FiltroOS extends Filtro{
	private String obraSocial;

	public FiltroOS(String os) {
		super();
		this.obraSocial = os;
	
	}

	@Override
	public boolean cumple(Medico m) {
		return m.getObrasSociales().contains(obraSocial);
	}
}
