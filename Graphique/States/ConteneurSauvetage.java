package Graphique.States;

import java.awt.Color;
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
import Karmaka.src.Pile;

public class ConteneurSauvetage extends JPanel implements ActionListener{

	private Fenetre fenetre;
	private Carte cardPlayed;
	private JButton skip;
	private List<JButton> buttons = new ArrayList<JButton>();
	
	
	public ConteneurSauvetage(Fenetre menu, Carte carte) {
		super();
		this.fenetre = menu;
		this.cardPlayed = carte;
		propSauvetage();
		this.setBounds(200,150,800,400);
	}
	
	public void propSauvetage() {
		JLabel etiquette = new JLabel("Sauvetage\n", SwingConstants.CENTER);
		etiquette.setFont(new Font("Serif",Font.BOLD,30));
		etiquette.setForeground(Color.white);
		add(etiquette);
		JLabel etiquette2 = new JLabel("Ajouter une des 3 dernières cartes de la fosse dans votre main :\n", SwingConstants.LEFT);
		etiquette2.setFont(new Font("Serif",Font.BOLD,30));
		etiquette2.setForeground(Color.white);
		add(etiquette2);
		Pile fosse = fenetre.getVue().getController().getModel().getDefausse();
		double size = 200;
		if (fosse.getCartes().size() == 0) {
			JLabel texte = new JLabel("Il n'y a pas de carte dans la fosse");
			add(texte);
			skip = new JButton("Continuer");
		}
		for (int i = 0; i < 3;i++) {
			if(fosse.getCartes().size() - (i+1) < 0) {
				break;
			}
			JPanel card = new JPanel(new GridLayout(2,1));
			card.setBounds((int)((size/8)+i*(size+size/4)),50,(int) (size),250);
			Couleur couleur = fosse.getCartes().get(fosse.getCartes().size()-(i+1)).getType();
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
			JLabel name = new JLabel(fosse.getCartes().get(i).getCout()+" "+fosse.getCartes().get(i).getNom());
			name.setFont(new Font("Serif", Font.BOLD, 20));
			card.add(name);
			JLabel desc = new JLabel(fosse.getCartes().get(i).getDescription());
			card.add(desc);
			JButton check = new JButton("Choisir");
			check.setBounds((int)((size/8)+i*(size+size/4)),350,(int) (size),50);
			add(card);
			check.addActionListener(this);
			buttons.add(check);
			add(check);
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Pile fosse = fenetre.getVue().getController().getModel().getDefausse();
		// TODO Auto-generated method stub
		if (e.getSource().equals(skip)) {
			cardPlayed.setActions(new ArrayList<String>());
		} else {
			for (JButton button : buttons) {
				if (e.getSource().equals(button)) {
					int index = buttons.indexOf(button);
					cardPlayed.setActions(new ArrayList<String>());
					cardPlayed.getActions().add(fosse.getCartes().get(index).getNom());
				}
			}
		}
	}

}
