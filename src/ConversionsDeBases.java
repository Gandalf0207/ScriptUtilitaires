public class ConversionsDeBases {
    // variables utilitaires de la class
    private String nb;
    private String nbConverti = "";
    private int baseEntre;
    private int baseSortie;

    public ConversionsDeBases(String nb, int baseEntre, int baseSortie) {
        this.nb = nb;
        this.baseEntre = baseEntre;
        this.baseSortie = baseSortie;
    }

    public void Convertir() {
        // convert en base 10
        int[] tab = convertStringToTabInt(this.nb);
        int totalBase10 = 0;
        for (int i = 0; i < tab.length; i++) {
            totalBase10 += tab[i] * exposant(baseEntre, tab.length - (i + 1));
        }

        //convert dans la base souhaitée
        do {
            int r = totalBase10 % this.baseSortie;
            this.nbConverti = r + this.nbConverti;
            totalBase10 /= this.baseSortie;
        } while (totalBase10 != 0);
    }

    public String toString() {
        return String.format("%s en base %d vaut %s en base %d", this.nb, this.baseEntre, this.nbConverti, this.baseSortie);
    }


    /**
     * Fonction permettant de tranformer une chaine de caractère en un tableau avec les valeur entière
     * Nombre compris entre 0-9 & A-Z
     *
     * @return un tableau de caractère dans l'ordre de la chaine.
     *
     */
    private int[] convertStringToTabInt(String nb) {
        int len = nb.length();
        int[] tab = new int[len];
        for (int i = 0; i < len; i++) {
            char carac = nb.charAt(i);
            if (carac >= '0' && carac <= '9') {
                tab[i] = carac - '0'; // calcul avec valeur Ascii
            } else if (carac >= 'A' && carac <= 'Z') {
                tab[i] = carac - 'A' + 10; // calcul avec valeur Ascii
            }
        }
        return tab;
    }

    /**
     * Fonction permettant de calculer un nombre exposant un autre.
     *
     * @param nb       entier du nombre
     * @param exposant entier positif exposant du nombre
     *
     */
    private int exposant(int nb, int exposant) {
        int somme = 1;
        for (int i = 0; i < exposant; i++) {
            somme *= nb;
        }
        return somme;
    }
}