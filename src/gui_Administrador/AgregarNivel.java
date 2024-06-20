package gui_Administrador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import auxiliar.Iconeable;
import auxiliar.NotaInformativa;
import auxiliar.PanelConFondo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import logic.Administrador;
import logic.Juego;
import logic.Nivel;
import logic.Pregunta;

import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("unused")
public class AgregarNivel extends JDialog implements Iconeable{

	private static final long serialVersionUID = 1L;
	private PanelConFondo contentPanel = new PanelConFondo();
	private JFrame padre;
	private JSpinner spinner;
	private boolean cancelado;	

	public AgregarNivel(JFrame admin) {
		super(admin, "Agregar Nivel", true);
		setResizable(false);
		padre = admin;
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.cambiarFoto(4);
		setBounds(100, 100, 450, 177);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		cancelado = false;
		setModal(true);
		{
			JLabel lblNewLabel = new JLabel(
					"Cantidad de preguntas :");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setForeground(Color.CYAN);
			lblNewLabel.setBounds(79, 98, 186, 17);
			contentPanel.add(lblNewLabel);
		}
		{
			SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 5, 1);
			spinner = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
			spinner.setForeground(Color.CYAN);
			spinner.setFont(new Font("Tahoma", Font.BOLD, 13));
			spinner.setBackground(new Color(0, 0, 255));
			spinner.setBounds(275, 96, 101, 20);
			JComponent editor = spinner.getEditor();
			if (editor instanceof JSpinner.DefaultEditor) {
				JFormattedTextField textField = ((JSpinner.DefaultEditor) editor)
						.getTextField();
				textField.setEditable(false); // Deshabilitar la edición de
												// texto en el
												// JFormattedTextField
			}
			contentPanel.add(spinner);
		}
		{
			JButton btnAgregar = new JButton("Agregar", icon);
			btnAgregar.setForeground(Color.CYAN);
			btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnAgregar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnAgregar.setVerticalTextPosition(SwingConstants.CENTER);
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean cancelado = false;
					int cantPreguntas = getCantPreguntas();
					setVisible(false);
					ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
					for (int i = 0; i < cantPreguntas && !cancelado; i++) {
						Edicion ed = new Edicion(padre, null);
						ed.setVisible(true);
						if (!ed.cancelado()) {
							try{
							ed.addPregunta(ed.getPregunta(), preguntas);
							ed.dispose();
							}catch(Exception eo){
								NotaInformativa nota = new NotaInformativa("No se pueden repetir las preguntas dentro del nivel.");
								nota.setVisible(true);
							}
							
						} else
							cancelado = true;
					}
					if (!cancelado) {
						Nivel nivel = new Nivel(preguntas);
						try{
						Administrador.getInstance().agregarNivelAdmin(nivel);
						NotaInformativa nota = new NotaInformativa("Agregado con éxito");
						nota.setVisible(true);
						}catch(Exception e1){
							NotaInformativa nota = new NotaInformativa("No se pueden repetir los niveles.");
							nota.setVisible(true);
						}
					}
					dispose();
				}
			});
			btnAgregar.setBounds(79, 145, 101, 23);
			contentPanel.add(btnAgregar);
		}
		{
			JButton btnCancelar = new JButton("Cancelar", icon);
			btnCancelar.setForeground(Color.CYAN);
			btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnCancelar.setVerticalTextPosition(SwingConstants.CENTER);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setBounds(275, 145, 101, 23);
			contentPanel.add(btnCancelar);
		}
		{
			JLabel lblAgregarNivel = new JLabel("Agregar nivel ");
			lblAgregarNivel.setForeground(Color.CYAN);
			lblAgregarNivel.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblAgregarNivel.setBounds(163, 11, 123, 31);
			contentPanel.add(lblAgregarNivel);
		}
		{
			JLabel lblCantidadActualDe = new JLabel(
					"Cantidad actual de niveles :");
			lblCantidadActualDe.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblCantidadActualDe.setForeground(Color.CYAN);
			lblCantidadActualDe.setBounds(79, 62, 216, 14);
			contentPanel.add(lblCantidadActualDe);
		}
		{
			JLabel lblX = new JLabel("x");
			lblX.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblX.setForeground(Color.CYAN);
			lblX.setBounds(329, 62, 47, 14);
			lblX.setText(String
					.valueOf(Juego.getInstance().getNiveles().size()));
			contentPanel.add(lblX);
		}
	}

	private int getCantPreguntas() {
		int numero = ((Number) spinner.getValue()).intValue();
		return numero;
	}

}
