package Karmaka.src;

import java.util.Scanner;

public abstract class Joueur {
    protected Pile main = new Pile();
    protected Pile pile = new Pile();
    protected Pile vieFuture = new Pile();
    protected int anneaux;
    protected Echelle echelleKarmique;
    
    
    public abstract String jouer();
    
    
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
		for (int i = 0; i < getMain().getCartes().size(); i++) {
			System.out.println(getMain().getCartes().get(i).getNom());
		}
		Carte carteAJouer = null;
		String action = new String();
		// TODO Auto-generated method stub
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Entrer la carte à jouer (son nom)");

	    action  = myObj.nextLine();  // Read user input
	    System.out.println(action);
		myObj.close();
		for (int i = 0; i < getMain().getCartes().size(); i++) {
			if (action.equals(getMain().getCartes().get(i).getNom())) {
				carteAJouer = getMain().getCartes().get(i);
				getMain().removeCarte(carteAJouer);
				break;
			}
		}
		return carteAJouer;
	}
}
