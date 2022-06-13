package Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

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
		turnos = new ArrayList<ArrayList<Turno>>();
		generarTurnos();
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
		generarTurnos();
	}	
	
	public ArrayList<ArrayList<Turno>> getTurnos(){	return new ArrayList<ArrayList<Turno>>(turnos);}
	
	public void generarTurnos() {
		ArrayList<Turno> turnosDia = new ArrayList<Turno>();
		Turno t1 = new Turno("09:00", LocalDate.of(2022, 6, 14), this, new Paciente(), 30);
		Turno t2 = new Turno("11:00", LocalDate.of(2022, 6, 14), this, new Paciente(), 30);
		Turno t3 = new Turno("14:00", LocalDate.of(2022, 6, 14), this, new Paciente(), 30);
		Turno t4 = new Turno("10:00", LocalDate.of(2022, 6, 14), this, new Paciente(), 30);
		Turno t5 = new Turno("13:00", LocalDate.of(2022, 6, 14), this, new Paciente(), 30);
		Turno t6 = new Turno("12:00", LocalDate.of(2022, 6, 14), this, new Paciente(), 30);
		turnosDia.add(t1);
		turnosDia.add(t2);
		turnosDia.add(t3);
		turnosDia.add(t4);
		turnosDia.add(t5);
		turnosDia.add(t6);
		Collections.sort(turnosDia);
		turnos.add(turnosDia);
		
		ArrayList<Turno> turnosDia2 = new ArrayList<Turno>();
		t1 = new Turno("08:00", LocalDate.of(2022, 6, 17), this, new Paciente(), 30);
		t2 = new Turno("11:00", LocalDate.of(2022, 6, 17), this, new Paciente(), 30);
		t3 = new Turno("15:00", LocalDate.of(2022, 6, 17), this, new Paciente(), 30);
		t4 = new Turno("10:00", LocalDate.of(2022, 6, 17), this, new Paciente(), 30);
		t5 = new Turno("13:00", LocalDate.of(2022, 6, 17), this, new Paciente(), 30);
		t6 = new Turno("16:00", LocalDate.of(2022, 6, 17), this, new Paciente(), 30);
		turnosDia2.add(t1);
		turnosDia2.add(t2);
		turnosDia2.add(t3);
		turnosDia2.add(t4);
		turnosDia2.add(t5);
		turnosDia2.add(t6);
		Collections.sort(turnosDia2);
		turnos.add(turnosDia2);
	}
	
	public ArrayList<String> getObrasSociales() {
		return obrasSociales;
	}
	public void setObrasSociales(ArrayList<String> obrasSociales) {
		this.obrasSociales = obrasSociales;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public ArrayList<Integer> getDias() {
		return dias;
	}
	public void setDias(ArrayList<Integer> dias) {
		this.dias = dias;
	}
	public int getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}
	public int getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(int horaFin) {
		this.horaFin = horaFin;
	}
	public void setTurnos(ArrayList<ArrayList<Turno>> turnos) {
		this.turnos = turnos;
	}	
}
