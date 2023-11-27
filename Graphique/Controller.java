package Graphique;

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
	
	public static void main(String[] args) {
		Controller controller = new Controller(new Partie(), new Vue(null));
		controller.getVue().setController(controller);
		controller.getVue().render();
		//controller.getVue().publish(new Options(controller.getVue()));
		
	}
}
