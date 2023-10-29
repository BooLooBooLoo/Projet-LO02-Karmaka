package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;

public class Lendemain extends Carte{
	
	public Lendemain() {
		super("Lendemain",1,Couleur.VERT,"description");
	}

	@Override
	public void effet() {
		// TODO Auto-generated method stub
		System.out.println("J'aime la pêche");
	}
}
