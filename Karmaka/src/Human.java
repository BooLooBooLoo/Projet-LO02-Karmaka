package Karmaka.src;

import java.util.Scanner;

public class Human extends Joueur{
	
	private String nom;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String jouer() {
		String action = new String();
		// TODO Auto-generated method stub
		System.out.println(action);
		System.out.println(action != "Passer");
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Entrer votre action (Passer/Oeuvre/Pouvoir/VieFuture)");

	    action  = myObj.nextLine();  // Read user input
	    System.out.println(action);
		myObj.close();
	    if (action.equals("Passer")) {
	    	if (getPile().getCartes().size() > 0) {
	    		return "pile";
	    	} else {
	    		return null;
	    	}
	    } else if (action.equals("Oeuvre")) {
	    	
	    }
		return null;
	}
	
	public static void main(String[] args) {
		Human human = new Human();
		human.jouer();
	}
}
