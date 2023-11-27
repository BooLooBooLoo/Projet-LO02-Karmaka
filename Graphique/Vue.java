package Graphique;

import java.awt.Container;

import Graphique.States.Fenetre;

public class Vue{
	
	private Fenetre fenetre;
	private Controller controller;
	
	public Vue(Fenetre fenetre)
	{
		if (fenetre == null) {
			this.setFenetre(new Fenetre(this));
		} else {
			this.setFenetre(fenetre);
		}
		
	}

	public Fenetre getFenetre() {
		return fenetre;
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
