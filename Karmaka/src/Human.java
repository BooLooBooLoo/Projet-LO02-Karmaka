package Karmaka.src;

import java.util.Scanner;

public class Human extends Joueur{
	
	private Carte cardToPlay;
	private String action;
	private String actionCK = null;
	
	public String getActionCK() {
		return actionCK;
	}

	public void setActionCK(String actionCK) {
		this.actionCK = actionCK;
	}

	public Human(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	public Carte getCardToPlay() {
		return cardToPlay;
	}

	public void setCardToPlay(Carte cardToPlay) {
		this.cardToPlay = cardToPlay;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String jouer(Partie partie) {
		System.out.println("IN Jouer");
		String bool = new String();

		Carte temp = cardToPlay;
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
	    	this.getMain().removeCarte(temp);
	    	bool = "done";
	    } else if (action.equals("VieFuture")) {
	    	setDerniereCarteJoue(temp);
	    	vieFuture.addCarte(temp);
	    	this.getMain().removeCarte(temp);
	    	bool = "done";
	    }
	    System.out.println("OUT jouer");
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
		return carteAJouer;
	}
	
	public void coutKarmique(Carte carte, Partie partie) {
		System.out.println("IN cout Karmique");
		while (actionCK == null) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    System.out.println(actionCK);
		//myObj.close();
		if (actionCK.equals("Y")) {
			partie.getAdversaire().getVieFuture().addCarte(carte);
		}else if (actionCK.equals("N")) {
			partie.getDefausse().addCarte(carte);
		}
		System.out.println("OUT Cout Karmique");
	}

}
