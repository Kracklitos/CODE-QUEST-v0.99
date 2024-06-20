package gui_Jugador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.swing.Timer;
import javax.swing.ButtonGroup;

import logic.Jugador;
import logic.Juego;
import logic.Nivel;
import logic.Pregunta;

import javax.swing.JProgressBar;

import auxiliar.Iconeable;
import auxiliar.NotaInformativa;
import auxiliar.PanelConFondo;
import auxiliar.Prevencion2;
import auxiliar.Prevencion3;

import java.awt.Font;

@SuppressWarnings("unused")
public class Cuestionario extends JFrame implements Iconeable {

	// Declaración de variables
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 9125176325463985246L;
	private PanelConFondo contentPane;
	private JLabel lblNivel;
	private JLabel lblPreguntaNum;
	private JLabel lblPregunta;
	private JRadioButton rdbtnRespuesta1;
	private JRadioButton rdbtnRespuesta2;
	private JRadioButton rdbtnRespuesta3;
	private JRadioButton rdbtnRespuesta4;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ArrayList<JRadioButton> radioButtons = new ArrayList<JRadioButton>();
	private JLabel lblPuntaje;
	private JLabel lblPuntos;
	private Juego juego;
	private JProgressBar progressBar;
	private Menu menu;

	// temporizador
	private Timer temporizador;
	private int tiempoTotal = 0;
	private int incremento = 1;

	// Constructor
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public Cuestionario(Menu menu, Juego juego, Jugador user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 460);
		contentPane = new PanelConFondo();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.cambiarFoto(4);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNivel());
		contentPane.add(getLblPreguntaNum());
		contentPane.add(getLblPregunta());
		contentPane.add(getRdbtnRespuesta1());
		contentPane.add(getRdbtnRespuesta2());
		contentPane.add(getRdbtnRespuesta3());
		contentPane.add(getRdbtnRespuesta4());
		contentPane.add(getBtnAceptar());
		contentPane.add(getBtnCancelar());
		contentPane.add(getLblPuntaje());
		contentPane.add(getLblPuntos());
		contentPane.add(getProgressBar());
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		setJuego(juego);
		juego.setJugador(user);
		juego.inicioSesion(user);
		actualizarJuego();
		lblPuntos
				.setText(String.valueOf(juego.getJugadorActual().getPuntaje()));
		this.menu = menu;

	}

	// Inicialización de componentes
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private JLabel getLblNivel() {
		if (lblNivel == null) {
			lblNivel = new JLabel("Nivel");
			lblNivel.setForeground(Color.CYAN);
			lblNivel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNivel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNivel.setBounds(10, 32, 202, 14);
		}
		return lblNivel;
	}

	private JLabel getLblPreguntaNum() {
		if (lblPreguntaNum == null) {
			lblPreguntaNum = new JLabel("Pregunta Num");
			lblPreguntaNum.setForeground(Color.CYAN);
			lblPreguntaNum.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblPreguntaNum.setHorizontalAlignment(SwingConstants.CENTER);
			lblPreguntaNum.setBounds(327, 32, 218, 14);
		}
		return lblPreguntaNum;
	}

	private JLabel getLblPregunta() {
		if (lblPregunta == null) {
			lblPregunta = new JLabel("Pregunta");
			lblPregunta.setForeground(Color.YELLOW);
			lblPregunta.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblPregunta.setHorizontalAlignment(SwingConstants.CENTER);
			lblPregunta.setBounds(69, 124, 430, 29);
		}
		return lblPregunta;
	}

	private JRadioButton getRdbtnRespuesta1() {
		if (rdbtnRespuesta1 == null) {
			rdbtnRespuesta1 = new JRadioButton("");
			rdbtnRespuesta1.setOpaque(false);
			rdbtnRespuesta1.setFont(new Font("Tahoma", Font.BOLD, 13));
			rdbtnRespuesta1.setForeground(Color.YELLOW);
			buttonGroup.add(rdbtnRespuesta1);
			radioButtons.add(rdbtnRespuesta1);
			rdbtnRespuesta1.setBounds(69, 185, 430, 23);
		}
		return rdbtnRespuesta1;
	}

	private JRadioButton getRdbtnRespuesta2() {
		if (rdbtnRespuesta2 == null) {
			rdbtnRespuesta2 = new JRadioButton("");
			rdbtnRespuesta2.setOpaque(false);
			rdbtnRespuesta2.setForeground(Color.YELLOW);
			rdbtnRespuesta2.setFont(new Font("Tahoma", Font.BOLD, 13));
			buttonGroup.add(rdbtnRespuesta2);
			radioButtons.add(rdbtnRespuesta2);
			rdbtnRespuesta2.setBounds(69, 240, 430, 23);
		}
		return rdbtnRespuesta2;
	}

	private JRadioButton getRdbtnRespuesta3() {
		if (rdbtnRespuesta3 == null) {
			rdbtnRespuesta3 = new JRadioButton("");
			rdbtnRespuesta3.setOpaque(false);
			rdbtnRespuesta3.setForeground(Color.YELLOW);
			rdbtnRespuesta3.setFont(new Font("Tahoma", Font.BOLD, 13));
			buttonGroup.add(rdbtnRespuesta3);
			radioButtons.add(rdbtnRespuesta3);
			rdbtnRespuesta3.setBounds(69, 295, 430, 23);
		}
		return rdbtnRespuesta3;
	}

	private JRadioButton getRdbtnRespuesta4() {
		if (rdbtnRespuesta4 == null) {
			rdbtnRespuesta4 = new JRadioButton("");
			rdbtnRespuesta4.setOpaque(false);
			rdbtnRespuesta4.setForeground(Color.YELLOW);
			rdbtnRespuesta4.setFont(new Font("Tahoma", Font.BOLD, 13));
			buttonGroup.add(rdbtnRespuesta4);
			radioButtons.add(rdbtnRespuesta4);
			rdbtnRespuesta4.setBounds(69, 350, 430, 23);
		}
		return rdbtnRespuesta4;
	}

	private JLabel getLblPuntaje() {
		if (lblPuntaje == null) {
			lblPuntaje = new JLabel("Puntaje :");
			lblPuntaje.setForeground(Color.CYAN);
			lblPuntaje.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblPuntaje.setBounds(89, 78, 89, 14);
		}
		return lblPuntaje;
	}

	private JLabel getLblPuntos() {
		if (lblPuntos == null) {
			lblPuntos = new JLabel();
			lblPuntos.setForeground(new Color(0, 255, 255));
			lblPuntos.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblPuntos.setBounds(283, 78, 62, 14);
		}
		return lblPuntos;
	}

	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setForeground(Color.RED);
			progressBar.setBackground(Color.WHITE);
			progressBar.setBounds(372, 78, 146, 14);
		}
		return progressBar;
	}

	// Función del botón aceptar
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar", icon);
			btnAceptar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnAceptar.setVerticalTextPosition(SwingConstants.CENTER);
			btnAceptar.setForeground(Color.CYAN);
			btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					temporizador.stop();
					if (tiempoTotal != 100) {

						if (revisarRespuesta()) {
							siguientePregunta();
						} else {
							Toolkit.getDefaultToolkit().beep();
							Prevencion2 pre = new Prevencion2(Cuestionario.this,"Debe seleccionar una respuesta");
							pre.setVisible(true);
						}
					} else
						siguientePregunta();
				}
			});
			btnAceptar.setBounds(125, 405, 97, 23);
		}
		return btnAceptar;
	}

	// Función para revisar si la respuesta seleccionada es la correcta o no y
	// dar retroalimentación
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private boolean revisarRespuesta() {
		boolean selected = false;
		if (isAnswerSelected()) {
			selected = true;
			if (checkAnswer()) {
				juego.getJugadorActual().incrementarPuntaje();
				updateScore();
				Toolkit.getDefaultToolkit().beep();
				NotaInformativa nota = new NotaInformativa("Respuesta correcta");
				nota.setVisible(true);
			} else {
				markCorrectAnswer();
				Toolkit.getDefaultToolkit().beep();				
				NotaInformativa nota = new NotaInformativa("Respuesta incorrecta");
				nota.setVisible(true);
			}
		}
		return selected;
	}

	// Función para pasar a la siguiente pregunta
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void siguientePregunta() {
		if (juego.getNiveles().get(juego.getNivelActual()).getPreguntas()
				.size() - 1 == juego.getPreguntaActual()) {
			if (juego.getNiveles().size() - 1 == juego.getNivelActual()) {
				Toolkit.getDefaultToolkit().beep();
				try {
					juego.cierreSesion(juego.getJugadorActual());
					juego.getJugadorActual().setNivelActual(
							juego.getNivelActual() + 1);
					juego.getJugadorActual().setPreguntaActual(
							juego.getPreguntaActual() + 1);
					Resultados dialog = new Resultados(menu,
							juego.getJugadorActual());
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				juego.cerrarJuego();
				dispose();
			} else {
				juego.setPreguntaActual(0);
				juego.setNivelActual(juego.getNivelActual() + 1);
				NotaInformativa nota = new NotaInformativa("Felicidades has completado el nivel");
				nota.setVisible(true);
				actualizarJuego();
				clearSelection();
			}
		} else {
			setPreguntaActual(juego.getPreguntaActual() + 1);
			actualizarJuego();
			temporizador.restart();
			clearSelection();
		}
	}

	// Función del botón cancelar
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar", icon);
			btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnCancelar.setVerticalTextPosition(SwingConstants.CENTER);
			btnCancelar.setForeground(Color.CYAN);
			btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					juego.cierreSesion(juego.getJugadorActual());
					temporizador.stop();
					Juego.getInstance().cerrarJuego();
					dispose();
					menu.setVisible(true);
				}
			});
			btnCancelar.setBounds(347, 405, 97, 23);
		}
		return btnCancelar;
	}

	// Set instancia de juego usando los patrones especificados
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	private void setJuego(Juego juego) {
		if (juego != null) {
			this.juego = juego;
		} else
			throw new IllegalArgumentException("El juego no puede estar vacío");
	}

	// Función para actualizar el juego en la pantalla junto a sus componentes
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private void actualizarJuego() {

		Nivel nivel = juego.getNiveles().get(juego.getNivelActual());
		Pregunta pregunta = nivel.getPreguntas().get(juego.getPreguntaActual());
		lblNivel.setText("Nivel " + (juego.getNivelActual() + 1));
		lblPreguntaNum.setText("Pregunta: " + (juego.getPreguntaActual() + 1));
		lblPregunta.setText(pregunta.getPregunta());
		for (int i = 0; i < radioButtons.size(); i++) {
			radioButtons.get(i).setText(
					pregunta.getRespuestas().get(i).getTexto());
		}
		iniciarProgreso();
		limpiarRadioButtons();
		habilitarRadioButtons();

	}

	// Función para actualizar el puntaje del jugador
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private void updateScore() {
		int n = juego.getJugadorActual().getPuntaje();
		String punto = Integer.toString(n);
		lblPuntos.setText(punto);
	}

	// Función para revisar si está seleccionado alguna respuesta
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private boolean isAnswerSelected() {
		boolean marcada = false;
		for (int i = 0; i < radioButtons.size(); i++) {
			if (radioButtons.get(i).isSelected()) {
				marcada = true;
			}
		}
		return marcada;
	}

	// Función para revisar si la respuesta está correcta
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private boolean checkAnswer() {
		Nivel nivel = juego.getNiveles().get(juego.getNivelActual());
		Pregunta pregunta = nivel.getPreguntas().get(juego.getPreguntaActual());
		int respuestaSeleccionada = -1;
		int respuestaCorrecta = pregunta.getRespuestaCorrecta();
		boolean seleccionada = false;

		for (int i = 0; i < radioButtons.size() && !seleccionada; i++) {
			if (radioButtons.get(i).isSelected()) {
				respuestaSeleccionada = i;
				if (i != respuestaCorrecta) {
					radioButtons.get(i).setForeground(Color.RED);
				} else if (i == respuestaCorrecta) {
					radioButtons.get(i).setForeground(Color.GREEN);
				}
				seleccionada = true;
			}
		}

		return pregunta.getRespuestaCorrecta() == respuestaSeleccionada ? true
				: false;
	}

	// Función para marcar respuesta correcta en verde
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private void markCorrectAnswer() {
		Nivel nivel = juego.getNiveles().get(juego.getNivelActual());
		Pregunta pregunta = nivel.getPreguntas().get(juego.getPreguntaActual());
		int respuestaCorrecta = pregunta.getRespuestaCorrecta();

		for (int i = 0; i < radioButtons.size(); i++) {
			if (i == respuestaCorrecta) {
				radioButtons.get(i).setForeground(Color.GREEN);
			}
		}
	}

	// función para limpiar la selección hecha
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private void clearSelection() {
		for (int i = 0; i < radioButtons.size(); i++) {
			radioButtons.get(i).setForeground(Color.YELLOW);
		}
	}

	// Set de la pregunta actual con la que se está trabajando
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private void setPreguntaActual(int index) {
		juego.setPreguntaActual(index);
	}

	// Función para iniciar el temporizador en pantalla
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	private void iniciarProgreso() {
		tiempoTotal = 0;
		temporizador = new Timer(200, new ActionListener() {
			int progreso = 0;

			public void actionPerformed(ActionEvent e) {
				progreso += incremento;
				progressBar.setValue(progreso);

				if (progreso >= 100) {
					tiempoTotal = 100;
					temporizador.stop();
					if (isAnswerSelected()) {
						revisarRespuesta();
						siguientePregunta();
					} else {
						deshabilitarRadioButtons();
						Toolkit.getDefaultToolkit().beep();
						Prevencion3 pre = new Prevencion3(Cuestionario.this,"Se acabó el tiempo");
						pre.setVisible(true);
						siguientePregunta();
		
					}
				}
			}
		});

		temporizador.start();
	}

	// Funciones de agrupar radiobuttons
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private void deshabilitarRadioButtons() {
		for (JRadioButton j : radioButtons) {
			j.setEnabled(false);

		}
	}

	private void habilitarRadioButtons() {
		for (JRadioButton j : radioButtons) {
			j.setEnabled(true);

		}
	}

	private void limpiarRadioButtons() {
		for (JRadioButton j : radioButtons) {
			if (j.isSelected())
				j.setSelected(false);

		}
		buttonGroup.clearSelection();
	}

	public void temporizador() {
		temporizador.start();
	}
}
