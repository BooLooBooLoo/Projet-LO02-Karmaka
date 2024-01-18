package Karmaka.src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * L'interface Startegy fait partie du design-pattern du même nom utilisé afin construire une stratégie pour les {@code Bot} du jeu.
 * @author Ali MIKOU et Hoang-Viet LE
 * @version 1.0
 */
public interface Strategy {
	/**
	 * Méthode permettant à la stratégie de jouer la partie.
	 * @param partie La partie où se trouve le joeur.
	 * @return Un string qui permet le bon fonctionnement de la partie.
	 */
	public String jouer(Partie partie);
	
	/**
	 * La classe {@code Neutre} est une stratégie qui joue aléatoirement.
	 */
	class Neutre implements Strategy{
		
		/**
		 * Méthode permettant de choisir au hasard l'action du {@code Bot}.
		 */
		public String jouer(Partie partie) {
			String bool = new String();
			String action = new String();
			int rand = (int) Math.floor(Math.random()*4);
			switch (rand) {
				case 0:
					action = "Passer";
					break;
				case 1:
					action = "Oeuvre";
					break;
				case 2:
					action = "Pouvoir";
					break;
				case 3:
					action = "VieFuture";
					break;
			}
			bool = null;
		    if (action.equals("Passer")) {
		    	if (partie.getTour().getPile().getCartes().size() > 0) {
		    		bool = "done";
		    	} else {
		    		bool = null;
		    	}
		    } else if (action.equals("Pouvoir")) {
		    	Carte temp = partie.getTour().choisirCarte();
		    	partie.getTour().setDerniereCarteJoue(temp);
		    	temp.effet(partie);
		    	partie.getTour().getMain().removeCarte(temp);
		    	bool = "Pouvoir";
		    } else if (action.equals("Oeuvre")) {
		    	Carte temp = partie.getTour().choisirCarte();
		    	partie.getTour().setDerniereCarteJoue(temp);
		    	partie.getTour().oeuvre.addCarte(temp);
		    	partie.getTour().getMain().removeCarte(temp);
		    	bool = "done";
		    } else if (action.equals("VieFuture")) {
		    	Carte temp = partie.getTour().choisirCarte();
		    	partie.getTour().setDerniereCarteJoue(temp);
		    	partie.getTour().vieFuture.addCarte(temp);
		    	partie.getTour().getMain().removeCarte(temp);
		    	bool = "done";
			
		    }
		    return bool;
		}
	}
	
	/**
	 * Méthode permettant de choisir au hasard l'action du {@code Bot} mais qui a une tendance à jouer les cartes en mode "Pouvoir".
	 */
	class Aggressif implements Strategy{

		public String jouer(Partie partie) {
			String bool = new String();
			String action = new String();
			int rand = (int) Math.floor(Math.random()*10);
			if (rand <= 7) {
				rand = 2;
			} else if (rand == 8) {
				rand = 0;
			} else if (rand == 9) {
				rand = 1;
			} else {
				rand = 3;
			}
			switch (rand) {
				case 0:
					action = "Passer";
					break;
				case 1:
					action = "Oeuvre";
					break;
				case 2:
					action = "Pouvoir";
					break;
				case 3:
					action = "VieFuture";
					break;
			}
			bool = null;
		    if (action.equals("Passer")) {
		    	if (partie.getTour().getPile().getCartes().size() > 0) {
		    		bool = "done";
		    	} else {
		    		bool = null;
		    	}
		    } else if (action.equals("Pouvoir")) {
		    	Carte temp = partie.getTour().choisirCarte();
		    	partie.getTour().setDerniereCarteJoue(temp);
		    	temp.effet(partie);
		    	partie.getTour().getMain().removeCarte(temp);
		    	bool = "Pouvoir";
		    } else if (action.equals("Oeuvre")) {
		    	Carte temp = partie.getTour().choisirCarte();
		    	partie.getTour().setDerniereCarteJoue(temp);
		    	partie.getTour().oeuvre.addCarte(temp);
		    	partie.getTour().getMain().removeCarte(temp);
		    	bool = "done";
		    } else if (action.equals("VieFuture")) {
		    	Carte temp = partie.getTour().choisirCarte();
		    	partie.getTour().setDerniereCarteJoue(temp);
		    	partie.getTour().vieFuture.addCarte(temp);
		    	partie.getTour().getMain().removeCarte(temp);
		    	bool = "done";
			
		    }
		    return bool;
		}
	}
	
	/**
	 * Méthode permettant de choisir au hasard l'action du {@code Bot} mais qui a une tendance à jouer les cartes en mode "Oeuvre".
	 */
	class Defensif implements Strategy{

		public String jouer(Partie partie) {
			String bool = new String();
			String action = new String();
			int rand = (int) Math.floor(Math.random()*10);
			if (rand <= 7) {
				rand = 1;
			} else if (rand == 8) {
				rand = 0;
			} else if (rand == 9) {
				rand = 2;
			} else {
				rand = 3;
			}
			switch (rand) {
				case 0:
					action = "Passer";
					break;
				case 1:
					action = "Oeuvre";
					break;
				case 2:
					action = "Pouvoir";
					break;
				case 3:
					action = "VieFuture";
					break;
			}
			bool = null;
		    if (action.equals("Passer")) {
		    	if (partie.getTour().getPile().getCartes().size() > 0) {
		    		bool = "done";
		    	} else {
		    		bool = null;
		    	}
		    } else if (action.equals("Pouvoir")) {
		    	Carte temp = partie.getTour().choisirCarte();
		    	partie.getTour().setDerniereCarteJoue(temp);
		    	temp.effet(partie);
		    	partie.getTour().getMain().removeCarte(temp);
		    	bool = "Pouvoir";
		    } else if (action.equals("Oeuvre")) {
		    	Carte temp = partie.getTour().choisirCarte();
		    	partie.getTour().setDerniereCarteJoue(temp);
		    	partie.getTour().oeuvre.addCarte(temp);
		    	partie.getTour().getMain().removeCarte(temp);
		    	bool = "done";
		    } else if (action.equals("VieFuture")) {
		    	Carte temp = partie.getTour().choisirCarte();
		    	partie.getTour().setDerniereCarteJoue(temp);
		    	partie.getTour().vieFuture.addCarte(temp);
		    	partie.getTour().getMain().removeCarte(temp);
		    	bool = "done";
			
		    }
		    return bool;
		}
	}
	
	/**
	 * Méthode permettant de choisir l'action du {@code Bot} selon sa main. Elle réalise les différents combinaisons de cartes possibles et choisit son action.
	 */
	class IA implements Strategy, Serializable {
		
		public Pile oeuvre = new Pile();
		public Pile main = new Pile();
		private Echelle ancienneEchelle;
		private List<Couleur> colOeuvre = null;
		private int nbr = 0;
		
		public String jouer(Partie partie) {
			String bool = "";
			if (ancienneEchelle != partie.getTour().getEchelleKarmique()) {
				ancienneEchelle = partie.getTour().getEchelleKarmique();
				nbr = setupNbr(partie);
				colOeuvre = compterPoint(partie, nbr);
			}
			if (colOeuvre != null) {
				System.out.println(colOeuvre);
				oeuvre = combinaison(partie, colOeuvre.get(0), nbr - partie.getTour().getOeuvre().compterPoint());
			}
			if (oeuvre.getCartes().contains(partie.getTour().getMain().getCartes().get(0)) 
				&& partie.getTour().getOeuvre().compterPoint() + partie.getTour().getAnneaux() < nbr) {
				
				Carte carte = partie.getTour().getMain().getCartes().get(0);
				partie.getTour().getOeuvre().addCarte(carte);
				partie.getTour().setDerniereCarteJoue(carte);
				partie.getTour().getMain().removeCarte(carte);
				bool = "done";
			} else if (partie.getTour().getMain().getCartes().get(0).getType().equals(colOeuvre.get(1)) 
					|| partie.getTour().getMain().getCartes().get(0).getType().equals(Couleur.MOSAIQUE)){
				Carte carte = partie.getTour().getMain().getCartes().get(0);
				partie.getTour().getVieFuture().addCarte(carte);
				partie.getTour().setDerniereCarteJoue(carte);
				partie.getTour().getMain().removeCarte(carte);
				bool = "done";
			} else {
				Carte carte1 = partie.getTour().getMain().getCartes().get(0);
				carte1.effet(partie);
				partie.getTour().setDerniereCarteJoue(carte1);
				partie.getTour().getMain().removeCarte(carte1);
				bool = "Pouvoir";

			}
			return bool;
		}
		
		public int setupNbr(Partie partie) {
			int nbr = 100;
			switch (partie.getTour().getEchelleKarmique()) {
			case BOUSIER :
				nbr = 4;
				break;
			case SERPENT :
				nbr = 5;
				break;
			case LOUP :
				nbr = 6;
				break;
			case SINGE :
				nbr = 7;
				break;
			}
			return nbr;
		}
		public List<Couleur> compterPoint(Partie partie, int nbr) {
			int bleu = 0;
			int rouge = 0;
			int vert = 0;
			int mos = 0;
			for (int i = 0; i < partie.getTour().getMain().getCartes().size(); i++) {
				if (partie.getTour().getMain().getCartes().get(i).getType() == Couleur.BLEU) {
					bleu+= partie.getTour().getMain().getCartes().get(i).getCout();
				}
				if (partie.getTour().getMain().getCartes().get(i).getType() == Couleur.ROUGE) {
					rouge+= partie.getTour().getMain().getCartes().get(i).getCout();
				}
				if (partie.getTour().getMain().getCartes().get(i).getType() == Couleur.VERT) {
					vert+= partie.getTour().getMain().getCartes().get(i).getCout();
				}
				if (partie.getTour().getMain().getCartes().get(i).getType() == Couleur.MOSAIQUE) {
					mos+= partie.getTour().getMain().getCartes().get(i).getCout();
				}
			}
			List<Couleur> couleurs = new ArrayList<Couleur>();
			if (bleu >= rouge && bleu >= vert) {
				couleurs.add(Couleur.BLEU);
				if (rouge >= vert) {
					couleurs.add(Couleur.ROUGE);
					couleurs.add(Couleur.VERT);
				} else {
					couleurs.add(Couleur.VERT);
					couleurs.add(Couleur.ROUGE);
				}
			} else if (rouge >= bleu && rouge >= vert) {
				couleurs.add(Couleur.ROUGE);
				if (bleu >= vert) {
					couleurs.add(Couleur.BLEU);
					couleurs.add(Couleur.VERT);
				} else {
					couleurs.add(Couleur.VERT);
					couleurs.add(Couleur.BLEU);
				}
			} else if (vert >= bleu && vert >= rouge) {
				couleurs.add(Couleur.VERT);
				if (rouge >= bleu) {
					couleurs.add(Couleur.ROUGE);
					couleurs.add(Couleur.BLEU);
				} else {
					couleurs.add(Couleur.BLEU);
					couleurs.add(Couleur.ROUGE);
				}
			}
			return couleurs;
		}
		
		public Pile combinaison(Partie partie, Couleur col, int nbr) {
			Pile oeuvre = new Pile();
			Pile fin = new Pile();
			int iter = 0;
			int val = 0;
			Joueur j = partie.getTour();
			for (int i = 0; i < j.getMain().getCartes().size();i++) {
				if (j.getMain().getCartes().get(i).getType().equals(col) || j.getMain().getCartes().get(i).getType().equals(Couleur.MOSAIQUE)) {
					oeuvre.addCarte(j.getMain().getCartes().get(i));
				}
			}
			
			int ecart = 100;
			while (iter <= oeuvre.getCartes().size() && val != nbr) {
				List<List<Carte>> result = Outil.getCombinations(oeuvre.getCartes(), iter);
				for (List<Carte> cartes : result) {
					val = partie.getTour().getOeuvre().compterPoint();
					for (int i = 0; i < iter; i++) {
						val += cartes.get(i).getCout();
					}
					if (val == nbr) {
						fin.setCartes(cartes);
						break;
					} else if (ecart > Math.abs(nbr - val) && val >= nbr) {
						ecart = Math.abs(nbr - val);
						fin.setCartes(cartes);
					}
				}
				iter++;
			}
			
			return fin;
			
		}
		
	}
	
}
