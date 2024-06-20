package gui_Administrador;

import gui_Jugador.InicioSesion;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import auxiliar.PanelConFondo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("unused")
public class PanelDeControl extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnEdicion;
	private JMenuItem mntmCerrarSesión;
	private JMenu mnAyuda;
	private JMenuItem mntmInformación;
	private JMenuItem mntmAgregarNivel;
	private JMenuItem mntmModificarNivel;
	private JMenuItem mntmEliminarNivel;
	private JMenu mnNivel;
	private JMenu mnPregunta;
	private JMenuItem mntmAgregarPregunta;
	private JMenuItem mntmModificarPregunta;
	private JMenuItem mntmEliminarPregunta;
	private PanelConFondo panel;
	private JMenuItem mntmCambiarContrasena;

	public PanelDeControl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 460);
		setJMenuBar(getMenuBar_1());
		setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setUndecorated(true);
		getContentPane().add(getPanel());

	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBorderPainted(false);
			menuBar.setBorder(new EmptyBorder(0, 0, 0, 0));
			menuBar.setFont(new Font("Tahoma", Font.BOLD, 13));
			menuBar.setBackground(Color.BLACK);
			menuBar.add(getMnArchivo());
			menuBar.add(getMnEdicion());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}

	private JMenu getMnArchivo() {
		if (mnArchivo == null) {
			mnArchivo = new JMenu("Archivo");
			mnArchivo.setBorder(new EmptyBorder(0, 0, 0, 0));
			mnArchivo.setBorderPainted(false);
			mnArchivo.setFont(new Font("Tahoma", Font.BOLD, 13));
			mnArchivo.setForeground(Color.CYAN);
			mnArchivo.setBackground(Color.BLACK);
			mnArchivo.add(getMntmCambiarContrasena());
			mnArchivo.add(getMntmCerrarSesión());
		}
		return mnArchivo;
	}

	private JMenu getMnEdicion() {
		if (mnEdicion == null) {
			mnEdicion = new JMenu("Edici\u00F3n");
			mnEdicion.setBorder(new EmptyBorder(0, 0, 0, 0));
			mnEdicion.setBorderPainted(false);
			mnEdicion.setFont(new Font("Tahoma", Font.BOLD, 13));
			mnEdicion.setForeground(Color.CYAN);
			mnEdicion.setBackground(Color.BLACK);
			mnEdicion.add(getMnNivel());
			mnEdicion.add(getMnPregunta());
		}
		return mnEdicion;
	}

	private JMenuItem getMntmCerrarSesión() {
		if (mntmCerrarSesión == null) {
			mntmCerrarSesión = new JMenuItem("Cerrar sesi\u00F3n");
			mntmCerrarSesión.setBorder(new EmptyBorder(0, 0, 0, 0));
			mntmCerrarSesión.setBorderPainted(false);
			mntmCerrarSesión.setFont(new Font("Tahoma", Font.BOLD, 13));
			mntmCerrarSesión.setForeground(Color.CYAN);
			mntmCerrarSesión.setBackground(Color.BLACK);
			mntmCerrarSesión.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					InicioSesion en = new InicioSesion();
					en.setVisible(true);
					dispose();
				}
			});
		}
		return mntmCerrarSesión;
	}

	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.setBorder(new EmptyBorder(0, 0, 0, 0));
			mnAyuda.setBorderPainted(false);
			mnAyuda.setFont(new Font("Tahoma", Font.BOLD, 13));
			mnAyuda.setForeground(Color.CYAN);
			mnAyuda.setBackground(Color.BLACK);
			mnAyuda.add(getMntmInformación());
		}
		return mnAyuda;
	}

	private JMenuItem getMntmInformación() {
		if (mntmInformación == null) {
			mntmInformación = new JMenuItem("Informaci\u00F3n");
			mntmInformación.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Ayuda a = new Ayuda();
					a.setVisible(true);
				}
			});
			mntmInformación.setBorder(new EmptyBorder(0, 0, 0, 0));
			mntmInformación.setBorderPainted(false);
			mntmInformación.setFont(new Font("Tahoma", Font.BOLD, 13));
			mntmInformación.setForeground(Color.CYAN);
			mntmInformación.setBackground(Color.BLACK);
		}
		return mntmInformación;
	}

	private JMenuItem getMenuItem_6() {
		if (mntmAgregarNivel == null) {
			mntmAgregarNivel = new JMenuItem("Agregar nivel");
			mntmAgregarNivel.setBorder(new EmptyBorder(0, 0, 0, 0));
			mntmAgregarNivel.setBorderPainted(false);
			mntmAgregarNivel.setFont(new Font("Tahoma", Font.BOLD, 13));
			mntmAgregarNivel.setForeground(Color.CYAN);
			mntmAgregarNivel.setBackground(Color.BLACK);
			mntmAgregarNivel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AgregarNivel an = new AgregarNivel(PanelDeControl.this);
					an.setVisible(true);
				}
			});
		}
		return mntmAgregarNivel;
	}

	private JMenuItem getMenuItem_7() {
		if (mntmModificarNivel == null) {
			mntmModificarNivel = new JMenuItem("Modificar nivel");
			mntmModificarNivel.setBorder(new EmptyBorder(0, 0, 0, 0));
			mntmModificarNivel.setBorderPainted(false);
			mntmModificarNivel.setFont(new Font("Tahoma", Font.BOLD, 13));
			mntmModificarNivel.setForeground(Color.CYAN);
			mntmModificarNivel.setBackground(Color.BLACK);
			mntmModificarNivel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EditarNivel ed = new EditarNivel(PanelDeControl.this);
					ed.setVisible(true);
				}
			});
		}
		return mntmModificarNivel;
	}

	private JMenuItem getMenuItem_8() {
		if (mntmEliminarNivel == null) {
			mntmEliminarNivel = new JMenuItem("Eliminar nivel");
			mntmEliminarNivel.setBorder(new EmptyBorder(0, 0, 0, 0));
			mntmEliminarNivel.setBorderPainted(false);
			mntmEliminarNivel.setFont(new Font("Tahoma", Font.BOLD, 13));
			mntmEliminarNivel.setForeground(Color.CYAN);
			mntmEliminarNivel.setBackground(Color.BLACK);
			mntmEliminarNivel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EliminarNivel en = new EliminarNivel();
					en.setVisible(true);
				}
			});
		}
		return mntmEliminarNivel;
	}

	private JMenu getMnNivel() {
		if (mnNivel == null) {
			mnNivel = new JMenu("Nivel");
			mnNivel.setBorder(new EmptyBorder(0, 0, 0, 0));
			mnNivel.setBorderPainted(false);			
			mnNivel.setFont(new Font("Tahoma", Font.BOLD, 13));
			mnNivel.setForeground(Color.BLACK);
			mnNivel.setBackground(Color.BLACK);			
			mnNivel.add(getMenuItem_6());
			mnNivel.add(getMenuItem_7());
			mnNivel.add(getMenuItem_8());
		}
		return mnNivel;
	}

	private JMenu getMnPregunta() {
		if (mnPregunta == null) {
			mnPregunta = new JMenu("Pregunta");
			mnPregunta.setBorder(new EmptyBorder(0, 0, 0, 0));
			mnPregunta.setBorderPainted(false);
			mnPregunta.setFont(new Font("Tahoma", Font.BOLD, 13));
			mnPregunta.setForeground(Color.BLACK);
			mnPregunta.setBackground(Color.BLACK);
			mnPregunta.add(getMntmAgregarPregunta());
			mnPregunta.add(getMntmModificarPregunta());
			mnPregunta.add(getMntmEliminarPregunta());
		}
		return mnPregunta;
	}

	private JMenuItem getMntmAgregarPregunta() {
		if (mntmAgregarPregunta == null) {
			mntmAgregarPregunta = new JMenuItem("Agregar pregunta");
			mntmAgregarPregunta.setBorder(new EmptyBorder(0, 0, 0, 0));
			mntmAgregarPregunta.setBorderPainted(false);
			mntmAgregarPregunta.setFont(new Font("Tahoma", Font.BOLD, 13));
			mntmAgregarPregunta.setForeground(Color.CYAN);
			mntmAgregarPregunta.setBackground(Color.BLACK);
			mntmAgregarPregunta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AgregarPregunta ap = new AgregarPregunta(
							PanelDeControl.this);
					ap.setVisible(true);
				}
			});
		}
		return mntmAgregarPregunta;
	}

	private JMenuItem getMntmModificarPregunta() {
		if (mntmModificarPregunta == null) {
			mntmModificarPregunta = new JMenuItem("Modificar pregunta");
			mntmModificarPregunta.setBorder(new EmptyBorder(0, 0, 0, 0));
			mntmModificarPregunta.setBorderPainted(false);
			mntmModificarPregunta.setFont(new Font("Tahoma", Font.BOLD, 13));
			mntmModificarPregunta.setForeground(Color.CYAN);
			mntmModificarPregunta.setBackground(Color.BLACK);
			mntmModificarPregunta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					EditarPregunta ep = new EditarPregunta(PanelDeControl.this);
					ep.setVisible(true);
				}
			});
		}
		return mntmModificarPregunta;
	}

	private JMenuItem getMntmEliminarPregunta() {
		if (mntmEliminarPregunta == null) {
			mntmEliminarPregunta = new JMenuItem("Eliminar pregunta");
			mntmEliminarPregunta.setBorder(new EmptyBorder(0, 0, 0, 0));
			mntmEliminarPregunta.setBorderPainted(false);
			mntmEliminarPregunta.setFont(new Font("Tahoma", Font.BOLD, 13));
			mntmEliminarPregunta.setForeground(Color.CYAN);
			mntmEliminarPregunta.setBackground(Color.BLACK);
			mntmEliminarPregunta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					EliminarPregunta epr = new EliminarPregunta(
							PanelDeControl.this);
					epr.setVisible(true);
				}
			});
		}
		return mntmEliminarPregunta;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new PanelConFondo();
			panel.cambiarFoto(1);
			panel.setBounds(0, 0, 569, 439);
			panel.setLayout(new BorderLayout(0, 0));
		}
		return panel;
	}
	private JMenuItem getMntmCambiarContrasena() {
		if (mntmCambiarContrasena == null) {
			mntmCambiarContrasena = new JMenuItem("Cambiar contrase\u00F1a");
			mntmCambiarContrasena.setBorder(new EmptyBorder(0, 0, 0, 0));
			mntmCambiarContrasena.setBorderPainted(false);
			mntmCambiarContrasena.setFont(new Font("Tahoma", Font.BOLD, 13));
			mntmCambiarContrasena.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CambiarContrasenaAdmin cambcon = new CambiarContrasenaAdmin(panel);
					cambcon.setVisible(true);
				}
			});
			mntmCambiarContrasena.setBackground(Color.BLACK);
			mntmCambiarContrasena.setForeground(Color.CYAN);
		}
		return mntmCambiarContrasena;
	}
}
