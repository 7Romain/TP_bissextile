public class Outils {

    /**
     * @author 7Romain
     * @version 1
     */

    /**
     * @param annee
     * @return boolean
     *         Fonction qui renvoie true si l'année entrée en paramètre est une
     *         année bissextile,
     *         sinon renvoie false.
     */
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

    /**
     * @param numerateur
     * @param denominateur
     * @return boolean
     *         fonction pour factoriser modulo, entrez un numérateur et le
     *         dénominateur et vous obtientrais true
     *         si le numérateur est divisible par le dénominateur , sinon renvoie
     *         false.
     */
    public static boolean mod(int numerateur, int denominateur) {
        return (Math.floorMod(numerateur, denominateur) == 0);

    }

    /**
     * @param annee
     * @return boolean
     *         * Fonction raccourcie qui renvoie true si l'année entrée en paramètre
     *         est une année bissextile,
     *         sinon renvoie false.
     */
    public static boolean shortBiss(int annee) {
        return ((mod(annee, 4) && !mod(annee, 100)) ||
                (mod(annee, 4) && mod(annee, 100) && mod(annee, 400)));

    }

    /**
     * @param mois
     * @return boolean
     *         Vérifie si mois est entre 1 et 12.
     */
    public static boolean verifierMois(int mois) {
        return (0 < mois && mois <= 12);

    }

    /**
     * @param annee
     * @return boolean
     *         Vérifie si année est entre 0 et 9999.
     */
    public static boolean verifierAnnee(int annee) {
        return (0 <= annee && annee <= 9999);

    }

    /**
     * @param jour
     * @return boolean
     *         Vérifie si jour est entre 1 et 31.
     */
    public static boolean verifierJour(int jour) {

        return !(1 > jour || jour > 31);
    }

    /**
     * @param jour
     * @param mois
     * @param annee
     * @return boolean
     *         vérifie s'il s'agit ou non d'une date valide.
     *         revoie true si oui ; sinon renvoie false.
     * 
     */
    public static boolean verifierDate(int jour, int mois, int annee) {
        if (verifierJour(jour) && verifierMois(mois) && verifierAnnee(annee)) {
            if (isBissextile(annee)) { // année bissextile

                switch (mois) {// on a déjà vérifié que jour est entre 1 et 31
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
                        return (1 <= jour && jour <= 30); // les mois Avril Juin Septembre et Novembre n'ont que 30
                                                          // jours

                    case 2: // mois de février en année bissextile 29 jours
                        return (1 <= jour && jour <= 29);

                }

            } else { // presque pareill en année non bissextile

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

                    case 2: // sauf que le mois de février à 28 jours
                        return (1 <= jour && jour <= 28);

                }

            }
        }
        return false;
    }

}
