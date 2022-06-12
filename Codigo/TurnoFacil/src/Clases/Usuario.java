package Clases;

public class Usuario {
	private long dni;
	private String nombre;
	private String apellido;
	
	
	
	Usuario(long dni, String nombre, String apellido){
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}	
	

//	@Override
//	public boolean equals(Object o) {
//		Usuario u = (Usuario) o;
//		if(dni == (u.getDni())) return true;
//		return false;
//	}
//	
	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
