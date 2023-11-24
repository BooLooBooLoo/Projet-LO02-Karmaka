package Karmaka.src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface Strategy{
	public String jouer(Partie partie);
	
	class Neutre implements Strategy{
		
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
		    	bool = "Pouvoir";
		    } else if (action.equals("Oeuvre")) {
		    	Carte temp = partie.getTour().choisirCarte();
		    	partie.getTour().setDerniereCarteJoue(temp);
		    	partie.getTour().oeuvre.addCarte(temp);
		    	bool = "done";
		    } else if (action.equals("VieFuture")) {
		    	Carte temp = partie.getTour().choisirCarte();
		    	partie.getTour().setDerniereCarteJoue(temp);
		    	partie.getTour().vieFuture.addCarte(temp);
		    	bool = "done";
			
		    }
		    return bool;
		}
	}	
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
		    	bool = "Pouvoir";
		    } else if (action.equals("Oeuvre")) {
		    	Carte temp = partie.getTour().choisirCarte();
		    	partie.getTour().setDerniereCarteJoue(temp);
		    	partie.getTour().oeuvre.addCarte(temp);
		    	bool = "done";
		    } else if (action.equals("VieFuture")) {
		    	Carte temp = partie.getTour().choisirCarte();
		    	partie.getTour().setDerniereCarteJoue(temp);
		    	partie.getTour().vieFuture.addCarte(temp);
		    	bool = "done";
			
		    }
		    return bool;
		}
	}
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
		    	bool = "Pouvoir";
		    } else if (action.equals("Oeuvre")) {
		    	Carte temp = partie.getTour().choisirCarte();
		    	partie.getTour().setDerniereCarteJoue(temp);
		    	partie.getTour().oeuvre.addCarte(temp);
		    	bool = "done";
		    } else if (action.equals("VieFuture")) {
		    	Carte temp = partie.getTour().choisirCarte();
		    	partie.getTour().setDerniereCarteJoue(temp);
		    	partie.getTour().vieFuture.addCarte(temp);
		    	bool = "done";
			
		    }
		    return bool;
		}
	}
	class IA implements Strategy,Serializable {
		
		public Pile oeuvre = new Pile();
		public Pile main = new Pile();
		private Echelle ancienneEchelle;
		private List<Couleur> colOeuvre = null;
		private int nbr = 0;
		
		public String jouer(Partie partie) {
			System.out.println("Le bot joue");
			
			String bool = "";
			if (ancienneEchelle != partie.getTour().getEchelleKarmique()) {
				System.out.println("IN");
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
				System.out.println("Oeuvre : "+carte.getNom());
				bool = "done";
			} else if (partie.getTour().getMain().getCartes().get(0).getType().equals(colOeuvre.get(1)) 
					|| partie.getTour().getMain().getCartes().get(0).getType().equals(Couleur.MOSAIQUE)){
				Carte carte = partie.getTour().getMain().getCartes().get(0);
				partie.getTour().getVieFuture().addCarte(carte);
				partie.getTour().setDerniereCarteJoue(carte);
				partie.getTour().getMain().removeCarte(carte);
				bool = "done";
				System.out.println("Vie Future : "+carte.getNom());
			} else {
				Carte carte1 = partie.getTour().getMain().getCartes().get(0);
				carte1.effet(partie);
				partie.getTour().setDerniereCarteJoue(carte1);
				partie.getTour().getMain().removeCarte(carte1);
				bool = "Pouvoir";
				System.out.println("Pouvoir : "+carte1.getNom());
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
			System.out.println("bleu : "+bleu);
			System.out.println("rouge : "+rouge);
			System.out.println("vert : "+vert);
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
			System.out.println("Combinaison en cours");
			System.out.println(col);
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
			System.out.println(oeuvre.toString());
			
			int ecart = 100;
			while (iter <= oeuvre.getCartes().size() && val != nbr) {
				List<List<Carte>> result = Outil.getCombinations(oeuvre.getCartes(), iter);
				for (List<Carte> cartes : result) {
					val = partie.getTour().getOeuvre().compterPoint();
					System.out.println(cartes);
					for (int i = 0; i < iter; i++) {
						val += cartes.get(i).getCout();
					}
					System.out.println("val : "+val);
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
			
			System.out.println("fin : "+fin.toString());
			return fin;
			
		}
		
	}
	
}
