package OtherProjects.src.hust.soict.cybersec.oopLab01;

import java.util.Scanner;

public class AddTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first row and first col: ");
        int row1 = scanner.nextInt();
        int col1 = scanner.nextInt();
        System.out.println("Enter first matrix: ");
        int[][] matrix1 = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Enter second row and second col: ");
        int row2 = scanner.nextInt();
        int col2 = scanner.nextInt();
        System.out.println("Enter second matrix: ");
        int[][] matrix2 = new int[row2][col2];
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }
        if (row1 != row2 || col1 != col2) {
            System.out.println("Matrices cannot be added");
            scanner.close();
            System.exit(0);
        }
        int[][] sum = new int[row1][col1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("Sum of matrices: ");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
