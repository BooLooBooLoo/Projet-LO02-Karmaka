package Karmaka.src;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Cartes.*;
import Graphique.Controller;

/**
 * La classe {@code Partie} représente une session de jeu du jeu de cartes "Karmaka".
 * Elle comprend des méthodes et des fonctionnalités pour configurer le jeu, gérer les tours,
 * traiter les actions des joueurs et déterminer le gagnant.
 *
 * @author Ali MIKOU et Hoang-Viet LE
 * @version 1.0
 */
public class Partie implements Serializable, PropertyChangeListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5988232900096601206L;

	/**
	 * Getter de l'attribut {@code nbrTour}
	 * @return Le nombre de tour actuel de la partie.
	 */
	public  int getNbrTour() {
		return nbrTour;
	}
	
	/**
	 * Setter de l'attribut {@code nbrTour}
	 * @param nbrTour Le nombre de tour à fixer.
	 */
	public  void setNbrTour(int nbrTour) {
		this.nbrTour = nbrTour;
	}

	private int nbrTour = 0;
	private List<Joueur> joueurs = new ArrayList<Joueur>();
	private Joueur tour = null;
	private Pile source = new Pile();
	private Pile defausse = new Pile();
	private boolean win = false;
	private PropertyChangeSupport diffuseur;
	private boolean cardPlayed = false;
	
	/**
	 * Constructeur de la classe {@code Partie}.
	 */
	public Partie() {
		diffuseur = new PropertyChangeSupport(this);
	}
	
	public void addSub(PropertyChangeListener pcl) {
		diffuseur.addPropertyChangeListener(pcl);
	}
	
	/**
	 * Getter de l'attribut {@code win}
	 * @return Un booléen indiquant si la partie est terminée.
	 */
	public boolean getWin() {
		return win;
	}
	
	/**
	 * Getter de l'attribut {@code source}.
	 * @return La source de la partie.
	 */
	public Pile getSource() {
		return source;
	}
	
	/**
	 * Setter de l'attribut {@code source}.
	 * @param source Une liste de cartes.
	 */
	public void setSource(Pile source) {
		this.source = source;
	}
	/**
	 * Getter de l'attribut {@code defausse}.
	 * @return La défausse de la partie.
	 */
	public Pile getDefausse() {
		return defausse;
	}
	
	/**
	 * Setter de l'attribut {@code defausse}.
	 * @param defausse Une liste de cartes.
	 */
	public void setDefausse(Pile defausse) {
		this.defausse = defausse;
	}
	
	/**
	 * Getter de l'attribut {@code tour} qui représente le joueur qui joue actuellement.
	 * @return Le joueur du tour actuel.
	 */
	public Joueur getTour() {
		return tour;
	}
	
	/**
	 * Setter de l'attribut {@code tour}
	 * @param tour Un joueur de la partie.
	 */
	public void setTour(Joueur tour) {
		this.tour = tour;
	}
	
	/**
	 * Getter de l'attribut {@code joueurs} qui représente l'ensemble des joueurs de la partie.
	 * @return La liste de tous les joueurs de la partie.
	 */
	public List<Joueur> getJoueurs() {
		return joueurs;
	}
	
	/**
	 * Setter de l'attribut {@code joueurs}.
	 * @param joueurs Une liste de joueurs.
	 */
	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	
	/**
	 * Méthode qui permet de créer les joueurs de la partie.
	 * Elle dépends du choix de la configuration de la partie qui est stocké dans un string.
	 * @param j Les paramètres de configuration des joueurs de la partie.
	 * @return Une liste de joueurs correspondant aux choix de la configuration.
	 */
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
	
	/**
	 * Méthode permettant d'initialiser les échelles de tous les joueurs de la partie.
	 * @param joueur Un joueur.
	 */
	public void setupEchelleKarmique(Joueur joueur){
		joueur.setEchelleKarmique(Echelle.BOUSIER);
	}
	
	/**
	 * Méthode permettant de "déplacer" une carte d'une pile de carte à une autre.
	 * @param pileSource La pile source où l'on veut déplacer la carte.
	 * @param pileCible La pile où l'on veut que la carte se retrouve.
	 * @param carte La carte choisie à déplacer.
	 */
	public void deplacerCarte(Pile pileSource, Pile pileCible, Carte carte) {
		pileCible.addCarte(carte);
		pileSource.removeCarte(carte);
	}
	
	/**
	 * Méthode permettant d'obtenir l'adversaire du joueur qui joue actuellement.
	 * @return L'adversaire du joueur qui joue.
	 */
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
	
	/**
	 * Méthode permettant d'initialiser la source de la partie.
	 * Elle respecte les règles du jeu Karmaka avec le bon nombre de cartes différentes.
	 * @return
	 */
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
	
	/**
	 * Méthode permettant d'initialiser la main et la pile de chaque joueurs.
	 * @param source La source de la partie.
	 */
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
	
	/**
	 * Méthode permettant de choisir le joueur qui va débuter cette partie.
	 * Dans les règles du jeu, c'est celui le plus malchanceux qui commence. On le simule par de l'hasard ici.
	 */
	public void choisirJoueur() {
		if (this.tour == null) {
			double rand = Math.random();
			Joueur j = (rand >= 0.5) ? getJoueurs().get(0) : getJoueurs().get(1);
			this.tour = j;
		} else {
			nbrTour++;
			Joueur j = (joueurs.indexOf(tour) >= joueurs.size()-1) ? joueurs.get(0) : joueurs.get(joueurs.indexOf(tour) + 1);
			this.tour = j;
		}
		
	}

	/**
	 * Méthode qui simule un tour complet de jeu d'une partie, c'est-à-dire de choisir une carte à jouer et de son action.
	 * @param joueur Le joueur qui joue actuellement.
	 */
	public void tourDeJeu(Joueur joueur) {
		afficher();
		String temp = "";
		if (joueur.getMain().getCartes().size() == 0 && joueur.getPile().getCartes().size() == 0) {
			reincarnation(joueur);
		} else {
			//joueur.piocher();
			if (joueur instanceof Human) {
				while (!cardPlayed) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				temp = joueur.jouer(this);
				cardPlayed = false;	
			} else {
				temp = joueur.jouer(this);
				while (temp == null) {
					temp = joueur.jouer(this);
				}
			}
			
			if (temp.equals("Pouvoir")) {
				diffuseur.firePropertyChange("Cout Karmique", "a", joueur.getDerniereCarteJoue());
				getAdversaire().coutKarmique(joueur.getDerniereCarteJoue(), this);
				
			}
		}
		System.out.println("Fin du tour de : "+joueur.getNom());
	}

	/**
	 * Méthode permettant d'afficher les informations sur le déroulement de la partie.
	 * C'est l'affichage de notre jeu dans la console.
	 */
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
	
	/**
	 * Méthode permettant de simuler une partie complètement.
	 * Elle se rappelle jusqu'à que la partie détecte un gagnant.
	 */
	public void gestionDeLaPartie() {
		choisirJoueur();
		tourDeJeu(tour);
		refillSource();
		
		if (!win) {
			gestionDeLaPartie();
		}
	}
	
	/**
	 * Méthode permettant de regénérer la source à partir de la défausse.
	 */
	public void refillSource() {
		if (source.getCartes().size() <= 3) {
			Collections.shuffle(defausse.getCartes());
			for (int i = 0; i < defausse.getCartes().size() - 3; i++) {
				source.addCarte(defausse.getCartes().get(0));
				defausse.removeCarte(defausse.getCartes().get(0));
				
			}
		}
	}
	
	/**
	 * Méthode permettant d'initialiser l'ensemble des éléments pour débuter une partie.
	 */
	public void setupPartie() {
		setupEchelleKarmique(getJoueurs().get(0));
		setupEchelleKarmique(getJoueurs().get(1));
		setupSource();
		setupPileEtMain(getSource());
		
	}
	
	/**
	 * Méthode permettant de gérer le système de réincarnation du jeu "Karmaka".
	 * @param joueur Le joueur dont l'on regarde s'il peut se réincarner.
	 */
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
	
	/**
	 * Setter de l'attribut {@code win}
	 * @param win Un booléen.
	 */
	public void setWin(boolean win) {
		this.win = win;
	}
	
	/**
	 * Méthode permettant de sauvegarder une partie
	 */
	public void sauvegarder() {
		ObjectOutputStream oos = null;
		try {
			final FileOutputStream fichier = new FileOutputStream("./sauvegarde/sauvegarde_partie.ser");
			oos = new ObjectOutputStream(fichier);
			oos.writeObject(this);
			oos.flush();
		} catch(final java.io.IOException e) {
			e.printStackTrace();
		} finally {
		      try {
		          if (oos != null) {
		            oos.flush();
		            oos.close();
		          }
		          System.out.println("Partie Sauvegardée");
		        } catch (final IOException ex) {
		          ex.printStackTrace();
		        }
		     }
	}
	
	/**
	 * Méthode permettant d'importer une partie
	 * @param partie La partie que l'on veut importer
	 * @throws ClassNotFoundException
	 */
	public static Partie importer(File fichierPartie) throws ClassNotFoundException {
		ObjectInputStream ois = null;
		try {
			final FileInputStream fichier = new FileInputStream(fichierPartie);
			ois = new ObjectInputStream(fichier);
			final Partie partieImportee = (Partie) ois.readObject();
			System.out.println("Partie importée");
			return partieImportee;
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) {
					ois.close();
				}
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * Méthode permettant de vérifier s'il y a une sauvegarde dans le dossier.
	 * @return Booléen indiquant la présence d'une sauvegarde.
	 */
	public boolean hasSave() {
		File f = new File("./sauvegarde/sauvegarde_partie.ser");
		return f.exists();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (tour instanceof Human && !evt.getOldValue().equals("Rejouer")) {
			((Human) tour).setAction(evt.getPropertyName());
			((Human) tour).setCardToPlay((Carte) evt.getNewValue());
			cardPlayed = true;
		} else if (tour instanceof Human && evt.getOldValue().equals("Rejouer")) {
			((Human) tour).setActionRejouer(evt.getPropertyName());
			((Human) tour).setcTPRejouer((Carte) evt.getNewValue());
		}
		
	}
}
