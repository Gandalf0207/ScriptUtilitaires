import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in); //.useLocale(Locale.US);
    public static PrintStream output = System.out;

    public static void main(String[] args) {
        // conversion de base
        //conversionBaseSetup();

        // addition de meme base
        additionDeMemeBase();
    }

    public static void additionDeMemeBase() {
        int baseGlobal = askInt("Base des nombres ? : ");
        String nb1 = getNombre();
        String nb2 = getNombre();

        AdditionDeBases item = new AdditionDeBases(nb1, nb2, baseGlobal);
        item.addition();
        output.println(item);
    }

    public static void conversionBaseSetup() {
        //get nombre
        String nb = getNombre();
        int baseEntre = askInt("Saisir la base du nombre : ");
        int baseSortie = askInt("Saisir la base de sortie : ");

        ConversionsDeBases item = new ConversionsDeBases(nb, baseEntre, baseSortie);
        item.Convertir();
        output.println(item);
    }

    /**
     * Fonction permettant de demander un nombre entier positif stric à l'utilisateur
     *
     * @return valeur entière positive stricte
     *
     */
    public static String getNombre() {
        String nb;
        do {
            try {
                output.print("Saisir un nombre entier positif : ");
                nb = input.nextLine();
            } catch (Exception e) {
                output.println("Saisie incorrecte");
                nb = "";
            }
        } while (nb.equalsIgnoreCase("")); // check qu'il n'y ait pas de caractère interdit

        return nb;
    }


    public static int askInt(String text) {
        int nb;
        do {
            try {
                output.print(text);
                nb = input.nextInt();
            } catch (Exception e) {
                output.println("Saisie incorrecte");
                nb = -1;
            }
        } while (nb <= 0);
        return nb;
    }
}


