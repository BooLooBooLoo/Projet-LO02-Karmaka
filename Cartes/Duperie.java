package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;

public class Duperie extends Carte{
	
	public Duperie() {
		super("Duperie",3,Couleur.BLEU,"description");
	}

	@Override
	public void effet() {
		// TODO Auto-generated method stub
		System.out.println("J'aime la pêche");
	}
}
