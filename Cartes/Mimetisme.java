package Cartes;

import java.util.Scanner;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Joueur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Mimetisme extends Carte{
	
	public Mimetisme() {
		super("Mimétise",2,Couleur.MOSAIQUE,"description");
	}

	@Override
	public void effet(Partie partie) {
	// Variables
	Pile main = partie.getTour().getMain();
	Pile oeuvreAdverse = partie.getAdversaire().getOeuvre();
	// Effet carte
	System.out.println("Oeuvre de l'adversaire :");
	for(int i=0; i<oeuvreAdverse.getCartes().size(); i++) {
		System.out.println(oeuvreAdverse.getCartes().get(i).getNom());
	}
	if(oeuvreAdverse.getCartes().isEmpty()) {
		System.out.println("Pas de carte à copier son pouvoir.");
	} else {
		System.out.println("Choisir l'oeuvre dont vous voulez copier le pouvoir :");
		Scanner sc = new Scanner(System.in);
		String carteSelect = sc.nextLine();
		// Trouver la carte sélectionnée
		int indiceCarteSelect = -1;
		for(int i=0; i<oeuvreAdverse.getCartes().size(); i++) {
			if(oeuvreAdverse.getCartes().get(i).getNom().equals(carteSelect)) {
				indiceCarteSelect = i;
				break;
			}
		}
		// Modification objet "partie"
		if(indiceCarteSelect == -1) {
			System.out.println("Erreur! (La carte n'est pas trouvé...)");
		} else {
			Carte carteCopie = oeuvreAdverse.getCartes().get(indiceCarteSelect);
			
		}
		main.removeCarte(this);
	}
}
}
