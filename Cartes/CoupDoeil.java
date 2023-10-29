package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;

public class CoupDoeil extends Carte{
	
	public CoupDoeil() {
		super("Coup d'oeil",1,Couleur.BLEU,"description");
	}

	@Override
	public void effet() {
		// TODO Auto-generated method stub
		System.out.println("J'aime la pêche");
	}
}
