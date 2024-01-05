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
			vue.getFenetre().dispatchEvent(new WindowEvent(vue.getFenetre(), WindowEvent.WINDOW_CLOSING));
		}
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("Cout Karmique")) {
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
