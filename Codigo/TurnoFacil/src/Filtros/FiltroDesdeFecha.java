package Filtros;

import java.time.LocalDate;

import Clases.Turno;

public class FiltroDesdeFecha extends FiltroTurno{
	private LocalDate fechaIni;

	public FiltroDesdeFecha(LocalDate fi) {
		this.fechaIni = fi;
	}
	
	@Override
	public boolean cumple(Turno t) {
		if(t.getFecha().isAfter(fechaIni)||t.getFecha().isEqual(fechaIni)) {
			return true;
		}
		return false;
	}
}
