	package Cartes;

import java.util.Scanner;

import Karmaka.src.Bot;
import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Human;
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
		Pile defausse = partie.getDefausse();
		Pile pile = new Pile();
		String carteSelect = "";
		Scanner sc = new Scanner(System.in);
		int nbr = (defausse.getCartes().size() > 3) ? 3 : defausse.getCartes().size();
		System.out.println("3 Dernières Cartes de la Fosse :");
		for(int i=0; i<nbr; i++) {
			System.out.println(defausse.getCartes().get(i).getNom());
			pile.addCarte(defausse.getCartes().get(i));
		}
		if (partie.getTour() instanceof Human) {
			System.out.println("Choisir une carte à placer dans votre main.");
			carteSelect = sc.nextLine();
		} else {
			if (pile.getCartes().size() > 0) {
				carteSelect = pile.getCartes().get(((Bot) partie.getTour()).choisir(pile.getCartes().size())).getNom();
			}
			
		}
		
		// Trouver la carte sélectionnée
		int indiceCarteSelect = -1;
		for(int i=0; i<nbr; i++) {
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
		}
	}
}
