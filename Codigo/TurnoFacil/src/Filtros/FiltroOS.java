package Filtros;

import Clases.Medico;
import Clases.ObraSocial;

public class FiltroOS extends FiltroMedico{
	private ObraSocial obraSocial;

	public FiltroOS(ObraSocial os) {
		super();
		this.obraSocial = os;	
	}
	
	private boolean contiene(Medico m) {
		for(ObraSocial o:m.getObrasSociales()){
			String o2 = o.getNombre(); 
			if(o2.toLowerCase().contains(obraSocial.getNombre().toLowerCase()))
				return true;	
		}
		return false;
	}

	@Override
	public boolean cumple(Medico m) {
		return obraSocial.getNombre().equals("")||contiene(m);
	}
}
