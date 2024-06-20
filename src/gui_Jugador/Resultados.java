package gui_Jugador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import auxiliar.Iconeable;
import auxiliar.PanelConFondo;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logic.Juego;
import logic.Jugador;
import logic.Nivel;
import logic.Pregunta;

import java.awt.Color;

@SuppressWarnings("unused")
public class Resultados extends JDialog implements Iconeable {

	private static final long serialVersionUID = 9047200899513288932L;
	private PanelConFondo contentPanel;
	private JLabel lblNewLabel;
	private JLabel lblHasAcertado;
	private JLabel lblMejorSuerteLa;
	private Jugador jugador = null;
	private JLabel labelpuntaje;
	private JLabel lblPreguntas;
	private JLabel lblJuegoPerdido;
	private Menu menu;

	public Resultados(Menu Menu, Jugador user) {
		setResizable(false);
		contentPanel = new PanelConFondo();
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.cambiarFoto(2);
		setBounds(100, 100, 569, 460);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblHasAcertado());
		contentPanel.add(getLblMejorSuerteLa());
		setLocationRelativeTo(null);
		setUndecorated(true);
		this.jugador = user;
		menu = Menu;

		{
			JButton btnConfimar = new JButton("Confirmar", icon);
			btnConfimar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnConfimar.setForeground(Color.CYAN);
			btnConfimar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnConfimar.setVerticalTextPosition(SwingConstants.CENTER);
			btnConfimar.setBounds(232, 412, 104, 23);
			contentPanel.add(btnConfimar);
			contentPanel.add(getLabelpuntaje());
			contentPanel.add(getLblPreguntas());
			contentPanel.add(getLblJuegoPerdido());
			btnConfimar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					menu.setVisible(true);
					dispose();
				}
			});
		}
		mostrarPuntaje();
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Felicidades has ganado");
			lblNewLabel.setForeground(Color.CYAN);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblNewLabel.setBounds(102, 98, 364, 76);
		}
		return lblNewLabel;
	}

	private JLabel getLblHasAcertado() {
		if (lblHasAcertado == null) {
			lblHasAcertado = new JLabel("Has acertado ");
			lblHasAcertado.setForeground(Color.CYAN);
			lblHasAcertado.setFont(new Font("Tahoma", Font.BOLD, 23));
			lblHasAcertado.setBounds(102, 284, 166, 56);
		}
		return lblHasAcertado;
	}

	private JLabel getLblMejorSuerteLa() {
		if (lblMejorSuerteLa == null) {
			lblMejorSuerteLa = new JLabel("Mejor suerte a la pr\u00F3xima");
			lblMejorSuerteLa.setFont(new Font("Tahoma", Font.BOLD, 23));
			lblMejorSuerteLa.setForeground(Color.RED);
			lblMejorSuerteLa.setBounds(116, 253, 326, 43);
		}
		return lblMejorSuerteLa;
	}

	private JLabel getLabelpuntaje() {

		if (labelpuntaje == null) {
			labelpuntaje = new JLabel("" + jugador.getPuntaje());
			labelpuntaje.setFont(new Font("Tahoma", Font.BOLD, 23));
			labelpuntaje.setForeground(new Color(0, 255, 255));
			labelpuntaje.setBounds(278, 301, 46, 23);
		}
		return labelpuntaje;
	}

	private JLabel getLblPreguntas() {
		if (lblPreguntas == null) {
			lblPreguntas = new JLabel("preguntas");
			lblPreguntas.setForeground(Color.CYAN);
			lblPreguntas.setFont(new Font("Tahoma", Font.BOLD, 23));
			lblPreguntas.setBounds(321, 284, 133, 56);
		}
		return lblPreguntas;
	}

	private JLabel getLblJuegoPerdido() {
		if (lblJuegoPerdido == null) {
			lblJuegoPerdido = new JLabel("Juego perdido");
			lblJuegoPerdido.setForeground(Color.RED);
			lblJuegoPerdido.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblJuegoPerdido.setBounds(170, 31, 228, 56);
		}
		return lblJuegoPerdido;
	}

	private void mostrarPuntaje() {
		int totalPreguntas = totalPreguntas();
		if (jugador.getPuntaje() <= totalPreguntas) {
			contentPanel.cambiarFoto(3);			
			lblMejorSuerteLa.setVisible(true);
			lblHasAcertado.setVisible(true);
			lblJuegoPerdido.setVisible(true);
			lblNewLabel.setVisible(false);
			lblPreguntas.setForeground(Color.RED);
			lblHasAcertado.setForeground(Color.RED);
			lblPreguntas.setForeground(Color.RED);
			labelpuntaje.setForeground(Color.RED);
		} else {			
			lblMejorSuerteLa.setVisible(false);
			lblJuegoPerdido.setVisible(false);
			lblHasAcertado.setVisible(true);
			lblNewLabel.setVisible(true);
		}
	}

	private int totalPreguntas (){
		int a=0;
		for(Nivel n : Juego.getInstance().getNiveles()){
			for(Pregunta p : n.getPreguntas()){
			a++;
			}
		}
		return (a/2)+1;
	}
	 
}
