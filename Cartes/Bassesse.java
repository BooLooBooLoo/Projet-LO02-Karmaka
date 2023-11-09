package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Joueur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Bassesse extends Carte{
	
	public Bassesse() {
		super("Bassesse",3,Couleur.ROUGE,"description");
	}

	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
		Joueur adversaire = partie.getAdversaire();
		Pile mainAdverse = adversaire.getMain();
		Pile main = partie.getTour().getMain();
		Pile defausse = partie.getDefausse();
		// Check si on peut voler
		if(mainAdverse.getCartes().isEmpty()) {
			System.out.println("Il n'y a pas de carte à défausser. Veuillez jouer une autre carte.");
			// partie.getTour().jouer(partie);
		}
		else {
			// Effet de la carte
			for(int i=0; i<2; i++) {
				if(i>mainAdverse.getCartes().size()) {
					break;
				} else {
					int randomIndex = (int) Math.floor(Math.random() * mainAdverse.getCartes().size());
					Carte carteDefausse = mainAdverse.getCartes().get(randomIndex);
					System.out.println("On défausse l'oeuvre visible adverse.");
					System.out.println("La carte défaussée est : " + carteDefausse.getNom());
					// Modification objet "partie"
					partie.deplacerCarte(mainAdverse, defausse, carteDefausse);
				}
			}
			// Modification objet "partie"
			main.removeCarte(this);
			}
		}
}
