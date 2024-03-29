package Karmaka.src;

import java.io.Serializable;

public abstract class Carte implements Serializable{
	
    protected String nom;
    protected int cout;
    protected Couleur type;
    protected String description;
    protected boolean rejouable;
    
    public Carte(String nom, int cout, Couleur type, String description) {
    	this.cout = cout;
    	this.description = description;
    	this.nom = nom;
    	this.type = type;
    	this.rejouable = false;
    }
    
    public abstract void effet(Partie partie);
    
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

