package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input p: ");
        String p = scanner.nextLine();
        System.out.print("Input q: ");
        String q = scanner.nextLine();
        System.out.print("Input r: ");
        String r =scanner.nextLine();
        createTable(p,q,r);

    }

    public static void createTable(String p, String q, String r) {
        System.out.println("--------------------------------");
        System.out.println("| p | q | r | p ^ (q && r) |");
        System.out.println("--------------------------------");
        for (int i = 0; i < p.length(); i++) {
            String result = p.charAt(i) != '0' ^ (q.charAt(i) != '0' && r.charAt(i) != '0') ? "1" : "0";
            System.out.printf("| %s | %s | %s |       %s      |\n", p.charAt(i), q.charAt(i), r.charAt(i), result);
        }

        System.out.println("--------------------------------");
    }
}