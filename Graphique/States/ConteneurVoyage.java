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

public class ConteneurVoyage extends JPanel implements ActionListener{

	private Fenetre fenetre;
	private Carte cardPlayed;
	
	public ConteneurVoyage(Fenetre menu, Carte carte) {
		super();
		this.fenetre = menu;
		this.cardPlayed = carte;
		propVoyage();
		this.setBounds(200,150,800,400);
	}
	
	public void propVoyage() {
		JLabel etiquette = new JLabel("Voyage\n", SwingConstants.CENTER);
		etiquette.setFont(new Font("Serif",Font.BOLD,30));
		add(etiquette);
		JLabel text = new JLabel("Pioche 3 cartes", SwingConstants.CENTER);
		text.setFont(new Font("Serif",Font.BOLD,30));
		add(text);
		JButton button = new JButton("Continuer");
		button.addActionListener(this);
		add(button);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		cardPlayed.setActions(new ArrayList<String>());
		fenetre.publish(new ConteneurRejouer(fenetre));
	}

}
