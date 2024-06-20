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
public class EditarNivel extends JDialog implements Iconeable {

	private static final long serialVersionUID = 933101475640000925L;
	private PanelConFondo contentPanel = new PanelConFondo();
	private JSpinner spinnerNivel;
	private JButton buttonAceptar;
	private JButton buttonCancelar;
	private JFrame padre;

	public EditarNivel(JFrame frame) {
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
		contentPanel.add(getSpinnerNivel());
		contentPanel.add(getButtonAceptar());
		contentPanel.add(getButtonCancelar());
		setModal(true);
		{
			JLabel lblModificarNivel = new JLabel("Modificar nivel");
			lblModificarNivel.setForeground(Color.CYAN);
			lblModificarNivel.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblModificarNivel.setBounds(159, 11, 132, 31);
			contentPanel.add(lblModificarNivel);
		}
		{
			JLabel lblSeleccionarNivel = new JLabel("Seleccionar nivel :");
			lblSeleccionarNivel.setForeground(Color.CYAN);
			lblSeleccionarNivel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSeleccionarNivel.setBounds(72, 84, 151, 14);
			contentPanel.add(lblSeleccionarNivel);
		}
		{
			JLabel label = new JLabel("Cantidad actual de niveles :");
			label.setForeground(Color.CYAN);
			label.setFont(new Font("Tahoma", Font.BOLD, 13));
			label.setBounds(72, 56, 216, 14);
			contentPanel.add(label);
		}
		{
			JLabel labelNiveles = new JLabel("x");
			labelNiveles.setForeground(Color.CYAN);
			labelNiveles.setFont(new Font("Tahoma", Font.BOLD, 13));
			labelNiveles.setBounds(313, 56, 47, 14);
			labelNiveles.setText(String.valueOf(Juego.getInstance()
					.getNiveles().size()));
			contentPanel.add(labelNiveles);
		}
	}

	private JSpinner getSpinnerNivel() {
		if (spinnerNivel == null) {
			SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Juego
					.getInstance().getNiveles().size(), 1);
			spinnerNivel = new JSpinner(model);
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
			spinnerNivel.setBounds(259, 81, 101, 20);
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
						int index = Juego.getInstance().getNiveles()
								.indexOf(nivel);
						int cantPreguntas = nivel.getPreguntas().size();
						setVisible(false);
						ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
						for (int i = 0; i < cantPreguntas && !cancelado; i++) {
							Edicion ed = new Edicion(padre, null);
							ed.setCampos(nivel, i);
							ed.setVisible(true);
							if (!ed.cancelado()) {
								ed.addPregunta(ed.getPregunta(), preguntas);
								NotaInformativa nota = new NotaInformativa(
										"Modificado con éxito");
								nota.setVisible(true);
								ed.dispose();
							} else
								cancelado = true;
						}
						if (!cancelado) {
							Nivel nivelnew = new Nivel(preguntas);
							Administrador.getInstance().modificarNivelAdmin(
									nivelnew, index);
						}
						dispose();
					} else {
						NotaInformativa nota = new NotaInformativa(
								"Seleccione un nivel correcto");
						nota.setVisible(true);
					}
				}
			});
			buttonAceptar.setBounds(72, 127, 101, 23);
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
			buttonCancelar.setBounds(259, 127, 101, 23);
		}
		return buttonCancelar;
	}

	private int getNivel() {
		int numero = ((Number) spinnerNivel.getValue()).intValue();
		return numero;
	}

}
