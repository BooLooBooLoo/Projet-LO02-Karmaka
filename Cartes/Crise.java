package Cartes;

import java.util.Scanner;

import Karmaka.src.Bot;
import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Human;
import Karmaka.src.Joueur;
import Karmaka.src.Oeuvre;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Crise extends Carte{
	
	public Crise() {
		super("Crise",2,Couleur.ROUGE,"description");
	}

	
	public void effet(Partie partie) {
		// Variables
		Joueur adversaire = partie.getAdversaire();
		Pile oeuvreAdverse = adversaire.getOeuvre();
		Pile defausse = partie.getDefausse();
		// Effet carte
		while(actions == null) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(oeuvreAdverse.getCartes().isEmpty()) {
			System.out.println("Pas d'oeuvre dans la pile adverse");
		}
		else {
			String carteSelect = "";
			for(int i=0; i<oeuvreAdverse.getCartes().size(); i++) {
				System.out.println(oeuvreAdverse.getCartes().get(i).getNom());
			}
			if (partie.getTour() instanceof Human) {
				System.out.println("Veuilez choisir une oeuvre à défausser.");
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
				Carte carteDefausse = oeuvreAdverse.getCartes().get(indiceCarteSelect);
				partie.deplacerCarte(oeuvreAdverse, defausse, carteDefausse);
		}
	}
}
}
