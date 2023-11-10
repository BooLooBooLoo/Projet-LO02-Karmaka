package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Joueur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Fournaise extends Carte{
	
	public Fournaise() {
		super("Fournaise",2,Couleur.ROUGE,"description");
	}

	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
		Joueur adversaire = partie.getAdversaire();
		Pile vieFutureAdverse = adversaire.getOeuvre();
		Pile main = partie.getTour().getMain();
		Pile defausse = partie.getDefausse();
		// Check si on peut voler
		if(vieFutureAdverse.getCartes().isEmpty()) {
			System.out.println("Il n'y a pas de carte à défausser. Veuillez jouer une autre carte.");
			// partie.getTour().jouer(partie);
		}
		else {
			// Effet de la carte
			for(int i=0; i<2; i++) {
				if(i>vieFutureAdverse.getCartes().size()) {
					break;
				} else {
					Carte carteDefausse = vieFutureAdverse.getCartes().get(vieFutureAdverse.getCartes().size()-1);
					System.out.println("On défausse l'oeuvre visible adverse.");
					System.out.println("La carte défaussée est : " + carteDefausse.getNom());
					// Modification objet "partie"
					partie.deplacerCarte(vieFutureAdverse, defausse, carteDefausse);
				}
			}
			}
		}
}
