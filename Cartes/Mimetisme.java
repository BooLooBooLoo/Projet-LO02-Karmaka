package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Partie;

public class Mimetisme extends Carte{
	
	public Mimetisme() {
		super("Mimétise",2,Couleur.MOSAIQUE,"description");
	}

	@Override
	public void effet(Partie partie) {
		// TODO Auto-generated method stub
		System.out.println("J'aime la pêche");
	}
}
