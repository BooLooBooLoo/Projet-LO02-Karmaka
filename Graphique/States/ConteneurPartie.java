package Graphique.States;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.util.*;


import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import Graphique.ImagePanel;
import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Joueur;
import Karmaka.src.Partie;

public class ConteneurPartie extends JPanel implements ActionListener, MouseListener{
	
	private List<JPanel> cards;
	
	//Variables pour la main
	private ImagePanel zoomCard; private JLabel name,cout, desc; private JPanel choix; private List<JButton> buttons; private Carte cardPlayed;
	
	//Variables pour la source
	private JPanel source;
	
	//Variables pour la fosse
	private JPanel fosse;
	
	//Variables pour les vies futures
	private JPanel vieFuture;
	private JPanel vieFutureAdverse;
	
	//Variables pour les oeuvres
	private JPanel oeuvre;
	private JPanel oeuvreAdverse;
	
	//Variables pour la pioche du joueur
	private JPanel pioche;
	
	//Variable pour le conteneur des pouvoirs
	private JPanel power;
	
	private Fenetre fenetre;
	
	private JPanel transition;
	private JButton sauvegarder;
	
	public ConteneurPartie(Fenetre menu) {
		super();
		this.fenetre = menu;
		propConteneurFenetre();
	}
	
	
	private void propConteneurFenetre() {
		cards = new ArrayList<JPanel>();
		buttons = new ArrayList<JButton>();
		this.setLayout(null);
		if (fenetre.getVue().getController().getModel().getNbrTour() != 0 || this.fenetre.getImportPartie() != null) {
			transition();
			propTour();
			propSauvegarder();
			propCards();
			propZoomCard();
			propVieFuture();
			propOeuvre();
			propSource();
			propFosse();
			propVieFutureAdverse();
			propOeuvreAdverse();
			propPioche();
			propEchelle();
			Timer timer = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					transition.setVisible(false);
				}
			});
			timer.start();
		}
		
	}
	
	
	private void propTour() {
		JLabel texte = new JLabel("Tour "+fenetre.getVue().getController().getModel().getNbrTour()+" : "+fenetre.getVue().getController().getModel().getTour().getNom(), SwingConstants.CENTER);
		texte.setForeground(Color.white);
		texte.setBounds(1,1,100,50);
		add(texte);
	}
	
	private void propSauvegarder() {
		sauvegarder = new JButton("Sauvegarder");
		sauvegarder.setForeground(Color.white);
		sauvegarder.setBounds(1,2,100,50);
		sauvegarder.addMouseListener(this);
		add(sauvegarder);
	}
	
	private void transition() {
		transition = new JPanel(new GridLayout(2,1));
		JLabel texte = new JLabel("Tour "+fenetre.getVue().getController().getModel().getNbrTour()+" : "+fenetre.getVue().getController().getModel().getTour().getNom(), SwingConstants.CENTER);
		texte.setFont(new Font("Serif", Font.BOLD, 48));
		texte.setForeground(Color.white);
		JLabel texte2 = new JLabel("Cliquez sur l'écran", SwingConstants.CENTER);
		texte2.setFont(new Font("Serif", Font.BOLD, 32));
		texte2.setForeground(Color.white);
		transition.add(texte);
		transition.add(texte2);
		transition.setBounds(0,0,1200,800);
		transition.setBackground(Color.DARK_GRAY);
		add(transition);
		transition.addMouseListener(this);
	}
	
	private void propSource() {
		source = new JPanel(new GridLayout(2,1));
		source.setBounds(50,325,100,150);
		source.setBackground(Color.LIGHT_GRAY);
		source.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		JLabel nom = new JLabel("Source", SwingConstants.CENTER);
		JLabel nbrCartePioche = new JLabel(""+fenetre.getVue().getController().getModel().getSource().getCartes().size(), SwingConstants.CENTER);
		nbrCartePioche.setFont(new Font("Serif", Font.BOLD, 30));
		nom.setFont(new Font("Serif", Font.BOLD, 30));
		source.add(nom);
		source.add(nbrCartePioche);
		
		add(source);
	}
	
	private void propPioche() {
		pioche = new JPanel(new GridLayout());
		pioche.setBounds(200,600,150,70);
		pioche.setBackground(Color.LIGHT_GRAY);
		pioche.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		JLabel nbrCartePioche = new JLabel("Pioche : "+fenetre.getVue().getController().getModel().getTour().getPile().getCartes().size());
		nbrCartePioche.setFont(new Font("Serif", Font.BOLD, 30));
		pioche.add(nbrCartePioche);
		add(pioche);
	}
	
	private void propFosse() {
		fosse = new JPanel(new GridLayout(2,1));
		fosse.setBounds(1050,325,100,150);
		fosse.setBackground(Color.LIGHT_GRAY);
		fosse.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		JLabel nom = new JLabel("Fosse", SwingConstants.CENTER);
		JLabel nbrCartePioche = new JLabel(""+fenetre.getVue().getController().getModel().getDefausse().getCartes().size(), SwingConstants.CENTER);
		nbrCartePioche.setFont(new Font("Serif", Font.BOLD, 30));
		nom.setFont(new Font("Serif", Font.BOLD, 30));
		fosse.add(nom);
		fosse.add(nbrCartePioche);
		add(fosse);
	}
	
	private void propVieFuture() {
		vieFuture = new JPanel(new FlowLayout());
		vieFuture.setBounds(50,600,100,150);
		vieFuture.setBackground(Color.LIGHT_GRAY);
		vieFuture.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		if (fenetre.getVue().getController().getModel().getTour().getVieFuture().getCartes().size() != 0) {
			JPanel zoomCard = new JPanel(new GridLayout(2,1));
			JPanel top = new JPanel(new FlowLayout());
			int size = fenetre.getVue().getController().getModel().getTour().getVieFuture().getCartes().size();
			top.setOpaque(false);
			zoomCard.setBounds(0,0,100,150);
			JLabel name = new JLabel(fenetre.getVue().getController().getModel().getTour().getVieFuture().getCartes().get(size-1).getNom());
			JLabel cout = new JLabel(""+fenetre.getVue().getController().getModel().getTour().getVieFuture().getCartes().get(size-1).getCout());
			cout.setFont(new Font("Serif", Font.BOLD, 20));
			JLabel desc = new JLabel();
			top.add(cout);
			top.add(name);
			zoomCard.add(top);
			zoomCard.add(desc);
			vieFuture.add(zoomCard);
		}
		add(vieFuture);
	}
	
	private void propOeuvre() {
		oeuvre = new JPanel(new FlowLayout());
		oeuvre.setBounds(1050,600,100,150);
		oeuvre.setBackground(Color.LIGHT_GRAY);
		oeuvre.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		if (fenetre.getVue().getController().getModel().getTour().getOeuvre().getCartes().size() != 0) {
			JPanel zoomCard = new JPanel(new GridLayout(2,1));
			JPanel top = new JPanel(new FlowLayout());
			int size = fenetre.getVue().getController().getModel().getTour().getOeuvre().getCartes().size();
			top.setOpaque(false);
			zoomCard.setBounds(0,0,100,150);
			JLabel name = new JLabel(fenetre.getVue().getController().getModel().getTour().getOeuvre().getCartes().get(size-1).getNom());
			JLabel cout = new JLabel(""+fenetre.getVue().getController().getModel().getTour().getOeuvre().getCartes().get(size-1).getCout());
			cout.setFont(new Font("Serif", Font.BOLD, 20));
			JLabel desc = new JLabel();
			top.add(cout);
			top.add(name);
			zoomCard.add(top);
			zoomCard.add(desc);
			oeuvre.add(zoomCard);
		}
		
		
		add(oeuvre);
	}
	
	private void propVieFutureAdverse() {
		vieFutureAdverse = new JPanel(new FlowLayout());
		vieFutureAdverse.setBounds(50,50,100,150);
		vieFutureAdverse.setBackground(Color.LIGHT_GRAY);
		vieFutureAdverse.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		if (fenetre.getVue().getController().getModel().getAdversaire().getVieFuture().getCartes().size() != 0) {
			JPanel zoomCard = new JPanel(new GridLayout(2,1));
			JPanel top = new JPanel(new FlowLayout());
			int size = fenetre.getVue().getController().getModel().getAdversaire().getVieFuture().getCartes().size();
			top.setOpaque(false);
			zoomCard.setBounds(0,0,100,150);
			JLabel name = new JLabel(fenetre.getVue().getController().getModel().getAdversaire().getVieFuture().getCartes().get(size-1).getNom());
			JLabel cout = new JLabel(""+fenetre.getVue().getController().getModel().getAdversaire().getVieFuture().getCartes().get(size-1).getCout());
			cout.setFont(new Font("Serif", Font.BOLD, 20));
			JLabel desc = new JLabel();
			top.add(cout);
			top.add(name);
			zoomCard.add(top);
			zoomCard.add(desc);
			vieFutureAdverse.add(zoomCard);
		}
		add(vieFutureAdverse);
	}
	
	private void propOeuvreAdverse() {
		oeuvreAdverse = new JPanel(new FlowLayout());
		oeuvreAdverse.setBounds(1050,50,100,150);
		oeuvreAdverse.setBackground(Color.LIGHT_GRAY);
		oeuvreAdverse.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		if (fenetre.getVue().getController().getModel().getAdversaire().getOeuvre().getCartes().size() != 0) {
			JPanel zoomCard = new JPanel(new GridLayout(2,1));
			JPanel top = new JPanel(new FlowLayout());
			int size = fenetre.getVue().getController().getModel().getAdversaire().getOeuvre().getCartes().size();
			top.setOpaque(false);
			zoomCard.setBounds(0,0,100,150);
			JLabel name = new JLabel(fenetre.getVue().getController().getModel().getAdversaire().getOeuvre().getCartes().get(size-1).getNom());
			JLabel cout = new JLabel(""+fenetre.getVue().getController().getModel().getAdversaire().getOeuvre().getCartes().get(size-1).getCout());
			cout.setFont(new Font("Serif", Font.BOLD, 20));
			JLabel desc = new JLabel();
			top.add(cout);
			top.add(name);
			zoomCard.add(top);
			zoomCard.add(desc);
			oeuvreAdverse.add(zoomCard);
		}
		add(oeuvreAdverse);
	}
	
	private void propZoomCard() {
		GridLayout layout = new GridLayout(4,1);
		layout.setHgap(30);
		layout.setVgap(30);
		choix = new JPanel(layout);
		choix.setOpaque(false);
		zoomCard = new ImagePanel(null);
		JPanel top = new JPanel(new FlowLayout());
		top.setOpaque(false);
		zoomCard.setBounds(400,250,200,280);
		choix.setBounds(610,250,200,300);
		JButton passer = new JButton("Passer");
		JButton pouvoir = new JButton("Pouvoir");
		JButton oeuvre = new JButton("Oeuvre");
		JButton vieFuture = new JButton("Vie Future");
		buttons.add(vieFuture);
		buttons.add(oeuvre);
		buttons.add(passer);
		buttons.add(pouvoir);
		choix.setBorder(new EmptyBorder(10, 10, 10, 10));
		choix.setBackground(null);
		name = new JLabel();
		cout = new JLabel();
		cout.setFont(new Font("Serif", Font.BOLD, 20));
		desc = new JLabel();
		top.add(cout);
		top.add(name);
		
		pouvoir.addActionListener(this);
		vieFuture.addActionListener(this);
		oeuvre.addActionListener(this);
		passer.addActionListener(this);
		choix.add(pouvoir);
		choix.add(vieFuture);
		choix.add(oeuvre);
		choix.add(passer);
		add(zoomCard);
		add(choix);
		zoomCard.setVisible(false);
		choix.setVisible(false);
	}
	
	private void propCards() {
		Joueur tour = fenetre.getVue().getController().getModel().getTour();
		JPanel cardPanel = new JPanel(new GridLayout());
		cardPanel.setBounds(200,720,800,60);
		cardPanel.setBackground(Color.darkGray);
		for (int i = 0; i < tour.getMain().getCartes().size(); i++) {
			JPanel card;
			Couleur couleur = tour.getMain().getCartes().get(i).getType();
			switch(couleur) {
				case BLEU :
					card = new JPanel(new FlowLayout()) {
						public void paintComponent(Graphics g) {
					        Image backgroundImage = new ImageIcon("./assets/bleuBackground.png").getImage();
					        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
						}
					};;
					break;
				case ROUGE :
					card = new JPanel(new FlowLayout()) {
						public void paintComponent(Graphics g) {
					        Image backgroundImage = new ImageIcon("./assets/rougeBackground.png").getImage();
					        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
						}
					};
					break;
				case VERT :
					card = new JPanel(new FlowLayout()) {
						public void paintComponent(Graphics g) {
					        Image backgroundImage = new ImageIcon("./assets/vertBackground.png").getImage();
					        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
						}
					};
					break;
				case MOSAIQUE :
					card = new JPanel(new FlowLayout()) {
						public void paintComponent(Graphics g) {
					        Image backgroundImage = new ImageIcon("./assets/mosaiqueBackground.png").getImage();
					        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
						}
					};
					break;
				default :
					card = new JPanel(new FlowLayout()) {
						public void paintComponent(Graphics g) {
					        Image backgroundImage = new ImageIcon("./assets/vertBackground.png").getImage();
					        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
						}
					};
			}
			JLabel name = new JLabel(tour.getMain().getCartes().get(i).getNom());
			name.setFont(new Font("Vinque Rg", Font.PLAIN, 14));
			JLabel cout = new JLabel(""+tour.getMain().getCartes().get(i).getCout());
			cout.setFont(new Font("Serif", Font.BOLD, 20));
			//cout.setForeground(Color.white);
			Border raisedbevel = BorderFactory.createRaisedBevelBorder();
			Border loweredbevel = BorderFactory.createLoweredBevelBorder();
			Border cardBoarder = BorderFactory.createCompoundBorder(raisedbevel, loweredbevel);
			card.setBorder(cardBoarder);
			cards.add(card);
			card.addMouseListener(this);
			card.add(cout);
			card.add(name);
			cardPanel.add(card);
		}
		add(cardPanel);
	}
	
	private void propEchelle() {
		JPanel echelle = new JPanel();
		echelle.setLayout(null);
		echelle.setBounds(200,0,800,100);
		echelle.setBackground(Color.LIGHT_GRAY);
		List<Joueur> joueurs = fenetre.getVue().getController().getModel().getJoueurs();
		
		for (int i = 0; i < joueurs.size();i++) {
			JLabel temp = new JLabel();
			temp.setFont(new Font("Serif", Font.BOLD, 20));
			switch(joueurs.get(i).getEchelleKarmique()){
				case BOUSIER:
					temp.setText("BOUSIER");
					temp.setBounds(10, 40*i,100,100);
					break;
				case SERPENT:
					temp.setText("SERPENT");
					temp.setBounds(220, 40*i,100,100);
					break;
				case LOUP:
					temp.setText("LOUP");
					temp.setBounds(430, 40*i,100,100);
					break;
				case SINGE:
					temp.setText("SINGE");
					temp.setBounds(640, 40*i,100,100);
					break;
			}
			echelle.add(temp);
		}
		add(echelle);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(fenetre.getImportPartie() != null) {
			fenetre.setImportPartie(null);
		}
		if (e.getSource() instanceof JButton) {
			for(JButton button : buttons) {
				if (e.getSource().equals(button)) {
					System.out.println("in button");
					 switch (button.getText()) {
						 case "Pouvoir":
							 System.out.println("in pouvoir");
							 zoomCard.setVisible(false);
							 choix.setVisible(false);
							 instantiateContainer(cardPlayed.getNom());
							 fenetre.getContentPane().repaint();
							 fenetre.getVue().getDiffuseur().firePropertyChange("Pouvoir", "", cardPlayed);
							 break;
						 case "Oeuvre":
							 fenetre.getVue().getDiffuseur().firePropertyChange("Oeuvre", "", cardPlayed);
							 break;
						 case "Vie Future":
							 fenetre.getVue().getDiffuseur().firePropertyChange("VieFuture", "", cardPlayed);
							 break;
						 case "Passer":
							 fenetre.getVue().getDiffuseur().firePropertyChange("Passer", "", null);
							 break;
					 }
				}
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (JPanel card : cards) {
			if (e.getSource().equals(card) ) {
				int index = cards.indexOf(card);
				Joueur tour = fenetre.getVue().getController().getModel().getTour();
				cardPlayed = tour.getMain().getCartes().get(index);
				Couleur couleur = tour.getMain().getCartes().get(index).getType();
				switch(couleur) {
					case BLEU :
						zoomCard.setBackground(new Color(0,0,255));
						break;
					case ROUGE :
						zoomCard.setBackground(new Color(255,0,0));
						break;
					case VERT :
						zoomCard.setBackground(new Color(0,255,0));
						break;
					case MOSAIQUE :
						zoomCard.setBackground(new Color(72,209,204));
						break;
				}
				boolean visible = !zoomCard.isVisible();
				zoomCard.setImg(new ImageIcon("./assets/" + tour.getMain().getCartes().get(index).getNom() + ".png").getImage());
				zoomCard.repaint();
				zoomCard.setVisible(visible);
				choix.setVisible(visible);
			}
		}
		if (e.getSource().equals(sauvegarder)) {
			fenetre.getVue().getController().getModel().sauvegarder();
		}
	}
	
	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void instantiateContainer(String cardName) {
		switch (cardName) {
			case "Bassesse":
				power = new ConteneurBassesse(fenetre, cardPlayed);
				break;
			case "Coup d'oeil":
				power = new ConteneurCoupDoeil(fenetre, cardPlayed);
				break;
			case "Crise":
				power = new ConteneurCrise(fenetre, cardPlayed);
				break;
			case "Déni":
				power = new ConteneurDeni(fenetre, cardPlayed);
				break;
			case "Dernier Souffle":
				power = new ConteneurDernierSouffle(fenetre, cardPlayed);
				break;
			case "Destinee":
				power = new ConteneurDestinee(fenetre, cardPlayed);
				break;
			case "Duperie":
				power = new ConteneurDuperie(fenetre, cardPlayed);
				break;
			case "Fournaise":
				power = new ConteneurFournaise(fenetre, cardPlayed);
				break;
			case "Incarnation":
				power = new ConteneurIncarnation(fenetre, cardPlayed);
				break;
			case "Jubilé":
				power = new ConteneurJubile(fenetre, cardPlayed);
				break;
			case "Lendemain":
				power = new ConteneurLendemain(fenetre, cardPlayed);
				break;
			case "Longevite":
				power = new ConteneurLongevite(fenetre, cardPlayed);
				break;
			case "Mimétisme":
				power = new ConteneurMimetisme(fenetre, cardPlayed);
				break;
			case "Panique":
				power = new ConteneurPanique(fenetre, cardPlayed);
				break;
			case "Recyclage":
				power = new ConteneurRecyclage(fenetre, cardPlayed);
				break;
			case "Rêves Brisés":
				power = new ConteneurRevesBrises(fenetre, cardPlayed);
				break;
			case "Roulette":
				power = new ConteneurRoulette(fenetre, cardPlayed);
				break;
			case "Sauvetage":
				power = new ConteneurSauvetage(fenetre, cardPlayed);
				break;
			case "Semis":
				power = new ConteneurSemis(fenetre, cardPlayed);
				break;
			case "Transmigration":
				power = new ConteneurTransmigration(fenetre, cardPlayed);
				break;
			case "Vengeance":
				power = new ConteneurVengeance(fenetre, cardPlayed);
				break;
			case "Vol":
				power = new ConteneurVol(fenetre, cardPlayed);
				break;
			case "Voyage":
				power = new ConteneurVoyage(fenetre, cardPlayed);
				break;
			default :
				System.out.println("problem here");
				
		}
		add(power);
		power.setVisible(true);
	}

	public void paintComponent(Graphics g) {
        Image backgroundImage = new ImageIcon("./assets/Karmaka_Background.jpg").getImage();
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
       }
}
