package Karmaka.src;

import java.io.Serializable;
import java.util.Scanner;

public class Human extends Joueur implements Serializable{
	
	
	
	public Human(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String jouer(Partie partie) {
		String bool = new String();
		String action = new String();
		Carte temp = choisirCarte();
		// TODO Auto-generated method stub
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Entrer votre action (Passer/Oeuvre/Pouvoir/VieFuture)");

	    action  = myObj.nextLine();  // Read user input
	    System.out.println(action);
		//myObj.close();
		bool = null;
	    if (action.equals("Passer")) {
	    	if (getPile().getCartes().size() > 0) {
	    		bool = "done";
	    	} else {
	    		bool = null;
	    	}
	    } else if (action.equals("Pouvoir")) {
	    	setDerniereCarteJoue(temp);
	    	temp.effet(partie);
			partie.getTour().getMain().removeCarte(temp);
			if(temp.rejouable) {
				partie.getTour().rejouer(partie);
			}
	    	bool = "Pouvoir";
	    } else if (action.equals("Oeuvre")) {
	    	setDerniereCarteJoue(temp);
	    	oeuvre.addCarte(temp);
	    	bool = "done";
	    } else if (action.equals("VieFuture")) {
	    	setDerniereCarteJoue(temp);
	    	vieFuture.addCarte(temp);
	    	bool = "done";
	    }
		return bool;
	}

	@Override
	public String rejouer(Partie partie) {
		
		String bool = new String();
		String action = new String();
		// TODO Auto-generated method stub
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Entrer votre action (Passer/Oeuvre/Pouvoir/VieFuture)");

	    action  = myObj.nextLine();  // Read user input
	    System.out.println(action);
		//myObj.close();
		bool = null;
	    if (action.equals("Passer")) {
	    	if (getPile().getCartes().size() > 0) {
	    		bool = "done";
	    	} else {
	    		bool = null;
	    	}
	    } else if (action.equals("Pouvoir")) {
	    	Carte temp = choisirCarte();
	    	setDerniereCarteJoue(temp);
	    	temp.effet(partie);
	    	bool = "Pouvoir";
	    } else if (action.equals("Oeuvre")) {
	    	Carte temp = choisirCarte();
	    	oeuvre.addCarte(temp);
	    	bool = "done";
	    } else if (action.equals("VieFuture")) {
	    	Carte temp = choisirCarte();
	    	vieFuture.addCarte(temp);
	    	bool = "done";
	    }
		return bool;
		
	}
	public Carte choisirCarte() {
		System.out.println(getMain().toString());
		Carte carteAJouer = null;
		String action = new String();
		Scanner myObj = new Scanner(System.in);
		System.out.println("Entrer la carte à jouer (son nom)");
		action  = myObj.nextLine();
		for (int i = 0; i < getMain().getCartes().size(); i++) {
			if (action.equals(getMain().getCartes().get(i).getNom())) {
				carteAJouer = getMain().getCartes().get(i);
				getMain().removeCarte(carteAJouer);
				break;
			}
		}
		System.out.println("Fin choix");
		return carteAJouer;
	}
	
	public void coutKarmique(Carte carte, Partie partie) {
		String action = new String();
		// TODO Auto-generated method stub
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Voulez-vous récuperer la carte suivante (Y/N) :"+carte.getNom());

	    action  = myObj.nextLine();  // Read user input
	    System.out.println(action);
		//myObj.close();
		if (action.equals("Y")) {
			partie.getAdversaire().getVieFuture().addCarte(carte);
		}else if (action.equals("N")) {
			partie.getDefausse().addCarte(carte);
		}
	}

}
