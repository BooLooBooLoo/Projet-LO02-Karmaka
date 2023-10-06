package Karmaka.src;

public class Jeu {
    public static void main(String[] args) {
        Carte carte = new Carte();
        carte.setCout(1);
        carte.setType(Couleur.couleur.bleu);
        carte.setNom("Deni");
        Pile pile = new Pile();
        pile.addCarte(carte);
        System.out.println(pile.getCartes().get(0).getNom());
    }
}
