package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        createTable();

    }

    public static void createTable() {
        System.out.println("--------------------------------");
        System.out.println("| p | q | r | p ^ (q && r) |");
        System.out.println("--------------------------------");
        for (int p1=0;p1<2;p1++){
            for (int q1=0;q1<2;q1++){
                for (int r1=0;r1<2;r1++){
                    String result = p1!= 0 ^ (q1 != 0 && r1 != 0) ? "1" : "0";
                    System.out.printf("| %d | %d | %d |       %s      |\n", p1, q1, r1, result);
                }

            }
        }
        System.out.println("--------------------------------");
    }
}