package Graphique.States;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ConteneurGagnant extends JPanel implements ActionListener{
	
	private Fenetre menu;
	private JButton end;
	
	public ConteneurGagnant(Fenetre menu) {
		super();	
		this.menu = menu;
		propConteneurFenetre();
	}
	
	private void propConteneurFenetre() {
		this.setLayout(null);
		this.propEtiquette();
	}
	
	private void propEtiquette() {
		JLabel etiquette = new JLabel(menu.getVue().getController().getModel().getTour().getNom()+" a gagné la partie !",SwingConstants.CENTER);
		etiquette.setFont(new Font("Serif",Font.BOLD,30));
		etiquette.setBounds(300,100,600,100);
		add(etiquette);
		
		GridLayout layout = new GridLayout(4,1);
		
		JPanel cr = new JPanel(layout);
		cr.setBorder(new EmptyBorder(10, 10, 10, 10));
		cr.setBounds(300,250,600,350);
		JLabel title = new JLabel("Statistiques",SwingConstants.CENTER);
		title.setFont(new Font("Serif",Font.BOLD,30));
		cr.add(title);
		JLabel stat1 = new JLabel("Nombre de tour joué : "+menu.getVue().getController().getModel().getNbrTour());
		stat1.setFont(new Font("Serif",Font.BOLD,20));
		JLabel stat2 = new JLabel("La carte de la victoire : "+menu.getVue().getController().getModel().getTour().getDerniereCarteJoue().getNom());
		stat2.setFont(new Font("Serif",Font.BOLD,20));
		JLabel stat3 = new JLabel("L'arrêt de votre adversaire : "+menu.getVue().getController().getModel().getAdversaire().getEchelleKarmique());
		stat3.setFont(new Font("Serif",Font.BOLD,20));
		cr.add(stat1);
		cr.add(stat2);
		cr.add(stat3);
		add(cr);
		end = new JButton("Quitter l'application");
		end.setBounds(500,650,200,50);
		end.addActionListener(this);
		add(end);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(end)) {
			menu.dispatchEvent(new WindowEvent(menu, WindowEvent.WINDOW_CLOSING));
		}
	}
	public void paintComponent(Graphics g) {
        Image backgroundImage = new ImageIcon("./assets/Karmaka_Background.jpg").getImage();
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
       }
	
}
