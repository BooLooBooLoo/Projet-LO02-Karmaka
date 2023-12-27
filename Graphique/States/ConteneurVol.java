package Graphique.States;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Joueur;

public class ConteneurVol extends JPanel implements ActionListener{

	private Fenetre fenetre;
	private Carte cardPlayed;
	
	public ConteneurVol(Fenetre menu, Carte carte) {
		super();
		this.fenetre = menu;
		this.cardPlayed = carte;
		propVol();
		this.setBounds(200,150,800,400);
		this.setBackground(null);
	}
	
	public void propVol() {
		JLabel etiquette = new JLabel("Vol\n", SwingConstants.CENTER);
		etiquette.setFont(new Font("Serif",Font.BOLD,30));
		add(etiquette);
		JLabel text = new JLabel("Vous voulez l'oeuvre exposée de l'adversaire. Vous la placez dans votre main.", SwingConstants.CENTER);
		text.setFont(new Font("Serif",Font.BOLD,30));
		add(text);

		JButton button = new JButton("Continuer");
		button.setBorder(new EmptyBorder(50,50,50,50));
		button.addActionListener(this);
		add(button);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		cardPlayed.setActions(new ArrayList<String>());
	}

}
