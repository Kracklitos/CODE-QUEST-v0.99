package Prueba;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import logic.Juego;
import logic.Jugador;
import logic.Nivel;
import logic.Usuario;

import org.junit.Before;
import org.junit.Test;

public class JuegoTestCase {

	private Juego juego;

    @Before
    public void setUp() {
        juego = Juego.getInstance();
    }

    @Test
    public void testAgregarNivel() {
        Nivel nivel = Complementaria.nivel();
        juego.agregarNivel(nivel);

        ArrayList<Nivel> niveles = juego.getNiveles();
        assertTrue(niveles.contains(nivel));
    }

    @Test
    public void testAgregarNivelExistente() {
        Nivel nivel = Complementaria.nivel();
        juego.agregarNivel(nivel);

        try {
            juego.agregarNivel(nivel);
            fail("Debería haber lanzado una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("El nivel no puede estar vacío ni estar repetido.", e.getMessage());
        }
    }

    @Test
    public void testAgregarNivelNull() {
        try {
            juego.agregarNivel(null);
            fail("Debería haber lanzado una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("El nivel no puede estar vacío ni estar repetido.", e.getMessage());
        }
    }

    @Test
    public void testEliminarNivel() {
        Nivel nivel = Complementaria.nivel();
        juego.agregarNivel(nivel);

        assertTrue(juego.eliminarNivel(3));
    }

    @Test
    public void testModificarNivel() {
        Nivel nivel = Complementaria.nivel();
        juego.agregarNivel(nivel);

        Nivel nivelModificado = Complementaria.nivel();
        juego.modificarNivel(nivelModificado, 3);

        ArrayList<Nivel> niveles = juego.getNiveles();
        assertEquals(4, niveles.size());
        assertTrue(niveles.contains(nivelModificado));
        assertFalse(niveles.contains(nivel));
    }

    @Test
    public void testModificarNivelNull() {
        try {
            juego.modificarNivel(null, 0);
            fail("Debería haber lanzado una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("El nivel no puede estar vacío y debe estar definido.", e.getMessage());
        }
    }

    @Test
    public void testAgregarJugador() {
        Jugador jugador = new Jugador("jugador", "password");
        assertFalse(juego.agregarJugador((Usuario)jugador));

        ArrayList<Usuario> jugadores = juego.getJugadores();
        assertEquals(2, jugadores.size());
        assertTrue(jugadores.contains(jugador));
    }

    @Test
    public void testAgregarJugadorExistente() {
        Jugador jugador = new Jugador("jugador", "password");
        juego.agregarJugador(jugador);

        assertTrue(juego.agregarJugador(jugador));
    }

    @Test
    public void testAgregarJugadorNull() {
        assertFalse(juego.agregarJugador(null));
    }

}
