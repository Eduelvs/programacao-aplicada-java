import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira um numero decimal: ");
        int decimalNumber1 = scanner.nextInt();
        int decimalNumber = decimalNumber1;
        StringBuilder binaryNumber = new StringBuilder();
        
        if (decimalNumber == 0) {
            binaryNumber.append("0");
        } else {
            while (decimalNumber > 0) {
                int remainder = decimalNumber % 2;
                binaryNumber.insert(0, remainder);
                decimalNumber /= 2;
            }
        }
        
        System.out.println(decimalNumber1 + " em binario e: " + binaryNumber.toString());
        scanner.close();
    }
}
