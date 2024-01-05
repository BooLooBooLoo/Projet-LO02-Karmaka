package Karmaka.src;

import java.io.Serializable;

/**
 * La classe {@code Oeuvre} est une classe qui hérite de la classe {@code Pile}. 
 * Elle représente toujours une pile de cartes mais elle possède une méthode en plus permettant de calculer les points gagnés par les joueurs.
 * Elle possède des méthodes afin de pouvoir la manipuler.
 * @author Ali MIKOU et Hoang-Viet LE
 * @version 1.0
 */
public class Oeuvre extends Pile implements Serializable{
	
	/**
	 * Méthode qui permet de calculer les points gagnés par un joueur selon les cartes présentes dans la pile d'Oeuvre.
	 * @return Le nombre de points gagnés avec la pile d'Oeuvre donnée.
	 */
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
