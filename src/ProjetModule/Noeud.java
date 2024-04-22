package ProjetModule;
import java.util.ArrayList;

public class Noeud {
    public String info;
    public Noeud gauche;
    public Noeud droit;

    ArrayList<Noeud> enfants;

    public Noeud(String info) {
        this.info = info;
        this.enfants = new ArrayList<>();
    }
}