package logic;

import java.util.ArrayList;

public class Nivel {
	private ArrayList<Pregunta> preguntas;

	public Nivel(ArrayList<Pregunta> preguntas) {
		setPreguntas(preguntas);
	}

	private void setPreguntas(ArrayList<Pregunta> preguntas) {
		if (!preguntas.isEmpty() && preguntas.size() > 0) {
			this.preguntas = preguntas;
		} else
			throw new IllegalArgumentException(
					"Debe haber mínimo una pregunta.");

	}

	public boolean addPregunta(ArrayList <Pregunta> preguntas) {
		boolean encontrado = false;
		for (Nivel n : Juego.getInstance().getNiveles()) {

			for (Pregunta p : n.getPreguntas()) {
				for(Pregunta pregunta: preguntas)
				if (p.getPregunta().equalsIgnoreCase(pregunta.getPregunta())
						|| pregunta.getRespuestas().equals(p.getRespuestas())
						|| pregunta == null) {
					encontrado = true;
				}
			}
		}
		
		return encontrado;
	}
	
	public void agregarPregunta(Pregunta pregunta) {
		if (!preguntas.contains(pregunta) && pregunta != null && !addPregunta(preguntas)) {
			preguntas.add(pregunta);
		} else
			throw new IllegalArgumentException(
					"La pregunta no puede estar vacía ni estar repetida.");
	}

	public boolean eliminarPregunta(int indexNivel, int indexPregunta) {
		boolean posible = false;

		if (Juego.getInstance().getNiveles().get(indexNivel).getPreguntas()
				.size() - 1 > 0) {
			preguntas.remove(indexPregunta);
			posible = true;
		}
		return posible;
	}

	public void modificarPregunta(Pregunta pregunta, int indexPregunta) {
		if (pregunta != null) {
			preguntas.set(indexPregunta, pregunta);
		} else
			throw new IllegalArgumentException(
					"La pregunta no puede estar vacía y debe estar definida.");
	}

	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}
}
