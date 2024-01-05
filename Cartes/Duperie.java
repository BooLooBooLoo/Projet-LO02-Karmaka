package Cartes;

import java.util.ArrayList;

import Karmaka.src.Bot;
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
		wait(partie);
		if (mainAdverse.getCartes().size()>0) {
			if (partie.getTour() instanceof Bot) {
				actions = new ArrayList<String>();
				actions.add(mainAdverse.getCartes().get(((Bot) partie.getTour()).choisir(mainAdverse.getCartes().size())).getNom());
			}
			Carte card = null;
			for (Carte carte : mainAdverse.getCartes()) {
				if (carte.getNom().equals(actions.get(0))) {
					card = carte;
				}
			}
			partie.getTour().getMain().addCarte(card);
			adversaire.getMain().removeCarte(card);
		} else {
			System.out.println("Il n'y a pas de cartes dans la main adverse");
		}
		
	}
}
