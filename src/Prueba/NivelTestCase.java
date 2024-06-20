package Prueba;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import logic.Nivel;
import logic.Pregunta;
import logic.Respuesta;

import org.junit.Before;
import org.junit.Test;

public class NivelTestCase {

	private Nivel nivel;
    private Pregunta pregunta1;
    private Pregunta pregunta2;
	@SuppressWarnings("unused")
	private Pregunta pregunta3;
	private Respuesta respuesta1;
    private Respuesta respuesta2;
    private Respuesta respuesta3;
    private Respuesta respuesta4;

    @Before
    public void setUp() {
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
        //preguntas.add(pregunta3);

        nivel = new Nivel(preguntas);
    }

    @Test
    public void testAgregarPregunta() {
    	respuesta1 = new Respuesta("Respuesta 1", false);
        respuesta2 = new Respuesta("Respuesta 2", false);
        respuesta3 = new Respuesta("Respuesta 3", false);
        respuesta4 = new Respuesta("Respuesta 4", true);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        respuestas.add(respuesta3);
        respuestas.add(respuesta4);
        Pregunta pregunta4 = new Pregunta("Pregunta 4", respuestas, 3);
        nivel.agregarPregunta(pregunta4);

        ArrayList<Pregunta> preguntas = nivel.getPreguntas();
        assertEquals(3, preguntas.size());
        assertTrue(preguntas.contains(pregunta4));
    }

    @Test
    public void testEliminarPregunta() {
        assertTrue(nivel.eliminarPregunta(0, 0));

        ArrayList<Pregunta> preguntas = nivel.getPreguntas();
        assertEquals(1, preguntas.size());
        assertFalse(preguntas.contains(pregunta1));
    }

    @Test
    public void testModificarPregunta() {
    	respuesta1 = new Respuesta("Respuesta 1", false);
        respuesta2 = new Respuesta("Respuesta 2", false);
        respuesta3 = new Respuesta("Respuesta 3", false);
        respuesta4 = new Respuesta("Respuesta 4", true);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta1);
        respuestas.add(respuesta2);
        respuestas.add(respuesta3);
        respuestas.add(respuesta4);
        Pregunta pregunta4 = new Pregunta("Pregunta 4", respuestas, 3);
        nivel.modificarPregunta(pregunta4, 0);

        ArrayList<Pregunta> preguntas = nivel.getPreguntas();
        assertEquals(2, preguntas.size());
        assertTrue(preguntas.contains(pregunta4));
        assertFalse(preguntas.contains(pregunta1));
    }

    @Test
    public void testModificarPreguntaNull() {
        try {
            nivel.modificarPregunta(null, 0);
            fail("Debería haber lanzado una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("La pregunta no puede estar vacía y debe estar definida.", e.getMessage());
        }
    }

}
