import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Largura: ");
        int largura = scanner.nextInt();
        System.out.print("Altura: ");
        int altura = scanner.nextInt();

        scanner.nextLine(); // Limpa o buffer após nextInt()

        System.out.println("Digite o Caractere de Borda:");
        char borda = scanner.nextLine().charAt(0);

        System.out.println("Digite o Preenchimento (Caso Vazio Pressione Enter):");
        String linhaPreenchimento = scanner.nextLine();
        char preenchimento = linhaPreenchimento.isEmpty() ? ' ' : linhaPreenchimento.charAt(0);

        // Desenha o retângulo
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                if (i == 0 || i == altura - 1 || j == 0 || j == largura - 1) {
                    System.out.print(borda);
                } else {
                    System.out.print(preenchimento);
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}