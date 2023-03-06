package org.example.lab5;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input A(3 values): ");
        String A = scanner.nextLine();
        System.out.print("Input B(3 values): ");
        String B = scanner.nextLine();
        System.out.print("Input C(2 values): ");
        String C = scanner.nextLine();
        String[] production = production(A, C, A);
        System.out.println(Arrays.toString(production));
    }

    public static String[] production(String A, String B, String C) {
        int length = A.length() * B.length() * C.length();
        String[] result = new String[length];
        int counter = 0;
        for (int i = 0; i < A.length() ; i++) {
            for (int j = 0; j < B.length() ; j++) {
                for (int k = 0; k < C.length() ; k++) {
                    result[counter++] = String.valueOf(A.charAt(i)) + B.charAt(j) + C.charAt(k);
                }
            }
        }
        return result;
    }


}
