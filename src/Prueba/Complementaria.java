package Prueba;

import java.util.ArrayList;

import logic.Nivel;
import logic.Pregunta;
import logic.Respuesta;

public class Complementaria {
	private static Nivel nivel;
    private static Pregunta pregunta1;
    private static Pregunta pregunta2;
	private static Pregunta pregunta3;
	private static Respuesta respuesta1;
    private static Respuesta respuesta2;
    private static Respuesta respuesta3;
    private static Respuesta respuesta4;
	private static Pregunta pregunta;
    
    public static Nivel nivel() {
    	respuesta1 = new Respuesta("Respuesta 1", false);
        respuesta2 = new Respuesta("Respuesta 2", false);
        respuesta3 = new Respuesta("Respuesta 3", true);
        respuesta4 = new Respuesta("Respuesta 4", false);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        respuestas.add(respuesta3);
        respuestas.add(respuesta4);
    	
        pregunta1 = new Pregunta("Pregunta 1", respuestas, 2);
        pregunta2 = new Pregunta("Pregunta 2", respuestas, 2);
        pregunta3 = new Pregunta("Pregunta 3", respuestas, 2);

        ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
        preguntas.add(pregunta1);
        preguntas.add(pregunta2);
        preguntas.add(pregunta3);

        return setNivel(new Nivel(preguntas));
    }
    
    public static Pregunta pregunta(){
    	respuesta1 = new Respuesta("Respuesta 1", false);
        respuesta2 = new Respuesta("Respuesta 2", false);
        respuesta3 = new Respuesta("Respuesta 3", true);
        respuesta4 = new Respuesta("Respuesta 4", false);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        respuestas.add(respuesta3);
        respuestas.add(respuesta4);
    	
        return setPregunta(new Pregunta("Pregunta Ejemplo 1", respuestas, 2));
    }

	public Nivel getNivel() {
		return nivel;
	}

	public static Nivel setNivel(Nivel nivel) {
		Complementaria.nivel = nivel;
		return nivel;
	}

	public static Pregunta getPregunta() {
		return pregunta;
	}

	public static Pregunta setPregunta(Pregunta pregunta) {
		Complementaria.pregunta = pregunta;
		return pregunta;
	}
}
