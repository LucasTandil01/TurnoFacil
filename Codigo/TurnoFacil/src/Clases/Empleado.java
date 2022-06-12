package Clases;

public class Empleado extends Usuario{
	private String nombreUsuario;
	private String contrasenia;
	
	Empleado(long dni, String nombre, String apellido, String nombreUsuario, String contrasenia) {
		super(dni, nombre, apellido);
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
	}	
}
