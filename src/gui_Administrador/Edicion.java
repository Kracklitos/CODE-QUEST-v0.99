package gui_Administrador;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;

import auxiliar.Iconeable;
import auxiliar.JTextFieldMejorado;
import auxiliar.NotaInformativa;
import auxiliar.PanelConFondo;
import logic.Juego;
import logic.Nivel;
import logic.Pregunta;
import logic.Respuesta;

import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("unused")
public class Edicion extends JDialog implements Iconeable {	
	
	private static final long serialVersionUID = 6740578811776272861L;
	private PanelConFondo contentPanel = new PanelConFondo();
	private JTextFieldMejorado textFieldPregunta;
	private JTextFieldMejorado textFieldRespuesta1;
	private JTextFieldMejorado textFieldRespuesta2;
	private JTextFieldMejorado textFieldRespuesta3;
	private JTextFieldMejorado textFieldRespuesta4;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JFrame padre;
	private final ArrayList<JRadioButton> radioButtons = new ArrayList<JRadioButton>();
	private JRadioButton radioButtonResp2;
	private JRadioButton radioButtonResp1;
	private JRadioButton radioButtonResp3;
	private JRadioButton radioButtonResp4;
	private static boolean cancelado;
	private static boolean preguntaCompleta;	

	public Edicion(JFrame frame, final Nivel nivel) {
		super(frame, "Introduzca los parámetros", true);
		padre = frame;
		contentPanel.cambiarFoto(4);
		setBounds(100, 100, 648, 366);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		cancelado = false;
		preguntaCompleta = false;
		{
			textFieldPregunta = new JTextFieldMejorado();
			textFieldPregunta.setLimite(36);
			textFieldPregunta.setBackground(Color.WHITE);
			textFieldPregunta.setText("");
			textFieldPregunta.setToolTipText("");
			textFieldPregunta.setColumns(10);
			textFieldPregunta.setBounds(160, 38, 456, 20);
			contentPanel.add(textFieldPregunta);
		}
		{
			JLabel label = new JLabel("Pregunta:");
			label.setFont(new Font("Tahoma", Font.BOLD, 13));
			label.setForeground(Color.CYAN);
			label.setBounds(56, 40, 96, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Respuesta 1:");
			label.setFont(new Font("Tahoma", Font.BOLD, 13));
			label.setForeground(Color.CYAN);
			label.setBounds(56, 85, 96, 14);
			contentPanel.add(label);
		}
		{
			textFieldRespuesta1 = new JTextFieldMejorado();
			textFieldRespuesta1.setLimite(36);
			textFieldRespuesta1.setBackground(Color.WHITE);
			textFieldRespuesta1.setText("");
			textFieldRespuesta1.setColumns(10);
			textFieldRespuesta1.setBounds(160, 83, 456, 20);
			contentPanel.add(textFieldRespuesta1);
		}
		{
			JLabel label = new JLabel("Respuesta 2:");
			label.setFont(new Font("Tahoma", Font.BOLD, 13));
			label.setForeground(Color.CYAN);
			label.setBounds(56, 127, 96, 14);
			contentPanel.add(label);
		}
		{
			textFieldRespuesta2 = new JTextFieldMejorado();
			textFieldRespuesta2.setLimite(36);
			textFieldRespuesta2.setBackground(Color.WHITE);
			textFieldRespuesta2.setText("");
			textFieldRespuesta2.setColumns(10);
			textFieldRespuesta2.setBounds(160, 125, 456, 20);
			contentPanel.add(textFieldRespuesta2);
		}
		{
			JLabel label = new JLabel("Respuesta 3:");
			label.setFont(new Font("Tahoma", Font.BOLD, 13));
			label.setForeground(Color.CYAN);
			label.setBounds(56, 169, 96, 14);
			contentPanel.add(label);
		}
		{
			textFieldRespuesta3 = new JTextFieldMejorado();
			textFieldRespuesta3.setLimite(36);
			textFieldRespuesta3.setBackground(Color.WHITE);
			textFieldRespuesta3.setText("");
			textFieldRespuesta3.setColumns(10);
			textFieldRespuesta3.setBounds(160, 167, 456, 20);
			contentPanel.add(textFieldRespuesta3);
		}
		{
			JLabel label = new JLabel("Respuesta 4:");
			label.setFont(new Font("Tahoma", Font.BOLD, 13));
			label.setForeground(Color.CYAN);
			label.setBounds(56, 211, 96, 14);
			contentPanel.add(label);
		}
		{
			textFieldRespuesta4 = new JTextFieldMejorado();
			textFieldRespuesta4.setLimite(36);
			textFieldRespuesta4.setBackground(Color.WHITE);
			textFieldRespuesta4.setText("");
			textFieldRespuesta4.setColumns(10);
			textFieldRespuesta4.setBounds(160, 209, 456, 20);
			contentPanel.add(textFieldRespuesta4);
		}
		{
			JLabel label = new JLabel(
					"Marque cual ser\u00E1 la respuesta correcta");
			label.setFont(new Font("Tahoma", Font.BOLD, 13));
			label.setForeground(Color.CYAN);
			label.setBounds(207, 251, 258, 14);
			contentPanel.add(label);
		}
		{
			radioButtonResp1 = new JRadioButton("Respuesta 1");
			radioButtonResp1.setBackground(Color.WHITE);
			radioButtonResp1.setOpaque(false);			
			radioButtonResp1.setFont(new Font("Tahoma", Font.BOLD, 13));
			radioButtonResp1.setForeground(Color.CYAN);
			buttonGroup.add(radioButtonResp1);
			radioButtonResp1.setSelected(true);
			radioButtonResp1.setBounds(66, 287, 121, 23);
			contentPanel.add(radioButtonResp1);
			radioButtons.add(radioButtonResp1);
		}
		{
			radioButtonResp2 = new JRadioButton("Respuesta 2");
			radioButtonResp2.setOpaque(false);			
			radioButtonResp2.setFont(new Font("Tahoma", Font.BOLD, 13));
			radioButtonResp2.setForeground(Color.CYAN);
			buttonGroup.add(radioButtonResp2);
			radioButtonResp2.setBounds(205, 287, 121, 23);
			contentPanel.add(radioButtonResp2);
			radioButtons.add(radioButtonResp2);
		}
		{
			radioButtonResp3 = new JRadioButton("Respuesta 3");
			radioButtonResp3.setOpaque(false);	
			radioButtonResp3.setFont(new Font("Tahoma", Font.BOLD, 13));
			radioButtonResp3.setForeground(Color.CYAN);
			buttonGroup.add(radioButtonResp3);
			radioButtonResp3.setBounds(344, 287, 121, 23);
			contentPanel.add(radioButtonResp3);
			radioButtons.add(radioButtonResp3);
		}
		{
			radioButtonResp4 = new JRadioButton("Respuesta 4");
			radioButtonResp4.setOpaque(false);				
			radioButtonResp4.setFont(new Font("Tahoma", Font.BOLD, 13));
			radioButtonResp4.setForeground(Color.CYAN);
			buttonGroup.add(radioButtonResp4);
			radioButtonResp4.setBounds(483, 287, 121, 23);
			contentPanel.add(radioButtonResp4);
			radioButtons.add(radioButtonResp4);
		}
		{
			JButton buttonAceptar = new JButton("Aceptar", icon);
			buttonAceptar.setHorizontalTextPosition(SwingConstants.CENTER);
			buttonAceptar.setVerticalTextPosition(SwingConstants.CENTER);
			buttonAceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
			buttonAceptar.setForeground(Color.CYAN);
			buttonAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getPregunta();
					if (nivel == null && preguntaCompleta) {
						setVisible(false);
					}

				}
			});
			buttonAceptar.setBounds(176, 332, 96, 23);
			contentPanel.add(buttonAceptar);
		}
		{
			JButton buttonCancelar = new JButton("Cancelar", icon);
			buttonCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
			buttonCancelar.setVerticalTextPosition(SwingConstants.CENTER);
			buttonCancelar.setForeground(Color.CYAN);
			buttonCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
			buttonCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cancelado = true;
					dispose();
				}
			});
			buttonCancelar.setBounds(400, 332, 96, 23);
			contentPanel.add(buttonCancelar);
		}
		if (nivel == null) {
			textFieldPregunta.setText("");
			textFieldRespuesta1.setText("");
			textFieldRespuesta2.setText("");
			textFieldRespuesta3.setText("");
			textFieldRespuesta4.setText("");
		}
	}

	public Pregunta getPregunta() {
		Pregunta pregunta = null;
		preguntaCompleta = false;

		if (textFieldPregunta.getText().trim().isEmpty()
				|| textFieldRespuesta1.getText().trim().isEmpty()
				|| textFieldRespuesta2.getText().trim().isEmpty()
				|| textFieldRespuesta3.getText().trim().isEmpty()
				|| textFieldRespuesta4.getText().trim().isEmpty()) {
			NotaInformativa nota = new NotaInformativa("Por favor complete todos los campos.");
			nota.setVisible(true);
		}else if (textFieldPregunta.getText().trim().equalsIgnoreCase(textFieldRespuesta1.getText().trim())
				|| textFieldPregunta.getText().trim().equalsIgnoreCase(textFieldRespuesta2.getText().trim())
				|| textFieldPregunta.getText().trim().equalsIgnoreCase(textFieldRespuesta3.getText().trim())
				|| textFieldPregunta.getText().trim().equalsIgnoreCase(textFieldRespuesta4.getText().trim())
				|| textFieldRespuesta1.getText().trim().equalsIgnoreCase(textFieldRespuesta2.getText().trim())
				|| textFieldRespuesta1.getText().trim().equalsIgnoreCase(textFieldRespuesta3.getText().trim())
				|| textFieldRespuesta1.getText().trim().equalsIgnoreCase(textFieldRespuesta4.getText().trim())
				|| textFieldRespuesta2.getText().trim().equalsIgnoreCase(textFieldRespuesta3.getText().trim())
				|| textFieldRespuesta2.getText().trim().equalsIgnoreCase(textFieldRespuesta4.getText().trim())
				|| textFieldRespuesta3.getText().trim().equalsIgnoreCase(textFieldRespuesta4.getText().trim())
				) {
			NotaInformativa nota = new NotaInformativa("No puede repetir las respuestas o preguntas.");
			nota.setVisible(true);
		}else
			preguntaCompleta = true;
		if (isAnswerSelected() && preguntaCompleta) {
			preguntaCompleta = true;
			ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
			switch (seleccionRadioButton()) {
			case 0:
				Respuesta respuesta1 = new Respuesta(
						textFieldRespuesta1.getText(), true);
				Respuesta respuesta2 = new Respuesta(
						textFieldRespuesta2.getText(), false);
				Respuesta respuesta3 = new Respuesta(
						textFieldRespuesta3.getText(), false);
				Respuesta respuesta4 = new Respuesta(
						textFieldRespuesta4.getText(), false);
				respuestas.add(respuesta1);
				respuestas.add(respuesta2);
				respuestas.add(respuesta3);
				respuestas.add(respuesta4);
				break;
			case 1:
				Respuesta respuesta11 = new Respuesta(
						textFieldRespuesta1.getText(), false);
				Respuesta respuesta21 = new Respuesta(
						textFieldRespuesta2.getText(), true);
				Respuesta respuesta31 = new Respuesta(
						textFieldRespuesta3.getText(), false);
				Respuesta respuesta41 = new Respuesta(
						textFieldRespuesta4.getText(), false);
				respuestas.add(respuesta11);
				respuestas.add(respuesta21);
				respuestas.add(respuesta31);
				respuestas.add(respuesta41);
				break;
			case 2:
				Respuesta respuesta12 = new Respuesta(
						textFieldRespuesta1.getText(), false);
				Respuesta respuesta22 = new Respuesta(
						textFieldRespuesta2.getText(), false);
				Respuesta respuesta32 = new Respuesta(
						textFieldRespuesta3.getText(), true);
				Respuesta respuesta42 = new Respuesta(
						textFieldRespuesta4.getText(), false);
				respuestas.add(respuesta12);
				respuestas.add(respuesta22);
				respuestas.add(respuesta32);
				respuestas.add(respuesta42);
				break;
			case 3:
				Respuesta respuesta13 = new Respuesta(
						textFieldRespuesta1.getText(), false);
				Respuesta respuesta23 = new Respuesta(
						textFieldRespuesta2.getText(), false);
				Respuesta respuesta33 = new Respuesta(
						textFieldRespuesta3.getText(), false);
				Respuesta respuesta43 = new Respuesta(
						textFieldRespuesta4.getText(), true);
				respuestas.add(respuesta13);
				respuestas.add(respuesta23);
				respuestas.add(respuesta33);
				respuestas.add(respuesta43);
				break;
			}

			pregunta = new Pregunta(textFieldPregunta.getText(), respuestas,
					seleccionRadioButton());
		}

		return pregunta;
	}

	private boolean isAnswerSelected() {
		boolean marcada = false;
		for (int i = 0; i < radioButtons.size(); i++) {
			if (radioButtons.get(i).isSelected()) {
				marcada = true;
			}
		}
		return marcada;
	}

	private int seleccionRadioButton() {
		int respuestaSeleccionada = -1;
		for (int i = 0; i < radioButtons.size(); i++) {
			if (radioButtons.get(i).isSelected()) {
				respuestaSeleccionada = i;
			}
		}
		return respuestaSeleccionada;
	}

	private void seleccionarRespuestaCorrecta(int respuestaCorrecta) {
		for (JRadioButton radio : radioButtons) {
			if (radio == radioButtons.get(respuestaCorrecta))
				radio.setSelected(true);
		}
	}

	public void addPregunta(Pregunta pregunta, ArrayList<Pregunta> preguntas) {
		boolean mal=false; 
		for(Pregunta p :preguntas){
			if(p.getPregunta().equalsIgnoreCase(pregunta.getPregunta())|| pregunta.getRespuestas().equals(p.getRespuestas()))
				mal = true;
		}
		if (!preguntas.contains(pregunta) && pregunta != null && !mal) {
			preguntas.add(pregunta);
		} else{
			NotaInformativa nota = new NotaInformativa("No se pueden repetir las preguntas dentro del nivel.");
		nota.setVisible(true);
		}
		
	}
	
	public boolean addPregunta(Pregunta pregunta) {
		boolean encontrado = false;
		for (Nivel n : Juego.getInstance().getNiveles()) {

			for (Pregunta p : n.getPreguntas()) {
				if (p.getPregunta().equalsIgnoreCase(p.getPregunta())
						|| pregunta.getRespuestas().equals(p.getRespuestas())
						|| pregunta == null) {
					encontrado = true;
				}
			}
		}
		if (encontrado){
			NotaInformativa nota = new NotaInformativa(
					"La respuesta no puede estar repetida ni vacía.");
			nota.setVisible(true);
		}
		return encontrado;
	}

	public boolean cancelado() {
		return cancelado;
	}

	public void setCampos(Nivel nivel, int indexPregunta) {
		ArrayList<Pregunta> preguntas = nivel.getPreguntas();
		textFieldPregunta.setText(preguntas.get(indexPregunta).getPregunta());
		textFieldRespuesta1.setText(preguntas.get(indexPregunta)
				.getRespuestas().get(0).getTexto());
		textFieldRespuesta2.setText(preguntas.get(indexPregunta)
				.getRespuestas().get(1).getTexto());
		textFieldRespuesta3.setText(preguntas.get(indexPregunta)
				.getRespuestas().get(2).getTexto());
		textFieldRespuesta4.setText(preguntas.get(indexPregunta)
				.getRespuestas().get(3).getTexto());
		seleccionarRespuestaCorrecta(nivel.getPreguntas().get(indexPregunta)
				.getRespuestaCorrecta());
	}

}
