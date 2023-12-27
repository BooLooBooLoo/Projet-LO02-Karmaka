package Graphique.States;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Karmaka.src.Carte;

public class ConteneurLendemain extends JPanel implements ActionListener{

	private Fenetre fenetre;
	private Carte cardPlayed;
	private JButton button;
	
	public ConteneurLendemain(Fenetre menu, Carte carte) {
		super();
		this.fenetre = menu;
		this.cardPlayed = carte;
		propVoyage();
		this.setBounds(200,150,800,400);
		this.setLayout(null);
		this.setBackground(null);
	}
	
	public void propVoyage() {
		JLabel etiquette = new JLabel("Lendemain",SwingConstants.CENTER);
		etiquette.setFont(new Font("Serif",Font.BOLD,30));
		etiquette.setForeground(Color.white);
		etiquette.setBounds(325,0,150,50);
		JLabel texte = new JLabel("Vous puisez une carte à la source, vous pouvez rejouer");
		texte.setFont(new Font("Serif",Font.BOLD,20));
		texte.setForeground(Color.white);
		texte.setBounds(10,100,500,50);
		add(texte);
		button = new JButton("Continuer");
		button.addActionListener(this);
		button.setBounds(350,350,100,50);
		add(button);
		add(etiquette);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		cardPlayed.setActions(new ArrayList<String>());
		fenetre.publish(new ConteneurRejouer(fenetre));
	}

}
