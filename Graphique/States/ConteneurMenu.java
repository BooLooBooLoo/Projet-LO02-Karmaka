package Graphique.States;

import java.awt.Color;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class ConteneurMenu extends JPanel implements ActionListener{
	
	private JLabel etiquette;
	private List<JButton> boutons;
	private Fenetre menu;
	private String[] nameButtons;
	private double index;
	
	public ConteneurMenu(Fenetre menu, double ind) {
		super();	
		this.menu = menu;
		this.index = (ind != 0) ? ind : 3;
		nameButtons = (ind == 3) ? new String[] {"Jouer","Options","Quitter"} : new String[] {"Reprendre Partie","Nouvelle Partie","Options","Quitter"};
		propConteneurFenetre();
	}
	
	private void propConteneurFenetre() {
		boutons = new ArrayList<JButton>();
		this.setLayout(null);
		this.propEtiquette();
		this.propBoutons();
	}
	
	private void propEtiquette() {
		etiquette = new JLabel();
		this.etiquette.setBounds(20,10,350,20);
		this.etiquette.setForeground(Color.BLACK);
		this.etiquette.setText("Menu");
		this.add(etiquette);
	}
	
	private void propBoutons() {
		System.out.println(index);
		System.out.println("IN");
		double size = 600/((double)index);
		System.out.println("size : "+size);
		double buttonSize = size;
		for (int j = 0; j < index; j++) {
			JButton bouton = new JButton();
			bouton.setText(nameButtons[j]);
			bouton.setBounds((int) (600 - buttonSize/2),(int) (100 + (size/4 + (size)*j)),(int) buttonSize,20);
			bouton.setForeground(Color.getHSBColor(0, 0, (float) 10.2));
			add(bouton);
			bouton.addActionListener(this);
			this.boutons.add(bouton);
		}

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			for (JButton bouton : boutons) {
				System.out.println(bouton.getText());
				if (e.getSource().equals(bouton)) {
					this.etiquette.setText("Vous avez appuyez sur le bouton "+boutons.indexOf(bouton));
				}
				if (e.getSource().equals(bouton) && (bouton.getText().equals("Jouer") || bouton.getText().equals("Nouvelle Partie"))) {
					this.etiquette.setText("Vous avez appuyez sur le bouton Jouer");
					menu.publish(new ConteneurChoixJoueur(menu));
				}
			}
		}
		if(e.getSource().equals(this.boutons.get((int)index-1))) {
			this.etiquette.setText("Vous avez appuyez sur le bouton Quitter");
			menu.publish(new ConteneurOptions());
		}
		
	}
	
}