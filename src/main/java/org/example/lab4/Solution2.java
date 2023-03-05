package org.example.lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {
    public static void main(String[] args) {
        Integer[] n = new Integer[]{1, 2, 3, 4, 5};
        List<List<Integer>> list = combination(n, 3);
        System.out.println(list);
    }

    public static List<List<Integer>> combination(Integer[] n, int r) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.stream(n).limit(r).collect(Collectors.toList()));
        Integer[] range = result.get(0).toArray(new Integer[0]);
        System.out.println(result.get(0).toString());
        for (int i = 2; i <= factorial(n.length) / (factorial(r) * factorial(n.length - r)) + 1; i++) {
            for (int j = range.length - 1; j >= 0; j--) {
                if (range[j] != n.length - r + j + 1) {
                    range[j] += 1;
                    for (int k = j + 1; k < r; k++) {
                        range[k] = range[j] + k - j;
                    }
                    result.add(Arrays.stream(range).collect(Collectors.toList()));
                    break;
                }
            }
        }
        return result;

    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
