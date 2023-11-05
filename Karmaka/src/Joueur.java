package Karmaka.src;

import java.util.Scanner;

public abstract class Joueur {
    protected Pile main = new Pile();
    protected Pile pile = new Pile();
    protected Pile vieFuture = new Pile();
    protected Oeuvre oeuvre = new Oeuvre();
    protected String nom;
    
    public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	protected int anneaux;
    protected Echelle echelleKarmique;
    protected Carte derniereCarteJoue;
    
    
    public Carte getDerniereCarteJoue() {
		return derniereCarteJoue;
	}


	public void setDerniereCarteJoue(Carte derniereCarteJoue) {
		this.derniereCarteJoue = derniereCarteJoue;
	}


	public abstract String jouer(Partie partie);
    
    
	//Echelle Karmique
    public Echelle getEchelleKarmique() {
		return echelleKarmique;
	}
	public void setEchelleKarmique(Echelle echelleKarmique) {
		this.echelleKarmique = echelleKarmique;
	}
			
    //Main
    public Pile getMain() {
		return main;
	}
	public void setMain(Pile main) {
		this.main = main;
	}


	//Pile
	public Pile getPile() {
		return pile;
	}
	public void setPile(Pile pile) {
		this.pile = pile;
	}
	public void addCartePile(Carte carte) {
		pile.addCarte(carte);
	}
	public void removeCartePile(Carte carte) {
		pile.removeCarte(carte);
	}
    
    //Anneaux
    public int getAnneaux(){
        return anneaux;
    }
	public void setAnneaux(int value){
        anneaux = value;
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
	
	public void piocher() {
		if (getPile().getCartes().size() > 0) {
			int rand = (int) Math.floor(Math.random()) * getPile().getCartes().size();
			Carte temp = getPile().getCartes().get(rand);
			getPile().removeCarte(temp);
			getMain().addCarte(temp);
		}
	}

	public Pile getVieFuture() {
		for(int i=0; i<vieFuture.getCartes().size(); i++) {
			System.out.println(vieFuture.getCartes().get(i).getNom());
		}
		return vieFuture;
	}


	public void setVieFuture(Pile vieFuture) {
		this.vieFuture = vieFuture;
	}


	public Oeuvre getOeuvre() {
		return oeuvre;
	}


	public void setOeuvre(Oeuvre oeuvre) {
		this.oeuvre = oeuvre;
	}
}
