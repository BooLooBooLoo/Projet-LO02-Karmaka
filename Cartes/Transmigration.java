package Cartes;

import java.util.Scanner;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Transmigration extends Carte{
	
	public Transmigration() {
		super("Transmigration",1,Couleur.BLEU,"description");
	}

	@Override
	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
		Pile VieFuture = partie.getTour().getVieFuture();
		Pile Main = partie.getTour().getMain();
		Scanner sc = new Scanner(System.in);
		// Syso et Scan 
		System.out.println("Cartes dans la Vie Future :");
		for(int i=0; i<VieFuture.getCartes().size(); i++) {
			System.out.println(VieFuture.getCartes().get(i).getNom());
		}
		System.out.println("Choisir une carte à placer dans votre main.");
		String carteSelect = sc.nextLine();
		sc.close();
		// Trouver la carte sélectionnée
		int indiceCarteSelect = -1;
		for(int i=0; i<VieFuture.getCartes().size(); i++) {
			if(VieFuture.getCartes().get(i).getNom().equals(carteSelect)) {
				indiceCarteSelect = i;
				break;
			}
		}
		// Modification objet "partie"
		if(indiceCarteSelect == -1) {
			System.out.println("Erreur! (La carte n'est pas trouvé...)");
		} else {
			Carte carte = VieFuture.getCartes().get(indiceCarteSelect);
			partie.deplacerCarte(VieFuture, Main, carte);
			Main.removeCarte(this);
		}
	}
}
