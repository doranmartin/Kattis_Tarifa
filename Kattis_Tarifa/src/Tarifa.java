import java.util.Scanner;

public class Tarifa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numMegaBytes = input.nextInt();
        int numMonths = input.nextInt();
        int leftover = numMegaBytes;
        int monthUsage;
        for (int i = 0; i < numMonths; i++) {
            leftover += numMegaBytes - input.nextInt();
        }
        System.out.println(leftover);
    }
}
