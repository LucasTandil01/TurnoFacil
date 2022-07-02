package Clases;

import java.util.ArrayList;

public class ResponsableInst extends Empleado{
	private TurnoFacil sistema;
	ResponsableInst(TurnoFacil sistema, long dni, String nombre, String apellido, String nombreUsuario, String contrasenia) {
		super(dni, nombre, apellido, nombreUsuario, contrasenia);
		this.sistema = sistema;
	}
	
	public void crearMedicos() {
		ArrayList<ObraSocial> obrasSociales = new ArrayList<ObraSocial>();
		ArrayList<ObraSocial> obrasSociales2 = new ArrayList<ObraSocial>();
		ObraSocial os1 = new ObraSocial("Obra Social");
		ObraSocial os2 = new ObraSocial("Obra Social 2");
		obrasSociales.add(os1);
		obrasSociales2.add(os1);
		obrasSociales.add(os2);
		ArrayList<Integer> dias = new ArrayList<Integer>();
		dias.add(1);
		dias.add(2);
		dias.add(3);
		dias.add(4);
		dias.add(5);
		crearMedico(22555444,"Julian","Alvarez","jAlvarez","123456", 
				new ArrayList<ArrayList<Turno>>(), obrasSociales, "Obstetra", dias, 8, 12);
		dias.remove(4);
		crearMedico(15666777,"Roberto","Lopez","rLopez","1234", 
				new ArrayList<ArrayList<Turno>>(), obrasSociales2, "Cirujano", dias, 10, 16);
	}
	
	public void crearMedico(long dni, String nombre, String apellido, String nombreUsuario, String contrasenia,
			String especialidad) {
		Medico m = new Medico(dni, nombre, apellido, nombreUsuario, contrasenia,especialidad);		
		sistema.addMedico(m);
	}
	
	public void crearMedico(long dni, String nombre, String apellido, String nombreUsuario, String contrasenia,
			ArrayList<ArrayList<Turno>> turnos, ArrayList<ObraSocial> obrasSociales, String especialidad,
			ArrayList<Integer> dias, int horaInicio, int horaFin) {
		Medico m = new Medico(dni, nombre, apellido, nombreUsuario, contrasenia,
								turnos, obrasSociales, especialidad, dias, horaInicio, horaFin);		
		sistema.addMedico(m);
	}
}
