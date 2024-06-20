package gui_Administrador;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import auxiliar.Iconeable;
import auxiliar.JTextFieldMejorado;
import auxiliar.NotaInformativa;
import auxiliar.PanelConFondo;
import logic.Administrador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class CambiarContrasenaAdmin extends JDialog implements Iconeable {

	private static final long serialVersionUID = 650796716730527796L;
	private final PanelConFondo contentPanel = new PanelConFondo();
	private JLabel lblUsuario;
	private JTextFieldMejorado txtContraseaAnterior;
	private JTextFieldMejorado txtNuevaContrasea;
	private JTextFieldMejorado txtConfirmarNuevaContrasea;
	private JLabel lblEscribaSuContrasea;
	private JLabel lblEscribaLaNueva;
	private JLabel lblEscribaDeNuevo;
	private JButton btnConfirmar;
	private JButton btnCancelar;

	public CambiarContrasenaAdmin(PanelConFondo panel) {
		setBounds(100, 100, 569, 460);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.cambiarFoto(4);
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblUsuario());
		contentPanel.add(getTxtContraseaAnterior());
		contentPanel.add(getTxtNuevaContrasea());
		contentPanel.add(getTxtConfirmarNuevaContrasea());
		contentPanel.add(getLblEscribaSuContrasea());
		contentPanel.add(getLblEscribaLaNueva());
		contentPanel.add(getLblEscribaDeNuevo());
		contentPanel.add(getBtnConfirmar());
		contentPanel.add(getBtnCancelar());
		setModal(true);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Administrador");
			lblUsuario.setForeground(Color.CYAN);
			lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblUsuario.setBounds(171, 11, 223, 37);
		}
		return lblUsuario;
	}

	private JTextFieldMejorado getTxtContraseaAnterior() {
		if (txtContraseaAnterior == null) {
			txtContraseaAnterior = new JTextFieldMejorado();
			txtContraseaAnterior.setLimite(15);
			txtContraseaAnterior.setBounds(182, 125, 204, 20);
			txtContraseaAnterior.setColumns(10);
		}
		return txtContraseaAnterior;
	}

	private JTextFieldMejorado getTxtNuevaContrasea() {
		if (txtNuevaContrasea == null) {
			txtNuevaContrasea = new JTextFieldMejorado();
			txtNuevaContrasea.setLimite(15);
			txtNuevaContrasea.setBounds(182, 214, 204, 20);
			txtNuevaContrasea.setColumns(10);
		}
		return txtNuevaContrasea;
	}

	private JTextFieldMejorado getTxtConfirmarNuevaContrasea() {
		if (txtConfirmarNuevaContrasea == null) {
			txtConfirmarNuevaContrasea = new JTextFieldMejorado();
			txtConfirmarNuevaContrasea.setLimite(15);
			txtConfirmarNuevaContrasea.setBounds(182, 298, 204, 20);
			txtConfirmarNuevaContrasea.setColumns(10);
		}
		return txtConfirmarNuevaContrasea;
	}

	private JLabel getLblEscribaSuContrasea() {
		if (lblEscribaSuContrasea == null) {
			lblEscribaSuContrasea = new JLabel(
					"Escriba su contrase\u00F1a actual :");
			lblEscribaSuContrasea.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblEscribaSuContrasea.setForeground(Color.CYAN);
			lblEscribaSuContrasea.setBounds(184, 89, 223, 14);
		}
		return lblEscribaSuContrasea;
	}

	private JLabel getLblEscribaLaNueva() {
		if (lblEscribaLaNueva == null) {
			lblEscribaLaNueva = new JLabel("Escriba la nueva contrase\u00F1a :");
			lblEscribaLaNueva.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblEscribaLaNueva.setForeground(Color.CYAN);
			lblEscribaLaNueva.setBounds(184, 189, 223, 14);
		}
		return lblEscribaLaNueva;
	}

	private JLabel getLblEscribaDeNuevo() {
		if (lblEscribaDeNuevo == null) {
			lblEscribaDeNuevo = new JLabel(
					"Reafirme la nueva contrase\u00F1a :");
			lblEscribaDeNuevo.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblEscribaDeNuevo.setForeground(Color.CYAN);
			lblEscribaDeNuevo.setBounds(184, 267, 271, 20);
		}
		return lblEscribaDeNuevo;
	}


	private void actualizarContrasenaUsuario(String text) {
		Administrador.getInstance().setContrasena(text);

	}

	private JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar",icon);
			btnConfirmar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnConfirmar.setVerticalTextPosition(SwingConstants.CENTER);
			btnConfirmar.setForeground(Color.CYAN);
			btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (txtContraseaAnterior.getText().isEmpty()
							|| txtNuevaContrasea.getText().isEmpty()
							|| txtConfirmarNuevaContrasea.getText().isEmpty()) {
						NotaInformativa nota = new NotaInformativa("Debe escribir en todos los campos de texto");
						nota.setVisible(true);
					} else {
						if (txtContraseaAnterior.getText().equals(Administrador.getInstance().getContrasena())) {
							if (txtNuevaContrasea.getText().equals(
									txtConfirmarNuevaContrasea.getText())) {
								actualizarContrasenaUsuario(txtNuevaContrasea.getText()); // Método
																							// para
																							// actualizar
																							// la
																							// contraseña
																							// del
																							// usuario
								NotaInformativa nota = new NotaInformativa("La contraseña ha sido actualizada con éxito");
								nota.setVisible(true);
								dispose();
							} else {
								NotaInformativa nota = new NotaInformativa("Las contraseñas nuevas no son iguales");
								nota.setVisible(true);
								txtConfirmarNuevaContrasea.setText("");
								txtContraseaAnterior.setText("");
								txtNuevaContrasea.setText("");
							}
						} else {
							NotaInformativa nota = new NotaInformativa("La contraseña actual es incorrecta");
							nota.setVisible(true);
						}
					}
				}
			});
			btnConfirmar.setBounds(121, 385, 102, 23);
		}
		return btnConfirmar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar",icon);
			btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnCancelar.setVerticalTextPosition(SwingConstants.CENTER);
			btnCancelar.setForeground(Color.CYAN);
			btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setBounds(344, 385, 102, 23);
		}
		return btnCancelar;
	}
}
