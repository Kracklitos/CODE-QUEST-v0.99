package logic;

public class Administrador extends Usuario {
	private static Administrador admin = null;
	private static Juego juego = Juego.getInstance();

	private Administrador(String nombre, String password) {
		super(nombre, password);
	}

	public static Administrador getInstance() {
		if (admin == null) {
			admin = crearAdmin();
		}
		return admin;
	}

	private static Administrador crearAdmin() {
		Administrador admin = new Administrador("admin", "QuestJava.");
		return admin;
	}

	// Métodos para el manejo de Niveles Preguntas y Respuestas.
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public void agregarPreguntaAdmin(int indiceNivel, Pregunta pregunta) {
		Nivel nivel = juego.getNiveles().get(indiceNivel);
		if (!nivel.getPreguntas().contains(pregunta) && pregunta != null) {
			juego.getNiveles().get(indiceNivel).agregarPregunta(pregunta);
		} else
			throw new IllegalArgumentException(
					"La pregunta no puede estar vacía ni estar repetida.");
	}

	public boolean eliminarPreguntaAdmin(int indiceNivel, int indicePregunta) {
		return juego.getNiveles().get(indiceNivel)
				.eliminarPregunta(indiceNivel, indicePregunta);
	}

	public void modificarPreguntaAdmin(int indiceNivel, int indicePregunta,
			Pregunta pregunta) {
		if (pregunta != null) {
			juego.getNiveles().get(indiceNivel)
					.modificarPregunta(pregunta, indicePregunta);
		} else
			throw new IllegalArgumentException(
					"La pregunta no puede estar vacía y debe estar definida.");
	}

	public void agregarNivelAdmin(Nivel nivel) {
		juego.agregarNivel(nivel);
	}

	public boolean eliminarNivelAdmin(int indice) {
		return juego.eliminarNivel(indice);
	}

	public void modificarNivelAdmin(Nivel nivel, int indice) {
		juego.modificarNivel(nivel, indice);
	}

}
