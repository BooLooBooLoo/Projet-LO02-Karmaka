package Karmaka.src;

import java.util.List;

import java.util.ArrayList;

public class Joueur {
    private List<Carte> main = new ArrayList<Carte>();
    private Pile pile = new Pile();
    private int anneaux;
    private Echelle.echelle echelleKarmique;
    
    //Echelle Karmique
    public Echelle.echelle getEchelleKarmique() {
		return echelleKarmique;
	}
	public void setEchelleKarmique(Echelle.echelle echelleKarmique) {
		this.echelleKarmique = echelleKarmique;
	}
	
	//Main
	public List<Carte> getMain(){
        return main;
    }
    public void setMain(List<Carte> value){
        main = value;
    }
    public void addCarteMain(Carte carte){
        main.add(carte);
    }
    public void removeCarteMain(Carte carte){
        main.remove(carte);
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
}
