package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;

public class Jubile extends Carte{
	
	public Jubile() {
		super("Jubilé",3,Couleur.VERT,"description");
	}

	@Override
	public void effet() {
		// TODO Auto-generated method stub
		System.out.println("J'aime la pêche");
	}
}
