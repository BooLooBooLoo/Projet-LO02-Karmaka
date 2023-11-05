package Cartes;

import java.util.Scanner;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Jubile extends Carte{
	
	public Jubile() {
		super("Jubilé",3,Couleur.VERT,"description");
	}

	@Override
	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
		Pile Main = partie.getTour().getMain();
		Pile Oeuvre = partie.getTour().getOeuvre();
		Scanner sc = new Scanner(System.in);
		// Syso et Scan 
		System.out.println("3 Premières Cartes de la Main :");
		for(int i=0; i<3; i++) {
			if(i>Main.getCartes().size()) {
				break;
			}
			System.out.println(Main.getCartes().get(i).getNom());
		}
		System.out.println("Combien de carte à ajouter dans l'Oeuvre?");
		int nbCarte = sc.nextInt();
		for(int i=0; i<nbCarte; i++) {
			System.out.println("Choisir une carte à placer dans votre main.");
			String carteSelect = sc.nextLine();
			// Trouver la carte sélectionnée
			int indiceCarteSelect = -1;
			for(int j=0; j<Main.getCartes().size(); j++) {
				if(Main.getCartes().get(j).getNom().equals(carteSelect)) {
					indiceCarteSelect = j;
					break;
				}
			}
			// Modification objet "partie"
			if(indiceCarteSelect == -1) {
				System.out.println("Erreur! (La carte n'est pas trouvé...)");
			} else {
				Oeuvre.addCarte(Main.getCartes().get(indiceCarteSelect));
			}		
		}
		sc.close();
		Main.removeCarte(this);
		}
}
