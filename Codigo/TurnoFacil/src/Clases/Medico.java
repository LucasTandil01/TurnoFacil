package Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import Clases.Cobertura;
import Filtros.FiltroDesdeFecha;
import Filtros.FiltroHastaFecha;
import Filtros.FiltroAndTurno;
import Filtros.FiltroHorario;
import Filtros.FiltroNotTurno;
import Filtros.FiltroTurno;

public class Medico extends Empleado {
	private ArrayList<ArrayList<Turno>> turnos;
	private ArrayList<Cobertura> obrasSociales;
	private String especialidad;
	private ArrayList<Integer> dias;
	// 0 = Domingo, 1 = Lunes ... 6 = Sábado
	private int horaInicio;
	private int horaFin;

	public Medico(long dni, String nombre, String apellido, String nombreUsuario, String contrasenia,
			String especialidad) {
		super(dni, nombre, apellido, nombreUsuario, contrasenia);
		this.especialidad = especialidad;
		turnos = new ArrayList<ArrayList<Turno>>();
		generarTurnos();
	}

	public Medico(long dni, String nombre, String apellido, String nombreUsuario, String contrasenia,
			ArrayList<ArrayList<Turno>> turnos, ArrayList<Cobertura> obs, String especialidad, ArrayList<Integer> dias,
			int horaInicio, int horaFin) {
		super(dni, nombre, apellido, nombreUsuario, contrasenia);
		this.turnos = turnos;
		this.obrasSociales = obs;
		this.especialidad = especialidad;
		this.dias = dias;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		generarTurnos();
	}

	public ArrayList<Turno> getTurnosDisp() {
		ArrayList<Turno> salida = new ArrayList<Turno>();
		for (ArrayList<Turno> t : turnos) {
			for (Turno t2 : t) {
				if (!t2.estaOcupado()) {
					salida.add(t2);
				}
			}
		}
		return salida;
	}

	public ArrayList<Turno> getTurnosOcup() {
		ArrayList<Turno> salida = new ArrayList<Turno>();
		for (ArrayList<Turno> t : turnos) {
			for (Turno t2 : t) {
				if (t2.estaOcupado()) {
					salida.add(t2);
				}
			}
		}
		return salida;
	}

	public ArrayList<Turno> getTurnosFranjaHor(ArrayList<Turno> turnos, String franjaHor) {
		ArrayList<Turno> salida = new ArrayList<Turno>();
		FiltroTurno franja = new FiltroHorario();
		if (franjaHor.equals("Tarde")) {
			franja = new FiltroNotTurno(franja);
		}
		for (Turno t : turnos)
			if (franja.cumple(t)) {
				salida.add(t);
			}
		return salida;
	}

	public ArrayList<ArrayList<Turno>> getTurnos() {
		return new ArrayList<ArrayList<Turno>>(turnos);
	}

	public void generarTurnos() {
		ArrayList<Turno> turnosDia = new ArrayList<Turno>();
		Turno t1 = new Turno(9, 00, LocalDate.of(2022, 6, 14), this, null, 30);
		Turno t2 = new Turno(11, 00, LocalDate.of(2022, 6, 14), this, new Paciente(), 30);
		Turno t3 = new Turno(14, 00, LocalDate.of(2022, 6, 14), this, new Paciente(), 30);
		Turno t4 = new Turno(10, 00, LocalDate.of(2022, 6, 14), this, null, 30);
		Turno t5 = new Turno(13, 00, LocalDate.of(2022, 6, 14), this, new Paciente(), 30);
		Turno t6 = new Turno(12, 00, LocalDate.of(2022, 6, 14), this, new Paciente(), 30);
		turnosDia.add(t1);
		turnosDia.add(t2);
		turnosDia.add(t3);
		turnosDia.add(t4);
		turnosDia.add(t5);
		turnosDia.add(t6);
		Collections.sort(turnosDia);
		turnos.add(turnosDia);

		ArrayList<Turno> turnosDia2 = new ArrayList<Turno>();
		t1 = new Turno(8, 00, LocalDate.of(2022, 6, 17), this, new Paciente(), 30);
		t2 = new Turno(11, 00, LocalDate.of(2022, 6, 17), this, null, 30);
		t3 = new Turno(15, 00, LocalDate.of(2022, 6, 17), this, new Paciente(), 30);
		t4 = new Turno(10, 00, LocalDate.of(2022, 6, 17), this, new Paciente(), 30);
		t5 = new Turno(13, 00, LocalDate.of(2022, 6, 17), this, null, 30);
		t6 = new Turno(16, 00, LocalDate.of(2022, 6, 17), this, new Paciente(), 30);
		turnosDia2.add(t1);
		turnosDia2.add(t2);
		turnosDia2.add(t3);
		turnosDia2.add(t4);
		turnosDia2.add(t5);
		turnosDia2.add(t6);
		Collections.sort(turnosDia2);
		turnos.add(turnosDia2);
	}

	public ArrayList<Turno> getListaEnUnRango(ArrayList<Turno> turnos, LocalDate diaIni, LocalDate diaFin) {
		ArrayList<Turno> salida = new ArrayList<Turno>();
		FiltroDesdeFecha f1 = new FiltroDesdeFecha(diaIni);
		FiltroHastaFecha f2 = new FiltroHastaFecha(diaFin);
		FiltroAndTurno rango = new FiltroAndTurno(f1, f2);
		for (Turno t1 : turnos) {
			if (t1.getFecha().isAfter(diaFin))
				break;
			if (rango.cumple(t1)) {
				salida.add(t1);
			}
		}
		return salida;
	}

	public ArrayList<Turno> quiereVerSemProx(LocalDate diaFin) {
		return getListaEnUnRango(getTurnosDisp(), diaFin.plusDays(1), diaFin.plusMonths(1));
	}

	public boolean verifcarOS(ObraSocial obraSocial) {
		boolean verificado = false;
		for (int i = 0; i < this.obrasSociales.size(); i++) {
			if (verificado == false) {
				String obritasocial = this.obrasSociales.get(i).getObrasocial().getNombre();
				verificado = obritasocial.equalsIgnoreCase(obraSocial.getNombre());
			}
		}
		return verificado;
	}

	public boolean verificarOSdiferencial(ObraSocial obraSocial) {
		boolean verificado = false;
		boolean verificado2 = false;
		for (int i = 0; i < this.obrasSociales.size(); i++) {
			if (verificado == false) {
				String obritasocial = this.obrasSociales.get(i).getObrasocial().getNombre();
				verificado = obritasocial.equalsIgnoreCase(obraSocial.getNombre());
				if(verificado) {
					verificado2 = obrasSociales.get(i).getPorcentaje()==100;
				}
			}
		}
		return verificado2;
	}

	public ArrayList<Cobertura> getObrasSociales() {
		ArrayList<Cobertura> aux = new ArrayList<Cobertura>();
		aux.addAll(obrasSociales);
		return aux;
	}

	public void setObrasSociales(ArrayList<Cobertura> obrasSociales) {
		this.obrasSociales.addAll(obrasSociales);
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
	
	public Cobertura getObraSocialPaciente(ObraSocial os) {
	for (Cobertura c: obrasSociales)	{
		if (os.getNombre().equals(c.getObrasocial().getNombre()))
			return c;
	}
	return null;
	}	
	}

