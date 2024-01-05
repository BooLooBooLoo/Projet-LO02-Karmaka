package Cartes;

import java.util.Scanner;

import Karmaka.src.Bot;
import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Human;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Semis extends Carte{
	
	public Semis() {
		super("Semis",2,Couleur.VERT,"description");
	}

	@Override
	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
		Pile main = partie.getTour().getMain();
		Pile vieFuture = partie.getTour().getVieFuture();
		Scanner sc = new Scanner(System.in);
		// Syso et Scan 
		/*System.out.println("Vous piochez deux cartes de la source.");
		for(int i=0; i<2; i++) {
			partie.getTour().piocher();
		}
		main.removeCarte(this);
		*/
		System.out.println("Voici votre main :");
		for(int i=0; i<main.getCartes().size(); i++) {
			System.out.println(main.getCartes().get(i).getNom());
		}
		
		wait(partie);
		for(int i=0; i<2; i++) {
			String carteSelect = "";
			if(partie.getTour() instanceof Human) {
				System.out.println("Choisir une carte à mettre dans votre vie future :");
				// carteSelect = sc.nextLine();
				this.actions.get(i);
			} else {
				if (main.getCartes().size() > 0) {
					main.getCartes().get(((Bot) partie.getTour()).choisir(main.getCartes().size())).getNom();
				}
				
			}
			// Trouver la carte sélectionnée
			int indiceCarteSelect = -1;
			for(int j=0; j<main.getCartes().size(); j++) {
				if(main.getCartes().get(j).getNom().equals(carteSelect)) {
					indiceCarteSelect = j;
					break;
				}
			}
		// Modification objet "partie"
		if(indiceCarteSelect == -1) {
			System.out.println("Erreur! (La carte n'est pas trouvé...)");
		} else {
			Carte carte = main.getCartes().get(indiceCarteSelect);
			partie.deplacerCarte(main, vieFuture, carte);
		}
	}
		this.setActions(null); // Pour régler le probleme des choix :)
}
}
