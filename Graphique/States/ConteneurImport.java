package Graphique.States;

import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import Karmaka.src.Partie;

public class ConteneurImport extends JFileChooser {
	
	public ConteneurImport(Fenetre fenetre) {
		super(Paths.get("").toAbsolutePath().toString());
		this.setDialogTitle("Choisir le fichier de sauvegarde :");
		this.setFileSelectionMode(ConteneurImport.FILES_ONLY);
		this.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier .ser", "ser");
		this.addChoosableFileFilter(filter);
		
		int res = this.showOpenDialog(null);
	    if (res == JFileChooser.APPROVE_OPTION) {
	      try {
			fenetre.getVue().getController().setModel(Partie.importer(this.getSelectedFile()));
			fenetre.setImportPartie("import");
			fenetre.getVue().getController().setIsNewGame("no");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    }
	}
}
