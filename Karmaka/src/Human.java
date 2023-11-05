package Karmaka.src;

import java.util.Scanner;

public class Human extends Joueur{
	
	
	
	@Override
	public String jouer(Partie partie) {
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
	    	setDerniereCarteJoue(temp);
	    	oeuvre.addCarte(temp);
	    	bool = "done";
	    } else if (action.equals("VieFuture")) {
	    	Carte temp = choisirCarte();
	    	setDerniereCarteJoue(temp);
	    	vieFuture.addCarte(temp);
	    	bool = "done";
	    }
		return bool;
	}

}
