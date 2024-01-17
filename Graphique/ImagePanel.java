package Graphique;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 * Classe qui permet de définir et d'afficher une image de fond sur un JPanel.
 * 
 * Elle hérite de {@code JPanel}.
 */
public class ImagePanel extends JPanel {

		private Image img;
		
		/**
		 * Getter de l'attribut {@code img} de l'objet.
		 * @return Un objet de type {@code Image} qui est l'image de fond.
		 */
		public Image getImg() {
			return img;
			
		}
		/**
		 * Setter de l'attribut {@code img} de l'objet.
		 * @param img Un objet de type {@code Image} qui sera.
		 */
		public void setImg(Image img) {
			this.img = img;
			this.repaint();
			this.revalidate();
		}
		
		/**
		 * Constructeur de la classe  {@code ImagePanel}.
		 * @param img Image que l'on met en fond du JPanel.
		 */
		public ImagePanel(Image img){
			this.setImg(img);
		}
		
		/**
		 * Redéfinition de la méthode paintComponent
		 */
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		}
}
