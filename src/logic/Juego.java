package logic;

import java.util.ArrayList;

import auxiliar.NotaInformativa;

@SuppressWarnings("unused")
public class Juego {
	private ArrayList<Usuario> usuarios;
	private ArrayList<Nivel> niveles;
	private int nivelActual = 0;
	private int preguntaActual = 0;
	private Jugador usuarioActual = null;

	private static Juego juego = null;

	public static Juego getInstance() {
		if (juego == null) {
			juego = crearJuego();
		}
		return juego;
	}

	private Juego(ArrayList<Nivel> niveles) {
		setNiveles(niveles);
		usuarios = new ArrayList<Usuario>();
	}

	public ArrayList<Usuario> getJugadores() {
		return usuarios;
	}

	public void setJugadores(ArrayList<Usuario> jugadores) {
		this.usuarios = jugadores;
	}

	public Jugador getJugadorActual() {
		return usuarioActual;
	}

	public void setJugadorActual(Jugador jugadorActual) {
		this.usuarioActual = jugadorActual;
	}

	public int getNivelActual() {
		return nivelActual;
	}

	public void setNivelActual(int nivelActual) {
		this.nivelActual = nivelActual;
	}

	public int getPreguntaActual() {
		return preguntaActual;
	}

	public void setPreguntaActual(int preguntaActual) {
		this.preguntaActual = preguntaActual;
	}

	public ArrayList<Nivel> getNiveles() {
		return niveles;
	}

	public void setJugador(Usuario jugador) {
		if (jugador instanceof Jugador) {
			Jugador jugadorCasteado = (Jugador) jugador; // Casteo a Jugador
			jugadorCasteado.setJugo(true);
			usuarioActual = jugadorCasteado;
			agregarJugador(jugadorCasteado);
		}

	}

	public void setNiveles(ArrayList<Nivel> niveles) {
		if (!niveles.isEmpty() && niveles.size() > 0) {
			this.niveles = niveles;
		} else
			throw new IllegalArgumentException("Debe haber mínimo un nivel.");

	}

	public void agregarNivel(Nivel nivel) {
		if (!niveles.contains(nivel) && nivel != null && !addPregunta(nivel.getPreguntas())) {
			niveles.add(nivel);
		} else
			throw new IllegalArgumentException(
					"El nivel no puede estar vacío ni estar repetido.");
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

	public boolean eliminarNivel(int indice) {
		boolean posible = false;
		if (Juego.juego.getNiveles().size() - 1 > 0) {
			niveles.remove(indice);
			posible = true;
		}
		return posible;
	}

	public void modificarNivel(Nivel nivel, int indice) {
		if (nivel != null) {
			niveles.set(indice, nivel);
		} else
			throw new IllegalArgumentException(
					"El nivel no puede estar vacío y debe estar definido.");
	}

	public boolean agregarJugador(Usuario usuario) {
		boolean agregado = false;
		if (!usuarios.contains(usuario) && usuario != null) {
			for (Usuario user : usuarios) {
				if (user.getNombre().equalsIgnoreCase(usuario.getNombre())) {
					agregado = true;
				}
			}
			if (!agregado) {
				usuarios.add((Jugador) usuario);
			}
		}
		return agregado;
	}

	public Jugador jugadorContinuado(Jugador jugador) {
		Usuario user = null;
		if (agregarJugador(jugador)) {
			int indice = buscarJugador(jugador);
			user = usuarios.get(indice);
		}
		return (Jugador) user;
	}

	private int buscarJugador(Jugador jugador) {
		int indice = -1;
		for (Usuario user : usuarios) {
			if (user.getNombre().equalsIgnoreCase(jugador.getNombre())) {
				indice = usuarios.indexOf(user);
			}
		}
		return indice;
	}

	public void cerrarJuego() {
		guardarProgreso();
		usuarioActual = null;
		nivelActual = 0;
		preguntaActual = 0;
	}

	public void guardarProgreso() {
		int indice = usuarios.indexOf(usuarioActual);
		usuarios.set(indice, usuarioActual);
	}

	public boolean verificarRespuesta(int respuestaSeleccionada) {
		Nivel nivel = niveles.get(nivelActual);
		Pregunta pregunta = nivel.getPreguntas().get(preguntaActual);

		return pregunta.getRespuestaCorrecta() == respuestaSeleccionada;
	}

	public boolean jugadorYaTermino(Jugador jugador) {
		boolean completo = false;
		int maxNiveles = getNiveles().size();
		int maxPreguntas = getNiveles()
				.get(Juego.juego.getNiveles().size() - 1).getPreguntas().size();

		if (jugador.getNivelActual() == maxNiveles
				&& jugador.getPreguntaActual() == maxPreguntas)
			completo = true;
		return completo;
	}

	public void inicioSesion(Jugador jugador) {
		setNivelActual(jugador.getNivelActual());
		setPreguntaActual(jugador.getPreguntaActual());
	}

	public void cierreSesion(Jugador jugador) {
		jugador.setNivelActual(nivelActual);
		jugador.setPreguntaActual(preguntaActual);
	}

	// Inicialización de un Juego por Default
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private static Juego crearJuego() {
		ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
		Respuesta respuesta1 = new Respuesta("int = 5;", true);
		Respuesta respuesta2 = new Respuesta("double a = 3;", false);
		Respuesta respuesta3 = new Respuesta("char a = 'A';", false);
		Respuesta respuesta4 = new Respuesta("float a = 5.56f;", false);
		respuestas.add(respuesta1);
		respuestas.add(respuesta2);
		respuestas.add(respuesta3);
		respuestas.add(respuesta4);
		Pregunta pregunta1 = new Pregunta(
				"¿Cuál es una declaración incorrecta de variables?",
				respuestas, 0);
		// 2da Pregunta
		ArrayList<Respuesta> respuestas1 = new ArrayList<Respuesta>();
		Respuesta respuesta5 = new Respuesta(
				"for (int i=0, i<10, i++){//Code here...}", false);
		Respuesta respuesta6 = new Respuesta("for (int i=0; i<10; i++);", false);
		Respuesta respuesta7 = new Respuesta(
				"for (int i=0; i<10; i++){//Code here...}", true);
		Respuesta respuesta8 = new Respuesta("for (i<10; i++){//Code here...}",
				false);
		respuestas1.add(respuesta5);
		respuestas1.add(respuesta6);
		respuestas1.add(respuesta7);
		respuestas1.add(respuesta8);
		Pregunta pregunta2 = new Pregunta(
				"¿Cuál es una declaración correcta de una sentencia for?",
				respuestas1, 2);

		// 3ra Pregunta
		ArrayList<Respuesta> respuestas2 = new ArrayList<Respuesta>();
		Respuesta respuesta9 = new Respuesta("2.5", false);
		Respuesta respuesta10 = new Respuesta("2", true);
		Respuesta respuesta11 = new Respuesta("3.5", false);
		Respuesta respuesta12 = new Respuesta("2.0", false);
		respuestas2.add(respuesta9);
		respuestas2.add(respuesta10);
		respuestas2.add(respuesta11);
		respuestas2.add(respuesta12);
		Pregunta pregunta3 = new Pregunta(
				"Si int a=5 y int b=2,¿qué retorna a/b?", respuestas2, 1);
		// 4ta Pregunta
		ArrayList<Respuesta> respuestas3 = new ArrayList<Respuesta>();
		Respuesta respuesta13 = new Respuesta(
				"Devuelve la longitud del arreglo", false);
		Respuesta respuesta14 = new Respuesta(
				"Convierte a cadena de caracteres un arreglo", false);
		Respuesta respuesta15 = new Respuesta(
				"Ordena los elementos del arreglo en orden descendente", false);
		Respuesta respuesta16 = new Respuesta(
				"Ordena los elementos del arreglo en orden ascendente", true);
		respuestas3.add(respuesta13);
		respuestas3.add(respuesta14);
		respuestas3.add(respuesta15);
		respuestas3.add(respuesta16);
		Pregunta pregunta4 = new Pregunta("¿Qué hace el método Arrays.sort()?",
				respuestas3, 3);
		// 5ta Pregunta
		ArrayList<Respuesta> respuestas4 = new ArrayList<Respuesta>();
		Respuesta respuesta17 = new Respuesta("int[] numbers = {1,2,3};", true);
		Respuesta respuesta18 = new Respuesta("array numbers = [1,2,3];", false);
		Respuesta respuesta19 = new Respuesta("int numbers[3] = {1,2,3};",
				false);
		Respuesta respuesta20 = new Respuesta("ArrayList numbers = {1,2,3};",
				false);
		respuestas4.add(respuesta17);
		respuestas4.add(respuesta18);
		respuestas4.add(respuesta19);
		respuestas4.add(respuesta20);
		Pregunta pregunta5 = new Pregunta(
				"¿Cuál es una declaración correcta de un arreglo en Java?",
				respuestas4, 0);
		// Crear colección de preguntas
		ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
		preguntas.add(pregunta1);
		preguntas.add(pregunta2);
		preguntas.add(pregunta3);
		preguntas.add(pregunta4);
		preguntas.add(pregunta5);

		// Siguiente nivel
		// 1ra Pregunta
		ArrayList<Respuesta> resps = new ArrayList<Respuesta>();
		Respuesta resp = new Respuesta("void", false);
		Respuesta resp1 = new Respuesta("class", true);
		Respuesta resp2 = new Respuesta("new", false);
		Respuesta resp3 = new Respuesta("public", false);
		resps.add(resp);
		resps.add(resp1);
		resps.add(resp2);
		resps.add(resp3);
		Pregunta preg = new Pregunta(
				"¿Qué palabra clave se utiliza para definir una clase en Java?",
				resps, 1);
		// 2da Pregunta
		ArrayList<Respuesta> resps2 = new ArrayList<Respuesta>();
		Respuesta resp4 = new Respuesta(
				"Inicializar los atributos de la clase", true);
		Respuesta resp5 = new Respuesta("Definir los métodos de la clase",
				false);
		Respuesta resp6 = new Respuesta("Crear nuevas instancias de la clase",
				false);
		Respuesta resp7 = new Respuesta("Manejar las excepciones de la clase",
				false);
		resps2.add(resp4);
		resps2.add(resp5);
		resps2.add(resp6);
		resps2.add(resp7);
		Pregunta preg2 = new Pregunta(
				"¿Cuál es el propósito del constructor en una clase en Java?",
				resps2, 0);
		// 3ra Pregunta
		ArrayList<Respuesta> resps3 = new ArrayList<Respuesta>();
		Respuesta resp8 = new Respuesta("Un tipo de dato primitivo", false);
		Respuesta resp9 = new Respuesta("Una instancia de un objeto", false);
		Respuesta resp10 = new Respuesta("Un bloque de código reutilizable",
				false);
		Respuesta resp11 = new Respuesta(
				"Es un molde para la creación de objetos.", true);
		resps3.add(resp8);
		resps3.add(resp9);
		resps3.add(resp10);
		resps3.add(resp11);
		Pregunta preg3 = new Pregunta("¿Qué es una clase en Java?", resps3, 3);
		// 4ta Pregunta
		ArrayList<Respuesta> resps4 = new ArrayList<Respuesta>();
		Respuesta resp12 = new Respuesta(
				"El contenido es accesible desde cualquier clase", false);
		Respuesta resp13 = new Respuesta(
				"El contenido es accesible desde cualquier clase y en subclases",
				false);
		Respuesta resp14 = new Respuesta(
				"El contenido solo es accesible en la clase que está definido",
				true);
		Respuesta resp15 = new Respuesta(
				"El contenido es accesible desde cualquier paquete", false);
		resps4.add(resp12);
		resps4.add(resp13);
		resps4.add(resp14);
		resps4.add(resp15);
		Pregunta preg4 = new Pregunta(
				"¿Qué indica el modificador de acceso 'private' en una clase?",
				resps4, 2);
		// 5ta Pregunta
		ArrayList<Respuesta> resps5 = new ArrayList<Respuesta>();
		Respuesta resp16 = new Respuesta(
				"Se refiere a la clase actual en la que se encuentra el código",
				true);
		Respuesta resp17 = new Respuesta(
				"Se refiere a la clase padre en una herencia", false);
		Respuesta resp18 = new Respuesta(
				"Se refiere a una instancia particular de una clase", false);
		Respuesta resp19 = new Respuesta(
				"Se refiere a una variable local en un método", false);
		resps5.add(resp16);
		resps5.add(resp17);
		resps5.add(resp18);
		resps5.add(resp19);
		Pregunta preg5 = new Pregunta(
				"¿Qué es la palabra clave 'this' en Java?", resps5, 0);
		// Coleccion de preguntas 2
		ArrayList<Pregunta> pregs = new ArrayList<Pregunta>();
		pregs.add(preg);
		pregs.add(preg2);
		pregs.add(preg3);
		pregs.add(preg4);
		pregs.add(preg5);
		// Siguiente nivel
		// 1ra Pregunta
		ArrayList<Respuesta> resptas = new ArrayList<Respuesta>();
		Respuesta res = new Respuesta(
				"Clase que no puede ser instanciada y sirve de base para otras",
				true);
		Respuesta res2 = new Respuesta(
				"Clase que no tiene atributos ni métodos", false);
		Respuesta res3 = new Respuesta(
				"Clase que solo puede heredar de una clase padre", false);
		Respuesta res4 = new Respuesta(
				"Clase que solo puede implementar una interfaz", false);
		resptas.add(res);
		resptas.add(res2);
		resptas.add(res3);
		resptas.add(res4);
		Pregunta prg = new Pregunta("¿Qué es una clase abstracta en Java?",
				resptas, 0);
		// 2da Pregunta
		ArrayList<Respuesta> resptas2 = new ArrayList<Respuesta>();
		Respuesta res5 = new Respuesta(
				"Que una clase implemente múltiples interfaces", false);
		Respuesta res6 = new Respuesta(
				"Que una clase herede atributos y métodos de otra clase", true);
		Respuesta res7 = new Respuesta(
				"Que una clase acceda atributos privados de otra clase", false);
		Respuesta res8 = new Respuesta(
				"Que una clase acceda a métodos privados de otra clase", false);
		resptas2.add(res5);
		resptas2.add(res6);
		resptas2.add(res7);
		resptas2.add(res8);
		Pregunta prg2 = new Pregunta("¿Qué es la herencia en Java?", resptas2,
				1);
		// 3ra Pregunta
		ArrayList<Respuesta> resptas3 = new ArrayList<Respuesta>();
		Respuesta res9 = new Respuesta(
				"La subclase es una instancia de la superclase", false);
		Respuesta res10 = new Respuesta(
				"La subclase solo hereda métodos de la superclase", false);
		Respuesta res11 = new Respuesta(
				"La subclase hereda atributos y métodos de la superclase", true);
		Respuesta res12 = new Respuesta(
				"La subclase puede sobrescribir los métodos de la superclase",
				false);
		resptas3.add(res9);
		resptas3.add(res10);
		resptas3.add(res11);
		resptas3.add(res12);
		Pregunta prg3 = new Pregunta(
				"¿Cuál es la relación entre superclase y subclase?", resptas3,
				2);
		// 4ta Pregunta
		ArrayList<Respuesta> resptas4 = new ArrayList<Respuesta>();
		Respuesta res13 = new Respuesta(
				"Se utiliza para crear una nueva instancia de una clase", false);
		Respuesta res14 = new Respuesta(
				"Se utiliza para definir una clase abstracta", false);
		Respuesta res15 = new Respuesta(
				"Se utiliza para implementar polimorfismo en Java", false);
		Respuesta res16 = new Respuesta(
				"Se utiliza para verificar si un objeto es instancia de una clase",
				true);
		resptas4.add(res13);
		resptas4.add(res14);
		resptas4.add(res15);
		resptas4.add(res16);
		Pregunta prg4 = new Pregunta(
				"¿Qué es la palabra clave 'instanceof' en Java?", resptas4, 3);
		// 5ta Pregunta
		ArrayList<Respuesta> resptas5 = new ArrayList<Respuesta>();
		Respuesta res17 = new Respuesta(
				"Una clase puede heredar atributos y métodos de otra clase",
				false);
		Respuesta res18 = new Respuesta(
				"Una clase puede implementar múltiples interfaces", false);
		Respuesta res19 = new Respuesta(
				"Una clase puede ocultar atributos y métodos de otras clases",
				false);
		Respuesta res20 = new Respuesta(
				"Una clase puede implementar diferente un método heredado",
				true);
		resptas5.add(res17);
		resptas5.add(res18);
		resptas5.add(res19);
		resptas5.add(res20);
		Pregunta prg5 = new Pregunta(
				"¿Qué es la sobrescritura de métodos en Java?", resptas5, 3);
		// Coleccion de preguntas 3
		ArrayList<Pregunta> prgs = new ArrayList<Pregunta>();
		prgs.add(prg);
		prgs.add(prg2);
		prgs.add(prg3);
		prgs.add(prg4);
		prgs.add(prg5);
		// Niveles
		ArrayList<Nivel> niveles = new ArrayList<Nivel>();
		// Nivel 1
		Nivel nivel1 = new Nivel(preguntas);
		niveles.add(nivel1);
		// Nivel 2
		Nivel nivel2 = new Nivel(pregs);
		niveles.add(nivel2);
		// Nivel 3
		Nivel nivel3 = new Nivel(prgs);
		niveles.add(nivel3);
		// Creación del juego
		Juego juego = new Juego(niveles);
		juego.agregarJugador(new Jugador("Lolito", "LOL"));
		return juego;
	}

}
