package tests;

public class Calculator {

    public double sum(double x, double y) {
        double a = x + y;
        System.out.println("sum is: " + a);
        return a;
    }

    public double minus(double x, double y) {
        double a = x - y;
        System.out.println("difference is: " + a);
        return a;
    }

    public double multiply(double x, double y) {
        double a = x * y;
        System.out.println("product is: " + a);
        return a;
    }

    public double divide(double x, double y) {
        if (y != 0) {
            double result = x / y;
            System.out.println("quotient is: " + result);
            return result;
        } else {
            System.out.println("Делить на ноль нельзя!");
            return 0;
        }
    }
}
