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
		wait(partie);
		if (partie.getTour() instanceof Human) {
			System.out.println("Choisir le nombre de carte à défausser :");
			nbCarteDefausse = Integer.parseInt(actions.get(actions.size()-1));
		} else {
			nbCarteDefausse = (int) Math.floor(Math.random()*2);
		}
		
		for(int i=0; i<nbCarteDefausse; i++) {
			if (partie.getTour() instanceof Human) {
				for(int j=0; j<partie.getTour().getMain().getCartes().size(); j++) {
					if(partie.getTour().getMain().getCartes().get(j).getNom() == actions.get(i)) {
						Carte carteDefausse = partie.getTour().getMain().getCartes().get(j);
						System.out.println("La carte défaussée est : " + carteDefausse.getNom());
						// Modification objet "partie"
						partie.deplacerCarte(main, defausse, carteDefausse);
						break;
					}
					
				}
			} else {
				int indexCarteDefausse = (int) Math.floor(Math.random()*main.getCartes().size());
				if (partie.getTour().getMain().getCartes().size() > 0) {
					Carte carteDefausse = partie.getTour().getMain().getCartes().get(indexCarteDefausse);
					System.out.println("La carte défaussée est : " + carteDefausse.getNom());
					// Modification objet "partie"
					partie.deplacerCarte(main, defausse, carteDefausse);
				}	
			}
		}
		System.out.println("Vous piochez " + (nbCarteDefausse+1) + " cartes de la source.");
		for(int i=0; i<nbCarteDefausse +1; i++) {
			int randomNumber = (int) (Math.random()*partie.getSource().getCartes().size()-1);
			partie.deplacerCarte(partie.getSource(), main, partie.getSource().getCartes().get(randomNumber));
		}
		this.setActions(null); // Pour régler le probleme des choix
	}
	
}
