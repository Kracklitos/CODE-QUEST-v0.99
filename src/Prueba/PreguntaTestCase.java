package Prueba;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import logic.Pregunta;
import logic.Respuesta;

import org.junit.Before;
import org.junit.Test;

public class PreguntaTestCase {

	private Pregunta pregunta;
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

        pregunta = new Pregunta("¿Cuál es la capital de Francia?", respuestas, 2);
    }

    @Test
    public void testGetPregunta() {
        assertEquals("¿Cuál es la capital de Francia?", pregunta.getPregunta());
    }

    @Test
    public void testGetRespuestaCorrecta() {
        assertEquals(2, pregunta.getRespuestaCorrecta());
    }

    @Test
    public void testGetRespuestas() {
        ArrayList<Respuesta> respuestas = pregunta.getRespuestas();
        assertEquals(4, respuestas.size());
        assertTrue(respuestas.contains(respuesta1));
        assertTrue(respuestas.contains(respuesta2));
        assertTrue(respuestas.contains(respuesta3));
        assertTrue(respuestas.contains(respuesta4));
    }

    @Test
    public void testAgregarRespuesta() {
        Respuesta respuesta5 = new Respuesta("Respuesta 5", false);
        assertTrue(pregunta.agregarRespuesta(respuesta5));

        ArrayList<Respuesta> respuestas = pregunta.getRespuestas();
        assertEquals(5, respuestas.size());
        assertTrue(respuestas.contains(respuesta5));
    }

    @Test
    public void testAgregarRespuestaExistente() {
        assertFalse(pregunta.agregarRespuesta(respuesta1));
    }

    @Test
    public void testAgregarRespuestaNull() {
        assertFalse(pregunta.agregarRespuesta(null));
    }

    @Test
    public void testAgregarRespuestaExceso() {
        Respuesta respuesta5 = new Respuesta("Respuesta 5", false);
        Respuesta respuesta6 = new Respuesta("Respuesta 6", false);

        assertTrue(pregunta.agregarRespuesta(respuesta5));
        assertFalse(pregunta.agregarRespuesta(respuesta6));
    }

    @Test
    public void testEliminarRespuesta() {
        pregunta.eliminarRespuesta(respuesta1);

        ArrayList<Respuesta> respuestas = pregunta.getRespuestas();
        assertEquals(3, respuestas.size());
        assertFalse(respuestas.contains(respuesta1));
    }

    @Test
    public void testSetRespuestaCorrecta() {
        pregunta.setRespuestaCorrecta(2);
        assertEquals(2, pregunta.getRespuestaCorrecta());
    }

    @Test
    public void testSetRespuestaCorrectaIncorrecta() {
        try {
            pregunta.setRespuestaCorrecta(1);
            fail("Debería haber lanzado una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Debe haber una respuesta correcta.", e.getMessage());
        }
    }

}
