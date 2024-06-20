package gui_Administrador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import logic.Administrador;
import logic.Juego;
import logic.Nivel;
import logic.Pregunta;

import javax.swing.SpinnerModel;

import auxiliar.Iconeable;
import auxiliar.NotaInformativa;
import auxiliar.PanelConFondo;

import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("unused")
public class EliminarPregunta extends JDialog implements Iconeable {

	private static final long serialVersionUID = 933101475640000925L;
	private final PanelConFondo contentPanel = new PanelConFondo();
	private JSpinner spinnerNivel;
	private JButton buttonAceptar;
	private JButton buttonCancelar;
	private JFrame padre;
	private JLabel lblPregunta;
	private JSpinner spinnerPregunta;
	private JLabel lblEliminarPregunta;
	private JLabel label_1;
	private JLabel label_2;

	public EliminarPregunta(JFrame frame) {
		super(frame, "Seleccione el nivel y la pregunta a eliminar", true);
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
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setForeground(Color.CYAN);
			lblNewLabel.setBounds(74, 81, 127, 14);
			contentPanel.add(lblNewLabel);
		}
		contentPanel.add(getSpinnerNivel());
		contentPanel.add(getButtonAceptar());
		contentPanel.add(getButtonCancelar());
		contentPanel.add(getLblPregunta());
		contentPanel.add(getSpinnerPregunta());
		contentPanel.add(getLblEliminarPregunta());
		contentPanel.add(getLabel_1_1());
		contentPanel.add(getLabel_2());
	}

	private JSpinner getSpinnerNivel() {
		if (spinnerNivel == null) {
			SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Juego
					.getInstance().getNiveles().size(), 1);
			spinnerNivel = new JSpinner(model);
			spinnerNivel.setFont(new Font("Tahoma", Font.BOLD, 13));
			// Obtener el JFormattedTextField del JSpinner y deshabilitar la
			// edición de texto
			JComponent editor = spinnerNivel.getEditor();
			if (editor instanceof JSpinner.DefaultEditor) {
				JFormattedTextField textField = ((JSpinner.DefaultEditor) editor)
						.getTextField();
				textField.setEditable(false); // Deshabilitar la edición de
												// texto en el
												// JFormattedTextField
			}
			spinnerNivel.setBounds(275, 78, 101, 20);
		}
		return spinnerNivel;
	}

	private JLabel getLblPregunta() {
		if (lblPregunta == null) {
			lblPregunta = new JLabel("Seleccionar pregunta :");
			lblPregunta.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblPregunta.setForeground(Color.CYAN);
			lblPregunta.setBounds(74, 107, 163, 19);
		}
		return lblPregunta;
	}

	private JSpinner getSpinnerPregunta() {
		if (spinnerPregunta == null) {
			SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Juego
					.getInstance().getNiveles().get(0).getPreguntas().size(), 1);
			spinnerPregunta = new JSpinner(model);
			spinnerPregunta.setFont(new Font("Tahoma", Font.BOLD, 13));
			spinnerNivel.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					int valorSpinner1 = getNivel() - 1;
					SpinnerModel newModel2 = new SpinnerNumberModel(1, 1, Juego
							.getInstance().getNiveles().get(valorSpinner1)
							.getPreguntas().size(), 1);
					spinnerPregunta.setModel(newModel2);
					// Obtener el JFormattedTextField del JSpinner y
					// deshabilitar la edición de texto
					JComponent editor = spinnerPregunta.getEditor();
					if (editor instanceof JSpinner.DefaultEditor) {
						JFormattedTextField textField = ((JSpinner.DefaultEditor) editor)
								.getTextField();
						textField.setEditable(false); // Deshabilitar la edición
														// de texto en el
														// JFormattedTextField
					}
				}
			});// Obtener el JFormattedTextField del JSpinner y deshabilitar la
				// edición de texto
			JComponent editor = spinnerPregunta.getEditor();
			if (editor instanceof JSpinner.DefaultEditor) {
				JFormattedTextField textField = ((JSpinner.DefaultEditor) editor)
						.getTextField();
				textField.setEditable(false); // Deshabilitar la edición de
												// texto en el
												// JFormattedTextField
			}

			spinnerPregunta.setBounds(275, 109, 101, 20);
		}
		return spinnerPregunta;
	}

	private JButton getButtonAceptar() {
		if (buttonAceptar == null) {
			buttonAceptar = new JButton("Aceptar", icon);
			buttonAceptar.setHorizontalTextPosition(SwingConstants.CENTER);
			buttonAceptar.setVerticalTextPosition(SwingConstants.CENTER);
			buttonAceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
			buttonAceptar.setForeground(Color.CYAN);
			buttonAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Nivel nivel = Juego.getInstance().getNiveles()
							.get(getNivel() - 1);
					int indexNivel = getNivel() - 1;
					int indexPregunta = getPregunta() - 1;
					if (indexNivel >= 0 && indexPregunta >= 0) {
						if (Administrador.getInstance().eliminarPreguntaAdmin(
								indexNivel, indexPregunta)) {

							NotaInformativa nota = new NotaInformativa(
									"Eliminado con éxito");
							nota.setVisible(true);
							dispose();
						} else {
							NotaInformativa nota = new NotaInformativa(
									"Eliminación fallida, el nivel no puede quedar sin preguntas");
							nota.setVisible(true);
							dispose();
						}
					} else {
						NotaInformativa nota = new NotaInformativa(
								"Eliminación fallida, seleccione un nivel o pregunta correctos");
						nota.setVisible(true);
					}
				}
			});
			buttonAceptar.setBounds(74, 138, 101, 23);
		}
		return buttonAceptar;
	}

	private JButton getButtonCancelar() {
		if (buttonCancelar == null) {
			buttonCancelar = new JButton("Cancelar", icon);
			buttonCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
			buttonCancelar.setVerticalTextPosition(SwingConstants.CENTER);
			buttonCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
			buttonCancelar.setForeground(Color.CYAN);
			buttonCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			buttonCancelar.setActionCommand("Cancel");
			buttonCancelar.setBounds(275, 140, 101, 23);
		}
		return buttonCancelar;
	}

	private int getPregunta() {
		int numero = ((Number) spinnerPregunta.getValue()).intValue();
		return numero;
	}

	private int getNivel() {
		int numero = ((Number) spinnerNivel.getValue()).intValue();
		return numero;
	}

	private JLabel getLblEliminarPregunta() {
		if (lblEliminarPregunta == null) {
			lblEliminarPregunta = new JLabel("Eliminar pregunta");
			lblEliminarPregunta.setForeground(Color.CYAN);
			lblEliminarPregunta.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblEliminarPregunta.setBounds(153, 12, 144, 31);
		}
		return lblEliminarPregunta;
	}

	private JLabel getLabel_1_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Cantidad actual de niveles :");
			label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			label_1.setForeground(Color.CYAN);
			label_1.setBounds(74, 55, 216, 14);
		}
		return label_1;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("x");
			label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			label_2.setForeground(Color.CYAN);
			label_2.setBounds(329, 53, 47, 14);
			label_2.setText(String.valueOf(Juego.getInstance().getNiveles()
					.size()));
		}
		return label_2;
	}
}
