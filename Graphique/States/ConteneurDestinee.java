package Graphique.States;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Karmaka.src.Carte;
import Karmaka.src.Couleur;
import Karmaka.src.Pile;

public class ConteneurDestinee extends JPanel implements ActionListener{

	private Fenetre fenetre;
	private Carte cardPlayed;
	private JButton skip;
	private List<JCheckBox> checkbox = new ArrayList<JCheckBox>();
	
	public ConteneurDestinee(Fenetre menu, Carte carte) {
		super();
		this.fenetre = menu;
		this.cardPlayed = carte;
		propDestinee();
		this.setBounds(200,150,800,400);
		this.setLayout(null);
		this.setBackground(null);
	}
	
	public void propDestinee() {
		JLabel etiquette = new JLabel("Destinée\n", SwingConstants.CENTER);
		etiquette.setFont(new Font("Serif",Font.BOLD,30));
		etiquette.setForeground(Color.white);
		add(etiquette);
		JLabel etiquette2 = new JLabel("3 premières cartes de la source, choisissez-en au maximum 2 :\n", SwingConstants.LEFT);
		etiquette2.setFont(new Font("Serif",Font.BOLD,30));
		etiquette2.setForeground(Color.white);
		add(etiquette2);
		Pile source = fenetre.getVue().getController().getModel().getSource();
		double size = 800/4;
		if (source.getCartes().size() == 0) {
			JLabel texte = new JLabel("Il n'y a pas de carte dans la source");
			add(texte);
			skip = new JButton("Continuer");
		}
		for (int i = 0; i < 3;i++) {
			JPanel card = new JPanel(new GridLayout(2,1));
			card.setBounds((int)((size/8)+i*(size+size/4)),50,(int) (size),250);
			Couleur couleur = source.getCartes().get(i).getType();
			switch(couleur) {
				case BLEU :
					card.setBackground(Color.BLUE);
					break;
				case ROUGE :
					card.setBackground(Color.RED);
					break;
				case VERT :
					card.setBackground(Color.GREEN);
					break;
				case MOSAIQUE :
					card.setBackground(Color.cyan);
					break;
			}
			card.setBorder(BorderFactory.createLineBorder(Color.black));
			JLabel name = new JLabel(source.getCartes().get(i).getCout()+" "+source.getCartes().get(i).getNom());
			name.setFont(new Font("Serif", Font.BOLD, 20));
			card.add(name);
			JLabel desc = new JLabel(source.getCartes().get(i).getDescription());
			card.add(desc);
			JCheckBox check = new JCheckBox(source.getCartes().get(i).getNom());
			check.setBounds((int)((size/8)+i*(size+size/4)),325,(int) (size),25);
			add(card);
			checkbox.add(check);
			add(check);
		}
		JButton button = new JButton("Fin choix");
		button.setBounds(350,375,100,25);
		button.addActionListener(this);
		add(button);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Pile source = fenetre.getVue().getController().getModel().getSource();
		if (e.getSource().equals(skip)) {
			cardPlayed.setActions(new ArrayList<String>());
		} else {
			int counter = 0;
			List<String> actions = new ArrayList<String>();
			for (JCheckBox check : checkbox) {
				if (check.isSelected()) {
					counter++;
					actions.add(source.getCartes().get(checkbox.indexOf(check)).getNom());
				}
			}
			if (counter < 3) {
				actions.add(String.valueOf(counter));
				cardPlayed.setActions(actions);
			}
		}
	}

}
