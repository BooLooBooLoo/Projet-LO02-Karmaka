package Graphique.States;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Joueur;

public class ConteneurCoupDoeil extends JPanel implements ActionListener{

	private Fenetre fenetre;
	private Carte cardPlayed;
	
	public ConteneurCoupDoeil(Fenetre menu, Carte carte) {
		super();
		this.fenetre = menu;
		this.cardPlayed = carte;
		propCoupDoeil();
		this.setBounds(200,150,800,400);
		this.setBackground(null);
		this.setLayout(new GridLayout(3,1));
	}
	
	public void propCoupDoeil() {
		JLabel etiquette = new JLabel("Coup D'oeil",SwingConstants.CENTER);
		etiquette.setFont(new Font("Serif",Font.BOLD,30));
		add(etiquette);
		JPanel cards = new JPanel(new FlowLayout());
		cards.setSize(800,350);
		cards.setBackground(null);
		Joueur tour = fenetre.getVue().getController().getModel().getTour();
		for (int i = 0; i < tour.getMain().getCartes().size(); i++) {
			JPanel card = new JPanel(new GridLayout(2,1));
			card.setSize(200,300);
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
			JLabel name = new JLabel(tour.getMain().getCartes().get(i).getCout()+" "+tour.getMain().getCartes().get(i).getNom());
			name.setFont(new Font("Serif", Font.BOLD, 20));
			card.add(name);
			JLabel desc = new JLabel(tour.getMain().getCartes().get(i).getDescription());
			card.add(desc);
			cards.add(card);
		}
		add(cards);
		JButton button = new JButton("Continuer");
		button.setBorder(new EmptyBorder(50,50,50,50));
		button.addActionListener(this);
		add(button);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		cardPlayed.setActions(new ArrayList<String>());
		fenetre.publish(new ConteneurRejouer(fenetre));
	}

}
