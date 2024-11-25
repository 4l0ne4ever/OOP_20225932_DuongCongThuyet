package OtherProjects.src.hust.soict.cybersec.oopLab01;

import java.util.Scanner;

public class EquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the type of equation to solve:");
        System.out.println("1. First-degree equation with one variable");
        System.out.println("2. System of first-degree equations with two variables");
        System.out.println("3. Second-degree equation with one variable");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                solveLinearEquation(scanner);
                break;
            case 2:
                solveLinearSystem(scanner);
                break;
            case 3:
                solveQuadraticEquation(scanner);
                break;
            default:
                System.out.println("Invalid choice.");
        }
        scanner.close();
    }

    private static void solveLinearEquation(Scanner scanner) {
        System.out.println("Solving ax + b = 0");
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();

        if (a == 0) {
            System.out.println("a cannot be 0.");
        } else {
            double x = -b / a;
            System.out.println("The solution is x = " + x);
        }
    }

    private static void solveLinearSystem(Scanner scanner) {
        System.out.println("Solving system of equations:");
        System.out.println("a11 * x1 + a12 * x2 = b1");
        System.out.println("a21 * x1 + a22 * x2 = b2");

        System.out.print("Enter a11: ");
        double a11 = scanner.nextDouble();
        System.out.print("Enter a12: ");
        double a12 = scanner.nextDouble();
        System.out.print("Enter a21: ");
        double a21 = scanner.nextDouble();
        System.out.print("Enter a22: ");
        double a22 = scanner.nextDouble();
        System.out.print("Enter b1: ");
        double b1 = scanner.nextDouble();
        System.out.print("Enter b2: ");
        double b2 = scanner.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("The system has infinitely many solutions.");
            } else {
                System.out.println("The system has no solution.");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("The solution is x1 = " + x1 + ", x2 = " + x2);
        }
    }

    private static void solveQuadraticEquation(Scanner scanner) {
        System.out.println("Solving ax^2 + bx + c = 0");
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();

        if (a == 0) {
            System.out.println("a cannot be 0.");
        } else {
            double discriminant = b * b - 4 * a * c;
            if (discriminant > 0) {
                double x1 = (-b + java.lang.Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - java.lang.Math.sqrt(discriminant)) / (2 * a);
                System.out.println("The solutions are x1 = " + x1 + ", x2 = " + x2);
            } else if (discriminant == 0) {
                double x = -b / (2 * a);
                System.out.println("The solution is x = " + x);
            } else {
                System.out.println("The equation has no real roots.");
            }
        }
    }
}