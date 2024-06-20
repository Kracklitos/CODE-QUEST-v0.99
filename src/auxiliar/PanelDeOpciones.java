package auxiliar;

import gui_Jugador.Menu;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelDeOpciones extends JDialog implements Iconeable{
	
	private static final long serialVersionUID = 4038185912824648661L;
	private final PanelConFondo contentPanel = new PanelConFondo();
	private JLabel lbldeseaReiniciarEl;
	private JButton buttonReiniciar;
	private JButton buttonContinuar;
	private Menu menu;
	
	public PanelDeOpciones(final Menu menu, boolean jugo) {
		setBounds(100, 100, 337, 82);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.cambiarFoto(5);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLbldeseaReiniciarEl());
		contentPanel.add(getButtonReiniciar());
		contentPanel.add(getButtonContinuar());
		this.menu = menu;
		if (jugo) {
			buttonContinuar.setEnabled(false);
		}

	}

	private JLabel getLbldeseaReiniciarEl() {
		if (lbldeseaReiniciarEl == null) {
			lbldeseaReiniciarEl = new JLabel(
					"\u00BFDesea reiniciar el juego \r\no \r\ncontinuar?");
			lbldeseaReiniciarEl.setBounds(44, 11, 262, 25);
			lbldeseaReiniciarEl.setForeground(Color.WHITE);
			lbldeseaReiniciarEl.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbldeseaReiniciarEl.setAlignmentX(0.5f);
		}
		return lbldeseaReiniciarEl;
	}

	private JButton getButtonReiniciar() {
		if (buttonReiniciar == null) {
			buttonReiniciar = new JButton("Reiniciar", icon);
			buttonReiniciar.setBounds(34, 47, 114, 23);
			buttonReiniciar.setHorizontalTextPosition(SwingConstants.CENTER);
			buttonReiniciar.setVerticalTextPosition(SwingConstants.CENTER);
			buttonReiniciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					menu.reiniciarJuego();
				}
			});
			buttonReiniciar.setVerticalTextPosition(SwingConstants.CENTER);
			buttonReiniciar.setHorizontalTextPosition(SwingConstants.CENTER);
			buttonReiniciar.setForeground(Color.CYAN);
			buttonReiniciar.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return buttonReiniciar;
	}

	private JButton getButtonContinuar() {
		if (buttonContinuar == null) {
			buttonContinuar = new JButton("Continuar", icon);
			buttonContinuar.setBounds(182, 47, 114, 23);
			buttonContinuar.setHorizontalTextPosition(SwingConstants.CENTER);
			buttonContinuar.setVerticalTextPosition(SwingConstants.CENTER);
			buttonContinuar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					menu.continuarJuego();
				}
			});
			buttonContinuar.setVerticalTextPosition(SwingConstants.CENTER);
			buttonContinuar.setHorizontalTextPosition(SwingConstants.CENTER);
			buttonContinuar.setForeground(Color.CYAN);
			buttonContinuar.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return buttonContinuar;
	}
}
