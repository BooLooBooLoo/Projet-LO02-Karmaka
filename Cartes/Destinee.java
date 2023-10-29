package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;

public class Destinee extends Carte{
	
	public Destinee() {
		super("Destinee",2,Couleur.BLEU,"description");
	}

	@Override
	public void effet() {
		// TODO Auto-generated method stub
		System.out.println("J'aime la pêche");
	}
}
