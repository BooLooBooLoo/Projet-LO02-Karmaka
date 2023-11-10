package Cartes;

import java.util.Scanner;

import Karmaka.src.Bot;
import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Human;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Incarnation extends Carte{
	
	public Incarnation() {
		super("Incarnation",2,Couleur.MOSAIQUE,"description");
	}

	public void effet(Partie partie) {
		// Variables
		String carteSelect = "";
		Pile main = partie.getTour().getMain();
		Pile oeuvre = partie.getTour().getOeuvre();
		// Effet carte
		System.out.println("Oeuvre :");
		for(int i=0; i<oeuvre.getCartes().size(); i++) {
			System.out.println(oeuvre.getCartes().get(i).getNom());
		}
		if(oeuvre.getCartes().isEmpty() || (oeuvre.getCartes().size() == 1 && oeuvre.getCartes().get(0).getNom().equals("Incarnation"))) {
			System.out.println("Pas de carte à copier son pouvoir.");
		} else {
			if (partie.getTour() instanceof Human) {
				System.out.println("Choisir l'oeuvre dont vous voulez copier le pouvoir :");
				Scanner sc = new Scanner(System.in);
				 carteSelect = sc.nextLine();
			} else {
				carteSelect = oeuvre.getCartes().get(((Bot) partie.getTour()).choisir(oeuvre.getCartes().size())).getNom();
			}
			
			// Trouver la carte sélectionnée
			int indiceCarteSelect = -1;
			for(int i=0; i<oeuvre.getCartes().size(); i++) {
				if(oeuvre.getCartes().get(i).getNom().equals(carteSelect)) {
					indiceCarteSelect = i;
					break;
				}
			}
			// Modification objet "partie"
			if(indiceCarteSelect == -1) {
				System.out.println("Erreur! (La carte n'est pas trouvé...)");
			} else {
				Carte carteCopie = oeuvre.getCartes().get(indiceCarteSelect);
				carteCopie.effet(partie);
			}
		}
	}
}
