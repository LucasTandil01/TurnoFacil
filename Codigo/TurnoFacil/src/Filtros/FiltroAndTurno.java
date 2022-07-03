package Filtros;
import Clases.Turno;

public class FiltroAndTurno extends FiltroTurno{
	private FiltroTurno filtro1;
	private FiltroTurno filtro2;
	
	public FiltroAndTurno(FiltroTurno f1, FiltroTurno f2) {
		this.filtro1 = f1;
		this.filtro2 = f2;
	}

	public boolean cumple(Turno t) {
		return filtro1.cumple(t) && filtro2.cumple(t);
	}
}
