package org.example.lab3;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
//    public static void main(String[] args) {
//        System.out.println(permutation(9,4));
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input i: ");
        second(scanner.nextInt());
    }

    public static void second(int val) {
        int max = val+5;

        System.out.printf("| n\\k |");
        for ( int n = 1 ; n <= max ; n++ ) {
            System.out.printf(" %10d |", n);
        }
        System.out.printf(" %10s |\n", "F()");

        for ( int n = 1 ; n <= max ; n++ ) {
            System.out.printf("| %-3d |", n);
            long res = 0;
            int k=1;
            for ( ; k <= n ; k++ ) {
                long ste = sterling2(n, k);
                res+=ste;
                System.out.printf(" %10s |" , ste);
            }

            for (int i=0;i<max-k+1;i++){
                System.out.printf(" %10s |","");
            }

            System.out.printf(" %10d |",res);
            System.out.printf("%n");
        }

    }

    private static Map<String, Long> COMPUTED = new HashMap<>();

    private static final long sterling2(int n, int k) {
        String key = n + "," + k;
        if ( COMPUTED.containsKey(key) ) {
            return COMPUTED.get(key);
        }
        if ( n == 0 && k == 0 ) {
            return 1;
        }
        if ( (n > 0 && k == 0) || (n == 0 && k > 0) ) {
            return 0;
        }
        if ( n == k ) {
            return 1;
        }
        if ( k > n ) {
            return 0;
        }
        long result = k*sterling2(n-1, k) + (sterling2(n-1, k-1));
        COMPUTED.put(key, result);
        return result;
    }






//    public static void second(int val) {
//        int max = val+5;
//
//        System.out.printf("| n\\k |");
//        for ( int n = 1 ; n <= max ; n++ ) {
//            System.out.printf(" %10d |", n);
//        }
//        System.out.printf(" %10s |\n", "F()");
//
//        for ( int n = 1 ; n <= max ; n++ ) {
//            System.out.printf("| %-3d |", n);
//            BigInteger res = BigInteger.ZERO;
//            int k=1;
//            for ( ; k <= n ; k++ ) {
//                BigInteger ste = sterling2(n, k);
//                res= res.add(ste);
//                System.out.printf(" %10s |" , ste);
//            }
//
//            for (int i=0;i<max-k+1;i++){
//                System.out.printf(" %10s |","");
//            }
//
//            System.out.printf(" %10d |",res);
//            System.out.printf("%n");
//        }
//
//    }
//
//    private static Map<String, BigInteger> COMPUTED = new HashMap<>();
//
//    private static final BigInteger sterling2(int n, int k) {
//        String key = n + "," + k;
//        if ( COMPUTED.containsKey(key) ) {
//            return COMPUTED.get(key);
//        }
//        if ( n == 0 && k == 0 ) {
//            return BigInteger.valueOf(1);
//        }
//        if ( (n > 0 && k == 0) || (n == 0 && k > 0) ) {
//            return BigInteger.ZERO;
//        }
//        if ( n == k ) {
//            return BigInteger.valueOf(1);
//        }
//        if ( k > n ) {
//            return BigInteger.ZERO;
//        }
//        BigInteger result = BigInteger.valueOf(k).multiply(sterling2(n-1, k)).add(sterling2(n-1, k-1));
//        COMPUTED.put(key, result);
//        return result;
//    }
//


    public static int permutation(int n, int r){
        return getFactorial(n)/getFactorial(n-r);
    }

    private static int getFactorial(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }
}
