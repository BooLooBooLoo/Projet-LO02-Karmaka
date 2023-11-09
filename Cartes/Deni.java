package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class Deni extends Carte{
	
	public Deni() {
		super("Déni",2,Couleur.BLEU,"description");
	}

	@Override
	public void effet(Partie partie) {
		// Variables utilisées
		Pile main = partie.getTour().getMain();
		Pile defausse = partie.getDefausse();
	}
}