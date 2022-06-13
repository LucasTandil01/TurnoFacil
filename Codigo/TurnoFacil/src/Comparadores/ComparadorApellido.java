package Comparadores;

import java.util.Comparator;
import Clases.*;

public class ComparadorApellido implements Comparator<Usuario>{
	@Override
	public int compare(Usuario u1, Usuario u2) {
		return (int) (u1.getApellido().compareTo(u2.getApellido()));
	}
}
