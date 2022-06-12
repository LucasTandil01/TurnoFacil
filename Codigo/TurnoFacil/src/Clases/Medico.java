package Clases;

import java.util.ArrayList;

public class Medico extends Empleado{
	private ArrayList<ArrayList<Turno>> turnos;
	private ArrayList<String> obrasSociales;
	private String especialidad;
	private ArrayList<Integer> dias;
	private int horaInicio;
	private int horaFin;
	
	public Medico(long dni, String nombre, String apellido, String nombreUsuario, String contrasenia,String especialidad) {
		super(dni, nombre, apellido, nombreUsuario, contrasenia);
		this.especialidad = especialidad;
	}	
	public Medico(long dni, String nombre, String apellido, String nombreUsuario, String contrasenia,
			ArrayList<ArrayList<Turno>> turnos, ArrayList<String> obrasSociales, String especialidad,
			ArrayList<Integer> dias, int horaInicio, int horaFin) {
		super(dni, nombre, apellido, nombreUsuario, contrasenia);
		this.turnos = turnos;
		this.obrasSociales = obrasSociales;
		this.especialidad = especialidad;
		this.dias = dias;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}	
}
