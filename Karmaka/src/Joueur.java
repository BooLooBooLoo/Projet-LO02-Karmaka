package Karmaka.src;

import java.io.Serializable;
import java.util.Scanner;

/**
 * La classe {@code Joueur} est une classe abstraite qui va représenter un joueur dans le jeu.
 * @author Ali MIKOU et Hoang-Viet LE
 * @version 1.0
 */

public abstract class Joueur implements Serializable {
    protected Pile main = new Pile();
    protected Pile pile = new Pile();
    protected Pile vieFuture = new Pile();
    protected Oeuvre oeuvre = new Oeuvre();
    protected String nom;
    
    /**
     * Le constructeur de la classe {@code Joueur}.
     * @param nom Le nom du joueur.
     */
    public Joueur(String nom) {
    	this.nom = nom;
    }
    
    /**
     * Getter de l'attribut {@code nom}.
     * @return L'attribut {@code nom} de l'instance.
     */
    public String getNom() {
		return nom;
	}

    /**
     * Setter de l'attribut {@code nom}.
     * @param nom Nom du joueur.
     */
	public void setNom(String nom) {
		this.nom = nom;
	}


	protected int anneaux;
    protected Echelle echelleKarmique;
    protected Carte derniereCarteJoue;
    
    /**
     * Getter de l'attribut {@code derniereCarteJoue}.
     * @return L'attribut {@code derniereCarteJoue} de l'instance.
     */
    public Carte getDerniereCarteJoue() {
		return derniereCarteJoue;
	}

    /**
     * Setter de l'attribut {@code derniereCarteJoue}.
     * @param derniereCarteJoue La dernière carte jouée par le joueur.
     */
	public void setDerniereCarteJoue(Carte derniereCarteJoue) {
		this.derniereCarteJoue = derniereCarteJoue;
	}

	/**
	 * La méthode {@code jouer} est abstraite pour différencier comment joue un joueur Humain et Bot.
	 * @param partie La partie sur laquelle on agit.
	 * @return Un message qui permet de vérifier le bon fonctionnement du jeu.
	 */
	public abstract String jouer(Partie partie);
	
	/**
	 * La méthode {@code rejouer} est abstraite pour différencier comment rejoue un joueur Humain et Bot.
	 * @param partie La partie sur laquelle on agit.
	 * @return Un message qui permet de vérifier le bon fonctionnement du jeu.
	 */
	public abstract String rejouer(Partie partie);
    
    
	/**
	 * Getter de l'attribut {@code echelleKarmique}.
	 * @return L'attribut {@code echelleKarmique} de l'instance.
	 */
    public Echelle getEchelleKarmique() {
		return echelleKarmique;
	}
    
    /**
     * Setter de l'attribut {@code echelleKarmique}.
     * @param echelleKarmique L'échelle karmique.
     */
	public void setEchelleKarmique(Echelle echelleKarmique) {
		this.echelleKarmique = echelleKarmique;
	}
			
	/**
	 * Getter de l'attribut {@code main}.
	 * @return L'attribut {@code main} de l'instance.
	 */
    public Pile getMain() {
		return main;
	}
    
    /**
     * Setter de l'attribut {@code main}.
     * @param main Une pile de carte.
     */
	public void setMain(Pile main) {
		this.main = main;
	}


	/**
	 * Getter de l'attribut {@code pile}.
	 * @return L'attribut {@code pile} de l'instance.
	 */
	public Pile getPile() {
		return pile;
	}
	/**
     * Setter de l'attribut {@code pile}.
     * @param pile Une pile de carte.
     */
	public void setPile(Pile pile) {
		this.pile = pile;
	}
	/**
	 * Ajoute une carte à la pile du joueur.
	 * @param carte Une carte.
	 */
	public void addCartePile(Carte carte) {
		pile.addCarte(carte);
	}
	
	/**
	 * Enlève une carte à la pile du joueur.
	 * @param carte Une carte.
	 */
	public void removeCartePile(Carte carte) {
		pile.removeCarte(carte);
	}
    
	/**
	 * Getter de l'attribut {@code anneaux}.
	 * @return L'attribut {@code anneaux} de l'instance.
	 */
    public int getAnneaux(){
        return anneaux;
    }
    /**
     * Setter de l'attribut {@code anneaux}.
     * @param anneaux Les anneaux du joueur.
     */
	public void setAnneaux(int value){
        anneaux = value;
    }

	/**
	 * La méthode permet au joueur de sélectionner une carte dans sa main.
	 * @return La carte choisie.
	 */
	public Carte choisirCarte() {
		Carte carteAJouer = null;
		String action = new String();
		Scanner myObj = new Scanner(System.in);
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
	 * La méthode permettant au joueur de piocher dans sa pile.
	 */
	public void piocher() {
		if (getPile().getCartes().size() > 0) {
			int rand = (int) Math.floor(Math.random()) * getPile().getCartes().size();
			Carte temp = getPile().getCartes().get(rand);
			getPile().removeCarte(temp);
			getMain().addCarte(temp);
		}
	}

	/**
	 * Getter de l'attribut {@code vieFuture}. Elle affiche également dans la console toutes les cartes de la vie future du joueur.
	 * @return La vie future du joueur.
	 */
	public Pile getVieFuture() {
		return vieFuture;
	}

	/**
	 * Setter de l'attribut {@code vieFuture}.
	 * @param vieFuture Une pile de carte.
	 */
	public void setVieFuture(Pile vieFuture) {
		this.vieFuture = vieFuture;
	}

	/**
	 * Getter de l'attribut {@code oeuvre}.
	 * @return Les oeuvres du joueur.
	 */
	public Oeuvre getOeuvre() {
		return oeuvre;
	}

	/**
	 * Settert de l'attribut {@code oeuvre}.
	 * @param oeuvre Une pile de carte.
	 */
	public void setOeuvre(Oeuvre oeuvre) {
		this.oeuvre = oeuvre;
	}
	
	/**
	 * Méthode permettant de récupérer une carte jouée en pouvoir par un adversaire. 
	 * Cette méthode est abstraite car elle fonctionne d'une façon différente selon si c'est un Joueur ou un Bot.
	 * @param carte La carte jouée en pouvoir
	 * @param partie La partie jouée
	 */
	public abstract void coutKarmique(Carte carte, Partie partie);
}
