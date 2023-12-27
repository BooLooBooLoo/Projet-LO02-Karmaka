package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Lendemain extends Carte{
	
	public Lendemain() {
		super("Lendemain",1,Couleur.VERT,"description");
		super.rejouable = true;
	}

	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
		Pile main = partie.getTour().getMain();
		// Syso et Scan 
		System.out.println("Vous piochez une carte de la source.");
		main.addCarte(partie.getSource().getCartes().get(0));
		partie.getSource().removeCarte(partie.getSource().getCartes().get(0));
		wait(partie);
	}
}
