public class Outils {

    public static boolean isBissextile(int annee) {
        if (Math.floorMod(annee, 4) != 0)
            return false;
        else if (Math.floorMod(annee, 100) != 0)
            return true;
        else if (Math.floorMod(annee, 400) != 0)
            return false;
        else {
            return true;
        }

    }

    public static boolean mod(int numerateur, int denominateur) {
        return (Math.floorMod(numerateur, denominateur) == 0);

    }

    public static boolean shortBiss(int annee) {
        return ((mod(annee, 4) && !mod(annee, 100)) ||
                (mod(annee, 4) && mod(annee, 100) && mod(annee, 400)));

    }

    public static boolean verifierMois(int mois) {
        return (0 < mois && mois <= 12);

    }

    public static boolean verifierAnnee(int annee) {
        return (0 <= annee && annee <= 9999);

    }

    public static boolean verifierJour(int jour) {

        return !(1 > jour || jour > 31);
    }

    public static boolean verifierDate(int jour, int mois, int annee) {
        if (verifierJour(jour) && verifierMois(mois) && verifierAnnee(annee)) {
            if (isBissextile(annee)) {
                // switch mois 31 jours, mois 30 jours, mois 29jours
                switch (mois) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        return true;

                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        return (1 <= jour && jour <= 30);

                    case 2:
                        return (1 <= jour && jour <= 29);

                }

            } else {

                switch (mois) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        return true;

                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        return (1 <= jour && jour <= 30);

                    case 2:
                        return (1 <= jour && jour <= 28);

                }

            }
        }
        return false;
    }

}
