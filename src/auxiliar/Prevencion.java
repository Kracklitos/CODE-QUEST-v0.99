package auxiliar;

import gui_Jugador.CrearUsuario;
import gui_Jugador.InicioSesion;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Prevencion extends JDialog implements Iconeable {

	private PanelConFondo contentPanel = new PanelConFondo();
	private JButton btnSi;
	private JButton btnNo;
	private JLabel lblTexto;
	private InicioSesion inicio = new InicioSesion();

	public Prevencion(InicioSesion inicio) {
		setBounds(100, 100, 350, 130);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.cambiarFoto(5);
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnSi());
		contentPanel.add(getBtnNo());
		contentPanel.add(getLblTexto());
		setResizable(true);
		setUndecorated(true);
		setLocationRelativeTo(null);
		this.inicio = inicio;
	}

	private JButton getBtnSi() {
		if (btnSi == null) {
			btnSi = new JButton("S\u00ED", icon);
			btnSi.setForeground(Color.CYAN);
			btnSi.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnSi.setHorizontalTextPosition(SwingConstants.CENTER);
			btnSi.setVerticalTextPosition(SwingConstants.CENTER);
			btnSi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					CrearUsuario c = new CrearUsuario();
					c.setVisible(true);			
					inicio.limpiar();
					dispose();
				}
			});
			btnSi.setBounds(99, 65, 53, 23);
		}
		return btnSi;
	}

	private JButton getBtnNo() {
		if (btnNo == null) {
			btnNo = new JButton("No", icon);
			btnNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicio.limpiar();
					dispose();
				}
			});
			btnNo.setForeground(Color.CYAN);
			btnNo.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnNo.setHorizontalTextPosition(SwingConstants.CENTER);
			btnNo.setVerticalTextPosition(SwingConstants.CENTER);
			btnNo.setBounds(174, 65, 53, 23);
		}
		return btnNo;
	}

	private JLabel getLblTexto() {
		if (lblTexto == null) {
			lblTexto = new JLabel(
					"El usuario no existe. \u00BFDesea registrarse?");
			lblTexto.setForeground(Color.WHITE);
			lblTexto.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblTexto.setBounds(44, 21, 279, 33);
		}
		return lblTexto;
	}
}
