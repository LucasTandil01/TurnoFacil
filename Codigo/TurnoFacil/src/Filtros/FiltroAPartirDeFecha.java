package Filtros;

import java.time.LocalDate;

import Clases.Turno;

public class FiltroAPartirDeFecha extends FiltroTurno{
	private LocalDate fechaIni;

	public FiltroAPartirDeFecha(LocalDate fi) {
		this.fechaIni = fi;
	}
	
	@Override
	public boolean cumple(Turno t) {
		if(t.getFecha().isAfter(fechaIni)) {
			return true;
		}
		return false;
	}
}
