package Prueba;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import logic.Usuario;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTestCase {

	private Usuario usuario;

    @Before
    public void setUp() {
        usuario = new UsuarioConcreto("Usuario1", "Contraseña1");
    }

    @Test
    public void testGetNombre() {
        assertEquals("Usuario1", usuario.getNombre());
    }

    @Test
    public void testSetNombre() {
        usuario.setNombre("Usuario2");
        assertEquals("Usuario2", usuario.getNombre());
    }

    @Test
    public void testSetNombreNull() {
        try {
            usuario.setNombre(null);
            fail("Debería haber lanzado una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("El nombre no puede estar vacío o contener solo espacios.", e.getMessage());
        }
    }

    @Test
    public void testSetNombreVacio() {
        try {
            usuario.setNombre("");
            fail("Debería haber lanzado una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("El nombre no puede estar vacío o contener solo espacios.", e.getMessage());
        }
    }

    @Test
    public void testSetNombreEspacios() {
        try {
            usuario.setNombre("   ");
            fail("Debería haber lanzado una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("El nombre no puede estar vacío o contener solo espacios.", e.getMessage());
        }
    }

    @Test
    public void testGetContrasena() {
        assertEquals("Contraseña1", usuario.getContrasena());
    }

    @Test
    public void testSetContrasena() {
        usuario.setContrasena("Contraseña2");
        assertEquals("Contraseña2", usuario.getContrasena());
    }

    @Test
    public void testSetContrasenaNull() {
        try {
            usuario.setContrasena(null);
            fail("Debería haber lanzado una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("La contraseña no puede estar vacía o contener solo espacios.", e.getMessage());
        }
    }

    @Test
    public void testSetContrasenaVacia() {
        try {
            usuario.setContrasena("");
            fail("Debería haber lanzado una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("La contraseña no puede estar vacía o contener solo espacios.", e.getMessage());
        }
    }

    @Test
    public void testSetContrasenaEspacios() {
        try {
            usuario.setContrasena("   ");
            fail("Debería haber lanzado una excepción IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("La contraseña no puede estar vacía o contener solo espacios.", e.getMessage());
        }
    }
    
    // Clase de prueba concreta que extiende la clase abstracta Usuario
    private class UsuarioConcreto extends Usuario {
        public UsuarioConcreto(String nombre, String contrasena) {
            super(nombre, contrasena);
        }
    }

}
