package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;

public class Panique extends Carte{
	
	public Panique() {
		super("Panique",1,Couleur.ROUGE,"description");
	}

	@Override
	public void effet() {
		// TODO Auto-generated method stub
		System.out.println("J'aime la queue");
	}
}
