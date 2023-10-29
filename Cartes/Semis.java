package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;

public class Semis extends Carte{
	
	public Semis() {
		super("Semis",2,Couleur.VERT,"description");
	}

	@Override
	public void effet() {
		// TODO Auto-generated method stub
		System.out.println("J'aime la pêche");
	}
}
