package Graphique.States;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Karmaka.src.Carte;

public class ConteneurVengeance extends JPanel implements ActionListener{

	private Carte cardPlayed;
	
	public ConteneurVengeance(Fenetre menu, Carte carte) {
		super();
		this.cardPlayed = carte;
		propVengeance();
		this.setBounds(200,150,800,400);
	}
	
	public void propVengeance() {
		JLabel etiquette = new JLabel("Vengeance\n", SwingConstants.CENTER);
		etiquette.setFont(new Font("Serif",Font.BOLD,30));
		add(etiquette);
		JLabel text = new JLabel("Vous défaussez l'oeuvre exposée de l'adversaire.", SwingConstants.CENTER);
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
