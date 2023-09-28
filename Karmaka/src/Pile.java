package Karmaka.src;

import java.util.ArrayList;
import java.util.List;

public class Pile {
    private List<Carte> cartes = new ArrayList<Carte>();

    public List<Carte> getCartes(){
        return cartes;
    }

    public void setCartes(List<Carte> value){
        cartes = value;
    }

    public void addCarte(Carte carte){
        cartes.add(carte);
    }

    public void removeCarte(Carte carte){
        cartes.remove(carte);
    }

}
