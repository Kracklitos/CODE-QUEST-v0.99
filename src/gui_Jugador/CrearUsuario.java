package gui_Jugador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import logic.Juego;
import logic.Jugador;
import logic.Usuario;
import auxiliar.Iconeable;
import auxiliar.JTextFieldMejorado;
import auxiliar.NotaInformativa;
import auxiliar.PanelConFondo;

public class CrearUsuario extends JFrame implements Iconeable {

	private static final long serialVersionUID = -5951001541028894919L;
	private JTextFieldMejorado nuevoUsernameField;
	private JPasswordField nuevoPasswordField;
	private JPasswordField confirmarPasswordField;
	private JCheckBox showPasswordCheckbox1;
	private JLabel nuevoUsernameLabel;
	private JLabel nuevoPasswordLabel;
	private JLabel confirmarPasswordLabel;
	private JButton crearUsuarioButton;
	private JButton btnCancelar;
	private JLabel lblNewLabel;

	public CrearUsuario() {
		setResizable(false);
		setTitle("Crear Nuevo Usuario");
		setSize(569, 460);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setLocationRelativeTo(null);

		nuevoUsernameLabel = new JLabel("Nuevo nombre de usuario :");
		nuevoUsernameLabel.setBounds(205, 96, 199, 16);
		nuevoUsernameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		nuevoUsernameLabel.setForeground(Color.CYAN);
		nuevoUsernameField = new JTextFieldMejorado();
		nuevoUsernameField.setLimite(13);
		nuevoUsernameField.setBounds(205, 122, 166, 20);
		nuevoPasswordLabel = new JLabel("Nueva contrase\u00F1a :");
		nuevoPasswordLabel.setBounds(205, 175, 199, 16);
		nuevoPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		nuevoPasswordLabel.setForeground(Color.CYAN);
		nuevoPasswordField = new JPasswordField(20);
		nuevoPasswordField.setBounds(205, 202, 166, 20);
		confirmarPasswordLabel = new JLabel("Confirmar contrase\u00F1a :");
		confirmarPasswordLabel.setBounds(205, 256, 199, 16);
		confirmarPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		confirmarPasswordLabel.setForeground(Color.CYAN);
		confirmarPasswordField = new JPasswordField(20);
		confirmarPasswordField.setBounds(205, 294, 166, 20);
		showPasswordCheckbox1 = new JCheckBox("Mostrar contrase\u00F1a");
		showPasswordCheckbox1.setOpaque(false);
		showPasswordCheckbox1.setBounds(205, 337, 166, 25);
		showPasswordCheckbox1.setForeground(Color.CYAN);
		showPasswordCheckbox1.setFont(new Font("Tahoma", Font.BOLD, 13));
		crearUsuarioButton = new JButton("Crear Usuario", icon);
		crearUsuarioButton.setHorizontalTextPosition(SwingConstants.CENTER);
		crearUsuarioButton.setVerticalTextPosition(SwingConstants.CENTER);
		crearUsuarioButton.setBounds(105, 411, 127, 23);
		crearUsuarioButton.setForeground(Color.CYAN);
		crearUsuarioButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		crearUsuarioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					boolean encontrado = false;
					String username = nuevoUsernameField.getText();
					String password = String.valueOf(nuevoPasswordField
							.getPassword());
					String confirmPassword = String
							.valueOf(confirmarPasswordField.getPassword());
					Jugador nuevoUsuario = new Jugador(username, password);

					for (Usuario user : Juego.getInstance().getJugadores()) {
						if (user.getNombre().trim()
								.equalsIgnoreCase(nuevoUsuario.getNombre().trim()))
							encontrado = true;
						if (user.getContrasena()
								.equals(nuevoUsuario.getContrasena()))
							encontrado = true;
					}
					if (password.equals(confirmPassword) && !encontrado) {
						Menu menu = new Menu(nuevoUsuario);
						menu.setVisible(true);
						Juego.getInstance().agregarJugador(nuevoUsuario);
						dispose();
					} else if (encontrado) {
						NotaInformativa nota = new NotaInformativa(
								"Este jugador ya existe.");
						nota.setVisible(true);
						nuevoPasswordField.setText("");
						nuevoUsernameField.setText("");
						confirmarPasswordField.setText("");
					} else {
						NotaInformativa nota = new NotaInformativa(
								"Las contraseñas no coinciden.");
						nota.setVisible(true);
						nuevoPasswordField.setText("");
						nuevoUsernameField.setText("");
						confirmarPasswordField.setText("");
					}
				} catch (IllegalArgumentException e) {
					NotaInformativa nota = new NotaInformativa(
							"No puede dejar los campos vacíos.");
					nota.setVisible(true);
					nuevoPasswordField.setText("");
					nuevoUsernameField.setText("");
					confirmarPasswordField.setText("");
				}
			}
		});

		showPasswordCheckbox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (showPasswordCheckbox1.isSelected()) {
					nuevoPasswordField.setEchoChar((char) 0);
					confirmarPasswordField.setEchoChar((char) 0);
				} else {
					nuevoPasswordField.setEchoChar('\u2022');
					confirmarPasswordField.setEchoChar('\u2022');
				}
			}
		});

		// Agregar los componentes al panel
		PanelConFondo panel = new PanelConFondo();
		panel.setBackground(Color.DARK_GRAY);
		panel.cambiarFoto(4);
		panel.setLayout(null);
		panel.add(nuevoUsernameLabel);
		panel.add(nuevoUsernameField);
		panel.add(nuevoPasswordLabel);
		panel.add(nuevoPasswordField);
		panel.add(confirmarPasswordLabel);
		panel.add(confirmarPasswordField);
		panel.add(showPasswordCheckbox1);
		panel.add(crearUsuarioButton);

		getContentPane().add(panel);

		btnCancelar = new JButton("Cancelar", icon);
		btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelar.setVerticalTextPosition(SwingConstants.CENTER);
		btnCancelar.setBounds(337, 410, 127, 25);
		btnCancelar.setForeground(Color.CYAN);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InicioSesion lg = new InicioSesion();
				lg.setVisible(true);
				dispose();
			}
		});
		panel.add(btnCancelar);

		lblNewLabel = new JLabel("Nuevo jugador");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setBounds(175, 34, 229, 51);
		panel.add(lblNewLabel);
		setVisible(true);
	}
}
