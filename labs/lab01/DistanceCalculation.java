import java.util.Scanner;

public class DistanceCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira o Angulo em graus: ");
        double a = scanner.nextDouble();
        System.out.print("Insira a Velocidade em m/s: ");
        double v = scanner.nextDouble();
        double g = 9.81;
        double radians = Math.toRadians(a);
        double d = (Math.pow(v, 2) * Math.sin(2 * radians)) / g;
        System.out.printf("A distancia maxima atingida e: %.2f metros%n", d);
    }
}
