package Karmaka.src;

public class Carte {
    private String nom;
    private int cout;
    enum couleur{
        bleu, 
        vert, 
        rouge
    };

    private couleur type;

    public int getCout(){
        return cout;
    }

    public void setCout(int value){
        cout = value;
    }

    public couleur getType(){
        return type;
    }

    public void setType(couleur value){
        type = value;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String value){
        nom = value;
    }
}
