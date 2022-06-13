package Comparadores;

import java.util.Comparator;
import Clases.*;

public class ComparadorNombre implements Comparator<Usuario>{
	@Override
	public int compare(Usuario u1, Usuario u2) {
		return (int) (u1.getNombre().compareTo(u2.getNombre()));
	}
}
