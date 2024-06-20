package Prueba;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import logic.Administrador;
import logic.Juego;
import logic.Nivel;
import logic.Pregunta;

import org.junit.Before;
import org.junit.Test;

public class AdministradorTestCase {

	private Administrador admin;
	
    @Before
    public void setUp() {
        admin = Administrador.getInstance();
    }

    @Test
    public void testAgregarPreguntaAdminNull() {
        try {
            admin.agregarPreguntaAdmin(0, null);
            fail("Debería haber lanzado una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("La pregunta no puede estar vacía ni estar repetida.", e.getMessage());
        }
    }

    @Test
    public void testEliminarPreguntaAdmin() {
        Nivel nivel = Complementaria.nivel();
        Juego.getInstance().agregarNivel(nivel);

        Pregunta pregunta = Complementaria.pregunta();
        nivel.agregarPregunta(pregunta);

        assertTrue(admin.eliminarPreguntaAdmin(3, 3));
    }

    @Test
    public void testModificarPreguntaAdmin() {
        Nivel nivel = Complementaria.nivel();
        Juego.getInstance().agregarNivel(nivel);

        Pregunta pregunta = Complementaria.pregunta();
        nivel.agregarPregunta(pregunta);

        Pregunta preguntaModificada = Complementaria.pregunta();
        admin.modificarPreguntaAdmin(3, 0, preguntaModificada);

        ArrayList<Pregunta> preguntas = nivel.getPreguntas();
        assertEquals(4, preguntas.size());
        //assertTrue(preguntas.contains(preguntaModificada));
        //assertFalse(preguntas.contains(pregunta));
    }

    @Test
    public void testModificarPreguntaAdminNull() {
        try {
            admin.modificarPreguntaAdmin(0, 0, null);
            fail("Debería haber lanzado una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("La pregunta no puede estar vacía y debe estar definida.", e.getMessage());
        }
    }

    @Test
    public void testAgregarNivelAdmin() {
        Nivel nivel = Complementaria.nivel();
        admin.agregarNivelAdmin(nivel);

        ArrayList<Nivel> niveles = Juego.getInstance().getNiveles();
        assertEquals(4, niveles.size());
        assertTrue(niveles.contains(nivel));
    }

    @Test
    public void testEliminarNivelAdmin() {
        Nivel nivel = Complementaria.nivel();
        Juego.getInstance().agregarNivel(nivel);

        assertTrue(admin.eliminarNivelAdmin(3));
    }

    @Test
    public void testModificarNivelAdmin() {
        Nivel nivel = Complementaria.nivel();
        Juego.getInstance().agregarNivel(nivel);

        ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
        preguntas.add(Complementaria.pregunta());
        
        Nivel nivelModificado = new Nivel(preguntas);
        admin.modificarNivelAdmin(nivelModificado, 0);

        ArrayList<Nivel> niveles = Juego.getInstance().getNiveles();
        assertTrue(niveles.contains(nivelModificado));
    }

}
