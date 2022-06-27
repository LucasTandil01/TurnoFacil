package Filtros;

import Clases.Medico;

public class FiltroAND extends Filtro {
	private Filtro filtro1;
	private Filtro filtro2;
	
	public FiltroAND(Filtro f1, Filtro f2) {
		this.filtro1 = f1;
		this.filtro2 = f2;
	}

	@Override
	public boolean cumple(Medico m) {
		return filtro1.cumple(m) && filtro2.cumple(m);
	}
}
