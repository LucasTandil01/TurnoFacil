package Clases;

import java.time.LocalDate;

public class Turno implements Comparable<Turno> {
	private int hora;
	private int minutos;
	private LocalDate fecha;
	private Medico medico;
	private Paciente paciente;
	private int duracion;
	
	public Turno(int hora, int minutos, LocalDate fecha, Medico medico, Paciente paciente, int duracion) {
		this.hora = hora;
		this.minutos = minutos;
		this.fecha = fecha;
		this.medico = medico;
		this.paciente = paciente;
		this.duracion = duracion;
	}

	public boolean estaOcupado() {
		return (this.paciente != null);
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
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
	public int compareTo(Turno t) {
		if (hora - t.getHora() == 0)
			return minutos - t.getMinutos();
		else
			return hora - t.getHora();
	}

}
