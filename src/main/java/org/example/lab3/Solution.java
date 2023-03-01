package org.example.lab3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
private static final Map<String, Long> map = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(permutation(9,4));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input i: ");
        createTable(scanner.nextInt());
    }
    public static void createTable(int val) {
        int max = val+5;

        System.out.print("| n\\k |");
        for ( int n = 1 ; n <= max ; n++ ) {
            System.out.printf(" %10d |", n);
        }
        System.out.printf(" %10s |\n", "F()");

        for ( int n = 1 ; n <= max ; n++ ) {
            System.out.printf("| %-3d |", n);
            long res = 0;
            int k=1;
            for ( ; k <= n ; k++ ) {
                long ste = sterling(n, k);
                res+=ste;
                System.out.printf(" %10s |" , ste);
            }

            for (int i=0;i<max-k+1;i++){
                System.out.printf(" %10s |","");
            }

            System.out.printf(" %10d |\n",res);
        }

    }
    private static long sterling(int n, int k) {
        String key = n + "," + k;
        if ( map.containsKey(key) ) {
            return map.get(key);
        }
        if ( n == k) {
            return 1;
        }
        if ( (n > 0 && k == 0) ||(k > n )) {
            return 0;
        }
        long result = (sterling(n-1, k-1))+k*sterling(n-1, k);
        map.put(key, result);
        return result;
    }
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
