package Karmaka.src;

public class Carte {
    private String nom;
    private int cout;
 
    private Couleur.couleur type;

    public int getCout(){
        return cout;
    }

    public void setCout(int value){
        cout = value;
    }

    public Couleur.couleur getType(){
        return type;
    }

    public void setType(Couleur.couleur value){
        type = value;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String value){
        nom = value;
    }
}

