package Graphique.States;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Karmaka.src.Carte;

public class ConteneurBassesse extends JPanel implements ActionListener{

	private Carte cardPlayed;
	
	public ConteneurBassesse(Fenetre menu, Carte carte) {
		super();
		this.cardPlayed = carte;
		propPouvoir();
		this.setBounds(200,150,800,400);
		this.setBackground(null);
	}
	
	public void propPouvoir() {
		JLabel etiquette = new JLabel("Bassesse\n", SwingConstants.CENTER);
		etiquette.setFont(new Font("Serif",Font.BOLD,30));
		add(etiquette);
		JLabel text = new JLabel("On défausse 2 cartes de la main adverse aléatoirement", SwingConstants.CENTER);
		text.setFont(new Font("Serif",Font.BOLD,30));
		add(text);
		JButton button = new JButton("Continuer");
		button.addActionListener(this);
		add(button);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		cardPlayed.setActions(new ArrayList<String>());
	}

}
