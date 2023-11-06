package Cartes;

import java.util.Scanner;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Joueur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Vengeance extends Carte{
	
	public Vengeance() {
		super("Vengeance",3,Couleur.ROUGE,"description");
	}

	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
		Joueur adversaire = partie.getAdversaire();
		Pile oeuvreAdverse = adversaire.getOeuvre();
		Pile main = partie.getTour().getMain();
		// Check si on peut voler
		if(oeuvreAdverse.getCartes().isEmpty()) {
			System.out.println("Il n'y a pas de carte à voler. Veuillez jouer une autre carte.");
			// partie.getTour().jouer(partie);
		}
		else {
			// Effet de la carte
			Carte carteDefausse = oeuvreAdverse.getCartes().get(oeuvreAdverse.getCartes().size()-1);
			System.out.println("On défausse l'oeuvre visible adverse.");
			System.out.println("La carte défaussée est : " + carteDefausse.getNom());
			// Modification objet "partie"
			oeuvreAdverse.removeCarte(carteDefausse);
			main.removeCarte(this);
			}
		}
}
