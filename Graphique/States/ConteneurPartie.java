package Graphique.States;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import Karmaka.src.Couleur;
import Karmaka.src.Joueur;

public class ConteneurPartie extends JPanel implements ActionListener, MouseListener{
	
	private List<JPanel> cards;
	
	//Variables pour la main
	private JPanel zoomCard; private JLabel name,cout, desc;
	
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
	
	private Fenetre fenetre;
	
	public ConteneurPartie(Fenetre menu) {
		super();
		this.fenetre = menu;
		System.out.println(fenetre);
		propConteneurFenetre();
	}
	
	private void propConteneurFenetre() {
		cards = new ArrayList<JPanel>();
		this.setLayout(null);
		propCards();
		propZoomCard();
		propVieFuture();
		propOeuvre();
		propSource();
		propFosse();
		propVieFutureAdverse();
		propOeuvreAdverse();
	}
	
	private void propSource() {
		source = new JPanel(new FlowLayout());
		source.setBounds(50,325,100,150);
		source.setBackground(Color.LIGHT_GRAY);
		source.setBorder(BorderFactory.createLineBorder(Color.black));
		add(source);
	}
	
	private void propFosse() {
		fosse = new JPanel(new FlowLayout());
		fosse.setBounds(1050,325,100,150);
		fosse.setBackground(Color.LIGHT_GRAY);
		fosse.setBorder(BorderFactory.createLineBorder(Color.black));
		add(fosse);
	}
	
	private void propVieFuture() {
		vieFuture = new JPanel(new FlowLayout());
		vieFuture.setBounds(50,600,100,150);
		vieFuture.setBackground(Color.LIGHT_GRAY);
		vieFuture.setBorder(BorderFactory.createLineBorder(Color.black));
		add(vieFuture);
	}
	
	private void propOeuvre() {
		oeuvre = new JPanel(new FlowLayout());
		oeuvre.setBounds(1050,600,100,150);
		oeuvre.setBackground(Color.LIGHT_GRAY);
		oeuvre.setBorder(BorderFactory.createLineBorder(Color.black));
		add(oeuvre);
	}
	
	private void propVieFutureAdverse() {
		vieFutureAdverse = new JPanel(new FlowLayout());
		vieFutureAdverse.setBounds(50,50,100,150);
		vieFutureAdverse.setBackground(Color.LIGHT_GRAY);
		vieFutureAdverse.setBorder(BorderFactory.createLineBorder(Color.black));
		add(vieFutureAdverse);
	}
	
	private void propOeuvreAdverse() {
		oeuvreAdverse = new JPanel(new FlowLayout());
		oeuvreAdverse.setBounds(1050,50,100,150);
		oeuvreAdverse.setBackground(Color.LIGHT_GRAY);
		oeuvreAdverse.setBorder(BorderFactory.createLineBorder(Color.black));
		add(oeuvreAdverse);
	}
	
	private void propZoomCard() {
		zoomCard = new JPanel(new GridLayout(2,1));
		JPanel top = new JPanel(new FlowLayout());
		top.setOpaque(false);
		zoomCard.setBounds(500,250,200,300);
		name = new JLabel();
		cout = new JLabel();
		cout.setFont(new Font("Serif", Font.BOLD, 20));
		desc = new JLabel();
		top.add(cout);
		top.add(name);
		zoomCard.add(top);
		zoomCard.add(desc);
		add(zoomCard);
		zoomCard.setVisible(false);
	}
	
	private void propCards() {
		Joueur tour = fenetre.getVue().getController().getModel().getTour();
		JPanel cardPanel = new JPanel(new GridLayout());
		cardPanel.setBounds(200,720,800,40);
		cardPanel.setBackground(Color.darkGray);
		for (int i = 0; i < tour.getMain().getCartes().size(); i++) {
			JPanel card = new JPanel(new FlowLayout());
			Couleur couleur = tour.getMain().getCartes().get(i).getType();
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
			JLabel name = new JLabel(tour.getMain().getCartes().get(i).getNom());
			JLabel cout = new JLabel(""+tour.getMain().getCartes().get(i).getCout());
			cout.setFont(new Font("Serif", Font.BOLD, 20));
			//cout.setForeground(Color.white);
			cards.add(card);
			card.addMouseListener(this);
			card.add(cout);
			card.add(name);
			cardPanel.add(card);
		}
		add(cardPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (JPanel card : cards) {
			if (e.getSource().equals(card) ) {
				int index = cards.indexOf(card);
				Joueur tour = fenetre.getVue().getController().getModel().getTour();
				Couleur couleur = tour.getMain().getCartes().get(index).getType();
				switch(couleur) {
					case BLEU :
						zoomCard.setBackground(Color.BLUE);
						break;
					case ROUGE :
						zoomCard.setBackground(Color.RED);
						break;
					case VERT :
						zoomCard.setBackground(Color.GREEN);
						break;
					case MOSAIQUE :
						zoomCard.setBackground(Color.cyan);
						break;
				}
				boolean visible = (name.getText() != tour.getMain().getCartes().get(index).getNom() || !zoomCard.isVisible());
				name.setText(tour.getMain().getCartes().get(index).getNom());
				cout.setText(""+tour.getMain().getCartes().get(index).getCout());
				desc.setText(tour.getMain().getCartes().get(index).getDescription());
				
				zoomCard.setVisible(visible);
			}
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

	
}
