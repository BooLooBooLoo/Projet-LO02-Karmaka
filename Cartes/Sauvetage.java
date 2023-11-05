package Cartes;

import java.util.Scanner;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Sauvetage extends Carte{
	
	public Sauvetage() {
		super("Sauvetage",2,Couleur.VERT,"description");
	}

	@Override
	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
		Pile main = partie.getTour().getMain();
		Pile defausse = partie.getDefausse();
		Scanner sc = new Scanner(System.in);
		// Syso et Scan 
		System.out.println("3 Dernières Cartes de la Fosse :");
		for(int i=defausse.getCartes().size()-3; i<defausse.getCartes().size(); i++) {
			System.out.println(defausse.getCartes().get(i).getNom());
		}
		System.out.println("Choisir une carte à placer dans votre main.");
		String carteSelect = sc.nextLine();
		sc.close();
		// Trouver la carte sélectionnée
		int indiceCarteSelect = -1;
		for(int i=defausse.getCartes().size()-3; i<defausse.getCartes().size(); i++) {
			if(defausse.getCartes().get(i).getNom().equals(carteSelect)) {
				indiceCarteSelect = i;
				break;
			}
		}
		// Modification objet "partie"
		if(indiceCarteSelect == -1) {
			System.out.println("Erreur! (La carte n'est pas trouvé...)");
		} else {
			Carte carte = defausse.getCartes().get(indiceCarteSelect);
			partie.deplacerCarte(defausse, main, carte);
			main.removeCarte(this);
		}
	}
}
