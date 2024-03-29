package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Joueur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Duperie extends Carte{
	
	public Duperie() {
		super("Duperie",3,Couleur.BLEU,"description");
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
	}
}
