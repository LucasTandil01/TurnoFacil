package Clases;

import java.awt.EventQueue;
import java.util.ArrayList;

import Swing.PopOutOS;
import Swing.PopOutTurnoAgregado;
import Swing.Turnero;

public class Paciente extends Usuario{
	private String direccion;
	private long telefono;
	private String email;
	private ObraSocial obraSocial;
	private int numAfiliado;
	private ArrayList<Turno> turnosReservados;	

	public Paciente() {
		super(12345678,"Juan", "Rodriguez");
		this.direccion = "Calle 123";
		this.telefono = 2494111111L;
		this.email = "example@gmail.com";
		this.obraSocial = new ObraSocial("Obra Social");
		this.numAfiliado = 12345;
		turnosReservados = new ArrayList<Turno>();
	}
	
	public Paciente(long dni, String nombre, String apellido, String direccion, long telefono, String email, ObraSocial obraSocial, int numAfiliado){
		super(dni,nombre, apellido);
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.obraSocial.setNombre(obraSocial.getNombre());
		this.numAfiliado = numAfiliado;
		turnosReservados = new ArrayList<Turno>();
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getObraSocialNombre() {
		return obraSocial.getNombre();
	}
	public void setObraSocial(ObraSocial obraSocial) {
		this.obraSocial.setNombre(obraSocial.getNombre());
	}
	public int getNumAfiliado() {
		return numAfiliado;
	}
	public void setNumAfiliado(int numAfiliado) {
		this.numAfiliado = numAfiliado;
	}	
	
	public ArrayList<Turno> getTurnosReservados() {
		return turnosReservados;
	}

	public void setTurnosReservados(ArrayList<Turno> turnosReservados) {
		this.turnosReservados = turnosReservados;
	}
	
	public Paciente getPaciente() {return this;}
	
	public void verificarTurno(Turno t,Turnero turnero) {
		if (t.getMedico().verifcarOS(obraSocial) && t.getMedico().verificarOSdiferencial(obraSocial)==2)	
			confirmarTurno(t,turnero);
		else {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						PopOutOS frame = new PopOutOS(turnero,t,getPaciente(),t.getMedico().verificarOSdiferencial(obraSocial),t.getMedico().getObraSocialPaciente(obraSocial)); // camiar esto para Cobertura
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			}
		}
	
	public void confirmarTurno(Turno t,Turnero turnero) {
		t.setPaciente(this);
		turnosReservados.add(t);
		turnero.buscar();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopOutTurnoAgregado frame = new PopOutTurnoAgregado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

