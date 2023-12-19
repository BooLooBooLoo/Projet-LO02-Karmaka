package Graphique.States;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Karmaka.src.Carte;

public class ConteneurFournaise extends JPanel implements ActionListener{

	private Fenetre fenetre;
	private Carte cardPlayed;
	
	public ConteneurFournaise(Fenetre menu, Carte carte) {
		super();
		this.fenetre = menu;
		this.cardPlayed = carte;
		propFournaise();
		this.setBounds(200,150,800,400);
		this.setBackground(null);
	}
	
	public void propFournaise() {
		JLabel etiquette = new JLabel("Fournaise\n", SwingConstants.CENTER);
		etiquette.setFont(new Font("Serif",Font.BOLD,30));
		etiquette.setForeground(Color.white);
		add(etiquette);
		JLabel text = new JLabel("On défausse les 2 premières cartes de la vie future adverse", SwingConstants.CENTER);
		text.setFont(new Font("Serif",Font.BOLD,30));
		text.setForeground(Color.white);
		add(text);
		JButton button = new JButton("Continuer");
		button.addActionListener(this);
		add(button);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		cardPlayed.setActions(new ArrayList<String>());
	}

}
