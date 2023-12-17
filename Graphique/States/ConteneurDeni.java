package Graphique.States;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Karmaka.src.Carte;

public class ConteneurDeni extends JPanel implements ActionListener{

	private Fenetre fenetre;
	private Carte cardPlayed;
	
	public ConteneurDeni(Fenetre menu, Carte carte) {
		super();
		this.fenetre = menu;
		this.cardPlayed = carte;
		propDeni();
		this.setBounds(200,150,800,400);
	}
	
	public void propDeni() {
		JLabel etiquette = new JLabel("Voyage");
		add(etiquette);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
