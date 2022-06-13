package Clases;
import java.awt.EventQueue;
import Comparadores.*;
import java.util.ArrayList;
import java.util.Collections;

import Swing.*;

public class TurnoFacil {
	private ArrayList<Usuario> usuarios;
	//private Scanner scan;
	
	public static void main(String[] args) {
		TurnoFacil sistema = new TurnoFacil();
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
		usuarios = new ArrayList<Usuario>();
		//cargarUsuarios();
	}
	
	public void crearPacientes() {
		Paciente p = new Paciente(43658967,"Lucas","Martinez","Brandsen 1262",2494554777L, "lucastandil01@gmail.com", "OSSEG",12345);
		addUser(p);
	}
	
	public boolean existeUsuario(long dni) {
		Collections.sort(usuarios, new ComparadorDNI());
		int i = 0;
		int j = usuarios.size() - 1;
		int k;
		long dniAux;
		while (i<=j) {
			k = (i+j)/2;
			dniAux = usuarios.get(k).getDni();
			if(dni == dniAux)
				return true;
			if(dni<dniAux) j = k+1;
			else i = k-1;
		}
		return false;
	}
	
	public void login(long dni){
//		if(!existeUsuario(dni))
			registrarPaciente(dni);
		//...
//		PortalUsuario pu = new PortalUsuario(buscarUsuario(dni));
//		pu.main(null);

	}
	
	public void login(String user, String pass) {
		Medico m =  buscarEmpleado(user, pass);
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
	}
	
	public Paciente buscarPaciente(long dni) {
		return null;
	}
	
	public Medico buscarEmpleado(String user, String pass) {
		Medico m = new Medico(12345678,"Rodrigo","Perez",user, pass, "Cirujano");
		return m;
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
		
	public void addUser(Usuario u) {
		//if(!existeUsuario(u.getDni())) 
			usuarios.add(u);
	}
}
