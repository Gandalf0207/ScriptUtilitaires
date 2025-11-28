public class AdditionDeBases {
    private int baseGlobal;
    private String nb1;
    private String nb2;
    private String nbFinal;

    public AdditionDeBases(String nb1, String nb2, int baseGlobal) {
        this.nb1 = nb1;
        this.nb2 = nb2;
        this.baseGlobal = baseGlobal;
        this.nbFinal = "";
    }

    private int getIntValueFromCharUsingASCII(char carac) {
        if (carac >= '0' && carac <= '9') {
            return carac - '0'; // calcul avec valeur Ascii
        } else if (carac >= 'A' && carac <= 'Z') {
            return carac - 'A' + 10; // calcul avec valeur Ascii
        }
        return 0;
    }

    public String addition() {
        int lenght = Math.max(this.nb1.length(), this.nb2.length());
        int i = 0;
        int retenu = 0;
        while (nb1.length() > i || nb2.length() > i || retenu != 0) {
            char carac1 = this.nb1.length() - 1 - i > -1 ? this.nb1.charAt(this.nb1.length() - 1 - i) : '0';
            char carac2 = this.nb2.length() - 1 - i > -1 ? this.nb2.charAt(this.nb2.length() - 1 - i) : '0';

            int somme = getIntValueFromCharUsingASCII(carac1) + getIntValueFromCharUsingASCII(carac2) + retenu;

            int value = somme % this.baseGlobal;
            this.nbFinal = value + this.nbFinal;
            retenu = somme / this.baseGlobal;
        }

        return this.nbFinal;
    }

    public String toString() {
        return String.format("%s en base %d + %s en base %d = %s en base %d", this.nb1, this.baseGlobal, this.nb2, this.baseGlobal, this.nbFinal);
    }
}
