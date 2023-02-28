package org.example.lab3;

public class Solution {
    public static void main(String[] args) {
        System.out.println(permutation(9,4));
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
