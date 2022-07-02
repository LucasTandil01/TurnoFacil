package Filtros;

import java.time.LocalDate;

import Clases.Turno;

public class FiltroEntreFechas extends FiltroTurno{
	private LocalDate fechaIni;
	private LocalDate fechaFin;

	public FiltroEntreFechas(LocalDate fi, LocalDate ff) {
		this.fechaIni = fi;
		this.fechaFin = ff;
	}
	
	@Override
	public boolean cumple(Turno t) {
		if(t.getFecha().isAfter(fechaIni)) {
			if( t.getFecha().isBefore(fechaFin)){
				return true;
			}
		}
		return false;
	}
}
