package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Partie;

public class Panique extends Carte{
	
	public Panique() {
		super("Panique",1,Couleur.ROUGE,"description");
	}

	@Override
	public void effet(Partie partie) {
		// TODO Auto-generated method stub
		System.out.println("J'aime la queue");
	}
}
