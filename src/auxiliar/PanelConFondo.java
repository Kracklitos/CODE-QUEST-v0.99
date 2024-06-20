package auxiliar;

import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class PanelConFondo extends JPanel {
	private ArrayList<BufferedImage> imagenes;
	private int indexActual;	

	public PanelConFondo() {
		super();		
		imagenes = new ArrayList<BufferedImage> ();		
		cargarImagenesDeFondo();
	}	

	public void cargarImagenesDeFondo() {		
		// Cargar las imágenes de fondo en el constructor
		try {			
			BufferedImage image2 = ImageIO.read(new File(
					"fotos\\fondo2.jpeg"));
			BufferedImage image3 = ImageIO.read(new File(
					"fotos\\fondo3.png"));
			BufferedImage image4 = ImageIO.read(new File(
					"fotos\\fondo4.jpg"));			
			BufferedImage image5 = ImageIO.read(new File(
					"fotos\\fondo5.jpg"));	
			BufferedImage image6 = ImageIO.read(new File(
					"fotos\\fondo6.png"));
			BufferedImage image7 = ImageIO.read(new File(
					"fotos\\fondo7.png"));
			
			// Agregar las imágenes a la lista			
			
			imagenes.add(image2);
			imagenes.add(image3);
			imagenes.add(image4);
			imagenes.add(image5);
			imagenes.add(image6);
			imagenes.add(image7);			
			
		} catch (IOException ex) {
			ex.printStackTrace();
			
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Dibujar la imagen de fondo actual
		if (indexActual < imagenes.size()) {
			g.drawImage(imagenes.get(indexActual), 0, 0,
					getWidth(), getHeight(), this);
		} 
	}

	// Método para cambiar la imagen de fondo
	public void cambiarFoto(int index) {
		if (index >= 0 && index < imagenes.size()) {
			indexActual = index;
			repaint(); // Volver a pintar el panel para mostrar la nueva imagen
		}
	}

}
