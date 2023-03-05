package org.example.lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input n: ");
        int range = scanner.nextInt();
        System.out.print("Input r: ");
        int r = scanner.nextInt();
        Integer[] n = new Integer[range];
        for (int i = 0; i < range; i++) {
            n[i] = i + 1;
        }
        List<List<Integer>> list = combination(n, r);
        System.out.println(list);
    }

    public static List<List<Integer>> combination(Integer[] n, int r) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.stream(n).limit(r).collect(Collectors.toList()));
        Integer[] range = result.get(0).toArray(new Integer[0]);

        for (int i = 2; i <= factorial(n.length) / (factorial(r) * factorial(n.length - r)); i++) {
            int j = range.length - 1;
            while (j >= 0) {
                if (range[j] <= n.length - r + j) {
                    range[j] += 1;
                    break;
                }
                j--;
            }
            increase(range, j, r);
            result.add(Arrays.stream(range).collect(Collectors.toList()));
        }
        return result;
    }


    private static void increase(Integer[] range, int j, int r) {
        for (int k = j + 1; k < r; k++) {
            range[k] = range[j] + k - j;
        }
    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
