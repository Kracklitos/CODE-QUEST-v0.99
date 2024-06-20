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

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

@SuppressWarnings("unused")
public class AgregarPregunta extends JDialog implements Iconeable {
	
	private static final long serialVersionUID = 933101475640000925L;
	private PanelConFondo contentPanel = new PanelConFondo();
	private JSpinner spinnerNivel;
	private JButton buttonAceptar;
	private JButton buttonCancelar;
	private JFrame padre;	
	private JLabel lblPreguntas;

	public AgregarPregunta(JFrame frame) {
		super(frame, "Seleccione el nivel", true);
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.cambiarFoto(4);
		setResizable(false);
		padre = frame;
		setBounds(100, 100, 450, 177);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setModal(true);
		{
			JLabel lblNewLabel = new JLabel("Seleccionar nivel :");
			lblNewLabel.setForeground(Color.CYAN);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setBounds(75, 100, 151, 14);
			contentPanel.add(lblNewLabel);
		}
		contentPanel.add(getSpinnerNivel());
		contentPanel.add(getButtonAceptar());
		contentPanel.add(getButtonCancelar());
		{
			JLabel lblAgregar = new JLabel("Agregar pregunta");
			lblAgregar.setForeground(Color.CYAN);
			lblAgregar.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblAgregar.setBounds(153, 11, 144, 31);
			contentPanel.add(lblAgregar);
		}
		{
			JLabel lblCantidadActualDe = new JLabel(
					"Cantidad actual de preguntas de este nivel :");
			lblCantidadActualDe.setForeground(Color.CYAN);
			lblCantidadActualDe.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblCantidadActualDe.setBounds(42, 64, 315, 14);
			contentPanel.add(lblCantidadActualDe);
		}
		{
			lblPreguntas = new JLabel("x");
			lblPreguntas.setForeground(Color.CYAN);
			lblPreguntas.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblPreguntas.setBounds(367, 64, 46, 14);
			lblPreguntas.setText(String.valueOf(Juego.getInstance()
					.getNiveles().get(0).getPreguntas().size()));
			contentPanel.add(lblPreguntas);
		}
	}

	private JSpinner getSpinnerNivel() {
		if (spinnerNivel == null) {
			SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Juego
					.getInstance().getNiveles().size(), 1);
			spinnerNivel = new JSpinner(model);
			spinnerNivel.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					int valorSpinner = getNivel();
					lblPreguntas.setText(String.valueOf(Juego.getInstance()
							.getNiveles().get(valorSpinner - 1).getPreguntas()
							.size()));
				}
			});
			spinnerNivel.setForeground(Color.CYAN);
			spinnerNivel.setFont(new Font("Tahoma", Font.BOLD, 13));
			JComponent editor = spinnerNivel.getEditor();
			if (editor instanceof JSpinner.DefaultEditor) {
				JFormattedTextField textField = ((JSpinner.DefaultEditor) editor)
						.getTextField();
				textField.setEditable(false); // Deshabilitar la edición de
												// texto en el
												// JFormattedTextField
			}
			spinnerNivel.setBounds(264, 97, 112, 20);
		}
		return spinnerNivel;
	}

	private JButton getButtonAceptar() {
		if (buttonAceptar == null) {
			buttonAceptar = new JButton("Aceptar", icon);
			buttonAceptar.setHorizontalTextPosition(SwingConstants.CENTER);
			buttonAceptar.setVerticalTextPosition(SwingConstants.CENTER);
			buttonAceptar.setForeground(Color.CYAN);
			buttonAceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
			buttonAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean cancelado = false;
					if (getNivel() - 1 >= 0) {
						Nivel nivel = Juego.getInstance().getNiveles()
								.get(getNivel() - 1);
						int index = getNivel() - 1;
						setVisible(false);
						Edicion ed = new Edicion(padre, null);
						ed.setVisible(true);
						if (nivel.getPreguntas().size() + 1 <= 5) {

							if (!ed.cancelado()) {
								Pregunta pregunta = ed.getPregunta();
								try{
								Administrador.getInstance().agregarPreguntaAdmin(
										index, pregunta);
								NotaInformativa nota = new NotaInformativa("Agregado con éxito");
								nota.setVisible(true);
								ed.dispose();
								}catch(Exception e1){
									NotaInformativa nota = new NotaInformativa("No se pueden repetir las preguntas.");
									nota.setVisible(true);
								}
								
							} else {
								cancelado = true;
								dispose();
							}
						} else {
							cancelado = true;
							NotaInformativa nota = new NotaInformativa("Solo se pueden tener como máximo 5 preguntas.");
							nota.setVisible(true);
							dispose();
						}
					}

				}
			});
			buttonAceptar.setBounds(75, 142, 116, 23);
		}
		return buttonAceptar;
	}

	private JButton getButtonCancelar() {
		if (buttonCancelar == null) {
			buttonCancelar = new JButton("Cancelar", icon);
			buttonCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
			buttonCancelar.setVerticalTextPosition(SwingConstants.CENTER);
			buttonCancelar.setForeground(Color.CYAN);
			buttonCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
			buttonCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			buttonCancelar.setActionCommand("Cancel");
			buttonCancelar.setBounds(264, 142, 116, 23);
		}
		return buttonCancelar;
	}

	private int getNivel() {
		int numero = ((Number) spinnerNivel.getValue()).intValue();
		return numero;
	}

}
