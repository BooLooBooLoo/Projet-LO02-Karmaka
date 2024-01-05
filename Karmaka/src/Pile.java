package Karmaka.src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * La classe {@code Pile} est une classe qui permet de représenter une pile de carte.
 * Elle possède des méthodes afin de pouvoir la manipuler.
 * @author Ali MIKOU et Hoang-Viet LE
 * @version 1.0
 */
public class Pile implements Serializable {
    protected List<Carte> cartes = new ArrayList<Carte>();

    /**
     * Getter de l'attribut {@code cartes}.
     * @return L'attribut {@code cartes} de l'instance de la classe. 
     */
    public List<Carte> getCartes(){
        return cartes;
    }
    
    /**
     * Setter de l'attribut {@code cartes}
     * @param value Une liste d'élements de type {@code carte}.
     */
    public void setCartes(List<Carte> value){
        cartes = value;
    }
    
    /**
     * Méthode qui permet d'ajouter une carte à la pile de carte.
     * @param carte Element de type {@code carte}
     */
    public void addCarte(Carte carte){
        cartes.add(carte);
    }
    
    /**
     * Méthode qui permet de retirer une carte à la pile de carte.
     * @param carte Element de type {@code carte}
     */
    public void removeCarte(Carte carte){
        cartes.remove(carte);
    }
    
    /**
     * Redéfinition de la méthode toString afin de l'utiliser selon nos besoins.
     * @return Retourne un string contenant l'ensemble des cartes de la pile.
     */
    public String toString() {
		String str = new String();
		str += "[";
		for (int i = 0; i < cartes.size(); i++) {
			str+= new String(cartes.get(i).getNom())+", ";
		}
		str+= "]";
		return str;
		
	}
}
