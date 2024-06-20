package auxiliar;

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
public class NotaInformativa extends JDialog implements Iconeable {

	private PanelConFondo contentPanel = new PanelConFondo();
	private JButton btnAceptar;
	private JLabel labelDinamico;	
	
	public NotaInformativa(String texto) {
		setBounds(100, 100, 394, 110);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.cambiarFoto(5);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnAceptar());
		contentPanel.add(getLabelDinamico());
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setModal(true);
		labelDinamico.setText(texto);
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar",icon);
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnAceptar.setForeground(Color.CYAN);
			btnAceptar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnAceptar.setVerticalTextPosition(SwingConstants.CENTER);
			btnAceptar.setBounds(149, 76, 89, 23);
		}
		return btnAceptar;
	}	
	private JLabel getLabelDinamico() {
		if (labelDinamico == null) {
			labelDinamico = new JLabel("Los campos no deben quedar vac\u00EDos");
			labelDinamico.setForeground(Color.WHITE);
			labelDinamico.setFont(new Font("Tahoma", Font.BOLD, 13));
			labelDinamico.setBounds(22, 23, 362, 23);
		}
		return labelDinamico;
	}
	
	public void setLabelDinamico(String texto) {
		labelDinamico.setText(texto);
		
	}
	
}
