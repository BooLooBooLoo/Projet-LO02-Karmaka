package Graphique.States;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Karmaka.src.Carte;
import Karmaka.src.Human;

public class ConteneurCoutKarmique extends JPanel implements ActionListener{

	private Fenetre fenetre;
	private Carte cardPlayed;
	private JButton button, button2;
	private boolean rejouable = false;
	
	public ConteneurCoutKarmique(Fenetre menu, Carte carte) {
		super();
		this.fenetre = menu;
		this.cardPlayed = carte;
		propPouvoir();
		this.setBackground(null);
	}
	public ConteneurCoutKarmique(Fenetre menu, Carte carte, boolean r) {
		super();
		this.fenetre = menu;
		this.cardPlayed = carte;
		this.rejouable = r;
		propPouvoir();
		this.setBackground(null);
	}
	
	public void propPouvoir() {
		JLabel etiquette = new JLabel(fenetre.getVue().getController().getModel().getAdversaire().getNom()+", Voulez vous récuperer la carte : "+cardPlayed.getNom(), SwingConstants.CENTER);
		etiquette.setFont(new Font("Serif",Font.BOLD,30));
		add(etiquette);
		button = new JButton("Oui");
		button.addActionListener(this);
		add(button);
		button2 = new JButton("Non");
		button2.addActionListener(this);
		add(button2);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Human adversaire = (Human) fenetre.getVue().getController().getModel().getAdversaire();
		if (e.getSource().equals(button)) {
			adversaire.setActionCK("Y");
		} else {
			adversaire.setActionCK("N");
		}
		fenetre.publish(new ConteneurPartie(fenetre));
	}

}
