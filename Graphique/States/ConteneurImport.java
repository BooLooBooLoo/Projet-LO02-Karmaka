package Graphique.States;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import Karmaka.src.Partie;

/**
 * Classe qui représente la fenêtre qui permet d'importer une partie.
 */
public class ConteneurImport extends JFileChooser {
	
	private Fenetre fenetre;
	/**
	 * Constructeur de la classe.
	 * @param fenetre La fenêtre principale qui contient le jeu.
	 */
	public ConteneurImport(Fenetre fenetre) {
		super(Paths.get("").toAbsolutePath().toString());
		this.fenetre = fenetre;
		this.setDialogTitle("Choisir le fichier de sauvegarde :");
		this.setFileSelectionMode(this.FILES_ONLY);
		this.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier .ser", "ser");
		this.addChoosableFileFilter(filter);
		
		int res = this.showOpenDialog(null);
	    if (res == JFileChooser.APPROVE_OPTION) {
	      try {
			fenetre.getVue().getController().setModel(Partie.importer(this.getSelectedFile()));
			fenetre.setImportPartie("import");
			//fenetre.getVue().getController().getVue().getFenetre().publish(new ConteneurPartie(fenetre));
			fenetre.getVue().getController().setIsNewGame("no");
			//fenetre.getVue().getController().controlerLaPartie();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    }
	}
}
