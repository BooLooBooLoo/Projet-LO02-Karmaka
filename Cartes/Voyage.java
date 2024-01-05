package Cartes;

import java.util.Scanner;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Human;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Voyage extends Carte{
	
	public Voyage() {
		super("Voyage",3,Couleur.VERT,"Puisez 3 cartes à la Source.\nVous pouvez ensuite jouer une autre carte.");
		super.rejouable = true;
	}

	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
		Pile main = partie.getTour().getMain();
		// Syso et Scan 
		System.out.println("Vous piochez trois cartes de la source.");
		for(int i=0; i<3; i++) {
			partie.deplacerCarte(partie.getSource(), main, partie.getSource().getCartes().get(0));
		}
		if (partie.getTour() instanceof Human) {
			while (actions == null) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		this.setActions(null); // Pour régler le probleme des choix :)
	}
}
