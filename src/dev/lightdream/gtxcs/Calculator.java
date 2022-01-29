package dev.lightdream.gtxcs;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:");
        String op = scanner.nextLine();
        switch (op.toLowerCase()) {
            case "add":
                System.out.println("Enter two integers:");
                try {
                    Integer add_a = scanner.nextInt();
                    Integer add_b = scanner.nextInt();
                    System.out.println("Answer: " + (add_a + add_b));
                } catch (Exception e) {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            case "subtract":
                System.out.println("Enter two integers:");
                try {
                    Integer sub_a = scanner.nextInt();
                    Integer sub_b = scanner.nextInt();
                    System.out.println("Answer: " + (sub_a - sub_b));
                } catch (Exception e) {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            case "multiply":
                System.out.println("Enter two doubles:");
                try {
                    Double mul_a = scanner.nextDouble();
                    Double mul_b = scanner.nextDouble();
                    System.out.printf("Answer: %.2f", mul_a * mul_b);
                } catch (Exception e) {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            case "divide":
                System.out.println("Enter two doubles:");
                try {
                    Double div_a = scanner.nextDouble();
                    //noinspection WrapperTypeMayBePrimitive
                    Double div_b = scanner.nextDouble();
                    if (div_b == 0.0) {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
                    System.out.printf("Answer: %.2f", div_a / div_b);
                } catch (Exception e) {
                    System.out.println("Invalid input entered. Terminating...");
                }

                break;
            case "alphabetize":
                System.out.println("Enter two words:");
                String al_a = scanner.next();
                String al_b = scanner.next();
                int response = stringCmp(al_a, al_b);
                if (response == 1) {
                    System.out.println("Answer: " + al_a + " comes before " + al_b + " alphabetically.");
                } else if (response == -1) {
                    System.out.println("Answer: " + al_b + " comes before " + al_a + " alphabetically.");
                } else {
                    System.out.println("Answer: Chicken or Egg.");
                }
                break;
            default:
                System.out.println("Invalid input entered. Terminating...");
                break;
        }


    }

    public static int stringCmp(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        for (int i = 0; i < Math.min(s1.toCharArray().length, s2.toCharArray().length); i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return 1;
            }
            if (s1.charAt(i) > s2.charAt(i)) {
                return -1;
            }
        }
        return 0;
    }
}