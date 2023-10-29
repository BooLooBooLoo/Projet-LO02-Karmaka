package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;

public class Sauvetage extends Carte{
	
	public Sauvetage() {
		super("Sauvetage",2,Couleur.VERT,"description");
	}

	@Override
	public void effet() {
		// TODO Auto-generated method stub
		System.out.println("J'aime la pêche");
	}
}
