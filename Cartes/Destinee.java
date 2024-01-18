package Cartes;

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
		wait(partie);
		System.out.println("3 Premières Cartes de la Source :");
		for(int i=0; i<3; i++) {
			if(i>source.getCartes().size()) {
				break;
			}
			System.out.println(source.getCartes().get(i).getNom());
		}
		int nbCarte = 0;
		if (partie.getTour() instanceof Human) {
			nbCarte = Integer.parseInt(actions.get(actions.size()-1));
		} else {
			nbCarte = (int) Math.floor(Math.random()*main.getCartes().size());
		}
		for(int i=0; i<nbCarte; i++) {
			String carteSelect = "";
			if (partie.getTour() instanceof Human) {
				 carteSelect = actions.get(i);
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
	}
}
