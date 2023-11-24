package Graphique;

import java.awt.Color;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	
	ConteneurFenetre panel;
	
	public Fenetre() {
		super();
		propFenetre();
	}
	
	private void propFenetre() {
		this.setSize(1200,800 );
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		panel = new ConteneurFenetre();
		this.setContentPane(panel);
		this.getContentPane().setBackground(Color.DARK_GRAY);
	}
}
