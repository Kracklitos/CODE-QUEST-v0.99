package logic;

public class Jugador extends Usuario {
	private int puntaje = 0;
	private int nivelActual = 0;
	private int preguntaActual = 0;
	private boolean jugo;

	public Jugador(String nombre, String password) {
		super(nombre, password);
		setJugo(false);
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		if (puntaje >= 0)
			this.puntaje = puntaje;
	}

	public void incrementarPuntaje() {
		puntaje++;
	}

	public int getNivelActual() {
		return nivelActual;
	}

	public void setNivelActual(int nivelActual) {
		if (puntaje >= 0)
			this.nivelActual = nivelActual;
	}

	public int getPreguntaActual() {
		return preguntaActual;
	}

	public void setPreguntaActual(int preguntaActual) {
		if (puntaje >= 0)
			this.preguntaActual = preguntaActual;
	}

	public void reiniciarJugador() {
		puntaje = 0;
		nivelActual = 0;
		preguntaActual = 0;
	}

	public boolean yaJugo() {
		return jugo;
	}

	public void setJugo(boolean jugo) {
		this.jugo = jugo;
	}

}
