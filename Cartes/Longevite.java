package Cartes;

import java.util.Scanner;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Human;
import Karmaka.src.Joueur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Longevite extends Carte{
	
	public Longevite() {
		super("Longevite",2,Couleur.VERT,"description");
	}

	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
		Joueur adversaire = partie.getAdversaire();
		Pile pileAdverse = adversaire.getPile();
		Pile pile = partie.getTour().getPile();
		Pile source = partie.getSource();
		Pile main = partie.getTour().getMain();
		
		wait(partie);
		// Check si on peut piocher dans la source
		if(partie.getSource().getCartes().isEmpty()) {
			System.out.println("Il n'y a pas de carte à piocher. Veuillez jouer une autre carte.");
			// partie.getTour().jouer(partie);
		}
		else {
			// Effet de la carte
			String choix = "";
			if (partie.getTour() instanceof Human) {
				System.out.println("Choisir entre Moi/Adversaire celui qui va piocher deux cartes dans sa pile.");
				choix = actions.get(0);
			} else {
				int rand = (int) Math.floor(Math.random()*2);
				switch (rand) {
				case 0:
					choix = "Moi";
					break;
				case 1:
					choix = "Adversaire";
					break;
				}
			}
			
			switch(choix) {
				case "Moi" :
					for(int i=0; i<2; i++) {
						Carte cartePioche = source.getCartes().get(source.getCartes().size()-1);
						System.out.println("On pioche la carte : " + cartePioche.getNom());
						partie.deplacerCarte(source, pile, cartePioche);
					}
					break;
				case "Adversaire" :
					for(int i=0; i<2; i++) {
						// Pioche Carte + syso
						Carte cartePioche = source.getCartes().get(source.getCartes().size()-1);
						System.out.println("On pioche la carte : " + cartePioche.getNom());
						// Modification objet "partie"
						partie.deplacerCarte(source, pileAdverse, cartePioche);
					}
					break;
				default :
					System.out.println("Erreur, veuillez rejouer le tour...");
					break;
			}
		}
	}
}
