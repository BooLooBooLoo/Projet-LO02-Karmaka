package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;

public class Crise extends Carte{
	
	public Crise() {
		super("Crise",2,Couleur.ROUGE,"description");
	}

	@Override
	public void effet() {
		// TODO Auto-generated method stub
		System.out.println("J'aime la pêche");
	}
}
