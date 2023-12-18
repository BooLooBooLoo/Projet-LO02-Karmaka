package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Human;
import Karmaka.src.Joueur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class CoupDoeil extends Carte{
	
	public CoupDoeil() {
		super("Coup d'oeil",1,Couleur.BLEU,"description");
		super.rejouable = true;
	}

	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
		Joueur adversaire = partie.getAdversaire();
		Pile mainAdverse = adversaire.getMain();
		Pile main = partie.getTour().getMain();
		System.out.println("Vous allez observer la main de votre adversaire");
		for(int i=0; i<mainAdverse.getCartes().size(); i++) {
			System.out.println(mainAdverse.getCartes().get(i).getNom());
		}
		wait(partie);
		
	}
}