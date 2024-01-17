package Graphique.States;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Graphique.Vue;

/**
 * Classe qui représente et caractérise la fenêtre de l'interface graphique.
 */
public class Fenetre extends JFrame {
	
	private Container currentPanel;
	private Vue vue;
	private String[] joueurs = null;
	private String importPartie;
	
	/**
	 * Getter de l'attribut {@code joueurs}.
	 * @return La liste des joueurs de la partie.
	 */
	public String[] getJoueurs() {
		return joueurs;
	}

	/**
	 * Setter de l'attribut {@code joueurs}.
	 * @param joueurs La liste des joueurs de la partie.
	 */
	public void setJoueurs(String[] joueurs) {
		this.joueurs = joueurs;
	}
	
	/**
	 * Getter de l'attribut {@code currentPanel}.
	 * @return Le panel actif sur l'interface graphique.
	 */
	public Container getPanel() {
		return currentPanel;
	}
	
	/**
	 * Setter de l'attribut {@code currentPanel}.
	 * @return Le panel à afficher sur l'interface graphique.
	 */
	public void setPanel(Container panel) {
		this.currentPanel = panel;
	}

	/**
	 * Constructeur de la classe.
	 * @param vue La vue à associer à la fenêtre.
	 */
	public Fenetre(Vue vue) {
		super();
		this.setImportPartie(null);
		this.vue = vue;
		propFenetre();
		this.setVisible(true);
	}
	
	/**
	 * Méthode qui permet de définir la fenêtre.
	 */
	private void propFenetre() {
		try {
			   GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			   ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("./assets/vinque_rg.ttf")));
			} catch (IOException|FontFormatException e){
			 //Handle exception
			}
		this.setTitle("Projet LO02 - Jeu Karmaka");
		this.setSize(1200,800);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(vue.getController().getModel().hasSave()) {
			this.currentPanel = new ConteneurMenu(this, 4);
		} else {
			this.currentPanel = new ConteneurMenu(this, 3);
		}
		this.setContentPane(this.currentPanel);
	}
	
	/**
	 * Getter de l'attribut {@code vue}.
	 * @return La vue assoiciée à la fenêtre.
	 */
	public Vue getVue() {
		return vue;
	}
	
	/**
	 * Setter de l'attribut {@code vue}.
	 * @param vue La vue à associer.
	 */
	public void setVue(Vue vue) {
		this.vue = vue;
	}
	
	/**
	 * Méthode permettant de réactualiser graphiquement la fenêtre lors du changement de panel.
	 * @param panel Le nouveau panel de la fenêtre.
	 */
	public void publish(Container panel) {
		setPanel(panel);
		this.getContentPane().repaint();
		render();
	}
	
	/**
	 * Méthode permettant de réactualiser graphiquement la fênetre lors du changement de panel.
	 */
	public void render() {	
		this.setContentPane(currentPanel);
		this.revalidate();
	}
	
	/**
	 * Getter de l'attribut {@code importPartie}
	 * @return La partie importée.
	 */
	public String getImportPartie() {
		return importPartie;
	}

	/**
	 * Setter de l'attribut {@code importPartie}.
	 * @param importPartie La partie à importer.
	 */
	public void setImportPartie(String importPartie) {
		this.importPartie = importPartie;
	}
}
