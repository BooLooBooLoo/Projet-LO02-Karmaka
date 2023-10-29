package Karmaka.src;

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
	
	public String choisirCarte() {
		for (int i = 0; i < getMain().getCartes().size(); i++) {
			System.out.println(getMain().getCartes().get(i));
		}
		return "";
	}
}
