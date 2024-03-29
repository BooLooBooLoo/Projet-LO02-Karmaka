package Graphique;

import java.awt.Color;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class ConteneurFenetre extends JPanel implements ActionListener{
	
	private JLabel etiquette;
	private List<JButton> boutons;
	
	public ConteneurFenetre() {
		super();
		propConteneurFenetre();
	}
	
	private void propConteneurFenetre() {
		boutons = new ArrayList<JButton>();
		this.setLayout(null);
		this.propEtiquette();
		this.propBoutons(10);
	}
	
	private void propEtiquette() {
		etiquette = new JLabel();
		this.etiquette.setBounds(20,10,350,20);
		this.etiquette.setForeground(Color.BLACK);
		this.etiquette.setText("Ceci est une étiquette");
		this.add(etiquette);
	}
	
	private void propBoutons(int i) {
		double size = 1200/i;
		System.out.println(size);
		double buttonSize = size/2;
		System.out.println(buttonSize);
		for (int j = 0; j < i; j++) {
			System.out.println((int) (size/4 + (size)*j));
			JButton bouton = new JButton();
			bouton.setText(new String(""+j));
			bouton.setBounds((int) (size/4 + (size)*j),700,(int) buttonSize,20);
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
				if (e.getSource().equals(bouton)) {
					this.etiquette.setText("Vous avez appuyez sur le bouton "+boutons.indexOf(bouton));
				}
			}
		}
		
	}
	
}
