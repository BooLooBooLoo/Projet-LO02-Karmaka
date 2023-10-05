package Karmaka.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Karmaka.src.Carte.couleur;

public class Partie {
	
	private List<Joueur> joueurs = new ArrayList<Joueur>();
	
	enum echelle{
		bousier,
		serpent,
		loup,
		singe
	}
	
	public List<Joueur> setupJoueur() {
		Joueur joueur = new Joueur();
		Joueur bot = new Joueur();
		joueurs.add(joueur);
		joueurs.add(bot);
		return joueurs;
	}
	
	public void setupEchelleKarmique(Joueur joueur){
		joueur.setEchelleKarmique(echelle.bousier);
	}
	
	public Pile setupSource() {
		//Initialisation de la pile "source"
		Pile source = new Pile();
		
		//Création des cartes de jeu
		Carte carte = new Carte();
		carte.setType(couleur.rouge);
		carte.setNom("Panique");
		carte.setCout(1);
		Carte carte2 = new Carte();
		carte2.setType(couleur.rouge);
		carte2.setNom("Crise");
		carte2.setCout(2);
		Carte carte3 = new Carte();
		carte3.setType(couleur.rouge);
		carte3.setNom("Bassesse");
		carte3.setCout(3);
		
		//Ajouter les cartes à la source
		source.addCarte(carte3);
		source.addCarte(carte2);
		source.addCarte(carte);
		
		//Mélanger les cartes
		List<Carte> cartes = source.getCartes();
		Collections.shuffle(cartes);
		source.setCartes(cartes);
		return source;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partie partie = new Partie();
		partie.joueurs = partie.setupJoueur();
		Pile source = partie.setupSource();
		for (int i = 0; i < source.getCartes().size();i++) {
			System.out.println(source.getCartes().get(i).getNom());
		}
		
		
	}

}
