package logic;

import java.util.*;

public class Pregunta {
	private String pregunta;
	private ArrayList<Respuesta> respuestas;
	private int respuestaCorrecta;

	public Pregunta(String pregunta, ArrayList<Respuesta> respuestas,
			int respuestaCorrecta) {
		setPregunta(pregunta);
		setRespuestas(respuestas);
		setRespuestaCorrecta(respuestaCorrecta);
	}

	public String getPregunta() {
		return pregunta;
	}

	public int getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public ArrayList<Respuesta> getRespuestas() {
		return respuestas;
	}

	private void setRespuestas(ArrayList<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	private void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public boolean agregarRespuesta(Respuesta respuesta) {
		boolean agregado = false;
		if (!respuestas.contains(respuesta) && respuesta != null
				&& respuestas.size() <= 4) {
			respuestas.add(respuesta);
			agregado = true;
		}
		return agregado;
	}

	public void eliminarRespuesta(Respuesta respuesta) {
		if (respuestas.contains(respuesta) && respuesta != null) {
			respuestas.remove(respuesta);
		} else
			throw new IllegalArgumentException(
					"La respuesta no puede estar vacía y debe estar definida.");
	}

	public void setRespuestaCorrecta(int respuestaCorrect) {
		int respuestaCorrecta = -1;
		for (Respuesta resp : respuestas) {
			if (resp.isEsCorrecta()) {
				respuestaCorrecta = respuestas.indexOf(resp);
			}
		}
		if (respuestaCorrecta == respuestaCorrect) {
			this.respuestaCorrecta = respuestaCorrect;
		} else
			throw new IllegalArgumentException(
					"Debe haber una respuesta correcta.");
	}

}
