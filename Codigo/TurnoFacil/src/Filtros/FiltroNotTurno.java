package Filtros;

import Clases.Turno;

public class FiltroNotTurno extends FiltroTurno{
private FiltroTurno f;
	public FiltroNotTurno(FiltroTurno f) {
		this.f = f;
	}
	@Override
	public boolean cumple(Turno t) {		
		return !f.cumple(t);
	}

}