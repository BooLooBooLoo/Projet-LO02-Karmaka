package Karmaka.src;

import java.util.List;

import Karmaka.src.Partie.echelle;

import java.util.ArrayList;

public class Joueur {
    private List<Carte> main = new ArrayList<Carte>();
    private int anneaux;
    private echelle echelleKarmique;
    

    public echelle getEchelleKarmique() {
		return echelleKarmique;
	}
	public void setEchelleKarmique(echelle echelleKarmique) {
		this.echelleKarmique = echelleKarmique;
	}
	public List<Carte> getMain(){
        return main;
    }
    public void setMain(List<Carte> value){
        main = value;
    }
    public void addCarte(Carte carte){
        main.add(carte);
    }
    public void removeCarte(Carte carte){
        main.remove(carte);
    }
    public int getAnneaux(){
        return anneaux;
    }
    public void setAnneaux(int value){
        anneaux = value;
    }
}
