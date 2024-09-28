package week1;

import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name? ");
        String strName = scanner.nextLine();
        System.out.println("How old are your? ");
        int age = scanner.nextInt();
        System.out.println("How tall are you (m)? ");
        double height = scanner.nextDouble();
        System.out.println("Mrs/Ms. " + strName + ", " + age + " years old. " + "Your height is: " + height + "m.");
        scanner.close();
        System.exit(0);
    }
}
