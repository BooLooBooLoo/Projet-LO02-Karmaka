package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Joueur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class RevesBrises extends Carte{
	
	public RevesBrises() {
		super("Rêves Brisés",2,Couleur.BLEU,"description");
	}

	@Override
	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
		Joueur adversaire = partie.getAdversaire();
		Pile vieFutureAdverse = adversaire.getVieFuture();
		Pile vieFuture = partie.getTour().getVieFuture();
		Pile main = partie.getTour().getMain();
		// Check si on peut voler
		if(vieFutureAdverse.getCartes().isEmpty()) {
			System.out.println("Il n'y a pas de carte à voler. Veuillez jouer une autre carte.");
			// partie.getTour().jouer(partie);
		}
		else {
			// Effet de la carte
			System.out.println("Vol de la première carte de la vie future adverse.");
			System.out.println("Carte volée : " + vieFutureAdverse.getCartes().get(vieFutureAdverse.getCartes().size()-1).getNom());
			// Modification objet "partie"
			partie.deplacerCarte(vieFutureAdverse, vieFuture, vieFutureAdverse.getCartes().get(vieFutureAdverse.getCartes().size()-1));
			main.removeCarte(this);
			}
		}
}

