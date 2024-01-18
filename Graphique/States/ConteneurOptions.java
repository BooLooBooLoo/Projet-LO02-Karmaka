package Graphique.States;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConteneurOptions extends JPanel implements ActionListener{
	
	private JLabel etiquette;
	private List<JButton> boutons;
	
	public ConteneurOptions() {
		super();
		propConteneurFenetre();
	}
	
	private void propConteneurFenetre() {
		boutons = new ArrayList<JButton>();
		this.setLayout(null);
		this.propEtiquette();
		this.propBoutons(5);
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
		double buttonSize = size/2;
		for (int j = 0; j < i; j++) {
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
