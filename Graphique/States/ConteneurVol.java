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

public class ConteneurVol extends JPanel implements ActionListener{

	private Carte cardPlayed;
	
	public ConteneurVol(Fenetre menu, Carte carte) {
		super();
		this.cardPlayed = carte;
		propVol();
		this.setBounds(200,150,800,400);
		this.setBackground(null);
	}
	
	public void propVol() {
		JLabel etiquette = new JLabel("Vol\n", SwingConstants.CENTER);
		etiquette.setFont(new Font("Serif",Font.BOLD,30));
		add(etiquette);
		JLabel text = new JLabel("Vous volez l'oeuvre exposée de l'adversaire. Vous la placez dans votre main.", SwingConstants.CENTER);
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
