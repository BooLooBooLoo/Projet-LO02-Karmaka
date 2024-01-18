package Graphique.States;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Cartes.Incarnation;
import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Joueur;

public class ConteneurIncarnation extends JPanel implements ActionListener{

	private Fenetre fenetre;
	private JPanel container;
	private Carte cardPlayed;
	
	private JPanel copyPanel; private Carte bait = new Incarnation(); 
	private Carte card;
	
	private JButton skip;
	private List<JButton> buttons = new ArrayList<JButton>();
	
	public ConteneurIncarnation(Fenetre menu, Carte carte) {
		super();
		this.fenetre = menu;
		this.cardPlayed = carte;
		
		this.setLayout(null);
		this.setBounds(200,150,800,400);
		this.setBackground(null);
		
		container = new JPanel();
		container.setLayout(null);
		container.setBackground(null);
		container.setBounds(0,0,800,400);
		
		propIncarnation();
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (bait.getActions() != null) {
					List<String> temp = new ArrayList<String>();
					temp.add(card.getNom());
					for (int i = 0; i < bait.getActions().size();i++) {
						temp.add(bait.getActions().get(i));
					}
					cardPlayed.setActions(temp);
				}
			}
		});
		timer.start();
	}
	
	public void propIncarnation() {
		JLabel etiquette = new JLabel("Incarnation");
		etiquette.setBounds(350,0,100,50);
		etiquette.setFont(new Font("Serif",Font.BOLD,25));
		etiquette.setForeground(Color.black);
		container.add(etiquette);
		Joueur tour = fenetre.getVue().getController().getModel().getTour();
		double size = 800/(tour.getOeuvre().getCartes().size()+1);
		if (tour.getOeuvre().getCartes().size() == 0) {
			System.out.println("IN case vide INCARNATION");
			JLabel texte = new JLabel("Il n'y a pas de carte dans votre oeuvre");
			texte.setBounds(100,100,600,100);
			container.add(texte);
			skip = new JButton("Continuer");
			skip.addActionListener(this);
			skip.setBounds(350,250,100,50);
			container.add(skip);
		} else {
			for (int i = 0; i < tour.getOeuvre().getCartes().size();i++) {
				JPanel card = new JPanel(new GridLayout(2,1));
				card.setBounds((int)((size/(2*tour.getOeuvre().getCartes().size()+1))+i*(size+size/tour.getOeuvre().getCartes().size()+1)),50,(int) (size),250);
				Couleur couleur = tour.getOeuvre().getCartes().get(i).getType();
				switch(couleur) {
					case BLEU :
						card.setBackground(Color.BLUE);
						break;
					case ROUGE :
						card.setBackground(Color.RED);
						break;
					case VERT :
						card.setBackground(Color.GREEN);
						break;
					case MOSAIQUE :
						card.setBackground(Color.cyan);
						break;
				}
				card.setBorder(BorderFactory.createLineBorder(Color.black));
				JLabel name = new JLabel(tour.getOeuvre().getCartes().get(i).getCout()+" "+tour.getOeuvre().getCartes().get(i).getNom());
				name.setFont(new Font("Serif", Font.BOLD, 20));
				card.add(name);
				JLabel desc = new JLabel(tour.getOeuvre().getCartes().get(i).getDescription());
				card.add(desc);
				JButton choix = new JButton("Choisir");
				choix.setBounds((int)((size/(2*tour.getOeuvre().getCartes().size()+1))+i*(size+size/tour.getOeuvre().getCartes().size()+1)),350,(int) (size),50);
				choix.addActionListener(this);
				container.add(card);
				buttons.add(choix);
				container.add(choix);
			}
			
		}
		add(container);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(skip)) {
			cardPlayed.setActions(new ArrayList<String>());
		} else {
			for (JButton button : buttons) {
				if (e.getSource().equals(button)) {
					int index = buttons.indexOf(button);
					card = fenetre.getVue().getController().getModel().getTour().getOeuvre().getCartes().get(index);
					container.setVisible(false);
					instantiateContainer(card.getNom());
				}
			}
		}
		
	}
	
	public void instantiateContainer(String cardName) {
		switch (cardName) {
			case "Bassesse":
				copyPanel = new ConteneurBassesse(fenetre, bait);
				break;
			case "Coup d'oeil":
				copyPanel = new ConteneurCoupDoeil(fenetre, bait);
				break;
			case "Crise":
				copyPanel = new ConteneurCrise(fenetre, bait);
				break;
			case "Deni":
				copyPanel = new ConteneurDeni(fenetre, bait);
				break;
			case "Dernier Souffle":
				copyPanel = new ConteneurDernierSouffle(fenetre, bait);
				break;
			case "Destinee":
				copyPanel = new ConteneurDestinee(fenetre, bait);
				break;
			case "Duperie":
				copyPanel = new ConteneurDuperie(fenetre, bait);
				break;
			case "Fournaise":
				copyPanel = new ConteneurFournaise(fenetre, bait);
				break;
			case "Incarnation":
				copyPanel = new ConteneurIncarnation(fenetre, bait);
				break;
			case "Jubilé":
				copyPanel = new ConteneurJubile(fenetre, bait);
				break;
			case "Lendemain":
				copyPanel = new ConteneurLendemain(fenetre, bait);
				break;
			case "Longevite":
				copyPanel = new ConteneurLongevite(fenetre, bait);
				break;
			case "Mimétisme":
				copyPanel = new ConteneurMimetisme(fenetre, bait);
				break;
			case "Panique":
				copyPanel = new ConteneurPanique(fenetre, bait);
				break;
			case "Recyclage":
				copyPanel = new ConteneurRecyclage(fenetre, bait);
				break;
			case "Rêves Brisés":
				copyPanel = new ConteneurRevesBrises(fenetre, bait);
				break;
			case "Roulette":
				copyPanel = new ConteneurRoulette(fenetre, bait);
				break;
			case "Sauvetage":
				copyPanel = new ConteneurSauvetage(fenetre, bait);
				break;
			case "Semis":
				copyPanel = new ConteneurSemis(fenetre, bait);
				break;
			case "Transmigration":
				copyPanel = new ConteneurTransmigration(fenetre, bait);
				break;
			case "Vengeance":
				copyPanel = new ConteneurVengeance(fenetre, bait);
				break;
			case "Vol":
				copyPanel = new ConteneurVol(fenetre, bait);
				break;
			case "Voyage":
				copyPanel = new ConteneurVoyage(fenetre, bait);
				break;
			default :
				System.out.println("problem here");
				
		}
		copyPanel.setBounds(0,0,800,400);
		add(copyPanel);
		copyPanel.setVisible(true);
		
		this.repaint();
		this.revalidate();
		System.out.println("Done");
	}

}
