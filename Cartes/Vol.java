package Cartes;

import java.util.Scanner;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Joueur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Vol extends Carte{
	
	public Vol() {
		super("Vol",3,Couleur.BLEU,"description");
	}

	@Override
	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
				Joueur adversaire = partie.getAdversaire();
				Pile oeuvreAdverse = adversaire.getOeuvre();
				Pile main = partie.getTour().getMain();
				// Check si Oeuvre contient au moins une carte 
				if(oeuvreAdverse.getCartes().isEmpty()) {
					System.out.println("Il n'y a pas de carte à voler");
					//partie.getTour().rejouer(partie);
				} else {
					// Effet de la carte
					System.out.println("Vol de l'oeuvre exposée (la première visible de la pile) adverse.");
					System.out.println("Carte volée : " + oeuvreAdverse.getCartes().get(oeuvreAdverse.getCartes().size()-1).getNom());
					// Modification objet "partie"
					partie.deplacerCarte(oeuvreAdverse, main, oeuvreAdverse.getCartes().get(oeuvreAdverse.getCartes().size()-1));
				}
				wait(partie);
	}
}
