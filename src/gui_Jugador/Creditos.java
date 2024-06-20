package gui_Jugador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import auxiliar.Iconeable;
import auxiliar.PanelConFondo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings({ "unused" })
public class Creditos extends JFrame implements Iconeable {

	private static final long serialVersionUID = -6320055673832524667L;
	private PanelConFondo contentPane;
	private JButton btnMenu;
	private Menu menu;
	private JLabel lblCreadoPor;
	private JLabel lblCarlosAlbertoLpez;
	private JLabel lblOmerLuisRodrguez;
	private JLabel lblJavierMolinaSnchez;
	private JLabel lblDamianJessGroning;

	public Creditos(Menu menu) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 460);
		contentPane = new PanelConFondo();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.cambiarFoto(4);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnMenu());
		contentPane.add(getLblCreadoPor());
		contentPane.add(getLblCarlosAlbertoLpez());
		contentPane.add(getLblOmerLuisRodrguez());
		contentPane.add(getLblJavierMolinaSnchez());
		contentPane.add(getLblDamianJessGroning());
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		this.menu = menu;
	}

	private JButton getBtnMenu() {
		if (btnMenu == null) {
			btnMenu = new JButton("Men\u00FA", icon);
			btnMenu.setHorizontalTextPosition(SwingConstants.CENTER);
			btnMenu.setVerticalTextPosition(SwingConstants.CENTER);
			btnMenu.setForeground(Color.CYAN);
			btnMenu.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					menu.setVisible(true);
					dispose();
				}
			});
			btnMenu.setBounds(216, 361, 120, 23);
		}
		return btnMenu;
	}

	private JLabel getLblCreadoPor() {
		if (lblCreadoPor == null) {
			lblCreadoPor = new JLabel("Creado por :");
			lblCreadoPor.setFont(new Font("Tahoma", Font.BOLD, 33));
			lblCreadoPor.setHorizontalAlignment(SwingConstants.CENTER);
			lblCreadoPor.setForeground(Color.CYAN);
			lblCreadoPor.setBounds(72, 31, 425, 55);
		}
		return lblCreadoPor;
	}

	private JLabel getLblCarlosAlbertoLpez() {
		if (lblCarlosAlbertoLpez == null) {
			lblCarlosAlbertoLpez = new JLabel(
					"Carlos Alberto L\u00F3pez Rodr\u00EDguez");
			lblCarlosAlbertoLpez.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblCarlosAlbertoLpez.setHorizontalAlignment(SwingConstants.CENTER);
			lblCarlosAlbertoLpez.setForeground(Color.CYAN);
			lblCarlosAlbertoLpez.setBounds(72, 121, 425, 35);
		}
		return lblCarlosAlbertoLpez;
	}

	private JLabel getLblOmerLuisRodrguez() {
		if (lblOmerLuisRodrguez == null) {
			lblOmerLuisRodrguez = new JLabel(
					"Omer Luis Rodr\u00EDguez Garc\u00EDa");
			lblOmerLuisRodrguez.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblOmerLuisRodrguez.setHorizontalAlignment(SwingConstants.CENTER);
			lblOmerLuisRodrguez.setForeground(Color.CYAN);
			lblOmerLuisRodrguez.setBounds(72, 192, 425, 35);
		}
		return lblOmerLuisRodrguez;
	}

	private JLabel getLblJavierMolinaSnchez() {
		if (lblJavierMolinaSnchez == null) {
			lblJavierMolinaSnchez = new JLabel("Javier Molina S\u00E1nchez");
			lblJavierMolinaSnchez.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblJavierMolinaSnchez.setHorizontalAlignment(SwingConstants.CENTER);
			lblJavierMolinaSnchez.setForeground(Color.CYAN);
			lblJavierMolinaSnchez.setBounds(72, 224, 425, 35);
		}
		return lblJavierMolinaSnchez;
	}

	private JLabel getLblDamianJessGroning() {
		if (lblDamianJessGroning == null) {
			lblDamianJessGroning = new JLabel(
					"Dami\u00E1n Jes\u00FAs Groning Vallin");
			lblDamianJessGroning.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblDamianJessGroning.setHorizontalAlignment(SwingConstants.CENTER);
			lblDamianJessGroning.setForeground(Color.CYAN);
			lblDamianJessGroning.setBounds(72, 157, 425, 35);
		}
		return lblDamianJessGroning;
	}
}
