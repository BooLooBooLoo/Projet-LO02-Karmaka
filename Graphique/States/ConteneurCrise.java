package Graphique.States;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Joueur;

public class ConteneurCrise extends JPanel implements ActionListener{

	private Fenetre fenetre;
	private Carte cardPlayed;
	private JButton skip;
	private List<JButton> buttons;
	
	public ConteneurCrise(Fenetre menu, Carte carte) {
		super();
		this.fenetre = menu;
		this.cardPlayed = carte;
		buttons = new ArrayList<JButton>();
		this.setLayout(null);
		this.setBounds(200,150,800,400);
		this.setBackground(null);
		propCrise();
	}
	
	public void propCrise() {
		JLabel etiquette = new JLabel("Crise");
		etiquette.setBounds(350,0,100,50);
		etiquette.setFont(new Font("Serif",Font.BOLD,30));
		etiquette.setForeground(Color.white);
		add(etiquette);
		Joueur adversaire = fenetre.getVue().getController().getModel().getAdversaire();
		double size = 800/(adversaire.getOeuvre().getCartes().size()+1);
		if (adversaire.getOeuvre().getCartes().size() == 0) {
			JLabel texte = new JLabel("Il n'y a pas de carte dans l'oeuvre adverse");
			add(texte);
			skip = new JButton("Continuer");
		}
		for (int i = 0; i < adversaire.getOeuvre().getCartes().size();i++) {
			JPanel card = new JPanel(new GridLayout(2,1));
			card.setBounds((int)((size/(2*adversaire.getOeuvre().getCartes().size()+1))+i*(size+size/adversaire.getOeuvre().getCartes().size()+1)),50,(int) (size),250);
			Couleur couleur = adversaire.getOeuvre().getCartes().get(i).getType();
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
			JLabel name = new JLabel(adversaire.getOeuvre().getCartes().get(i).getCout()+" "+adversaire.getOeuvre().getCartes().get(i).getNom());
			name.setFont(new Font("Serif", Font.BOLD, 20));
			card.add(name);
			JLabel desc = new JLabel(adversaire.getOeuvre().getCartes().get(i).getDescription());
			card.add(desc);
			JButton choix = new JButton("Choisir");
			choix.setBounds((int)((size/(2*adversaire.getOeuvre().getCartes().size()+1))+i*(size+size/adversaire.getOeuvre().getCartes().size()+1)),350,(int) (size),50);
			choix.addActionListener(this);
			add(card);
			buttons.add(choix);
			add(choix);
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(skip)) {
			cardPlayed.setActions(new ArrayList<String>());
		} else {
			for (JButton button : buttons) {
				if (e.getSource().equals(button)) {
					int index = buttons.indexOf(button);
					cardPlayed.setActions(new ArrayList<String>());
					cardPlayed.getActions().add(fenetre.getVue().getController().getModel().getAdversaire().getOeuvre().getCartes().get(index).getNom());
				}
			}
		}
		
	}

}
