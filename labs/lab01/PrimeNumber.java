import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantos Numeros primos voce quer ver? ");
        int n = scanner.nextInt();
        int count = 0;
        int num = 2; // O primeiro numero primo
        System.out.println("Os primeiros " + n + " numeros primos sao:");
        while (count < n) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(num + " ");
                count++;
            }
            num++;
        }
        System.out.println();
        scanner.close();
    }
    
}
