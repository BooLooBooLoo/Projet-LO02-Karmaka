package Cartes;

import java.util.Scanner;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Human;
import Karmaka.src.Joueur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class DernierSouffle extends Carte{
	
	public DernierSouffle() {
		super("Dernier Souffle",1,Couleur.ROUGE,"description");
	}

	@Override
	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
		Joueur adversaire = partie.getAdversaire();
		Pile mainAdverse = adversaire.getMain();
		Pile defausse = partie.getDefausse();
		Pile main = partie.getTour().getMain();
		Scanner sc = new Scanner(System.in);
		// Check si on peut voler
		if(mainAdverse.getCartes().isEmpty()) {
			System.out.println("Il n'y a pas de carte à voler. Veuillez jouer une autre carte.");
			// partie.getTour().jouer(partie);
		}
		else {
			// Effet de la carte
			int indexCarteDefausse = 0;
			if (partie.getTour() instanceof Human) {
				System.out.println("Veuillez choisir l'index de la carte à défausse (entre 0 et " + (partie.getTour().getMain().getCartes().size()-1) + ").");
				indexCarteDefausse = sc.nextInt();
				sc.nextLine();
			} else {
				indexCarteDefausse = (int) Math.floor(Math.random()*mainAdverse.getCartes().size());
			}
			Carte carteDefausse = mainAdverse.getCartes().get(indexCarteDefausse);
			System.out.println("La carte défaussée est : " + carteDefausse.getNom());
			// Modification objet "partie"
			partie.deplacerCarte(defausse, main, carteDefausse);
			}
		}
}