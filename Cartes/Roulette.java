package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;

public class Roulette extends Carte{
	
	public Roulette() {
		super("Roulette",2,Couleur.ROUGE,"description");
	}

	@Override
	public void effet() {
		// TODO Auto-generated method stub
		System.out.println("J'aime la pêche");
	}
}
