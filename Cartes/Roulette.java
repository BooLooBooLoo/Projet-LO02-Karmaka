package Cartes;

import java.util.Scanner;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Human;
import Karmaka.src.Joueur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Roulette extends Carte{
	
	public Roulette() {
		super("Roulette",2,Couleur.ROUGE,"description");
	}

	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
		Pile defausse = partie.getDefausse();
		Pile main = partie.getTour().getMain();
		Scanner sc = new Scanner(System.in);
		int nbCarteDefausse = 0;
		// Effet de la carte
		if (partie.getTour() instanceof Human) {
			System.out.println("Choisir le nombre de carte à défausser :");
			nbCarteDefausse = sc.nextInt();
			sc.nextLine();
		} else {
			nbCarteDefausse = (int) Math.floor(Math.random()*defausse.getCartes().size());
		}
		
		for(int i=0; i<nbCarteDefausse; i++) {
			int indexCarteDefausse = 0;
			if (partie.getTour() instanceof Human) {
				System.out.println("Veuillez choisir l'index de la carte à défausser (entre 0 et " + (partie.getTour().getMain().getCartes().size()-1) + ").");
				indexCarteDefausse = sc.nextInt();
				sc.nextLine();
			} else {
				indexCarteDefausse = (int) Math.floor(Math.random()*main.getCartes().size());
			}
			if (partie.getTour().getMain().getCartes().size() > 0) {
				Carte carteDefausse = partie.getTour().getMain().getCartes().get(indexCarteDefausse);
				System.out.println("La carte défaussée est : " + carteDefausse.getNom());
				// Modification objet "partie"
				partie.deplacerCarte(main, defausse, carteDefausse);
			}	
		}
		System.out.println("Vous piochez " + (nbCarteDefausse+1) + " cartes de la source.");
		for(int i=0; i<nbCarteDefausse +1; i++) {
			partie.getTour().piocher();
		}
	}
}
