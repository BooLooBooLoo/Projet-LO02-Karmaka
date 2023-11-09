package Cartes;

import java.util.Scanner;

import Karmaka.src.Bot;
import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Human;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Sauvetage extends Carte{
	
	public Sauvetage() {
		super("Sauvetage",2,Couleur.VERT,"description");
	}

	@Override
	public void effet(Partie partie) {
		String carteSelect;
		int loop = (partie.getDefausse().getCartes().size() > 3) ? 3 : partie.getDefausse().getCartes().size();
		// Déclaration des variables utilisés dans cette classe
		if (partie.getDefausse().getCartes().size() > 0) {
			Pile main = partie.getTour().getMain();
			Pile defausse = partie.getDefausse();
			Scanner sc = new Scanner(System.in);
			// Syso et Scan 
			System.out.println("Dernières Cartes de la Fosse :");
			for(int i= 0; i< loop; i++) {
				System.out.println(defausse.getCartes().get(i).getNom());
			}
			if (partie.getTour() instanceof Human) {
				System.out.println("Choisir une carte à placer dans votre main.");
				carteSelect = sc.nextLine();
			} else if (partie.getTour() instanceof Bot) {
				carteSelect = defausse.getCartes().get(((Bot) partie.getTour()).choisir(defausse.getCartes().size())).getNom();
			} else {
				carteSelect = "";
			}
			
			// Trouver la carte sélectionnée
			int indiceCarteSelect = -1;
			for(int i= 0; i<loop; i++) {
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
		} else {
			System.out.println("Il n'y a pas de carte dans la Fosse...Dommage");
		}
		
	}
}
