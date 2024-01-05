package Graphique;

import java.awt.Button;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
		private Image img;
		private JButton test = new JButton("Test");
		
		// Getters et setters
		public Image getImg() {
			return img;
		}
		public void setImg(Image img) {
			this.img = img;
		}
		
		// Constructeur
		public ImagePanel(Image img){
			this.img = img;
		}
		
		// paintComponent
		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
			super.paintComponent(g);
		}
}
