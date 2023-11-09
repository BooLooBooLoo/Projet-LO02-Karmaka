package Cartes;

import java.util.Scanner;

import Karmaka.src.Bot;
import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Human;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Transmigration extends Carte{
	
	public Transmigration() {
		super("Transmigration",1,Couleur.BLEU,"description");
	}

	@Override
	public void effet(Partie partie) {
		String carteSelect = "";
	// Déclaration des variables utilisés dans cette classe
		Pile vieFuture = partie.getTour().getVieFuture();
		Pile main = partie.getTour().getMain();
		if (vieFuture.getCartes().size() != 0) {
			Scanner sc = new Scanner(System.in);
			// Syso et Scan 
			System.out.println("Cartes dans la Vie Future :");
			vieFuture.toString();
			System.out.println("Choisir une carte à placer dans votre main.");
			if (partie.getTour() instanceof Human) {
				carteSelect = sc.nextLine();
			} else if (partie.getTour() instanceof Bot) {
				carteSelect = vieFuture.getCartes().get(((Bot) partie.getTour()).choisir(vieFuture.getCartes().size())).getNom();
			}
			
			// Trouver la carte sélectionnée
			int indiceCarteSelect = -1;
			for(int i=0; i<vieFuture.getCartes().size(); i++) {
				if(vieFuture.getCartes().get(i).getNom().equals(carteSelect)) {
					indiceCarteSelect = i;
					break;
				}
			}
			// Modification objet "partie"
			if(indiceCarteSelect == -1) {
				System.out.println("Erreur! (La carte n'est pas trouvé...)");
			} else {
				main.addCarte(vieFuture.getCartes().get(indiceCarteSelect));
				vieFuture.removeCarte(vieFuture.getCartes().get(indiceCarteSelect));
				main.removeCarte(this);
			}
		} else {
			System.out.println("Il n'y a pas de carte dans la vie future...");
		}
		 
	}
		
}
