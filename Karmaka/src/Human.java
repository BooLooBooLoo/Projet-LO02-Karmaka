package Karmaka.src;

import java.util.Scanner;

/**
 * La classe {@code Human} est une classe qui hérite de {@code Joueur} et représente un joueur humain qui peut réaliser des choix.
 */
public class Human extends Joueur{
	
	private Carte cardToPlay;
	private String action;
	
	private Carte cTPRejouer;
	private String actionRejouer;
	
	public Carte getcTPRejouer() {
		return cTPRejouer;
	}

	public void setcTPRejouer(Carte cTPRejouer) {
		this.cTPRejouer = cTPRejouer;
	}

	public String getActionRejouer() {
		return actionRejouer;
	}

	public void setActionRejouer(String actionRejouer) {
		this.actionRejouer = actionRejouer;
	}

	private String actionCK = null;
	
	public String getActionCK() {
		return actionCK;
	}

	public void setActionCK(String actionCK) {
		this.actionCK = actionCK;
	}
	
	/**
	 * Le constructeur de la classe {@code Human}.
	 * @param nom Le nom du joueur.
	 */
	public Human(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Getter de l'attribut {@code cardToPlay}.}
	 * @return La carte à jouer du joueur.
	 */
	public Carte getCardToPlay() {
		return cardToPlay;
	}
	
	/**
	 * Setter de l'attribut {@code cardToPlay}.
	 * @param cardToPlay La carte qui l'a choisi de jouer.
	 */
	public void setCardToPlay(Carte cardToPlay) {
		this.cardToPlay = cardToPlay;
	}

	/**
	 * Getter de l'attribut {@code action}.
	 * @return L'action du joueur.
	 */
	public String getAction() {
		return action;
	}
	
	/**
	 * Setter de l'attribut {@code action}.
	 * @param action L'action du joueur.
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * Méthode qui permet au joueur de jouer au jeu. Il doit choisir sa carte puis son action.
	 * @param partie La partie où se joue le jeu.
	 * @return Un string qui permet de vérifier le bon fonctionnement du jeu.
	 */
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
			this.getMain().removeCarte(temp);
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

	/**
	 * Méthode qui permet au joueur de rejouer une carte. Il doit choisir sa carte puis son action.
	 * @param partie La partie où se joue le jeu.
	 * @return Un string qui permet de vérifier le bon fonctionnement du jeu.
	 */
	public String rejouer(Partie partie) {
		System.out.println("IN Rejouer");
		while(cTPRejouer == null ) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String bool = new String();
		String action = new String();

	    action  = actionRejouer;  // Read user input
	    System.out.println(action);
	    Carte temp = cTPRejouer;
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
	    	this.getMain().removeCarte(temp);
	    	if(temp.rejouable) {
				partie.getTour().rejouer(partie);
			}
	    	bool = "Pouvoir";
	    } else if (action.equals("Oeuvre")) {
	    	oeuvre.addCarte(temp);
	    	this.getMain().removeCarte(temp);
	    	bool = "done";
	    } else if (action.equals("VieFuture")) {
	    	vieFuture.addCarte(temp);
	    	this.getMain().removeCarte(temp);
	    	bool = "done";
	    }
	    System.out.println("OUT Rejouer");
		return bool;
		
		
	}
	
	/**
	 * Méthode qui permet au joueur de choisir une carte de sa main. Elle affiche les cartes de la main du joueur puis demande quelle carte il veut jouer.
	 * @return La carte choisie par le joueur.
	 */
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
	
	/**
	 * Méthode qui permet au joueur de récupérer une carte adverse jouée en Oeuvre.
	 */
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
