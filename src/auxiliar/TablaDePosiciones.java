package auxiliar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;

import logic.Jugador;
import logic.Usuario;

import java.awt.Color;
import java.awt.Font;

public class TablaDePosiciones extends JDialog {
	private static final long serialVersionUID = 7154315006433053736L;
	PanelConFondo contentPane = new PanelConFondo();
	

	public TablaDePosiciones(JFrame parent, ArrayList<Usuario> users) {
		super(parent, "Tabla de Puntajes", true);
		contentPane.cambiarFoto(2);
		setResizable(false);
		// Organizar la lista de Jugadors por puntaje de mayor a menor

		for (int i = 0; i < users.size() - 1; i++) {
			for (int j = 0; j < users.size() - i - 1; j++) {
				if (((Jugador) users.get(j)).getPuntaje() < ((Jugador) users.get(j + 1)).getPuntaje()) {
					// Intercambiamos los elementos si están en el orden
					// incorrecto
					Jugador temp = (Jugador) users.get(j);
					users.set(j, users.get(j + 1));
					users.set(j + 1, temp);
				}
			}
		}
		// Crear los datos para la tabla
		Object[][] data = new Object[users.size()][2];
		for (int i = 0; i < users.size(); i++) {
			data[i][0] = users.get(i).getNombre();
			data[i][1] = ((Jugador) users.get(i)).getPuntaje();
		}

		// Crear las columnas de la tabla
		String[] columns = { "Jugador", "Puntaje" };

		// Crear el modelo de la tabla
		DefaultTableModel model = new DefaultTableModel(data, columns);

		// Crear la tabla con el modelo
		JTable table = new JTable(model);
		table.setForeground(Color.CYAN);
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setBackground(Color.DARK_GRAY);
		
		//contentPane.add(table);

		// Agregar la tabla a un JScrollPane
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane);

		// Configurar la ventana
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(parent);

	}

}
