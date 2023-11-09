package Cartes;

import java.util.Scanner;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
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
			// Effet de la carte
			System.out.println("Choisir le nombre de carte à défausser :");
			int nbCarteDefausse = sc.nextInt();
			sc.nextLine();
			for(int i=0; i<nbCarteDefausse; i++) {
				System.out.println("Veuillez choisir l'index de la carte à défausse (entre 0 et " + (partie.getTour().getMain().getCartes().size()-1) + ").");
				int indexCarteDefausse = sc.nextInt();
				sc.nextLine();
				Carte carteDefausse = partie.getTour().getMain().getCartes().get(indexCarteDefausse);
				System.out.println("La carte défaussée est : " + carteDefausse.getNom());
				// Modification objet "partie"
				partie.deplacerCarte(main, defausse, carteDefausse);
			}
			System.out.println("Vous piochez " + (nbCarteDefausse+1) + " cartes de la source.");
			for(int i=0; i<nbCarteDefausse +1; i++) {
				partie.getTour().piocher();
			}
			main.removeCarte(this);
		}
}
