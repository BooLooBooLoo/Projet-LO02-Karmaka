package Karmaka.src;

import java.io.Serializable;

public class Oeuvre extends Pile implements Serializable{
	
	public int compterPoint() {
		int bleu = 0;
		int rouge = 0;
		int vert = 0;
		int mos = 0;
		for (int i = 0; i < cartes.size(); i++) {
			if (cartes.get(i).getType() == Couleur.BLEU) {
				bleu+= cartes.get(i).getCout();
			}
			if (cartes.get(i).getType() == Couleur.ROUGE) {
				rouge+= cartes.get(i).getCout();
			}
			if (cartes.get(i).getType() == Couleur.VERT) {
				vert+= cartes.get(i).getCout();
			}
			if (cartes.get(i).getType() == Couleur.MOSAIQUE) {
				mos+= cartes.get(i).getCout();
			}
		}
		if (bleu >= rouge && bleu >= vert) {
			return bleu + mos;
		} else if (rouge >= bleu && rouge >= vert) {
			return rouge + mos;
		} else if (vert >= bleu && vert >= rouge) {
			return vert + mos;
		} else {
			return 0;
		}
	}
}
