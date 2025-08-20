import java.util.Scanner;

public class InverterFrase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite uma frase: ");
        String frase = sc.nextLine();

        String[] tokens = frase.split("\\s+");
        StringBuilder invertida = new StringBuilder();

        for (int i = tokens.length - 1; i >= 0; i--) {
            invertida.append(tokens[i]).append(" ");
        }

        System.out.println("Frase invertida:");
        System.out.println(invertida.toString().trim());
        sc.close();
    }
}
