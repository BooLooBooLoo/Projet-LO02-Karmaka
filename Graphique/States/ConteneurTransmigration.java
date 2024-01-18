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
import javax.swing.SwingConstants;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Joueur;

public class ConteneurTransmigration extends JPanel implements ActionListener{

	private Fenetre fenetre;
	private Carte cardPlayed;
	private JButton skip;
	private List<JButton> buttons = new ArrayList<JButton>();
	
	public ConteneurTransmigration(Fenetre menu,Carte carte) {
		super();
		this.fenetre = menu;
		this.cardPlayed = carte;
		propVoyage();
		this.setBounds(200,150,800,400);
	}
	
	public void propVoyage() {
		JLabel etiquette = new JLabel("Transmigration\n", SwingConstants.CENTER);
		etiquette.setFont(new Font("Serif",Font.BOLD,30));
		add(etiquette);
		JLabel etiquette2 = new JLabel("Choisir une carte de votre vie future à ajouter dans votre main.", SwingConstants.LEFT);
		etiquette2.setFont(new Font("Serif",Font.BOLD,30));
		add(etiquette2);
		Joueur joueur = fenetre.getVue().getController().getModel().getTour();
		double size = 200;
		if (joueur.getVieFuture().getCartes().size() == 0) {
			JLabel texte = new JLabel("Il n'y a pas de carte dans votre vie future");
			add(texte);
			skip = new JButton("Continuer");
			skip.addActionListener(this);
			add(skip);
		}
		for (int i = 0; i < joueur.getVieFuture().getCartes().size() ;i++) {
			JPanel card = new JPanel(new GridLayout(2,1));
			card.setBounds((int)((size/8)+i*(size+size/4)),50,(int) (size),250);
			Couleur couleur = joueur.getVieFuture().getCartes().get(i).getType();
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
			JLabel name = new JLabel(joueur.getVieFuture().getCartes().get(i).getCout()+" "+joueur.getVieFuture().getCartes().get(i).getNom());
			name.setFont(new Font("Serif", Font.BOLD, 20));
			card.add(name);
			JLabel desc = new JLabel(joueur.getVieFuture().getCartes().get(i).getDescription());
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
		// TODO Auto-generated method stub
		if (e.getSource().equals(skip)) {
			cardPlayed.setActions(new ArrayList<String>());
		} else {
			for (JButton button : buttons) {
				if (e.getSource().equals(button)) {
					int index = buttons.indexOf(button);
					cardPlayed.setActions(new ArrayList<String>());
					cardPlayed.getActions().add(fenetre.getVue().getController().getModel().getTour().getVieFuture().getCartes().get(index).getNom());
				}
			}
		}
	}

}
