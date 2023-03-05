package org.example.lab4;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input n: ");
        int length = scanner.nextInt();
        Integer[] n = new Integer[length];
        for (int i = 0; i < length; i++) {
            n[i] = i + 1;
        }
        List<List<Integer>> res = permutation(n);
        System.out.println(res);
    }

    public static List<List<Integer>> permutation(Integer[] n) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.stream(n).collect(Collectors.toList()));

        int startIndex = findStartIndex(n);
        while (startIndex != -1) {
            int biggerElement = findFirstBiggerElement(n, startIndex);
            swap(n, startIndex, biggerElement);
            reverseOrder(n, startIndex + 1);
            result.add(Arrays.stream(n).collect(Collectors.toList()));
            startIndex = findStartIndex(n);
        }
        return result;
    }

    private static int findStartIndex(Integer[] n) {
        for (int i = n.length - 2; i >= 0; i--) {
            if (n[i] < n[i + 1]) return i;
        }
        return -1;
    }

    private static int findFirstBiggerElement(Integer[] n, int elementIndex) {
        for (int i = n.length - 1; i > elementIndex; i--) {
            if (n[i] > n[elementIndex]) return i;
        }
        return -1;
    }

    private static void swap(Integer[] n, int i, int j) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }

    private static void reverseOrder(Integer[] n, int l) {
        int r = n.length - 1;
        while (l < r) {
            int temp = n[l];
            n[l] = n[r];
            n[r] = temp;
            r--;
            l++;
        }
    }


}