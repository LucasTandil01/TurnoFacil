package Filtros;

import Clases.Medico;

public class FiltroOS extends Filtro{
	private String obraSocial;

	public FiltroOS(String os) {
		super();
		this.obraSocial = os;	
	}
	
	private boolean contiene(Medico m) {
		for(String o:m.getObrasSociales()) {
			if(o.toLowerCase().contains(obraSocial.toLowerCase()))
				return true;	
		}
		return false;
	}

	@Override
	public boolean cumple(Medico m) {
		return obraSocial.equals("")||contiene(m);
	}
}
