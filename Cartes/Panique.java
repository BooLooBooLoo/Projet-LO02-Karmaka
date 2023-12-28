package Cartes;

import java.util.Scanner;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Joueur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Panique extends Carte{
	
	public Panique() {
		super("Panique",1,Couleur.ROUGE,"description");
		super.rejouable = true;
	}

	@Override
	public void effet(Partie partie) {
		wait(partie);
		// Déclaration des variables utilisés dans cette classe
		Joueur adversaire = partie.getAdversaire();
		Pile pileAdverse = adversaire.getPile();
		Pile defausse = partie.getDefausse();
		Scanner sc = new Scanner(System.in);
		// Check si on peut voler
		if(pileAdverse.getCartes().isEmpty()) {
			System.out.println("Il n'y a pas de carte à défausser. Veuillez jouer une autre carte.");
			// partie.getTour().jouer(partie);
		}
		else {
			// Effet de la carte
			Carte carteDefausse = pileAdverse.getCartes().get(0);
			System.out.println("La carte défaussée est : " + carteDefausse.getNom());
			// Modification objet "partie"
			partie.deplacerCarte(pileAdverse, defausse, carteDefausse);
			}
		}
}
