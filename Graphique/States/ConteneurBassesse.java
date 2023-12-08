package Graphique.States;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ConteneurBassesse extends JPanel implements ActionListener{

	private Fenetre fenetre;
	
	public ConteneurBassesse(Fenetre menu) {
		super();
		this.fenetre = menu;
		propVoyage();
		this.setBounds(200,150,800,400);
	}
	
	public void propVoyage() {
		JLabel etiquette = new JLabel("Bassesse");
		add(etiquette);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
