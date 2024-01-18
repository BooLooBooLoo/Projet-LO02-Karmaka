package Graphique.States;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ConteneurChoixJoueur extends JPanel implements ActionListener{
	
	private JRadioButton rBtn1, rBtn2, rBtn3, rBtn4;
	private JRadioButton subRBtn1,subRBtn2,subRBtn3,subRBtn4,subRBtn5,subRBtn6,subRBtn7,subRBtn8;
	private JPanel stratPanel1, stratPanel2;
	private JTextField text1, text2;
	private JButton button;
	private Fenetre fenetre;
	
	public ConteneurChoixJoueur(Fenetre fenetre) {
		super();
		propConteneurFenetre();
		this.fenetre = fenetre;
	}
	
	private void propConteneurFenetre() {
		this.setLayout(null);
		propPanel();
	}
	
	private void propPanel() {
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(150,100,400,500);
		panel1.setBackground(Color.gray);
		JLabel label = new JLabel("Joueur 1", JLabel.CENTER);
		label.setBounds(150,0,100,20);
		panel1.add(label);
		
		rBtn1 = new JRadioButton("Bot");
		rBtn2 = new JRadioButton("Humain");
		rBtn1.setBackground(Color.gray);
		rBtn2.setBackground(Color.gray);
		rBtn1.setBounds(100,150,100,50);
		rBtn2.setBounds(250,150,100,50);
		rBtn1.addActionListener(this);
		rBtn2.addActionListener(this);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rBtn2);
		bg.add(rBtn1);
		
		subRBtn1 = new JRadioButton("Aggressif");
		subRBtn2 = new JRadioButton("Neutre");
		subRBtn3 = new JRadioButton("Defensif");
		subRBtn4 = new JRadioButton("IA");
		subRBtn1.setBackground(Color.gray);
		subRBtn2.setBackground(Color.gray);
		subRBtn3.setBackground(Color.gray);
		subRBtn4.setBackground(Color.gray);
		subRBtn1.addActionListener(this);
		subRBtn2.addActionListener(this);
		subRBtn3.addActionListener(this);
		subRBtn4.addActionListener(this);
		ButtonGroup subBg1 = new ButtonGroup();
		subBg1.add(subRBtn2);
		subBg1.add(subRBtn1);
		subBg1.add(subRBtn3);
		subBg1.add(subRBtn4);
		
		text1 = new JTextField();
		text1.setBounds(100,100,200,20);
		
		stratPanel1 = new JPanel(new GridLayout(2,2));
		stratPanel1.setBackground(Color.gray);
		stratPanel1.setBounds(100,200,300,250);
		stratPanel1.setVisible(false);
		
		stratPanel1.add(subRBtn1);
		stratPanel1.add(subRBtn2);
		stratPanel1.add(subRBtn3);
		stratPanel1.add(subRBtn4);
		
		panel1.add(stratPanel1);
		panel1.add(rBtn2);
		panel1.add(rBtn1);
		panel1.add(text1);
		add(panel1);
		
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(650,100,400,500);
		panel2.setBackground(Color.gray);
		JLabel label2 = new JLabel("Joueur 2", JLabel.CENTER);
		label2.setBounds(150,0,100,20);
		panel2.add(label2);
		rBtn3 = new JRadioButton("Bot");
		rBtn4 = new JRadioButton("Humain");
		rBtn3.setBackground(Color.gray);
		rBtn4.setBackground(Color.gray);
		rBtn3.setBounds(100,150,100,50);
		rBtn4.setBounds(250,150,100,50);
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(rBtn3);
		bg2.add(rBtn4);
		rBtn3.addActionListener(this);
		rBtn4.addActionListener(this);
		text2 = new JTextField();
		text2.setBounds(100,100,200,20);
		
		subRBtn5 = new JRadioButton("Aggressif");
		subRBtn6 = new JRadioButton("Neutre");
		subRBtn7 = new JRadioButton("Defensif");
		subRBtn8 = new JRadioButton("IA");
		subRBtn5.setBackground(Color.gray);
		subRBtn6.setBackground(Color.gray);
		subRBtn7.setBackground(Color.gray);
		subRBtn8.setBackground(Color.gray);
		subRBtn5.addActionListener(this);
		subRBtn6.addActionListener(this);
		subRBtn7.addActionListener(this);
		subRBtn8.addActionListener(this);
		ButtonGroup subBg2 = new ButtonGroup();
		subBg2.add(subRBtn6);
		subBg2.add(subRBtn5);
		subBg2.add(subRBtn7);
		subBg2.add(subRBtn8);
		
		stratPanel2 = new JPanel(new GridLayout(2, 2));
		stratPanel2.setBackground(Color.gray);
		stratPanel2.setBounds(100,200,300,250);
		stratPanel2.setVisible(false);
		
		stratPanel2.add(subRBtn5);
		stratPanel2.add(subRBtn6);
		stratPanel2.add(subRBtn7);
		stratPanel2.add(subRBtn8);
		
		panel2.add(stratPanel2);
		panel2.add(rBtn4);
		panel2.add(rBtn3);
		panel2.add(text2);
		add(panel2);
		
		button = new JButton();
		button.setText("Jouer");
		button.setBounds(500,700,200,30);
		button.addActionListener(this);
		add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(rBtn1.isSelected()) {
			stratPanel1.setVisible(true);
		} else if (rBtn2.isSelected()) {
			stratPanel1.setVisible(false);
		}
		if(rBtn3.isSelected()) {
			stratPanel2.setVisible(true);
		} else if (rBtn4.isSelected()) {
			stratPanel2.setVisible(false);
		} 
		if (e.getSource().equals(button)) {
			String typeJ1 = (rBtn1.isSelected()) ? "B" : "H";
			String typeJ2 = (rBtn3.isSelected()) ? "B" : "H";
			String stratJ1 = (subRBtn1.isSelected())?"A":(subRBtn2.isSelected())? "N":(subRBtn3.isSelected())?"D":"IA";
			String stratJ2 = (subRBtn5.isSelected())?"A":(subRBtn6.isSelected())? "N":(subRBtn7.isSelected())?"D":"IA";;
			String[] joueurs = new String[] {typeJ1,stratJ1,text1.getText(),typeJ2,stratJ2,text2.getText()};
			fenetre.setJoueurs(joueurs);
		}
	}
	
	public void paintComponent(Graphics g) {
        Image backgroundImage = new ImageIcon("./assets/Karmaka_Background.jpg").getImage();
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
       }
	
}
