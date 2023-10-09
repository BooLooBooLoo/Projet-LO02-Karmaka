package Karmaka.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Partie {
	
	private List<Joueur> joueurs = new ArrayList<Joueur>();
	private Joueur tour;
	
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
		Joueur joueur = new Joueur();
		Joueur bot = new Joueur();
		joueurs.add(joueur);
		joueurs.add(bot);
		return joueurs;
	}
	
	public void setupEchelleKarmique(Joueur joueur){
		joueur.setEchelleKarmique(Echelle.BOUSIER);
	}
	
	public Pile setupSource() {
		//Initialisation de la pile "source"
		Pile source = new Pile();
		
		//Création des cartes de jeu
		Carte carte = new Carte();
		carte.setType(Couleur.ROUGE);
		carte.setNom("Panique");
		carte.setCout(1);
		Carte carte2 = new Carte();
		carte2.setType(Couleur.ROUGE);
		carte2.setNom("Crise");
		carte2.setCout(2);
		Carte carte3 = new Carte();
		carte3.setType(Couleur.ROUGE);
		carte3.setNom("Bassesse");
		carte3.setCout(3);
		
		//Ajouter les cartes à la source
		source.addCarte(carte3);
		source.addCarte(carte3);
		source.addCarte(carte3);
		source.addCarte(carte2);
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
		
		//Mélanger les cartes
		List<Carte> cartes = source.getCartes();
		Collections.shuffle(cartes);
		source.setCartes(cartes);
		return source;
	}
	
	public void setupPileEtMain(Pile source) {
		for (int i = 0; i < joueurs.size();i++) {
			for (int j = 0; j < 4; j++) {
				joueurs.get(i).addCarteMain(source.getCartes().get(0));
				source.removeCarte(source.getCartes().get(0));
			}
			for (int j = 0; j < 2; j++) {
				joueurs.get(i).addCartePile(source.getCartes().get(0));
				source.removeCarte(source.getCartes().get(0));
			}
		}
	}
	
	public void choisirPremierJoueur() {
		double rand = Math.random();
		Joueur j = (rand >= 0.5) ? getJoueurs().get(0) : getJoueurs().get(1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partie partie = new Partie();
		partie.setJoueurs(partie.setupJoueur());
		partie.setupEchelleKarmique(partie.getJoueurs().get(0));
		partie.setupEchelleKarmique(partie.getJoueurs().get(1));
		Pile source = partie.setupSource();
		System.out.println("Source :");
		for (int i = 0; i < source.getCartes().size();i++) {
			System.out.println(source.getCartes().get(i).getNom());
		}
		partie.setupPileEtMain(source);
		for (int i = 0; i < partie.getJoueurs().size();i++){
			System.out.println("Joueur "+i+" :");
			for (int j = 0; j < partie.getJoueurs().get(i).getMain().size();j++) {
				System.out.println(partie.getJoueurs().get(i).getMain().get(j).getNom());
			}
		}
		System.out.println("Source :");
		for (int i = 0; i < source.getCartes().size();i++) {
			System.out.println(source.getCartes().get(i).getNom());
		}
		
	}

}
