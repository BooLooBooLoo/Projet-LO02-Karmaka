package Cartes;

import java.util.Scanner;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Destinee extends Carte{
	
	public Destinee() {
		super("Destinee",2,Couleur.BLEU,"description");
	}

	@Override
	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
		Pile Main = partie.getTour().getMain();
		Pile Source = partie.getSource();
		Pile VieFuture = partie.getTour().getVieFuture();
		Scanner sc = new Scanner(System.in);
		// Syso et Scan 
		System.out.println("3 Premières Cartes de la Source :");
		for(int i=0; i<3; i++) {
			if(i>Source.getCartes().size()) {
				break;
			}
			System.out.println(Source.getCartes().get(i).getNom());
		}
		System.out.println("Combien de carte à ajouter dans la Vie Future?");
		int nbCarte = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<nbCarte; i++) {
			System.out.println("Choisir une carte à placer dans votre main.");
			String carteSelect = sc.nextLine();
			// Trouver la carte sélectionnée
			int indiceCarteSelect = -1;
			for(int j=0; j<Source.getCartes().size(); j++) {
				if(Source.getCartes().get(j).getNom().equals(carteSelect)) {
					indiceCarteSelect = j;
					break;
				}
			}
			// Modification objet "partie"
			if(indiceCarteSelect == -1) {
				System.out.println("Erreur! (La carte n'est pas trouvé...)");
			} else {
				VieFuture.addCarte(Source.getCartes().get(indiceCarteSelect));
			}		
		}
		//sc.close();
		Main.removeCarte(this);
		}
}
