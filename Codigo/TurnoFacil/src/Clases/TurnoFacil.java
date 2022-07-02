package Clases;
import java.awt.EventQueue;
import java.util.ArrayList;

import Filtros.Filtro;
import Swing.*;

public class TurnoFacil {
//	private ArrayList<Usuario> usuarios;
	private ArrayList<Paciente> pacientes;
	private ArrayList<Medico> medicos;
	private ArrayList<Secretaria> secretarias;
	private static ResponsableInst ri;
	//private Scanner scan;
	
	public static void main(String[] args) {
		TurnoFacil sistema = new TurnoFacil();
		ri = new ResponsableInst(sistema,12345678,"Carlos","Sanchez","admin","admin");
		ri.crearMedicos();
		sistema.launch();
	}
	
	public void launch() {
		TurnoFacil sistema = this;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu(sistema);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}
	
	public TurnoFacil() {
//		usuarios = new ArrayList<Usuario>();
		//cargarUsuarios();
		pacientes = new ArrayList<Paciente>();
		medicos = new ArrayList<Medico>();
		secretarias = new ArrayList<Secretaria>();
	}
	
	public void login(long dni){
//		if(!existeUsuario(dni))
			registrarPaciente(dni);
		//...
//		PortalUsuario pu = new PortalUsuario(buscarUsuario(dni));
//		pu.main(null);

	}
	
	public boolean login(String user, String pass) {
		Medico m =  buscarMedico(user, pass);
		if (m!=null) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						PortalMedico frame = new PortalMedico(m);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			return true;
		}
		return false;
	}
	
	public Medico buscarMedico(String user, String pass) {
		for(Medico m: medicos) {
			if(m.getNombreUsuario().equals(user)&&m.getContrasenia().equals(pass))return m;
		}
//		Medico m = new Medico(12345678,"Rodrigo","Perez",user, pass, "Cirujano");
		return null;
	}
	
	private void registrarPaciente(long dni) {
		TurnoFacil t = this;
		RegisterPaciente rf = new RegisterPaciente(dni,t);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//		System.out.println("Ingrese nombre: ");
//		String nombre = scan.nextLine();
//		//...
	}
	
	public ArrayList<Medico> buscarMedicos(Filtro f){
		ArrayList<Medico> salida = new ArrayList<>();
		for(Medico m : medicos) {
			if(f.cumple(m))
				salida.add(m);
		}
		return salida;
	}
	
	public ArrayList<Medico> buscarMedicosSinFiltro(){
			ArrayList<Medico> salida = new ArrayList<>();
			for(Medico m : medicos) {
					salida.add(m);
			}
			return salida;
		}
	
	public ArrayList<Medico> getMedicos(){return new ArrayList<Medico>(medicos);}
	public ArrayList<Secretaria> getSecretarias(){return new ArrayList<Secretaria>(secretarias);}
	public ArrayList<Paciente> getPacientes(){return new ArrayList<Paciente>(pacientes);}
	
	public void addPaciente(Paciente p) {
		//if(!existeUsuario(p.getDni())) 
		pacientes.add(p);
	}
	public void addMedico(Medico m) {
		//if(!existeUsuario(u.getDni())) 
		medicos.add(m);
	}
	public void addUser(Secretaria s) {
		//if(!existeUsuario(u.getDni())) 
		secretarias.add(s);
	}
}
