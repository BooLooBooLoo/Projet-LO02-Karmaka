package Karmaka.src;

public abstract class Carte {
	
    protected String nom;
    protected int cout;
    protected Couleur type;
    protected String description;
    
    public Carte(String nom, int cout, Couleur type, String description) {
    	this.cout = cout;
    	this.description = description;
    	this.nom = nom;
    	this.type = type;
    }
    
    public abstract void effet();
    
    public int getCout(){
        return cout;
    }

    public Couleur getType(){
        return type;
    }

    public String getNom(){
        return nom;
    }
}

