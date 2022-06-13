package Clases;

public class Paciente extends Usuario{
	private String direccion;
	private long telefono;
	private String email;
	private String obraSocial;
	private int numAfiliado;
	
	public Paciente() {
		super(12345678,"Juan", "Rodriguez");
		this.direccion = "Calle 123";
		this.telefono = 2494111111L;
		this.email = "example@gmail.com";
		this.obraSocial = "Obra Social";
		this.numAfiliado = 12345;
	}
	
	public Paciente(long dni, String nombre, String apellido, String direccion, long telefono, String email, String obraSocial, int numAfiliado){
		super(dni,nombre, apellido);
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.obraSocial = obraSocial;
		this.numAfiliado = numAfiliado;
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
	public String getObraSocial() {
		return obraSocial;
	}
	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}
	public int getNumAfiliado() {
		return numAfiliado;
	}
	public void setNumAfiliado(int numAfiliado) {
		this.numAfiliado = numAfiliado;
	}	
}
