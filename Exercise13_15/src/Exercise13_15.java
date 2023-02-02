import java.math.*;
import java.util.Scanner;

public class Exercise13_15 {
    public static void main(String[] args) {
        // Prompt the user to enter two Rational numbers
        Scanner input = new Scanner(System.in);
        System.out.print("Enter rational number1 with numerator and denominator seperated by a space: ");
        String n1 = input.next();
        String d1 = input.next();

        System.out.print("Enter rational number2 with numerator and denominator seperated by a space: ");
        String n2 = input.next();
        String d2 = input.next();

        CustomRational r1 = new CustomRational(new BigInteger(n1), new BigInteger(d1));
        CustomRational r2 = new CustomRational(new BigInteger(n2), new BigInteger(d2));

        // Display results
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        System.out.println(r2 + " is " + r2.doubleValue());
    }
}

class CustomRational extends Number implements Comparable<CustomRational> {
    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;

    public CustomRational() {}
    public CustomRational(BigInteger numerator, BigInteger denominator) {
        if (denominator.intValue() == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public void simplify() {
        BigInteger gcd = numerator.gcd(denominator);
        if (gcd.intValue() == 0) {
            return;
        }
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);
    }

    public String add(CustomRational r2) {
        CustomRational result = new CustomRational();
        result.denominator = this.denominator.multiply(r2.denominator);
        result.numerator = this.numerator.multiply(r2.denominator)
                .add(r2.numerator.multiply(this.denominator));
        result.simplify();
        return result.toString();
    }

    public String subtract(CustomRational r2) {
        CustomRational result = new CustomRational();
        result.denominator = this.denominator.multiply(r2.denominator);
        result.numerator = this.numerator.multiply(r2.denominator)
                .subtract(r2.numerator.multiply(this.denominator));
        result.simplify();
        return result.toString();
    }

    public String multiply(CustomRational r2) {
        CustomRational result = new CustomRational();
        result.numerator = this.numerator.multiply(r2.numerator);
        result.denominator = this.denominator.multiply(r2.denominator);
        result.simplify();
        return result.toString();
    }

    public String divide(CustomRational r2) {
        CustomRational result = new CustomRational();
        result.numerator = this.numerator.multiply(r2.denominator);
        result.denominator = this.denominator.multiply(r2.numerator);
        result.simplify();
        return result.toString();
    }

    @Override
    public int intValue() {
        return numerator.intValue() / denominator.intValue();
    }

    @Override
    public long longValue() {
        return numerator.longValue() / denominator.longValue();
    }

    @Override
    public float floatValue() {
        return numerator.floatValue() / denominator.floatValue();
    }

    @Override
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    @Override
    public int compareTo(CustomRational r2) {
        double first = this.doubleValue();
        double second = r2.doubleValue();
        return Double.compare(first, second);
    }

    public String toString() {
        return String.format("%s/%s", numerator.toString(), denominator.toString());
    }

}
