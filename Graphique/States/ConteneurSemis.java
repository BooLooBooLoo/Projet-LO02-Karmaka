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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Joueur;
import Karmaka.src.Partie;
import Karmaka.src.Pile;

public class ConteneurSemis extends JPanel implements ActionListener{

	private Fenetre fenetre;
	private Carte cardPlayed;
	private List<JCheckBox> checkbox = new ArrayList<JCheckBox>();
	
	public ConteneurSemis(Fenetre menu, Carte carte) {
		super();
		this.fenetre = menu;
		this.cardPlayed = carte;
		propSemis();
		this.setBounds(200,150,800,400);
		this.setLayout(null);
		this.setBackground(null);
	}
	
	public void propSemis() {
		// Jouer la premère partie de l'effet de la carte
		Partie partie = fenetre.getVue().getController().getModel();
		Joueur joueur = partie.getTour();
		Pile main = joueur.getMain();
		for(int i=0; i<2; i++) {
			int randomNumber = (int) (Math.random()*partie.getSource().getCartes().size()-1);
			partie.deplacerCarte(partie.getSource(), main, partie.getSource().getCartes().get(randomNumber));
		}
		joueur.getMain().removeCarte(cardPlayed);
		// Affichage choix
		JLabel etiquette = new JLabel("Semis\n", SwingConstants.CENTER);
		etiquette.setFont(new Font("Serif",Font.BOLD,30));
		etiquette.setForeground(Color.white);
		add(etiquette);
		JLabel etiquette2 = new JLabel("Vous piochez 2 cartes de la source.\nVous placez 2 cartes de votre main dans la vie Future :\n", SwingConstants.LEFT);
		etiquette2.setFont(new Font("Serif",Font.BOLD,30));
		etiquette2.setForeground(Color.white);
		add(etiquette2);
		double size = 800/4;
		for (int i = 0; i < main.getCartes().size() ;i++) {
			JPanel card = new JPanel(new GridLayout(2,1));
			card.setBounds((int)((size/8)+i*(size+size/4)),50,(int) (size),250);
			Couleur couleur = main.getCartes().get(i).getType();
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
			JLabel name = new JLabel(main.getCartes().get(i).getCout()+" "+main.getCartes().get(i).getNom());
			name.setFont(new Font("Serif", Font.BOLD, 20));
			card.add(name);
			JLabel desc = new JLabel(main.getCartes().get(i).getDescription());
			card.add(desc);
			JCheckBox check = new JCheckBox(main.getCartes().get(i).getNom());
			check.setBounds((int)((size/8)+i*(size+size/4)),325,(int) (size),25);
			add(card);
			checkbox.add(check);
			add(check);
		}
		JButton button = new JButton("Fin choix");
		button.setBounds(350,375,100,25);
		button.addActionListener(this);
		add(button);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Pile main = fenetre.getVue().getController().getModel().getTour().getMain();
			int counter = 0;
			List<String> actions = new ArrayList<String>();
			for (JCheckBox check : checkbox) {
				if (check.isSelected()) {
					counter++;
					actions.add(main.getCartes().get(checkbox.indexOf(check)).getNom());
				}
			}
			if (counter < 3) {
				actions.add(String.valueOf(counter));
				cardPlayed.setActions(actions);
			}
		}
}
