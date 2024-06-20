package Prueba;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import logic.Respuesta;

import org.junit.Before;
import org.junit.Test;

public class RespuestaTestCase {
	private Respuesta respuesta;

	@Before
	public void setUp() {
		respuesta = new Respuesta("Texto de prueba", true);
	}

	@Test
	public void testGetTexto() {
		assertEquals("Texto de prueba", respuesta.getTexto());
	}

	@Test
	public void testSetTexto() {
		respuesta.setTexto("Nuevo texto");
		assertEquals("Nuevo texto", respuesta.getTexto());
	}

	@Test
	public void testSetTextoNull() {
		try {
			respuesta.setTexto(null);
			fail("Debería haber lanzado una excepción IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals(
					"El texto no puede estar vacío ni contener solo espacios.",
					e.getMessage());
		}
	}

	@Test
	public void testSetTextoVacio() {
		try {
			respuesta.setTexto("");
			fail("Debería haber lanzado una excepción IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals(
					"El texto no puede estar vacío ni contener solo espacios.",
					e.getMessage());
		}
	}

	@Test
	public void testSetTextoEspacios() {
		try {
			respuesta.setTexto("   ");
			fail("Debería haber lanzado una excepción IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals(
					"El texto no puede estar vacío ni contener solo espacios.",
					e.getMessage());
		}
	}

	@Test
	public void testIsEsCorrecta() {
		assertTrue(respuesta.isEsCorrecta());
	}

	@Test
	public void testSetEsCorrecta() {
		respuesta.setEsCorrecta(false);
		assertFalse(respuesta.isEsCorrecta());
	}
}
