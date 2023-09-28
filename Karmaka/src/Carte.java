package Karmaka.src;

public class Carte {
    
    private int cout;

    public int getCout(){
        return cout;
    }

    public void setCout(int value){
        cout = value;
    }

    public static void main(String[] args) {
        Carte carte = new Carte();
        carte.setCout(4);
        System.out.println(carte.getCout());

    }
}
