package Karmaka.src;

public class Oeuvre extends Pile{
	
	public int compterPoint() {
		int bleu = 0;
		int rouge = 0;
		int vert = 0;
		int mos = 0;
		for (int i = 0; i < cartes.size(); i++) {
			if (cartes.get(i).getType() == Couleur.BLEU) {
				bleu++;
			}
			if (cartes.get(i).getType() == Couleur.ROUGE) {
				rouge++;
			}
			if (cartes.get(i).getType() == Couleur.VERT) {
				vert++;
			}
			if (cartes.get(i).getType() == Couleur.MOSAIQUE) {
				mos++;
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
