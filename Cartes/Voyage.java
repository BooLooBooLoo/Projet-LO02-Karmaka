package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;

public class Voyage extends Carte{
	
	public Voyage() {
		super("Voyage",3,Couleur.VERT,"description");
	}

	@Override
	public void effet() {
		// TODO Auto-generated method stub
		System.out.println("J'aime la pêche");
	}
}
