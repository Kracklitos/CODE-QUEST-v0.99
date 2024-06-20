package gui_Jugador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;

import logic.Jugador;

import javax.swing.ButtonGroup;

import auxiliar.Iconeable;
import auxiliar.PanelConFondo;

@SuppressWarnings("unused")
public class Opciones extends JFrame implements Iconeable {

	private static final long serialVersionUID = 3036501980541823583L;
	private PanelConFondo contentPane;
	private JButton buttonMenu;
	private JLabel label;
	private Menu menu;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JRadioButton rdbtnActivarMsica;	
	private JLabel lblNewLabel;
	
	public Opciones(Menu Menu) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 460);
		contentPane = new PanelConFondo();
		contentPane.cambiarFoto(4);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getButtonMenu());
		contentPane.add(getLabel());
		contentPane.add(getRdbtnActivarMsica());
		contentPane.add(getLblNewLabel());
		setUndecorated(true);
		setLocationRelativeTo(null);
		menu = Menu;
		setActivado();
	}

	private JButton getButtonMenu() {
		if (buttonMenu == null) {
			buttonMenu = new JButton("Men\u00FA", icon);
			buttonMenu.setHorizontalTextPosition(SwingConstants.CENTER);
			buttonMenu.setVerticalTextPosition(SwingConstants.CENTER);
			buttonMenu.setForeground(Color.CYAN);
			buttonMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					menu.setVisible(true);
					dispose();
				}
			});
			buttonMenu.setBounds(241, 397, 86, 23);
		}
		return buttonMenu;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Opciones");
			label.setForeground(Color.CYAN);
			label.setFont(new Font("Tahoma", Font.PLAIN, 36));
			label.setBounds(207, 16, 154, 58);
		}
		return label;
	}

	private JRadioButton getRdbtnActivarMsica() {
		if (rdbtnActivarMsica == null) {
			rdbtnActivarMsica = new JRadioButton("Activar M\u00FAsica");
			rdbtnActivarMsica.setOpaque(false);
			rdbtnActivarMsica.setBounds(207, 230, 135, 23);
			rdbtnActivarMsica.setFont(new Font("Tahoma", Font.BOLD, 13));
			rdbtnActivarMsica.setBackground(Color.DARK_GRAY);
			rdbtnActivarMsica.setForeground(Color.CYAN);
			rdbtnActivarMsica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (rdbtnActivarMsica.isSelected()
							&& !menu.isMusicPlaying()) {
						menu.continuar();
						menu.musica();
					} else if (!rdbtnActivarMsica.isSelected()
							&& menu.isMusicPlaying())
						menu.detenerMusica();
				}
			});
			rdbtnActivarMsica.setSelected(true);
		}
		return rdbtnActivarMsica;
	}

	private void setActivado() {
		if (menu.isMusicPlaying()) {
			rdbtnActivarMsica.setSelected(true);
		} else
			rdbtnActivarMsica.setSelected(false);
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("M\u00FAsica");
			lblNewLabel.setForeground(Color.CYAN);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setBounds(208, 203, 86, 23);
		}
		return lblNewLabel;
	}
}
