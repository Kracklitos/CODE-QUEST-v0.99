package logic;

public abstract class Usuario {
	protected String nombre;
	protected String contrasena;
	
	
	public Usuario(String nombre, String contrasena) {
		setNombre (nombre);
		setContrasena(contrasena);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre != null && !nombre.trim().isEmpty()) {
			this.nombre = nombre;
		} else
			throw new IllegalArgumentException(
					"El nombre no puede estar vacío o contener solo espacios.");
	}
	
	
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		if (contrasena != null && !contrasena.trim().isEmpty()) {
			this.contrasena = contrasena;
		} else
			throw new IllegalArgumentException(
					"La contraseña no puede estar vacía o contener solo espacios.");
	}
	
}
