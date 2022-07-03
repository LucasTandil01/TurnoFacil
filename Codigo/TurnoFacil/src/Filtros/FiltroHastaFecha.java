package Filtros;

import java.time.LocalDate;

import Clases.Turno;

public class FiltroHastaFecha extends FiltroTurno{
	private LocalDate fechaIni;

	public FiltroHastaFecha(LocalDate fi) {
		this.fechaIni = fi;
	}
	
	@Override
	public boolean cumple(Turno t) {
		if(t.getFecha().isBefore(fechaIni)||t.getFecha().isEqual(fechaIni)) {
			return true;
		}
		return false;
	}
}