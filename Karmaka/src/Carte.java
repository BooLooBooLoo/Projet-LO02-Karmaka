package Karmaka.src;

public abstract class Carte {
	
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
    
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

