package Karmaka.src;

public interface Strategy {
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
	class IA implements Strategy{

		@Override
		public String jouer(Partie partie) {
			// TODO Auto-generated method stub
			return "";
		}
		
	}
	
}