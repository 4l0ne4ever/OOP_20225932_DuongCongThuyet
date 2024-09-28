package lab01;

import java.util.Scanner;
import java.util.Stack;
import java.lang.Math;

public class LargestBlackRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] A = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = scanner.nextInt();
            }
        }
        int[] heights = new int[m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            max = Math.max(max, largestRectangleArea(heights));
        }
        System.out.println(max);
        scanner.close();
    }

    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int[] maxHeight = new int[heights.length + 1];
        System.arraycopy(heights, 0, maxHeight, 0, heights.length);
        maxHeight[heights.length] = 0;
        for (int i = 0; i < maxHeight.length; i++) {
            while (!stack.isEmpty() && maxHeight[i] < maxHeight[stack.peek()]) {
                int h = maxHeight[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}
