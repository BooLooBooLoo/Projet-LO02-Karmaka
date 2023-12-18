package Graphique;

import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import Graphique.States.ConteneurCoutKarmique;
import Graphique.States.ConteneurPartie;
import Graphique.States.Fenetre;
import Karmaka.src.*;

public class Controller implements PropertyChangeListener{
	
	private Partie model;
	private Vue vue;
	private PropertyChangeSupport diffuseur;
	private PropertyChangeEvent evt;
	
	public void addSub(PropertyChangeListener pcl) {
		diffuseur.addPropertyChangeListener(pcl);
	}
	
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
	}

	public Vue getVue() {
		return vue;
	}

	public void setVue(Vue vue) {
		this.vue = vue;
	}
	
	public void controlerLaPartie() {
		model.choisirJoueur();
		model.getTour().piocher();
		if (evt == null) {
			this.vue.getFenetre().publish(new ConteneurPartie(vue.getFenetre()));
		} else if (evt != null && evt.getPropertyName() == "Pouvoir") {
			this.vue.getFenetre().publish(new ConteneurCoutKarmique(vue.getFenetre(), (Carte) evt.getNewValue()));
			model.getAdversaire().coutKarmique((Carte) evt.getNewValue(), model);
		} else {
			this.vue.getFenetre().publish(new ConteneurPartie(vue.getFenetre()));
		}
		System.out.println("Out of the if ");
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
			vue.getFenetre().dispatchEvent(new WindowEvent(vue.getFenetre(), WindowEvent.WINDOW_CLOSING));
		}
	}
	public void propertyChange(PropertyChangeEvent evt) {
		diffuseur.firePropertyChange(evt);
		this.evt = evt;
		System.out.println(evt.getPropertyName()+" and "+evt.getNewValue());
		
	}
	
	public static void main(String[] args) {
		Controller controller = new Controller(new Partie(), new Vue());
		controller.getVue().setController(controller);
		controller.addSub(controller.getModel());
		controller.getModel().addSub(controller);
		controller.getVue().addSub(controller);
		controller.getVue().setFenetre(new Fenetre(controller.getVue()));
		System.out.println(controller.getVue().getController());
		controller.getVue().render();
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
		controller.getVue().getFenetre().publish(new ConteneurPartie(controller.getVue().getFenetre()));
		controller.controlerLaPartie();
		
	}
}
