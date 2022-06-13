package Clases;

import java.util.ArrayList;

public class Secretaria extends Empleado{
	private ArrayList<Medico> medicos;
	private ArrayList<Turno> informe;
	
	public Secretaria(long dni, String nombre, String apellido, String nombreUsuario, String contrasenia,
			ArrayList<Medico> medicos, ArrayList<Turno> informe) {
		super(dni, nombre, apellido, nombreUsuario, contrasenia);
		this.medicos = medicos;
		this.informe = informe;
	}

	public ArrayList<Medico> getMedicos() {
		return new ArrayList<Medico>(medicos);
	}
	public void setMedicos(ArrayList<Medico> medicos) {
		this.medicos = medicos;
	}
	public ArrayList<Turno> getInforme() {
		return new ArrayList<Turno>(informe);
	}
	public void setInforme(ArrayList<Turno> informe) {
		this.informe = informe;	
	}	
}
