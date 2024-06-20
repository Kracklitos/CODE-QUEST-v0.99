package gui_Administrador;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import auxiliar.Iconeable;
import auxiliar.PanelConFondo;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Ayuda extends JDialog implements Iconeable {

	private final PanelConFondo contentPanel = new PanelConFondo();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_6;
	private JLabel lblLasPreguntas;
			
	public Ayuda() {
		setResizable(false);		
		setBounds(100, 100, 675, 312);
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.cambiarFoto(4);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setModal(true);
		
		JButton btnCerrar = new JButton("Cerrar",icon);
		btnCerrar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrar.setVerticalTextPosition(SwingConstants.CENTER);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCerrar.setForeground(Color.CYAN);
		btnCerrar.setBounds(284, 265, 107, 25);
		contentPanel.add(btnCerrar);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getLblNewLabel_2());
		contentPanel.add(getLblNewLabel_3());
		contentPanel.add(getLblNewLabel_4());
		contentPanel.add(getLblNewLabel_6());
		contentPanel.add(getLblLasPreguntas());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel(" Desde esta men\u00FA se pueden crear, modificar  y eliminar niveles y preguntas :");
			lblNewLabel.setForeground(Color.CYAN);
			lblNewLabel.setBounds(104, 55, 506, 18);
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("4- Un nivel no se debe quedar sin preguntas.");
			lblNewLabel_1.setForeground(Color.CYAN);
			lblNewLabel_1.setBounds(104, 171, 458, 18);
			lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 13));
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("3- Cada nivel puede tener como m\u00E1ximo 5 preguntas.");
			lblNewLabel_2.setForeground(Color.CYAN);
			lblNewLabel_2.setBounds(104, 142, 458, 18);
			lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 13));
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("2- Al modificar una pregunta se le mostrar\u00E1 la informaci\u00F3n que ya pose\u00EDa.");
			lblNewLabel_3.setForeground(Color.CYAN);
			lblNewLabel_3.setBounds(104, 113, 489, 18);
			lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 13));
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("5- El juego no se debe quedar sin niveles.");
			lblNewLabel_4.setForeground(Color.CYAN);
			lblNewLabel_4.setBounds(104, 200, 458, 18);
			lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 13));
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("Reglas");
			lblNewLabel_6.setForeground(Color.CYAN);
			lblNewLabel_6.setBounds(299, 17, 77, 21);
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblNewLabel_6;
	}
	private JLabel getLblLasPreguntas() {
		if (lblLasPreguntas == null) {
			lblLasPreguntas = new JLabel("1- Las preguntas y respuestas deben tener una extensi\u00F3n m\u00E1xima de 36 caracteres");
			lblLasPreguntas.setForeground(Color.CYAN);
			lblLasPreguntas.setFont(new Font("Dialog", Font.BOLD, 13));
			lblLasPreguntas.setBounds(104, 84, 569, 18);
		}
		return lblLasPreguntas;
	}
}
