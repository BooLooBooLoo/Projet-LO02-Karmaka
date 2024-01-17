package Graphique;

import java.awt.event.WindowEvent;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

import Graphique.States.ConteneurCoutKarmique;
import Graphique.States.ConteneurPartie;
import Graphique.States.Fenetre;
import Karmaka.src.*;

/**
 * Classe qui représente le Controller dans le modèle MVC pour l'interface graphique.
 */
public class Controller implements PropertyChangeListener{

	private Partie model;
	private Vue vue;
	private PropertyChangeSupport diffuseur;
	private String isNewGame = null;
	
	public void addSub(PropertyChangeListener pcl) {
		diffuseur.addPropertyChangeListener(pcl);
	}
	
	/**
	 * Constructeur de la classe 
	 * @param m
	 * @param v
	 */
	public Controller(Partie m, Vue v) {
		this.model = m;
		this.vue = v;
		diffuseur = new PropertyChangeSupport(this);
	}

	public Partie getModel() {
		return model;
	}

	public void setModel(Partie model) {
		this.model = model;
		this.addSub(model);
		this.model.addSub(this);
	}

	public Vue getVue() {
		return vue;
	}

	public void setVue(Vue vue) {
		this.vue = vue;
	}
	
	

	public String getIsNewGame() {
		return isNewGame;
	}

	public void setIsNewGame(String isNewGame) {
		this.isNewGame = isNewGame;
	}

	public void controlerLaPartie() {
		System.out.println("Begin controlerLaPartie");
		model.choisirJoueur();
		System.out.println("OUT choisir joueur");
		model.getTour().piocher();
		System.out.println("OUT piocher");
		this.vue.getFenetre().publish(new ConteneurPartie(vue.getFenetre()));
		System.out.println("OUT publish partie");
		model.tourDeJeu(model.getTour());
		System.out.println("OUT tourDeJeu");
		model.refillSource();
		
		if (!model.getWin()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			controlerLaPartie();
		} else {
			vue.getFenetre().dispatchEvent(new WindowEvent(vue.getFenetre(), WindowEvent.WINDOW_CLOSING));
		}
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("Cout Karmique") && model.getTour() instanceof Human) {
			this.vue.getFenetre().publish(new ConteneurCoutKarmique(vue.getFenetre(), (Carte) evt.getNewValue()));
		} else {
			diffuseur.firePropertyChange(evt);
		}
		
		
	}
	
	public static void main(String[] args) {
		Controller controller = new Controller(new Partie(), new Vue());
		controller.getVue().setController(controller);
		controller.addSub(controller.getModel());
		controller.getModel().addSub(controller);
		controller.getVue().addSub(controller);
		controller.getVue().setFenetre(new Fenetre(controller.getVue()));
		controller.getVue().render();
		while (controller.getIsNewGame() == null) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (controller.getIsNewGame().equals("yes")) {
			while (controller.getVue().getFenetre().getJoueurs() == null) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			controller.getModel().setupJoueur(controller.getVue().getFenetre().getJoueurs());
			controller.getModel().setupPartie();
			controller.getModel().choisirJoueur();
		}
		controller.controlerLaPartie();
		
	}
}
