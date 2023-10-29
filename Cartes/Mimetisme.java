package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;

public class Mimetisme extends Carte{
	
	public Mimetisme() {
		super("Mimétise",2,Couleur.MOSAIQUE,"description");
	}

	@Override
	public void effet() {
		// TODO Auto-generated method stub
		System.out.println("J'aime la pêche");
	}
}
