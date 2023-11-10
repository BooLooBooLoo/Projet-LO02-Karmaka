package Cartes;

import java.util.Scanner;

import Karmaka.src.Bot;
import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Human;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Destinee extends Carte{
	
	public Destinee() {
		super("Destinee",2,Couleur.BLEU,"description");
	}

	@Override
	public void effet(Partie partie) {
		// Déclaration des variables utilisés dans cette classe
		Pile main = partie.getTour().getMain();
		Pile source = partie.getSource();
		Pile vieFuture = partie.getTour().getVieFuture();
		Scanner sc = new Scanner(System.in);
		// Syso et Scan 
		System.out.println("3 Premières Cartes de la Source :");
		for(int i=0; i<3; i++) {
			if(i>source.getCartes().size()) {
				break;
			}
			System.out.println(source.getCartes().get(i).getNom());
		}
		int nbCarte = 0;
		if (partie.getTour() instanceof Human) {
			System.out.println("Veuillez choisir l'index de la carte à défausse (entre 0 et " + (partie.getTour().getMain().getCartes().size()-1) + ").");
			nbCarte = sc.nextInt();
			sc.nextLine();
		} else {
			nbCarte = (int) Math.floor(Math.random()*main.getCartes().size());
		}
		for(int i=0; i<nbCarte; i++) {
			String carteSelect = "";
			if (partie.getTour() instanceof Human) {
				System.out.println("Choisir une carte à défausser. Vous copiez son pouvoir.");
				 carteSelect = sc.nextLine();
			} else {
				carteSelect = main.getCartes().get(((Bot) partie.getTour()).choisir(main.getCartes().size())).getNom();
			}
			// Trouver la carte sélectionnée
			int indiceCarteSelect = -1;
			for(int j=0; j<source.getCartes().size(); j++) {
				if(source.getCartes().get(j).getNom().equals(carteSelect)) {
					indiceCarteSelect = j;
					break;
				}
			}
			// Modification objet "partie"
			if(indiceCarteSelect == -1) {
				System.out.println("Erreur! (La carte n'est pas trouvé...)");
			} else {
				Carte carte = source.getCartes().get(indiceCarteSelect);
				partie.deplacerCarte(source, vieFuture, carte);
			}		
		}
		//sc.close();
		}
}
