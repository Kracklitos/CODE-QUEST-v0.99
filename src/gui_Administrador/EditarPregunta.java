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
public class EditarPregunta extends JDialog implements Iconeable {

	private static final long serialVersionUID = 933101475640000925L;
	private PanelConFondo contentPanel = new PanelConFondo();
	private JSpinner spinnerNivel;
	private JButton buttonAceptar;
	private JButton buttonCancelar;
	private JFrame padre;
	private JSpinner spinnerPregunta;
	private JLabel lblModificarPregunta;
	private JLabel lblSeleccionarNivel;
	private JLabel lblSeleccionarPregunta;
	private JLabel label_1;
	private JLabel label_2;

	public EditarPregunta(JFrame frame) {
		super(frame, "Seleccione el nivel y la pregunta a editar", true);
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
		contentPanel.add(getSpinnerNivel());
		contentPanel.add(getButtonAceptar());
		contentPanel.add(getButtonCancelar());
		contentPanel.add(getSpinnerPregunta());
		contentPanel.add(getLblModificarPregunta());
		contentPanel.add(getLblSeleccionarNivel());
		contentPanel.add(getLblSeleccionarPregunta());
		contentPanel.add(getLabel_1_1());
		contentPanel.add(getLabel_2_1());
		setModal(true);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("OK");
				okButton.setBounds(312, 5, 47, 23);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBounds(364, 5, 65, 23);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private JSpinner getSpinnerNivel() {
		if (spinnerNivel == null) {
			SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Juego
					.getInstance().getNiveles().size(), 1);
			spinnerNivel = new JSpinner(model);
			spinnerNivel.setFont(new Font("Tahoma", Font.BOLD, 13));
			spinnerNivel.setBounds(280, 81, 101, 20);
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
		}
		return spinnerNivel;
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
			spinnerPregunta.setBounds(280, 111, 101, 20);
		}
		return spinnerPregunta;
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
						int indexNivel = getNivel() - 1;
						int indexPregunta = getPregunta() - 1;
						setVisible(false);
						Edicion ed = new Edicion(padre, null);
						ed.setCampos(nivel, indexPregunta);
						ed.setVisible(true);
						if (!ed.cancelado()) {
							Pregunta pregunta = ed.getPregunta();
							Administrador.getInstance().modificarPreguntaAdmin(
									indexNivel, indexPregunta, pregunta);
							NotaInformativa nota = new NotaInformativa(
									"Modificada con éxito");
							nota.setVisible(true);
							ed.dispose();
						} else
							cancelado = true;
						dispose();
					} else {
						NotaInformativa nota = new NotaInformativa(
								"Seleccione un nivel correcto");
						nota.setVisible(true);
					}
				}
			});
			buttonAceptar.setBounds(69, 138, 101, 23);
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
			buttonCancelar.setBounds(280, 138, 101, 23);
		}
		return buttonCancelar;
	}

	private int getNivel() {
		int numero = ((Number) spinnerNivel.getValue()).intValue();
		return numero;
	}

	private int getPregunta() {
		int numero = ((Number) spinnerPregunta.getValue()).intValue();
		return numero;
	}

	private JLabel getLblModificarPregunta() {
		if (lblModificarPregunta == null) {
			lblModificarPregunta = new JLabel("Modificar pregunta");
			lblModificarPregunta.setForeground(Color.CYAN);
			lblModificarPregunta.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblModificarPregunta.setBounds(150, 11, 150, 31);
		}
		return lblModificarPregunta;
	}

	private JLabel getLblSeleccionarNivel() {
		if (lblSeleccionarNivel == null) {
			lblSeleccionarNivel = new JLabel("Seleccionar nivel :");
			lblSeleccionarNivel.setForeground(Color.CYAN);
			lblSeleccionarNivel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSeleccionarNivel.setBounds(69, 84, 142, 14);
		}
		return lblSeleccionarNivel;
	}

	private JLabel getLblSeleccionarPregunta() {
		if (lblSeleccionarPregunta == null) {
			lblSeleccionarPregunta = new JLabel("Seleccionar pregunta :");
			lblSeleccionarPregunta.setForeground(Color.CYAN);
			lblSeleccionarPregunta.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSeleccionarPregunta.setBounds(69, 111, 171, 14);
		}
		return lblSeleccionarPregunta;
	}

	private JLabel getLabel_1_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Cantidad actual de niveles :");
			label_1.setForeground(Color.CYAN);
			label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			label_1.setBounds(69, 55, 216, 14);
		}
		return label_1;
	}

	private JLabel getLabel_2_1() {
		if (label_2 == null) {
			label_2 = new JLabel("x");
			label_2.setForeground(Color.CYAN);
			label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
			label_2.setText(String.valueOf(Juego.getInstance().getNiveles()
					.size()));
			label_2.setBounds(311, 55, 47, 14);
		}
		return label_2;
	}
}
