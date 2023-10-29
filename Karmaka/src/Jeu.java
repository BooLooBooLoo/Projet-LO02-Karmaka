package Karmaka.src;

import Cartes.Deni;

public class Jeu {
    public static void main(String[] args) {
        Carte carte = new Deni();
        Pile pile = new Pile();
        pile.addCarte(carte);
        System.out.println(pile.getCartes().get(0).getNom());
    }
}
