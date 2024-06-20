package Prueba;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import logic.Jugador;

import org.junit.Before;
import org.junit.Test;

public class JugadorTestCase {

	private Jugador jugador;

	@Before
	public void setUp() {
		jugador = new Jugador("Test", "123456");
	}

	@Test
	public void testGetPuntaje() {
		assertEquals(0, jugador.getPuntaje());
	}

	@Test
	public void testSetPuntaje() {
		jugador.setPuntaje(10);
		assertEquals(10, jugador.getPuntaje());
	}

	@Test
	public void testIncrementarPuntaje() {
		jugador.incrementarPuntaje();
		assertEquals(1, jugador.getPuntaje());
	}

	@Test
	public void testGetNivelActual() {
		assertEquals(0, jugador.getNivelActual());
	}

	@Test
	public void testSetNivelActual() {
		jugador.setNivelActual(1);
		assertEquals(1, jugador.getNivelActual());
	}

	@Test
	public void testGetPreguntaActual() {
		assertEquals(0, jugador.getPreguntaActual());
	}

	@Test
	public void testSetPreguntaActual() {
		jugador.setPreguntaActual(1);
		assertEquals(1, jugador.getPreguntaActual());
	}

	@Test
	public void testReiniciarJugador() {
		jugador.setPuntaje(10);
		jugador.setNivelActual(1);
		jugador.setPreguntaActual(2);
		jugador.reiniciarJugador();

		assertEquals(0, jugador.getPuntaje());
		assertEquals(0, jugador.getNivelActual());
		assertEquals(0, jugador.getPreguntaActual());
	}

	@Test
	public void testYaJugo() {
		assertFalse(jugador.yaJugo());
	}

	@Test
	public void testSetJugo() {
		jugador.setJugo(true);
		assertTrue(jugador.yaJugo());
	}

}
