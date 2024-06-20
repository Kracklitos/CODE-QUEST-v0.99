package gui_Jugador;

import gui_Administrador.PanelDeControl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logic.Administrador;
import logic.Juego;
import logic.Jugador;
import logic.Usuario;
import auxiliar.Iconeable;
import auxiliar.JTextFieldMejorado;
import auxiliar.PanelConFondo;
import auxiliar.Prevencion;

@SuppressWarnings("unused")
public class InicioSesion extends JFrame implements Iconeable {

	private static final long serialVersionUID = -402001867975644353L;
	private PanelConFondo contentPanel = new PanelConFondo();
	private JLabel labelUsuario;
	private JTextFieldMejorado textFieldAdministrador;
	private JLabel labelContrasena;
	private JPasswordField passwordField;
	private JCheckBox checkBoxMostrarContrasena;
	private JLabel labelUsuarioIncorrecto;
	private JLabel labelContasenaIncorrecta;
	private JButton buttonAcceder;
	private JButton buttonCerrar;
	private JLabel lblNewLabel;
	private JButton btnRegistrarse;

	public InicioSesion() {
		setResizable(true);
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.cambiarFoto(4);
		setBounds(100, 100, 569, 460);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getButtonCerrar());
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLabelUsuario());
		contentPanel.add(getTextFieldAdministrador());
		contentPanel.add(getLabelContrasena());
		contentPanel.add(getPasswordField());
		contentPanel.add(getCheckBoxMostrarContrasena());
		contentPanel.add(getLabelUsuarioIncorrecto());
		contentPanel.add(getLabelContasenaIncorrecta());
		contentPanel.add(getBtnRegistrarse());
		contentPanel.add(getButtonAcceder());
		labelContasenaIncorrecta.setVisible(false);
		labelUsuarioIncorrecto.setVisible(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
	}

	private JLabel getLabelUsuario() {
		if (labelUsuario == null) {
			labelUsuario = new JLabel("Usuario:");
			labelUsuario.setBounds(194, 86, 80, 25);
			labelUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
			labelUsuario.setForeground(Color.CYAN);
		}
		return labelUsuario;
	}

	public JTextFieldMejorado getTextFieldAdministrador() {
		if (textFieldAdministrador == null) {
			textFieldAdministrador = new JTextFieldMejorado();
			textFieldAdministrador.setLimite(13);
			textFieldAdministrador.setBounds(194, 114, 165, 25);
		}
		return textFieldAdministrador;
	}

	private JLabel getLabelContrasena() {
		if (labelContrasena == null) {
			labelContrasena = new JLabel("Contrase\u00F1a:");
			labelContrasena.setBounds(194, 170, 80, 25);
			labelContrasena.setFont(new Font("Tahoma", Font.BOLD, 13));
			labelContrasena.setForeground(Color.CYAN);
		}
		return labelContrasena;
	}

	public JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField(20);
			passwordField.setBounds(194, 196, 165, 25);
		}
		return passwordField;
	}

	private JCheckBox getCheckBoxMostrarContrasena() {
		if (checkBoxMostrarContrasena == null) {
			checkBoxMostrarContrasena = new JCheckBox("Mostrar contrase\u00F1a");
			checkBoxMostrarContrasena.setOpaque(false);
			checkBoxMostrarContrasena.setBounds(194, 237, 165, 25);
			checkBoxMostrarContrasena
					.setFont(new Font("Tahoma", Font.BOLD, 13));
			checkBoxMostrarContrasena.setForeground(Color.CYAN);
			checkBoxMostrarContrasena.setBackground(Color.BLACK);
			checkBoxMostrarContrasena.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (arg0.getSource() == checkBoxMostrarContrasena) {
						if (checkBoxMostrarContrasena.isSelected()) {
							passwordField.setEchoChar((char) 0);
						} else {
							passwordField.setEchoChar('\u2022');
						}
					}
				}
			});
		}
		return checkBoxMostrarContrasena;
	}

	private JLabel getLabelUsuarioIncorrecto() {
		if (labelUsuarioIncorrecto == null) {
			labelUsuarioIncorrecto = new JLabel("Nombre de usuario incorrecto");
			labelUsuarioIncorrecto.setBounds(189, 269, 180, 14);
			labelUsuarioIncorrecto.setForeground(Color.RED);
		}
		return labelUsuarioIncorrecto;
	}

	private JLabel getLabelContasenaIncorrecta() {
		if (labelContasenaIncorrecta == null) {
			labelContasenaIncorrecta = new JLabel("Contrase\u00F1a incorrecta");
			labelContasenaIncorrecta.setBounds(207, 294, 142, 14);
			labelContasenaIncorrecta.setForeground(Color.RED);
		}
		return labelContasenaIncorrecta;
	}

	private JButton getButtonAcceder() {
		if (buttonAcceder == null) {
			buttonAcceder = new JButton("Acceder", icon);
			buttonAcceder.setBounds(297, 319, 114, 23);
			buttonAcceder.setFont(new Font("Tahoma", Font.BOLD, 13));
			buttonAcceder.setForeground(Color.CYAN);
			buttonAcceder.setHorizontalTextPosition(SwingConstants.CENTER);
			buttonAcceder.setVerticalTextPosition(SwingConstants.CENTER);
			buttonAcceder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean nombreCorrecto = false;
					boolean passwordCorrecta = false;
					boolean admin = false;
					boolean encontrado = false;
					boolean existente = false;
					String nombre = textFieldAdministrador.getText();
					String password = String.valueOf(passwordField
							.getPassword());
					if (nombre != null && !nombre.trim().isEmpty()) {
						labelUsuarioIncorrecto.setVisible(false);
						nombreCorrecto = true;
					} else {
						passwordField.setText("");
						textFieldAdministrador.setText("");
						labelUsuarioIncorrecto.setVisible(true);

					}
					if (password != null && !password.trim().isEmpty()) {
						labelContasenaIncorrecta.setVisible(false);
						passwordCorrecta = true;
					} else {
						labelContasenaIncorrecta.setVisible(true);
						passwordField.setText("");
						textFieldAdministrador.setText("");
					}

					if (nombreCorrecto && passwordCorrecta) {
						Jugador jg = new Jugador(nombre, password);
						for (Usuario user : Juego.getInstance().getJugadores()) {
							if (user.getNombre().trim().equalsIgnoreCase(
									jg.getNombre().trim())) {
								existente = true;
								if (user.getContrasena().equals(
										jg.getContrasena())) {
									existente = false;
									encontrado = true;
								}
							}
						}
						if (password.equals(Administrador.getInstance()
								.getContrasena())
								&& nombre.equalsIgnoreCase(Administrador
										.getInstance().getNombre())) {
							admin = true;
						}
						if (admin) {
							PanelDeControl a = new PanelDeControl();
							a.setVisible(true);
							dispose();
						} else if (encontrado) {
							Menu me = new Menu(new Jugador(nombre, password));
							me.setVisible(true);
							dispose();
						} else {
							if (existente) {
								labelContasenaIncorrecta.setVisible(true);
							} else {
								Prevencion pre = new Prevencion(InicioSesion.this);
								pre.setVisible(true);
							}
						}

					}

				}
			});
		}
		return buttonAcceder;
	}

	private JButton getButtonCerrar() {
		if (buttonCerrar == null) {
			buttonCerrar = new JButton("Cerrar", icon);
			buttonCerrar.setBounds(212, 359, 114, 23);
			buttonCerrar.setForeground(Color.CYAN);
			buttonCerrar.setFont(new Font("Tahoma", Font.BOLD, 13));
			buttonCerrar.setHorizontalTextPosition(SwingConstants.CENTER);
			buttonCerrar.setVerticalTextPosition(SwingConstants.CENTER);
			buttonCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return buttonCerrar;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Bienvenido a CodeQuest");
			lblNewLabel.setBounds(97, 16, 375, 56);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblNewLabel.setForeground(Color.CYAN);
		}
		return lblNewLabel;
	}

	private JButton getBtnRegistrarse() {
		if (btnRegistrarse == null) {
			btnRegistrarse = new JButton("Registrarse", icon);
			btnRegistrarse.setBounds(128, 319, 114, 23);
			btnRegistrarse.setForeground(Color.CYAN);
			btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnRegistrarse.setHorizontalTextPosition(SwingConstants.CENTER);
			btnRegistrarse.setVerticalTextPosition(SwingConstants.CENTER);
			btnRegistrarse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CrearUsuario create = new CrearUsuario();
					create.setVisible(true);
					dispose();
				}
			});
		}
		return btnRegistrarse;
	}

	public void setTextFieldAdministrador(JTextFieldMejorado textFieldAdministrador) {
		this.textFieldAdministrador = textFieldAdministrador;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
	
	public void limpiar (){
		passwordField.setText("");
		textFieldAdministrador.setText("");
	}
	
}
