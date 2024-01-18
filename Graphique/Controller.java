package Graphique;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import Graphique.States.ConteneurCoutKarmique;
import Graphique.States.ConteneurGagnant;
import Graphique.States.ConteneurPartie;
import Graphique.States.Fenetre;
import Karmaka.src.Carte;
import Karmaka.src.Human;
import Karmaka.src.Partie;

/**
 * Classe qui représente le Controller dans le modèle MVC pour l'interface graphique.
 */
public class Controller implements PropertyChangeListener{

	private Partie model;
	private Vue vue;
	private PropertyChangeSupport diffuseur;
	private String isNewGame = null;
	
	/**
	 * Méthode qui permet d'ajouter un listener/observateur à l'attribut {@code diffuseur} qui est responsable de la observabilité du Controller.
	 * @param pcl Le listener/observateur que l'on ajoute à la liste des listeners du Controller.
	 */
	public void addSub(PropertyChangeListener pcl) {
		diffuseur.addPropertyChangeListener(pcl);
	}
	
	/**
	 * Constructeur de la classe 
	 * @param m Le modèle qui est un objet de type {@code Partie}.
	 * @param v La vue associée avec le Controller.
	 */
	public Controller(Partie m, Vue v) {
		this.model = m;
		this.vue = v;
		diffuseur = new PropertyChangeSupport(this);
	}
	
	/**
	 * Getter de l'attribut {@code model}.
	 * @return Le modèle qui est un objet de type {@code Partie}.
	 */
	public Partie getModel() {
		return model;
	}
	
	/**
	 * Setter de l'attribut {@code model}.
	 * @param model La partie que l'on veut attribuer au Controller.
	 */
	public void setModel(Partie model) {
		this.model = model;
		this.addSub(model);
		this.model.addSub(this);
	}
	
	/**
	 * Getter de l'attribut {@code vue}.
	 * @return La vue associée au Controller.
	 */
	public Vue getVue() {
		return vue;
	}
	
	/**
	 * Setter de l'attribut {@code vue}.
	 * @param vue La vue que l'on veut attribuer au Controller.
	 */
	public void setVue(Vue vue) {
		this.vue = vue;
	}
	
	/**
	 * Getter de l'attribut {@code isNewGame}.
	 * @return Un booléen qui indique si on joue une nouvelle partie.
	 */
	public String getIsNewGame() {
		return isNewGame;
	}
	
	/**
	 * Setter de l'attribut {@code isNewGame}.
	 * @param isNewGame Le booléen qui indique si la partie est une nouvelle ou non.
	 */
	public void setIsNewGame(String isNewGame) {
		this.isNewGame = isNewGame;
	}
	
	/**
	 * Méthode qui permet de gérer les tours d'une partie.
	 */
	public void controlerLaPartie() {
		if (!isNewGame.equals("no")) {
			model.choisirJoueur();
			model.getTour().piocher();
		} else {
			isNewGame = "done";
		}
		this.vue.getFenetre().publish(new ConteneurPartie(vue.getFenetre()));
		model.tourDeJeu(model.getTour());
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
			vue.publish(new ConteneurGagnant(vue.getFenetre()));
			
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
