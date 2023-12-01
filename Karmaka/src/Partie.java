package Karmaka.src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Cartes.*;

/**
 * La classe {@code Partie} représente une session de jeu du jeu de cartes "Karmaka".
 * Elle comprend des méthodes et des fonctionnalités pour configurer le jeu, gérer les tours,
 * traiter les actions des joueurs et déterminer le gagnant.
 *
 * @author Ali MIKOU & Hoang-Viet LE
 * @version 1.0
 */
public class Partie implements Serializable{
	
	private static int nbrTour = 0;
	private List<Joueur> joueurs = new ArrayList<Joueur>();
	private Joueur tour = null;
	private Pile source = new Pile();
	private Pile defausse = new Pile();
	private boolean win = false;
	
	public boolean getWin() {
		return win;
	}
	
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

	public List<Joueur> setupJoueur(String[] j) {
		if (j[0].equals("B")) {
			Joueur joueur = new Bot(j[2], "IA");
			switch (j[1]) {
			case "A":
		    	joueur = new Bot(j[2], "Aggressif");
		    	break;
		    case "N":
		    	joueur =  new Bot(j[2], "Neutre");
		    	break;
		    case "D":
		    	joueur =  new Bot(j[2], "Défensif");
		    	break;
		    case "IA":
		    	joueur =  new Bot(j[2], "IA");
		    	break;
		     
			}
			joueurs.add(joueur);
		} else if (j[0].equals("H")){
			Joueur joueur = new Human(j[2]);
			joueurs.add(joueur);
		}
		if (j[3].equals("B")) {
			Joueur joueur = new Bot(j[5], "IA");
			switch (j[4]) {
			case "A":
		    	joueur = new Bot(j[5], "Aggressif");
		    	break;
		    case "N":
		    	joueur =  new Bot(j[5], "Neutre");
		    	break;
		    case "D":
		    	joueur =  new Bot(j[5], "Défensif");
		    	break;
		    case "IA":
		    	joueur =  new Bot(j[5], "IA");
		    	break;
		     
			}
			joueurs.add(joueur);
		} else if (j[3].equals("H")){
			Joueur joueur = new Human(j[5]);
			joueurs.add(joueur);
		}
		
		return joueurs;
	}
	
	public void setupEchelleKarmique(Joueur joueur){
		joueur.setEchelleKarmique(Echelle.BOUSIER);
	}
	
	public void deplacerCarte(Pile pileSource, Pile pileCible, Carte carte) {
		pileCible.addCarte(carte);
		pileSource.removeCarte(carte);
	}
	
	public Joueur getAdversaire() {
		Joueur adversaire = null;
		for(int i=0; i<this.getJoueurs().size(); i++) {
			if(this.tour != this.getJoueurs().get(i)) {
				adversaire = this.getJoueurs().get(i);
				break;
			}
		}
		return adversaire;
	}
	
	public Pile setupSource() {
		
		//Création des cartes de jeu
		Carte carte = new CoupDoeil();
		Carte carte2 = new Crise();
		Carte carte3 = new Bassesse();
		Carte carte4 = new Deni();
		Carte carte5 = new DernierSouffle();
		Carte carte6 = new Destinee();
		Carte carte7 = new Duperie();
		Carte carte8 = new Fournaise();
		Carte carte9 = new Incarnation();
		Carte carte10 = new Jubile();
		Carte carte11 = new Lendemain();
		Carte carte12 = new Longevite();
		Carte carte13 = new Mimetisme();
		Carte carte14 = new Panique();
		Carte carte15 = new Recyclage();
		Carte carte16 = new RevesBrises();
		Carte carte17 = new Roulette();
		Carte carte18 = new Sauvetage();
		Carte carte19 = new Semis();
		Carte carte20 = new Transmigration();
		Carte carte21 = new Vengeance();
		Carte carte22 = new Vol();
		Carte carte23 = new Voyage();
		
		
		for (int i = 0; i < 3; i++) {
			source.addCarte(carte20);
			source.addCarte(carte);
			source.addCarte(carte6);
			source.addCarte(carte16);
			source.addCarte(carte4);
			source.addCarte(carte11);
			source.addCarte(carte15);
			source.addCarte(carte18);
			source.addCarte(carte12);
			source.addCarte(carte19);
			source.addCarte(carte14);
			source.addCarte(carte5);
			source.addCarte(carte2);
			source.addCarte(carte17);
			source.addCarte(carte8);
			
		}
		for (int i = 0; i < 2; i++) {
			source.addCarte(carte7);
			source.addCarte(carte22);
			source.addCarte(carte23);
			source.addCarte(carte10);
			source.addCarte(carte21);
			source.addCarte(carte3);
			source.addCarte(carte13);
		}
		for (int i = 0; i < 5; i++) {
			source.addCarte(carte9);
		}
		//Ajouter les cartes à la source
		
		
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
		nbrTour++;
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
	
	
	public void tourDeJeu(Joueur joueur) {
		afficher();
		String temp = "";
		if (joueur.getMain().getCartes().size() == 0 && joueur.getPile().getCartes().size() == 0) {
			reincarnation(joueur);
		} else {
			joueur.piocher();
			temp = joueur.jouer(this);
			while (temp == null) {
				temp = joueur.jouer(this);
			}
			if (temp.equals("Pouvoir")) {
				getAdversaire().coutKarmique(joueur.getDerniereCarteJoue(), this);
			}
		}
		System.out.println("Fin du tour de : "+joueur.getNom());
	}
	
	public void afficher() {
		System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("________TOUR "+nbrTour+" : "+tour.getNom()+"________");
		System.out.println("__Echelle Karmique__");
		System.out.println(joueurs.get(0).getNom()+" : "+joueurs.get(0).getEchelleKarmique());
		System.out.println(joueurs.get(1).getNom()+" : "+joueurs.get(1).getEchelleKarmique());
		System.out.println("__Pile__");
		System.out.println("Source : "+this.source.getCartes().size());
		System.out.println("Fosse : "+this.defausse.getCartes().size());
		System.out.println("__Oeuvres__");
		System.out.println(joueurs.get(0).getNom()+" : "+joueurs.get(0).getOeuvre().toString());
		System.out.println(joueurs.get(1).getNom()+" : "+joueurs.get(1).getOeuvre().toString());
		System.out.println("__Vie Future__");
		System.out.println(joueurs.get(0).getNom()+" : "+joueurs.get(0).getVieFuture().toString());
		System.out.println(joueurs.get(1).getNom()+" : "+joueurs.get(1).getVieFuture().toString());
		System.out.println("__Mains__");
		System.out.println(joueurs.get(0).getNom()+" : "+joueurs.get(0).getMain().toString());
		System.out.println(joueurs.get(1).getNom()+" : "+joueurs.get(1).getMain().toString());
		System.out.println("__Anneaux__");
		System.out.println(joueurs.get(0).getNom()+" : "+joueurs.get(0).getAnneaux());
		System.out.println(joueurs.get(1).getNom()+" : "+joueurs.get(1).getAnneaux());
	}
	
	public void gestionDeLaPartie() {
		choisirJoueur();
		tourDeJeu(tour);
		refillSource();
		
		if (!win) {
			gestionDeLaPartie();
		}
	}
	public void refillSource() {
		if (source.getCartes().size() <= 3) {
			Collections.shuffle(defausse.getCartes());
			for (int i = 0; i < defausse.getCartes().size() - 3; i++) {
				source.addCarte(defausse.getCartes().get(0));
				defausse.removeCarte(defausse.getCartes().get(0));
				
			}
		}
	}
	
	public void setupPartie() {
		setupEchelleKarmique(getJoueurs().get(0));
		setupEchelleKarmique(getJoueurs().get(1));
		setupSource();
		setupPileEtMain(getSource());
		
	}
	
	public void reincarnation(Joueur joueur) {
		System.out.println("Vous allez vous réincarnez !");
		switch (joueur.getEchelleKarmique()) {
		case BOUSIER :
			if (joueur.getAnneaux() + joueur.getOeuvre().compterPoint() >= 4) {
				joueur.setEchelleKarmique(Echelle.SERPENT);
				System.out.println("Vous vous êtes réincarné en serpent");
				for (int i = 0; i < joueur.getOeuvre().getCartes().size(); i++) {
					defausse.addCarte(joueur.getOeuvre().getCartes().get(i));
				}
				joueur.getOeuvre().getCartes().clear();
				for (int i = 0; i < joueur.getVieFuture().getCartes().size(); i++) {
					joueur.getMain().addCarte(joueur.getVieFuture().getCartes().get(i));
				}
				joueur.getVieFuture().getCartes().clear();
				if (joueur.getMain().getCartes().size() < 6) {
					for (int i = 0; i < 6 - joueur.getMain().getCartes().size(); i++) {
						joueur.getMain().addCarte(source.getCartes().get(0));
						source.removeCarte(source.getCartes().get(0));
					}
				}
			} else {
				joueur.setAnneaux(joueur.getAnneaux() + 1);
				System.out.println("Vous n'avez pas de quoi évoluer...");
				for (int i = 0; i < joueur.getOeuvre().getCartes().size(); i++) {
					defausse.addCarte(joueur.getOeuvre().getCartes().get(i));
				}
				joueur.getOeuvre().getCartes().clear();
				for (int i = 0; i < joueur.getVieFuture().getCartes().size(); i++) {
					joueur.getMain().addCarte(joueur.getVieFuture().getCartes().get(i));
				}
				joueur.getVieFuture().getCartes().clear();
				if (joueur.getMain().getCartes().size() < 6) {
					for (int i = 0; i < 6 - joueur.getMain().getCartes().size(); i++) {
						joueur.getMain().addCarte(source.getCartes().get(0));
						source.removeCarte(source.getCartes().get(0));
					}
				}
			}
			break;
		case SERPENT :
			if (joueur.getAnneaux() + joueur.getOeuvre().compterPoint() >= 5) {
				joueur.setEchelleKarmique(Echelle.LOUP);
				System.out.println("Vous vous êtes réincarné en loup");
				for (int i = 0; i < joueur.getOeuvre().getCartes().size(); i++) {
					defausse.addCarte(joueur.getOeuvre().getCartes().get(i));
				}
				joueur.getOeuvre().getCartes().clear();
				for (int i = 0; i < joueur.getVieFuture().getCartes().size(); i++) {
					joueur.getMain().addCarte(joueur.getVieFuture().getCartes().get(i));
				}
				joueur.getVieFuture().getCartes().clear();
				if (joueur.getMain().getCartes().size() < 6) {
					for (int i = 0; i < 6 - joueur.getMain().getCartes().size(); i++) {
						joueur.getMain().addCarte(source.getCartes().get(0));
						source.removeCarte(source.getCartes().get(0));
					}
				}
			} else {
				joueur.setAnneaux(joueur.getAnneaux() + 1);
				System.out.println("Vous n'avez pas de quoi évoluer...");
				for (int i = 0; i < joueur.getOeuvre().getCartes().size(); i++) {
					defausse.addCarte(joueur.getOeuvre().getCartes().get(i));
				}
				joueur.getOeuvre().getCartes().clear();
				for (int i = 0; i < joueur.getVieFuture().getCartes().size(); i++) {
					joueur.getMain().addCarte(joueur.getVieFuture().getCartes().get(i));
				}
				joueur.getVieFuture().getCartes().clear();
				if (joueur.getMain().getCartes().size() < 6) {
					for (int i = 0; i < 6 - joueur.getMain().getCartes().size(); i++) {
						joueur.getMain().addCarte(source.getCartes().get(0));
						source.removeCarte(source.getCartes().get(0));
					}
				}
			}
			break;
		case LOUP :
			if (joueur.getAnneaux() + joueur.getOeuvre().compterPoint() >= 6) {
				joueur.setEchelleKarmique(Echelle.SINGE);
				System.out.println("Vous vous êtes réincarné en serpent");
				for (int i = 0; i < joueur.getOeuvre().getCartes().size(); i++) {
					defausse.addCarte(joueur.getOeuvre().getCartes().get(i));
				}
				joueur.getOeuvre().getCartes().clear();
				for (int i = 0; i < joueur.getVieFuture().getCartes().size(); i++) {
					joueur.getMain().addCarte(joueur.getVieFuture().getCartes().get(i));
				}
				joueur.getVieFuture().getCartes().clear();
				if (joueur.getMain().getCartes().size() < 6) {
					for (int i = 0; i < 6 - joueur.getMain().getCartes().size(); i++) {
						joueur.getMain().addCarte(source.getCartes().get(0));
						source.removeCarte(source.getCartes().get(0));
					}
				}
			} else {
				joueur.setAnneaux(joueur.getAnneaux() + 1);
				System.out.println("Vous n'avez pas de quoi évoluer...");
				for (int i = 0; i < joueur.getOeuvre().getCartes().size(); i++) {
					defausse.addCarte(joueur.getOeuvre().getCartes().get(i));
				}
				joueur.getOeuvre().getCartes().clear();
				for (int i = 0; i < joueur.getVieFuture().getCartes().size(); i++) {
					joueur.getMain().addCarte(joueur.getVieFuture().getCartes().get(i));
				}
				joueur.getVieFuture().getCartes().clear();
				if (joueur.getMain().getCartes().size() < 6) {
					for (int i = 0; i < 6 - joueur.getMain().getCartes().size(); i++) {
						joueur.getMain().addCarte(source.getCartes().get(0));
						source.removeCarte(source.getCartes().get(0));
					}
				}
			}
			break;
		case SINGE :
			if (joueur.getAnneaux() + joueur.getOeuvre().compterPoint() >= 7) {
				this.setWin(true);
				System.out.println("Vous avez atteint la transcendance");
				System.out.println(joueur.getNom() + " a gagné cette partie !");
			} else {
				joueur.setAnneaux(joueur.getAnneaux() + 1);
				System.out.println("Vous n'avez pas de quoi évoluer...");
				for (int i = 0; i < joueur.getOeuvre().getCartes().size(); i++) {
					defausse.addCarte(joueur.getOeuvre().getCartes().get(i));
				}
				joueur.getOeuvre().getCartes().clear();
				for (int i = 0; i < joueur.getVieFuture().getCartes().size(); i++) {
					joueur.getMain().addCarte(joueur.getVieFuture().getCartes().get(i));
				}
				joueur.getVieFuture().getCartes().clear();
				if (joueur.getMain().getCartes().size() < 6) {
					for (int i = 0; i < 6 - joueur.getMain().getCartes().size(); i++) {
						joueur.getMain().addCarte(source.getCartes().get(0));
						source.removeCarte(source.getCartes().get(0));
					}
				}
			}
			break;
		}
	}
	
	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partie partie = new Partie();
		partie.setupJoueur(new String[] {"B","A","Michael","H","D","Donovan"});
		partie.setupPartie();
		partie.gestionDeLaPartie();
		//{typeJ1,stratJ1,text1.getText(),typeJ2,stratJ2,text2.getText()}
	}
	
}
