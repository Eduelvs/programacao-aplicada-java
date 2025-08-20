import java.util.Scanner;

public class MaiusculasMinusculas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um texto: ");
        String frase = sc.nextLine();

        System.out.println("Maiúsculas: " + frase.toUpperCase());
        System.out.println("Minúsculas: " + frase.toLowerCase());

        sc.close();
    }
}
