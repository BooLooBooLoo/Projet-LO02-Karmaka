package Karmaka.src;

public class Carte {
	
    protected String nom;
    protected int cout;
    protected Couleur type;
    protected String description;

    public int getCout(){
        return cout;
    }

    public void setCout(int value){
        cout = value;
    }

    public Couleur getType(){
        return type;
    }

    public void setType(Couleur value){
        type = value;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String value){
        nom = value;
    }

	

}

