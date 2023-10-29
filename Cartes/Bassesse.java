package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;

public class Bassesse extends Carte{
	
	public Bassesse() {
		super("Bassesse",3,Couleur.ROUGE,"description");
	}

	@Override
	public void effet() {
		// TODO Auto-generated method stub
		System.out.println("J'aime la pêche");
	}
}
