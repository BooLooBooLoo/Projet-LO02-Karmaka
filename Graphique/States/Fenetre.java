package Graphique.States;

import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import Graphique.Vue;

public class Fenetre extends JFrame {
	
	private Container currentPanel;
	private Vue vue;
	private String[] joueurs = null;
	private String importPartie;
	
	public String[] getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(String[] joueurs) {
		this.joueurs = joueurs;
	}

	public Container getPanel() {
		return currentPanel;
	}

	public void setPanel(Container panel) {
		this.currentPanel = panel;
	}

	public Fenetre(Vue vue) {
		super();
		this.setImportPartie(null);
		this.vue = vue;
		propFenetre();
		this.setVisible(true);
	}
	
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
	
	public Vue getVue() {
		return vue;
	}

	public void setVue(Vue vue) {
		this.vue = vue;
	}

	public void publish(Container panel) {
		setPanel(panel);
		this.getContentPane().repaint();
		render();
	}
	
	public void render() {	
		this.setContentPane(currentPanel);
		this.revalidate();
	}

	public String getImportPartie() {
		return importPartie;
	}

	public void setImportPartie(String importPartie) {
		this.importPartie = importPartie;
	}
}
