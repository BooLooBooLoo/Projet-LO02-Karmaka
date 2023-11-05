package Karmaka.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Cartes.*;

public class Partie {
	
	private List<Joueur> joueurs = new ArrayList<Joueur>();
	private Joueur tour = null;
	private Pile source = new Pile();
	private Pile defausse = new Pile();
	
	public Pile getSource() {
		return source;
	}

	public void setSource(Pile source) {
		this.source = source;
	}

	public Pile getDefausse() {
		return defausse;
	}

	public void setDefausse(Pile defausse) {
		this.defausse = defausse;
	}
	
	public Joueur getTour() {
		return tour;
	}

	public void setTour(Joueur tour) {
		this.tour = tour;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public List<Joueur> setupJoueur() {
		Joueur joueur = new Human();
		Joueur bot = new Bot();
		joueurs.add(joueur);
		joueurs.add(bot);
		return joueurs;
	}
	
	public void setupEchelleKarmique(Joueur joueur){
		joueur.setEchelleKarmique(Echelle.BOUSIER);
	}
	
	public void deplacerCarte(Pile pileSource, Pile pileCible, Carte carte) {
		pileCible.addCarte(carte);
		pileSource.removeCarte(carte);
	}
	
	public Pile setupSource() {
		
		//Création des cartes de jeu
		Carte carte = new Panique();
		Carte carte2 = new Deni();
		Carte carte3 = new Crise();
		Carte carte4 = new Transmigration();
		Carte carte5 = new Semis();
		
		//Ajouter les cartes à la source
		source.addCarte(carte4);
		source.addCarte(carte4);
		source.addCarte(carte4);
		source.addCarte(carte4);
		source.addCarte(carte2);
		source.addCarte(carte);
		source.addCarte(carte);
		source.addCarte(carte);
		source.addCarte(carte3);
		source.addCarte(carte3);
		source.addCarte(carte3);
		source.addCarte(carte2);
		source.addCarte(carte2);
		source.addCarte(carte);
		source.addCarte(carte);
		source.addCarte(carte);
		source.addCarte(carte5);
		source.addCarte(carte5);
		source.addCarte(carte5);
		source.addCarte(carte5);
		
		//Mélanger les cartes
		List<Carte> cartes = source.getCartes();
		Collections.shuffle(cartes);
		source.setCartes(cartes);
		return source;
	}
	
	public void setupPileEtMain(Pile source) {
		for (int i = 0; i < joueurs.size();i++) {
			for (int j = 0; j < 4; j++) {
				joueurs.get(i).getMain().addCarte(source.getCartes().get(0));
				source.removeCarte(source.getCartes().get(0));
			}
			for (int j = 0; j < 2; j++) {
				joueurs.get(i).addCartePile(source.getCartes().get(0));
				source.removeCarte(source.getCartes().get(0));
			}
		}
	}
	
	public void choisirJoueur() {
		if (this.tour == null) {
			double rand = Math.random();
			System.out.println(rand);
			System.out.println(rand >= 0.5);
			Joueur j = (rand >= 0.5) ? getJoueurs().get(0) : getJoueurs().get(1);
			this.tour = j;
		} else {
			Joueur j = (joueurs.indexOf(tour) >= joueurs.size()-1) ? joueurs.get(0) : joueurs.get(joueurs.indexOf(tour) + 1);
			this.tour = j;
		}
		
	}
	//Coût Karmique
	public void coutKarmique(Carte carte) {
		String action = new String();
		// TODO Auto-generated method stub
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Voulez-vous récuperer la carte suivante (Y/N) :"+carte.getNom());

	    action  = myObj.nextLine();  // Read user input
	    System.out.println(action);
		//myObj.close();
		if (action.equals("Y")) {
			getJoueurs().get(1 - getJoueurs().indexOf(getTour())).getVieFuture().addCarte(carte);
		}
	}
	
	public void tourDeJeu(Joueur joueur) {
		joueur.piocher();
		String temp = joueur.jouer(this);
		while (temp.equals(null)) {
			temp = joueur.jouer(this);
		}
		if (temp.equals("Pouvoir")) {
			coutKarmique(joueur.getDerniereCarteJoue());
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partie partie = new Partie();
		partie.setJoueurs(partie.setupJoueur());
		partie.setupEchelleKarmique(partie.getJoueurs().get(0));
		partie.setupEchelleKarmique(partie.getJoueurs().get(1));
		partie.setupSource();
		System.out.println("Source :");
		for (int i = 0; i < partie.getSource().getCartes().size();i++) {
			System.out.println(partie.getSource().getCartes().get(i).getNom());
		}
		partie.setupPileEtMain(partie.getSource());
		for (int i = 0; i < partie.getJoueurs().size();i++){
			System.out.println("Joueur "+i+" :");
			for (int j = 0; j < partie.getJoueurs().get(i).getMain().getCartes().size();j++) {
				System.out.println(partie.getJoueurs().get(i).getMain().getCartes().get(j).getNom());
			}
		}
		
		System.out.println("Joueur 0 :");
		for (int j = 0; j < partie.getJoueurs().get(0).getMain().getCartes().size();j++) {
			System.out.println(partie.getJoueurs().get(0).getMain().getCartes().get(j).getNom());
		}
		
		partie.choisirJoueur();
		System.out.println(partie.getTour());
		partie.tourDeJeu(partie.getTour());
		System.out.println("OUT 2");
		
	}
	
}
