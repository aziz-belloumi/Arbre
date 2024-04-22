package ProjetModule;

import java.util.List;

public class arbreBinaire {

    public static Noeud convertir(Noeud racine) {
        if (racine == null) {
            return null;
        }
        if (racine.enfants.isEmpty()) {
            return racine;
        }
        if (racine.enfants.size() == 1) {
            racine.gauche = convertir(racine.enfants.get(0));
            return racine;
        }
        racine.gauche = convertir(racine.enfants.get(0));
        racine.droit = convertir(racine.enfants.get(1));

        List<Noeud> enfantsRestants
                = racine.enfants.subList(2,
                racine.enfants.size());
        Noeud racineArbreDroit = racine.droit;
        while (!enfantsRestants.isEmpty()) {
            if (racineArbreDroit.enfants.isEmpty()) {
                racineArbreDroit.gauche
                        = convertir(enfantsRestants.get(0));
            } else {
                racineArbreDroit.droit
                        = convertir(enfantsRestants.get(0));
            }
            enfantsRestants = enfantsRestants.subList(
                    1, enfantsRestants.size());
        }
        return racine;
    }
    
    public static int calculerProfondeur(Noeud racine, String info) {
        return profondeurHelper(racine, info, 0);
    }

    private static int profondeurHelper(Noeud noeud, String info, int profondeurActuelle) {
        if (noeud == null) {
            return -1;
        }
        if (noeud.info.equals(info)) {
            return profondeurActuelle;
        }
        int profondeurGauche = profondeurHelper(noeud.gauche, info, profondeurActuelle + 1);
        int profondeurDroit = profondeurHelper(noeud.droit, info, profondeurActuelle + 1);
        return Math.max(profondeurGauche, profondeurDroit);
    }
    
    public static int calculerHauteur(Noeud racine) {
        return calculerHauteurProcess(racine);
    }
    
    private static int calculerHauteurProcess(Noeud racine) {
        if (racine == null) {
            return -1;
        }
        int hauteurGauche = calculerHauteurProcess(racine.gauche);
        int hauteurDroit = calculerHauteurProcess(racine.droit);
        return 1 + Math.max(hauteurGauche, hauteurDroit);
    }
}
