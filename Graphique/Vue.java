package Graphique;

import java.awt.Container;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import Graphique.States.Fenetre;

/**
 * Classe qui représente la Vue dans le modèle MVC pour l'interface graphique.
 */
public class Vue{
	
	private Fenetre fenetre;
	private Controller controller;
	private PropertyChangeSupport diffuseur;
	
	/**
	 * Constructeur de la classe {@code Vue}.
	 */
	public Vue() {
		this.diffuseur = new PropertyChangeSupport(this);
	}
	
	/**
	 * Getter de l'attribut {@code Fenetre}.
	 * @return La fenetre de la vue.
	 */
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
	
	/**
	 * Setter de l'attribut {@code Fenetre}.
	 * @param fenetre Une fenetre.
	 */
	public void setFenetre(Fenetre fenetre) {
		this.fenetre = fenetre;
	}
	
	/**
	 * Méthode permettant d'actualiser et de changer le conteneur de la fenêtre.
	 * @param panel Le conteneur dont l'on veut afficher sur la fenêtre.
	 */
	public void publish(Container panel) {
		fenetre.publish(panel);
	}
	
	/**
	 * Méthode permettant d'actualiser l'affichage de la fenêtre.
	 */
	public void render() {
		fenetre.render();
	}
	
	/**
	 * Getter de l'attribut {@code Controller}.
	 * @return Le Controller de la Vue
	 */
	public Controller getController() {
		return controller;
	}
	
	/**
	 * Setter de l'attribut {@code Controller}.
	 * @param controller Le Controller à définir pour la Vue.
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
}
