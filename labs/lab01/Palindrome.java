import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira uma palavra de 5 caracteres: ");
        String palavra = scanner.nextLine();
        if (palavra.length() != 5) {
            System.out.println("A palavra deve ter exatamente 5 caracteres.");
        } else {
            String palavraInvertida = new StringBuilder(palavra).reverse().toString();
            if (palavra.equalsIgnoreCase(palavraInvertida)) {
                System.out.println("A palavra é um palíndromo.");
            } else {
                System.out.println("A palavra não é um palíndromo.");
            }
        }
        
        scanner.close();
    }
}
