package lab01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DaysInMonth {
    private static final Map<String, Integer> monthMap = new HashMap<>();
    private static final int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    static {
        monthMap.put("january", 1);
        monthMap.put("jan.", 1);
        monthMap.put("jan", 1);
        monthMap.put("1", 1);
        monthMap.put("february", 2);
        monthMap.put("feb.", 2);
        monthMap.put("feb", 2);
        monthMap.put("2", 2);
        monthMap.put("march", 3);
        monthMap.put("mar.", 3);
        monthMap.put("mar", 3);
        monthMap.put("3", 3);
        monthMap.put("april", 4);
        monthMap.put("apr.", 4);
        monthMap.put("apr", 4);
        monthMap.put("4", 4);
        monthMap.put("may", 5);
        monthMap.put("5", 5);
        monthMap.put("june", 6);
        monthMap.put("jun", 6);
        monthMap.put("6", 6);
        monthMap.put("july", 7);
        monthMap.put("jul", 7);
        monthMap.put("7", 7);
        monthMap.put("august", 8);
        monthMap.put("aug.", 8);
        monthMap.put("aug", 8);
        monthMap.put("8", 8);
        monthMap.put("september", 9);
        monthMap.put("sep.", 9);
        monthMap.put("sep", 9);
        monthMap.put("9", 9);
        monthMap.put("october", 10);
        monthMap.put("oct.", 10);
        monthMap.put("oct", 10);
        monthMap.put("10", 10);
        monthMap.put("november", 11);
        monthMap.put("nov.", 11);
        monthMap.put("nov", 11);
        monthMap.put("11", 11);
        monthMap.put("december", 12);
        monthMap.put("dec.", 12);
        monthMap.put("dec", 12);
        monthMap.put("12", 12);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = 0;
        int month = 0;
        boolean input = false;

        while (!input) {
            System.out.print("Enter month: ");
            String monthInput = scanner.next().toLowerCase();
            System.out.print("Enter year: ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year >= 0) {
                    month = monthMap.getOrDefault(monthInput, -1);
                    if (month != -1) {
                        input = true;
                    } else {
                        System.out.println("Invalid month");
                    }
                } else {
                    System.out.println("Invalid year");
                }
            } else {
                System.out.println("Invalid year");
                scanner.next();
            }
        }

        int days = getDaysInMonth(month, year);
        System.out.println("Number of days: " + days);
        scanner.close();
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static int getDaysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month - 1];
    }
}