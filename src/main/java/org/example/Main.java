package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        first();
        second();
    }


    public static void first() {
        Scanner in = new Scanner(System.in);

        System.out.print("Input p value: ");
        boolean p = in.nextBoolean();
        System.out.print("Input p value: ");
        boolean q = in.nextBoolean();

        boolean implicationsPToQ = !p || q;
        boolean implicationsQToP = !q || p;

        System.out.println("p and q: " + (p && q));
        System.out.println("p or q: " + (p || q));
        System.out.println("p xor q: " + (p ^ q));
        System.out.println("p implications(p->q) q: " + implicationsPToQ);
        System.out.println("p implications(q->p) q: " + implicationsQToP);
        System.out.println("p equivalence q: " + (implicationsPToQ && implicationsQToP));
    }

    public static void second() {
        Scanner in = new Scanner(System.in);

        System.out.print("Input a: ");
        String a = in.nextLine();
        System.out.print("Input b: ");
        String b = in.nextLine();

        int N = a.length();
        int[] x = new int[N];
        int[] y = new int[N];
        int[] z = new int[N];

        for (int i = 0; i < N; i++) {
            x[i] = a.charAt(i) != '0' || b.charAt(i) != '0' ? 1 : 0;
            y[i] = a.charAt(i) != '0' && b.charAt(i) != '0' ? 1 : 0;
            z[i] = a.charAt(i) != '0' ^ b.charAt(i) != '0' ? 1 : 0;
        }

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
        System.out.println(Arrays.toString(z));


    }

}
