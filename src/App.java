public class App {
    public static void main(String[] args) {
        int annee = 2020;
        int mois = 2;
        int jour = 28;

        System.out.println("Année Bissextile : " + Outils.shortBiss(annee));
        System.out.println("La date existe : " + Outils.verifierDate(jour, mois, annee));

    }
}
