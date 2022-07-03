package Filtros;

import Clases.Medico;

public class FiltroAndMedico extends FiltroMedico {
	private FiltroMedico filtro1;
	private FiltroMedico filtro2;
	
	public FiltroAndMedico(FiltroMedico f1, FiltroMedico f2) {
		this.filtro1 = f1;
		this.filtro2 = f2;
	}

	@Override
	public boolean cumple(Medico m) {
		return filtro1.cumple(m) && filtro2.cumple(m);
	}
}
