package Graphique.States;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

import Graphique.Vue;

public class Fenetre extends JFrame {
	
	private Container currentPanel;
	private Vue vue;
	private String[] joueurs = null;
	
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
		this.vue = vue;
		System.out.println(vue.getController());
		propFenetre();
		this.setVisible(true);
	}
	
	private void propFenetre() {
		this.setSize(1200,800);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		System.out.println(vue.getController());
		currentPanel = new ConteneurMenu(this, 3);
		this.setContentPane(currentPanel);
		this.getContentPane().setBackground(Color.DARK_GRAY);
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
		this.getContentPane().setBackground(Color.DARK_GRAY);
	}
}
