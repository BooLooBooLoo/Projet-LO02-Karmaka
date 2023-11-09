package Cartes;

import java.util.Scanner;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Voyage extends Carte{
	
	public Voyage() {
		super("Voyage",3,Couleur.VERT,"description");
	}

	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
		Pile main = partie.getTour().getMain();
		// Syso et Scan 
		System.out.println("Vous piochez trois cartes de la source.");
		for(int i=0; i<3; i++) {
			partie.getTour().piocher();
		}
		main.removeCarte(this);
		partie.getTour().rejouer(partie);
	}
}
