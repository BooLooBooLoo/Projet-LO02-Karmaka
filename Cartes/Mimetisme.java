package Cartes;

import java.util.Scanner;

import Karmaka.src.Bot;
import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Human;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Mimetisme extends Carte{
	
	public Mimetisme() {
		super("Mimétisme",2,Couleur.MOSAIQUE,"description");
	}

	public void effet(Partie partie) {
		// Variables
		String carteSelect = "";
		Pile oeuvreAdverse = partie.getAdversaire().getOeuvre();
		wait(partie);
		if(oeuvreAdverse.getCartes().isEmpty()) {
			System.out.println("Pas de carte à copier son pouvoir.");
		} else {
			if (partie.getTour() instanceof Human) {
				carteSelect = actions.get(0);
			} else {
				carteSelect = oeuvreAdverse.getCartes().get(((Bot) partie.getTour()).choisir(oeuvreAdverse.getCartes().size())).getNom();
			}
			
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
				carteCopie.setActions(actions.subList(1, actions.size()));
				carteCopie.effet(partie);
			}
		}
	}
}
