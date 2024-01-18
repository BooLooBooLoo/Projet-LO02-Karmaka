package Karmaka.src;

import java.io.Serializable;
import java.util.List;
/**
 * La classe {@code Carte} est une classe abstraite qui représente les cartes du jeu "Karmaka".
 * L'abstractivité de cette classe permet de réaliser les différents effets des cartes du jeu.
 *
 * @author Ali MIKOU et Hoang-Viet LE
 * @version 1.0
 */
public abstract class Carte implements Serializable{
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
	
	/**
	 * Le constructeur de la classe {@code Carte} qui permet de créer une instance de cette classe.
	 * 
	 * @param nom Le nom de la carte.
	 * @param cout Le coût karmique de la carte.
	 * @param type Le type de carte représentée par sa couleur.
	 * @param description La description de la carte et de son effet.
	 */
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
					
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * La méthode {@code effet} est la méthode abstraite de cette classe. Elle permet de créer les différents effets des cartes du jeu.
	 * @param partie La méthode a besoin de ce paramètre {@code partie} afin de pouvoir la modifier.
	 */
    public abstract void effet(Partie partie);
    
    /**
     * Getter de l'attribut {@code description}. 
     * @return L'attribut {@code description} de l'instance de classe qui l'appelle.
     */
    public String getDescription() {
		return description;
	}
    /**
     * Setter de l'attribut {@code description}.
     * @param description La description de la carte que l'on veut donner.
     */
	public void setDescription(String description) {
		this.description = description;
	}
    /**
     * Getter de l'attribut {@code cout}. 
     * @return L'attribut {@code cout} de l'instance de classe qui l'appelle.
     */
	public int getCout(){
        return cout;
    }
    /**
     * Getter de l'attribut {@code type}. 
     * @return L'attribut {@code type} de l'instance de classe qui l'appelle.
     */
    public Couleur getType(){
        return type;
    }
    /**
     * Getter de l'attribut {@code nom}. 
     * @return L'attribut {@code nom} de l'instance de classe qui l'appelle.
     */
    public String getNom(){
        return nom;
    }
}

