package gui_Jugador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import auxiliar.Iconeable;
import auxiliar.PanelConFondo;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class CambioDeNivel extends JDialog implements Iconeable {
	
	private static final long serialVersionUID = 620620927477041571L;
	private final PanelConFondo contentPanel = new PanelConFondo();
	
	public static void main(String[] args) {
		try {
			CambioDeNivel dialog = new CambioDeNivel();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CambioDeNivel() {
		setBounds(100, 100, 398, 184);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.cambiarFoto(4);		
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel(
					"Felicidades has completado el nivel");
			lblNewLabel.setForeground(Color.CYAN);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setBounds(15, 43, 373, 69);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton btnContinuar = new JButton("Continuar",icon);
			btnContinuar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnContinuar.setForeground(Color.CYAN);
			btnContinuar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnContinuar.setVerticalTextPosition(SwingConstants.CENTER);
			btnContinuar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnContinuar.setBounds(147, 123, 103, 23);
			contentPanel.add(btnContinuar);
		}
	}

}
