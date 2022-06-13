package Clases;

import java.time.LocalDate;

public class Turno implements Comparable<Turno>{
	private String hora;
	private LocalDate fecha;
	private Medico medico;
	private Paciente paciente;
	private int duracion;	
	
	public Turno(String hora, LocalDate fecha, Medico medico, Paciente paciente, int duracion) {
		this.hora = hora;
		this.fecha = fecha;
		this.medico = medico;
		this.paciente = paciente;
		this.duracion = duracion;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	@Override
	public int compareTo(Turno t) {return hora.compareTo(t.getHora());}	
}
