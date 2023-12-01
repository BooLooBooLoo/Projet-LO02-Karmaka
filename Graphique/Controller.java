package Graphique;

import java.awt.event.WindowEvent;

import Graphique.States.ConteneurPartie;
import Graphique.States.Fenetre;
import Karmaka.src.*;

public class Controller {
	private Partie model;
	private Vue vue;
	
	public Controller(Partie m, Vue v) {
		this.model = m;
		this.vue = v;
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
		this.vue.getFenetre().publish(new ConteneurPartie(vue.getFenetre()));
		model.tourDeJeu(model.getTour());
		model.refillSource();
		
		if (!model.getWin()) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			controlerLaPartie();
		} else {
			vue.getFenetre().dispatchEvent(new WindowEvent(vue.getFenetre(), WindowEvent.WINDOW_CLOSING));
		}
	}
	
	public static void main(String[] args) {
		Controller controller = new Controller(new Partie(), new Vue());
		controller.getVue().setController(controller);
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
		controller.controlerLaPartie();
		
	}
}
