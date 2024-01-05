package Graphique.States;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Cartes.Incarnation;
import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Joueur;
import Karmaka.src.Oeuvre;

public class ConteneurMimetisme extends JPanel implements ActionListener{

	private Fenetre fenetre;
	private JPanel container;
	private Carte cardPlayed;
	
	private JPanel copyPanel; 
	private Carte bait = new Incarnation(); 
	private Carte card;
	
	private JButton skip;
	private JButton button;
	
	public ConteneurMimetisme(Fenetre menu, Carte carte) {
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
		
		propMimetisme();
		Timer timer = new Timer(1000, new ActionListener() {
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
	
	public void propMimetisme() {
		JLabel etiquette = new JLabel("Mimétisme");
		etiquette.setBounds(325,0,150,50);
		etiquette.setFont(new Font("Serif",Font.BOLD,30));
		etiquette.setForeground(Color.black);
		container.add(etiquette);
		Joueur adversaire = fenetre.getVue().getController().getModel().getAdversaire();
		if (adversaire.getOeuvre().getCartes().size() == 0) {
			JLabel texte = new JLabel("Il n'y a pas de carte dans l'oeuvre adverse");
			container.add(texte);
			texte.setBounds(100,100,600,100);
			texte.setFont(new Font("Serif",Font.BOLD,20));
			texte.setForeground(Color.black);
			skip = new JButton("Continuer");
			container.add(skip);
			skip.setBounds(350,300,100,100);
			skip.addActionListener(this);
		} else {
			JLabel texte = new JLabel("Vous copiez le pouvoir de l'oeuvre adverse exposée");
			texte.setBounds(100,100,600,100);
			texte.setFont(new Font("Serif",Font.BOLD,20));
			texte.setForeground(Color.white);
			container.add(texte);
			button = new JButton("Contiuer");
			button.setBounds(350,300,100,100);
			button.addActionListener(this);
			container.add(button);
		}
		add(container);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(skip)) {
			cardPlayed.setActions(new ArrayList<String>());
		} else  if (e.getSource().equals(button)){
			Oeuvre oeuvre = fenetre.getVue().getController().getModel().getAdversaire().getOeuvre();
			card = oeuvre.getCartes().get(oeuvre.getCartes().size()-1);
			container.setVisible(false);
			instantiateContainer(card.getNom());
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
			case "Déni":
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
			case "Jubile":
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
	}

}
