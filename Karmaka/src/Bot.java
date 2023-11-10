package Karmaka.src;

import Karmaka.src.Strategy.*;

public class Bot extends Joueur{
	
	private Strategy strat;
	public Bot(String nom, String type) {
		super(nom);
		switch (type) {
		case "Aggressif":
			strat = new Aggressif();
			break;
		case "Neutre":
			strat = new Neutre();
			break;
		case "Défensif":
			strat = new Defensif();
			break;
		case "IA":
			strat = new IA();
			break;
		}
		// TODO Auto-generated constructor stub
	}
	
	public String jouer(Partie partie) {
		String nom = strat.jouer(partie);
		return nom;
	}
	

	@Override
	public String rejouer(Partie partie) {
		String bool = new String();
		String action = new String();
		int rand = (int) Math.floor(Math.random()*4);
		switch (rand) {
			case 0:
				action = "Passer";
				break;
			case 1:
				action = "Oeuvre";
				break;
			case 2:
				action = "Pouvoir";
				break;
			case 3:
				action = "VieFuture";
				break;
		}
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
		//System.out.println(getMain().toString());
		Carte carteAJouer = null;
		String action = new String();
		int rand = (int) Math.floor(Math.random()*getMain().getCartes().size());
		action = this.getMain().getCartes().get(rand).getNom();
		for (int i = 0; i < getMain().getCartes().size(); i++) {
			if (action.equals(getMain().getCartes().get(i).getNom())) {
				carteAJouer = getMain().getCartes().get(i);
				getMain().removeCarte(carteAJouer);
				break;
			}
		}
		System.out.println("Vous avez choisi : "+carteAJouer.getNom());
		return carteAJouer;
	}
	
	public void coutKarmique(Carte carte, Partie partie) {
		String action = new String();
		// TODO Auto-generated method stub
		double rand = Math.random();
		action = (rand >= 0.5) ? "Y" : "N";
		//myObj.close();
		if (action.equals("Y")) {
			partie.getAdversaire().getVieFuture().addCarte(carte);
		} else if (action.equals("N")) {
			partie.getDefausse().addCarte(carte);
		}
	}
	
	public int choisir(int size) {
		return (int) Math.floor(Math.random()*size);
	}

}
