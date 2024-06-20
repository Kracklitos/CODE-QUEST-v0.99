package auxiliar;

import gui_Jugador.Cuestionario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Prevencion2 extends JDialog implements Iconeable {

	private static final long serialVersionUID = 7750680192654148138L;
	private final PanelConFondo contentPanel = new PanelConFondo();
	private JButton btnCerrar;
	private JLabel lblDebeSeleccionarUna;
	private Cuestionario cuestionario ;


	public Prevencion2(Cuestionario cuestionario,String texto) {
		setBounds(100, 100, 394, 110);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.cambiarFoto(5);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnCerrar());
		contentPanel.add(getLblDebeSeleccionarUna());
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setLabelDinamico(texto);
		this.cuestionario=cuestionario;
		setModal(true);
		
	}

	private JButton getBtnCerrar() {
		if (btnCerrar == null) {
			btnCerrar = new JButton("Cerrar", icon);
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cuestionario.temporizador();
					dispose();
				}
			});
			btnCerrar.setForeground(Color.CYAN);
			btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnCerrar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnCerrar.setVerticalTextPosition(SwingConstants.CENTER);
			btnCerrar.setBounds(152, 76, 89, 23);
		}
		return btnCerrar;
	}

	private JLabel getLblDebeSeleccionarUna() {
		if (lblDebeSeleccionarUna == null) {
			lblDebeSeleccionarUna = new JLabel("Debe seleccionar una respuesta");
			lblDebeSeleccionarUna.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblDebeSeleccionarUna.setForeground(Color.WHITE);
			lblDebeSeleccionarUna.setBounds(31, 0, 351, 50);
		}
		return lblDebeSeleccionarUna;
	}
	
	public void setLabelDinamico(String texto) {
		lblDebeSeleccionarUna.setText(texto);
		
	}
}
