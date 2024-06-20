package gui_Administrador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import auxiliar.Iconeable;
import auxiliar.NotaInformativa;
import auxiliar.PanelConFondo;
import logic.Administrador;
import logic.Juego;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings({ "unused" })
public class EliminarNivel extends JDialog implements Iconeable{
	
	private static final long serialVersionUID = -1580755927517365738L;
	private PanelConFondo contentPanel = new PanelConFondo();
	private JSpinner spinnerNivel;
	private JLabel lblNewLabel;	

	public EliminarNivel() {
		setResizable(false);
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.cambiarFoto(4);
		setBounds(100, 100, 450, 177);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.CYAN);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setModal(true);
		{
			SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Juego
					.getInstance().getNiveles().size(), 1);
			spinnerNivel = new JSpinner(model);
			spinnerNivel.setFont(new Font("Tahoma", Font.BOLD, 13));
			spinnerNivel.setForeground(Color.CYAN);
			spinnerNivel.setBounds(267, 94, 99, 20);
			JComponent editor = spinnerNivel.getEditor();
			if (editor instanceof JSpinner.DefaultEditor) {
				JFormattedTextField textField = ((JSpinner.DefaultEditor) editor)
						.getTextField();
				textField.setEditable(false); 
			}
			contentPanel.add(spinnerNivel);
		}
		{
			JButton btnEliminar = new JButton("Eliminar", icon);
			btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnEliminar.setForeground(Color.CYAN);
			btnEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
			btnEliminar.setVerticalTextPosition(SwingConstants.CENTER);
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getNivel() - 1 >= 0) {
						if (Administrador.getInstance().eliminarNivelAdmin(
								getNivel() - 1)) {
							NotaInformativa nota = new NotaInformativa(
									"Eliminado con éxito");
							nota.setVisible(true);
							dispose();
						} else {
							NotaInformativa nota = new NotaInformativa(
									"Eliminación fallida, el juego no puede quedar sin niveles");
							nota.setVisible(true);
							dispose();
						}
					} else{
						NotaInformativa nota = new NotaInformativa(
								"Eliminación fallida, seleccione un nivel correcto");
						nota.setVisible(true);
				}}
			});
			btnEliminar.setBounds(84, 133, 99, 23);
			contentPanel.add(btnEliminar);
		}
		{
			JButton buttonCancelar = new JButton("Cancelar", icon);
			buttonCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
			buttonCancelar.setForeground(Color.CYAN);
			buttonCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
			buttonCancelar.setVerticalTextPosition(SwingConstants.CENTER);
			buttonCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			buttonCancelar.setBounds(267, 133, 99, 23);
			contentPanel.add(buttonCancelar);
		}
		contentPanel.add(getLblNewLabel());
		{
			JLabel lblSeleccionarNivel = new JLabel("Seleccionar nivel :");
			lblSeleccionarNivel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSeleccionarNivel.setForeground(Color.CYAN);
			lblSeleccionarNivel.setBounds(84, 97, 151, 14);
			contentPanel.add(lblSeleccionarNivel);
		}
		{
			JLabel label = new JLabel("Cantidad actual de niveles :");
			label.setFont(new Font("Tahoma", Font.BOLD, 13));
			label.setForeground(Color.CYAN);
			label.setBounds(84, 69, 203, 14);
			contentPanel.add(label);
		}
		{
			JLabel labelNiveles = new JLabel("x");
			labelNiveles.setFont(new Font("Tahoma", Font.BOLD, 13));
			labelNiveles.setForeground(Color.CYAN);
			labelNiveles.setBounds(299, 69, 47, 14);
			labelNiveles.setText(String.valueOf(Juego.getInstance()
					.getNiveles().size()));
			contentPanel.add(labelNiveles);
		}
	}

	private int getNivel() {
		int numero = ((Number) spinnerNivel.getValue()).intValue();
		return numero;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Eliminar nivel");
			lblNewLabel.setForeground(Color.CYAN);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel.setBounds(167, 11, 115, 31);
		}
		return lblNewLabel;
	}
}
