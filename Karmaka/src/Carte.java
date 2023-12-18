package Karmaka.src;

import java.util.List;

public abstract class Carte {
	
    protected String nom;
    protected int cout;
    protected Couleur type;
    protected String description;
    protected boolean rejouable;
    protected List<String> actions = null;
    
    public List<String> getActions() {
		return actions;
	}

	public void setActions(List<String> actions) {
		this.actions = actions;
	}

	public Carte(String nom, int cout, Couleur type, String description) {
    	this.cout = cout;
    	this.description = description;
    	this.nom = nom;
    	this.type = type;
    	this.rejouable = false;
    }
    
	public void wait(Partie partie) {
		if (partie.getTour() instanceof Human) {
			while(actions == null) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
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

