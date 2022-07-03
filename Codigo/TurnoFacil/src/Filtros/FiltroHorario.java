package Filtros;

import Clases.Turno;

public class FiltroHorario extends FiltroTurno {

	 public FiltroHorario() {
    }

    public boolean cumple(Turno t) {

        return t.getHora()<12;
    }
}
