package gui_Jugador;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;

import logic.Jugador;
import logic.Juego;
import logic.Nivel;
import logic.Pregunta;
import logic.Respuesta;

import javax.swing.JLabel;

import auxiliar.Iconeable;
import auxiliar.PanelConFondo;
import auxiliar.PanelDeOpciones;
import auxiliar.TablaDePosiciones;

import java.awt.SystemColor;
import java.io.FileInputStream;

import javax.swing.UIManager;

import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;

@SuppressWarnings("unused")
public class Menu extends JFrame implements Iconeable {
	
	// Declaración de variables
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private static final long serialVersionUID = 1L;
	private PanelConFondo contentPane;
	private JButton btnJugar;
	private JButton btnOpciones;
	private JButton btnSalir;
	private JButton btnRanking;
	private JLabel label;
	private Jugador JugadorActual;
	private JButton btnCerrarSesion;
	private JButton btnCreditos;
	private AdvancedPlayer player;
	private FileInputStream file;
	private Thread musicThread;
	private boolean detenido;
	
	// Constructor
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public Menu(Jugador user) {
		setFont(new Font("Arial", Font.BOLD, 14));
		setForeground(Color.GRAY);
		setResizable(false);
		setTitle("CODE QUEST");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 460);
		contentPane = new PanelConFondo();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.cambiarFoto(0);
		contentPane.setForeground(Color.BLACK);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnJugar());
		contentPane.add(getBtnOpciones());
		contentPane.add(getBtnSalir());
		contentPane.add(getBtnRanking());
		contentPane.add(getLabel());
		contentPane.add(getBtnCerrarSesin());
		contentPane.add(getBtnCreditos());
		setLocationRelativeTo(null);		
		setUndecorated(true);
		JugadorActual = user;
		detenido = false;
		musica();
	}

	// --------------------------------------------------------------
	public void changeBackgroundOfFondoPanel(PanelConFondo fondoPanel, int index) {
		fondoPanel.cambiarFoto(index);
	}

	// Inicialización de componentes
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("CodeQuest");
			label.setForeground(Color.CYAN);
			label.setFont(new Font("Tahoma", Font.PLAIN, 40));
			label.setBounds(10, 11, 219, 105);
		}
		return label;
	}

	// Función del botón jugar
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private JButton getBtnJugar() {
		if (btnJugar == null) {
			btnJugar = new JButton("Jugar", icon);
			btnJugar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnJugar.setVerticalTextPosition(SwingConstants.CENTER);
			btnJugar.setBackground(new Color(25, 25, 112));
			btnJugar.setToolTipText("");
			btnJugar.setForeground(Color.CYAN);
			btnJugar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnJugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Jugador u = Juego.getInstance().jugadorContinuado(
							JugadorActual);
					if (u != null) {
						JugadorActual = u;
					}
					int maxNiveles = Juego.getInstance().getNiveles().size();
					int maxPreguntas = Juego.getInstance().getNiveles()
							.get(Juego.getInstance().getNiveles().size() - 1)
							.getPreguntas().size();

					if (JugadorActual.getNivelActual() == maxNiveles
							&& JugadorActual.getPreguntaActual() == maxPreguntas
							|| JugadorActual.yaJugo()) {
						PanelDeOpciones continuar = new PanelDeOpciones(
								Menu.this, Juego.getInstance()
										.jugadorYaTermino(JugadorActual));
						continuar.setVisible(true);
					} else {
						iniciarJuego(); // Método para iniciar el juego
					}
				}
			});
			btnJugar.setBounds(38, 127, 128, 23);
		}
		return btnJugar;
	}

	// Método para reiniciar el juego
	public void reiniciarJuego() {
		// Lógica para reiniciar el juego
		JugadorActual.reiniciarJugador();
		iniciarJuego();
	}

	// Método para continuar el juego
	public void continuarJuego() {
		// Lógica para continuar el juego desde donde se quedó
		iniciarJuego();
	}

	// Método para iniciar el juego
	private void iniciarJuego() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cuestionario frame = new Cuestionario(Menu.this, Juego
							.getInstance(), JugadorActual);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		setVisible(false);
	}

	// Función del botón opciones
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	private JButton getBtnOpciones() {
		if (btnOpciones == null) {
			btnOpciones = new JButton("Opciones", icon);
			btnOpciones.setForeground(Color.CYAN);
			btnOpciones.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnOpciones.setHorizontalTextPosition(SwingConstants.CENTER);
			btnOpciones.setVerticalTextPosition(SwingConstants.CENTER);
			btnOpciones.setBackground(new Color(72, 61, 139));
			btnOpciones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Opciones frame = new Opciones(Menu.this);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					setVisible(false);
				}
			});
			btnOpciones.setBounds(38, 235, 128, 23);
		}
		return btnOpciones;
	}

	// Función del botón Ranking
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	private JButton getBtnRanking() {
		if (btnRanking == null) {
			btnRanking = new JButton("Ranking", icon);
			btnRanking.setForeground(Color.CYAN);
			btnRanking.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnRanking.setHorizontalTextPosition(SwingConstants.CENTER);
			btnRanking.setVerticalTextPosition(SwingConstants.CENTER);
			btnRanking.setBackground(new Color(72, 61, 139));
			btnRanking.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					TablaDePosiciones ranking = new TablaDePosiciones(Menu.this, Juego
							.getInstance().getJugadores());
					ranking.setVisible(true);
				}
			});
			btnRanking.setBounds(38, 181, 128, 23);
		}
		return btnRanking;
	}

	// Función del botón salir
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir", icon);
			btnSalir.setForeground(Color.CYAN);
			btnSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
			btnSalir.setVerticalTextPosition(SwingConstants.CENTER);
			btnSalir.setBackground(new Color(72, 61, 139));
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			btnSalir.setBounds(38, 397, 128, 23);
		}
		return btnSalir;
	}

	private JButton getBtnCerrarSesin() {
		if (btnCerrarSesion == null) {
			btnCerrarSesion = new JButton("Cerrar sesi\u00F3n", icon);
			btnCerrarSesion.setForeground(Color.CYAN);
			btnCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnCerrarSesion.setHorizontalTextPosition(SwingConstants.CENTER);
			btnCerrarSesion.setVerticalTextPosition(SwingConstants.CENTER);
			btnCerrarSesion.setBackground(new Color(72, 61, 139));
			btnCerrarSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					InicioSesion e = new InicioSesion();
					e.setVisible(true);
					detenerMusica();
					dispose();
				}
			});
			btnCerrarSesion.setBounds(38, 343, 128, 23);
		}
		return btnCerrarSesion;
	}

	private JButton getBtnCreditos() {
		if (btnCreditos == null) {
			btnCreditos = new JButton("Cr\u00E9ditos", icon);
			btnCreditos.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnCreditos.setHorizontalTextPosition(SwingConstants.CENTER);
			btnCreditos.setVerticalTextPosition(SwingConstants.CENTER);
			btnCreditos.setForeground(Color.CYAN);
			btnCreditos.setBackground(new Color(72, 61, 139));
			btnCreditos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Creditos c = new Creditos(Menu.this);
					c.setVisible(true);
					setVisible(false);
				}
			});
			btnCreditos.setBounds(38, 289, 128, 23);
		}
		return btnCreditos;
	}

	// Función de reproducir música
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void musica() {
		musicThread = new Thread(new Runnable() {
			public void run() {
				try {
					while (!detenido) {
						file = new FileInputStream(
								"src\\media\\Lofi Hip Hop _192kbps.mp3");
						player = new AdvancedPlayer(file);
						player.play();
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		musicThread.start();
	}

	public void detenerMusica() {
		if (player != null) {
			player.close();
			detenido = true;
			musicThread.interrupt();
		}
	}

	public void continuar() {
		detenido = false;
	}

	public boolean isMusicPlaying() {
		return player != null && musicThread.isAlive();
	}

	public Jugador getJugador() {
		return JugadorActual;
	}

}
