package Comparadores;

import java.util.Comparator;
import Clases.*;

public class ComparadorNombreUsuario implements Comparator<Empleado>{
	@Override
	public int compare(Empleado e1, Empleado e2) {
		return (int) (e1.getNombreUsuario().compareTo(e2.getNombreUsuario()));
	}
}
