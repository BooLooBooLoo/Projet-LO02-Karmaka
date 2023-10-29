package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;

public class Incarnation extends Carte{
	
	public Incarnation() {
		super("Incarnation",2,Couleur.MOSAIQUE,"description");
	}

	@Override
	public void effet() {
		// TODO Auto-generated method stub
		System.out.println("J'aime la pêche");
	}
}
