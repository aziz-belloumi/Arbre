package ProjetModule;

public class Main {
	
    public static void imprimerArbre(Noeud racine, int niveau) {
        if (racine == null) {
            return;
        }
        String indentation = "";
        for (int i = 0; i < niveau; i++) {
            indentation += "  ";
        }
        System.out.println(indentation + racine.info);
        imprimerArbre(racine.gauche, niveau + 1);
        imprimerArbre(racine.droit, niveau + 1);
    }
    
    public static void main(String[] args) {
        Noeud racine = new Noeud("Tunisie");
        racine.enfants.add(new Noeud("Ouest"));
        racine.enfants.add(new Noeud("Tunis"));
        racine.enfants.add(new Noeud("Sud"));
        racine.enfants.get(0).enfants.add(new Noeud("Beja"));
        racine.enfants.get(2).enfants.add(new Noeud("Gabes"));
        racine.enfants.get(2).enfants.add(new Noeud("Sfax"));
        Noeud racineArbreBinaire = arbreBinaire.convertir(racine);
        imprimerArbre(racineArbreBinaire,0);        
        int profondeurGabes = arbreBinaire.calculerProfondeur(racineArbreBinaire, "Tunis");
        System.out.println("La profondeur du nœud Gabes est : " + profondeurGabes);
        int hauteurArbreBinaire = arbreBinaire.calculerHauteur(racineArbreBinaire);
        System.out.println("La hauteur de l'arbre binaire est : " + hauteurArbreBinaire);
    }
}
