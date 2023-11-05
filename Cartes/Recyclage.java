	package Cartes;

import java.util.Scanner;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Recyclage extends Carte{
	
	public Recyclage() {
		super("Recyclage",1,Couleur.VERT,"description");
	}

	@Override
	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
		Pile vieFuture = partie.getTour().getVieFuture();
		Pile main = partie.getTour().getMain();
		Pile Defausse = partie.getDefausse();
		Scanner sc = new Scanner(System.in);
		// Syso et Scan 
		System.out.println("3 Dernières Cartes de la Fosse :");
		for(int i=Defausse.getCartes().size()-3; i<Defausse.getCartes().size(); i++) {
			System.out.println(Defausse.getCartes().get(i).getNom());
		}
		System.out.println("Choisir une carte à placer dans votre main.");
		String carteSelect = sc.nextLine();
		sc.close();
		// Trouver la carte sélectionnée
		int indiceCarteSelect = -1;
		for(int i=Defausse.getCartes().size()-3; i<Defausse.getCartes().size(); i++) {
			if(Defausse.getCartes().get(i).getNom().equals(carteSelect)) {
				indiceCarteSelect = i;
				break;
			}
		}
		// Modification objet "partie"
		if(indiceCarteSelect == -1) {
			System.out.println("Erreur! (La carte n'est pas trouvé...)");
		} else {
			Carte carte = Defausse.getCartes().get(indiceCarteSelect);
			partie.deplacerCarte(Defausse, main, carte);
			main.removeCarte(this);
		}
	}
}
