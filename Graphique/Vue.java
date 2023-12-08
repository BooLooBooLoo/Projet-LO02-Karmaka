package Graphique;

import java.awt.Container;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import Graphique.States.Fenetre;

public class Vue{
	
	private Fenetre fenetre;
	private Controller controller;
	private PropertyChangeSupport diffuseur;
	
	public Vue() {
		this.diffuseur = new PropertyChangeSupport(this);
	}
	
	public Fenetre getFenetre() {
		return fenetre;
	}

	public void addSub(PropertyChangeListener pcl) {
		diffuseur.addPropertyChangeListener(pcl);
	}


	public PropertyChangeSupport getDiffuseur() {
		return diffuseur;
	}

	public void setDiffuseur(PropertyChangeSupport diffuseur) {
		this.diffuseur = diffuseur;
	}

	public void setFenetre(Fenetre fenetre) {
		this.fenetre = fenetre;
	}

	public void publish(Container panel) {
		fenetre.publish(panel);
	}
	
	public void render() {
		fenetre.render();
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
	
}
