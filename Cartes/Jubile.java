package Cartes;

import java.util.Scanner;

import Karmaka.src.Bot;
import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Human;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Jubile extends Carte{
	
	public Jubile() {
		super("Jubilé",3,Couleur.VERT,"description");
	}

	@Override
	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
		Pile main = partie.getTour().getMain();
		Pile oeuvre = partie.getTour().getOeuvre();
		Scanner sc = new Scanner(System.in);
		// Syso et Scan 
		System.out.println("3 Premières Cartes de la Main :");
		for(int i=0; i<3; i++) {
			if(i>main.getCartes().size()) {
				break;
			}
			//System.out.println(Main.getCartes().get(i).getNom());
		}
		int nbCarte = 0;
		if (partie.getTour() instanceof Human) {
			System.out.println("Combien de carte à ajouter dans l'Oeuvre?");
			nbCarte = sc.nextInt();
			if (nbCarte > 2 || nbCarte < 0) {
				nbCarte = 0;
			}
		} else {
			nbCarte = (int) Math.floor(Math.random()*2);
		}
		
		for(int i=0; i<nbCarte; i++) {
			String carteSelect = "";
			if (partie.getTour() instanceof Human) {
				System.out.println("Choisir une carte à placer dans votre main.");
				carteSelect = sc.nextLine();
			} else {
				if (main.getCartes().size() > 0) {
					carteSelect = main.getCartes().get(((Bot) partie.getTour()).choisir(main.getCartes().size())).getNom();
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
				partie.deplacerCarte(main, oeuvre, carte);
			}		
		}
		}
}
