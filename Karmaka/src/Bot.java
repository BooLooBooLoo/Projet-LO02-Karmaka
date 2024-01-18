package Karmaka.src;

import java.io.Serializable;

import Karmaka.src.Strategy.Aggressif;
import Karmaka.src.Strategy.Defensif;
import Karmaka.src.Strategy.IA;
import Karmaka.src.Strategy.Neutre;
/**
 * La classe Bot est une classe qui hérite de Joueur et représente un Bot.
 */
public class Bot extends Joueur implements Serializable{
	
	private Strategy strat;
	
	/**
	 * Constructeur de la classe {@code Bot}
	 * @param nom Le nom du Bot.
	 * @param type Le type de stratégie du Bot.
	 */
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
	}
	
	/**
	 * Méthode faisant partie du design-pattern "Stratégie" permettant au Bot de jouer. 
	 * Elle dépends de la stratégie que le Bot possède et c'est la stratégie qui s'occupe de jouer (l'appel de la méthode jouer de la stratégie). 
	 * @param partie La partie où le Bot joue.
	 * @return Un string qui vérifie le bon fonctionnement de la méthode.
	 */
	public String jouer(Partie partie) {
		String nom = strat.jouer(partie);
		return nom;
	}
	

	/**
	 * Méthode permettant au Bot de rejouer. Elle rejoue de manière aléatoire une carte choisie aussi aléatoirement dans sa main.
	 * @param partie La partie où le Bot joue.
	 * @return Un string qui vérifie le bon fonctionnement de la méthode.
	 */
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
	
	/**
	 * Méthode permettant au Bot de choisir une carte.
	 * Il choisit une carte aléatoirement et la joue.
	 */
	public Carte choisirCarte() {
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
		return carteAJouer;
	}
	
	/**
	 * Méthode qui permet au Bot de récupérer une carte adverse jouée en Oeuvre.
	 */
	public void coutKarmique(Carte carte, Partie partie) {
		String action = new String();
		double rand = Math.random();
		action = (rand >= 0.5) ? "Y" : "N";
		if (action.equals("Y")) {
			partie.getAdversaire().getVieFuture().addCarte(carte);
		} else if (action.equals("N")) {
			partie.getDefausse().addCarte(carte);
		}
	}
	
	/**
	 * Méthode permettant d'obtenir un nombre aléatoire entre 0 et le paramètre d'entrée.
	 * @param size Le nombre maximal
	 * @return Un entier entre 0 et {@code size}.
	 */
	public int choisir(int size) {
		return (int) Math.floor(Math.random()*size);
	}

}
