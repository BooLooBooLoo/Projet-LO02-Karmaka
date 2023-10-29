package Cartes;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;

public class DernierSouffle extends Carte{
	
	public DernierSouffle() {
		super("Dernier Souffle",1,Couleur.ROUGE,"description");
	}

	@Override
	public void effet() {
		// TODO Auto-generated method stub
		System.out.println("J'aime la pêche");
	}
}
