package Graphique.States;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Karmaka.src.Carte;
import Karmaka.src.Joueur;

public class ConteneurDernierSouffle extends JPanel implements ActionListener{

	private Fenetre fenetre;
	private Carte cardPlayed;
	private JButton skip;
	private JTextField field;
	
	public ConteneurDernierSouffle(Fenetre menu, Carte carte) {
		super();
		this.fenetre = menu;
		this.cardPlayed = carte;
		propDernierSouffle();
		this.setBounds(200,150,800,400);
		this.setBackground(null);
		GridLayout layout = new GridLayout(4,1);
		layout.setHgap(100);
		layout.setVgap(100);
		this.setLayout(layout);
	}
	
	public void propDernierSouffle() {
		JLabel etiquette = new JLabel("Dernier Souffle", SwingConstants.CENTER);
		etiquette.setFont(new Font("Serif",Font.BOLD,30));
		etiquette.setForeground(Color.white);
		add(etiquette);
		Joueur adversaire = fenetre.getVue().getController().getModel().getAdversaire();
		if (adversaire.getMain().getCartes().size() == 0) {
			JLabel texte = new JLabel("Il n'y a pas de carte à voler.", SwingConstants.CENTER);
			texte.setFont(new Font("Serif",Font.BOLD,30));
			texte.setForeground(Color.white);
			add(texte);
		} else {
			JLabel texte = new JLabel("Veuillez choisir l'index de la carte à défausser (entre 0 et " + (adversaire.getMain().getCartes().size()-1) + ").", SwingConstants.CENTER);
			texte.setFont(new Font("Serif",Font.BOLD,30));
			texte.setForeground(Color.white);
			add(texte);
			field = new JTextField();
			add(field);
			JButton button = new JButton("Valider");
			button.addActionListener(this);
			add(button);
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(skip)) {
			cardPlayed.setActions(new ArrayList<String>());
		} else if (field.getText() != null && Integer.parseInt(field.getText()) <= fenetre.getVue().getController().getModel().getAdversaire().getMain().getCartes().size()-1 && Integer.parseInt(field.getText()) > 0) {
			System.out.println("IN");
			cardPlayed.setActions(new ArrayList<String>());
			cardPlayed.getActions().add(field.getText());
		}
	}

}
