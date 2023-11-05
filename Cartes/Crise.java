package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Partie;

public class Crise extends Carte{
	
	public Crise() {
		super("Crise",2,Couleur.ROUGE,"description");
	}

	@Override
	public void effet(Partie partie) {
		// TODO Auto-generated method stub
		System.out.println("J'aime la pêche");
	}
}
