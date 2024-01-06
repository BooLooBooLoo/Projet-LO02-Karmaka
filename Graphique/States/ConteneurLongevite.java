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

public class ConteneurLongevite extends JPanel implements ActionListener{

	private Fenetre fenetre;
	private Carte cardPlayed;
	private JButton skip;
	private JTextField field;
	
	public ConteneurLongevite(Fenetre menu, Carte carte) {
		super();
		this.fenetre = menu;
		this.cardPlayed = carte;
		propLongevite();
		this.setBounds(200,150,800,400);
		this.setBackground(null);
		GridLayout layout = new GridLayout(4,1);
		layout.setHgap(100);
		layout.setVgap(100);
		this.setLayout(layout);
	}
	
	public void propLongevite() {
		JLabel etiquette = new JLabel("Longévité", SwingConstants.CENTER);
		etiquette.setFont(new Font("Serif",Font.BOLD,30));
		etiquette.setForeground(Color.black);
		add(etiquette);
		Joueur adversaire = fenetre.getVue().getController().getModel().getAdversaire();
		if (adversaire.getMain().getCartes().size() == 0) {
			JTextArea texte = new JTextArea("Il n'y a pas de carte à voler.");
			texte.setFont(new Font("Serif",Font.BOLD,20));
			texte.setForeground(Color.black);
			add(texte);
			skip = new JButton("Continuer");
			skip.addActionListener(this);
			skip.setBounds(350,250,100,50);
			add(skip);
		} else {
			JTextArea texte = new JTextArea("Choisir entre vous et l'adversaire, il recevra 2 cartes de la source directement dans sa pile");
			texte.setBackground(null);
			texte.setFont(new Font("Serif",Font.BOLD,20));
			texte.setForeground(Color.black);
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
		} else if (field.getText() != null && (field.getText().equals("Moi") || field.getText().equals("Adversaire"))) {
			System.out.println("IN");
			cardPlayed.setActions(new ArrayList<String>());
			cardPlayed.getActions().add(field.getText());
		}
	}

}
