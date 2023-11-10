package Cartes;

import java.util.Scanner;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Deni extends Carte{
	
	public Deni() {
		super("Déni",2,Couleur.BLEU,"description");
	}

	@Override
	public void effet(Partie partie) {
		// Variables utilisées
		Pile main = partie.getTour().getMain();
		Pile defausse = partie.getDefausse();
		Scanner sc = new Scanner(System.in);
		// Effet de la carte
		if(main.getCartes().isEmpty()) {
			System.out.println("Pas de carte dans la main");
		} else {
			System.out.println("Cartes de votre main :");
			for(int i=0; i<main.getCartes().size(); i++) {
				System.out.println(main.getCartes().get(i).getNom());
			}
			System.out.println("Choisir une carte à défausser. Vous copiez son pouvoir.");
			String carteSelect = sc.nextLine();
			// Trouver la carte sélectionnée
			int indiceCarteSelect = -1;
			for(int i=0; i<main.getCartes().size(); i++) {
				if(main.getCartes().get(i).getNom().equals(carteSelect)) {
					indiceCarteSelect = i;
					break;
				}
			}
			// Modification objet "partie"
			if(indiceCarteSelect == -1) {
				System.out.println("Erreur! (La carte n'est pas trouvé...)");
			} else {
				Carte carteDefausse = main.getCartes().get(indiceCarteSelect);
				partie.deplacerCarte(main, defausse, carteDefausse);
				carteDefausse.effet(partie);
		}
		}
	}
}