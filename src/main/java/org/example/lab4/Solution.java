package org.example.lab4;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        Integer[] n = new Integer[]{1,2,3,4};
        result.add(new ArrayList<>(Arrays.asList(n)));


        for (int i = 0; i < factorialUsingForLoop(n.length) - 1; i++) {

            Queue<Integer> queue = new PriorityQueue<>();
            Queue<Integer> queue2 = new PriorityQueue<>();
            queue.add(n[n.length - 1]);
            queue2.add(n[n.length - 1]);

            for (int j = n.length - 2; j >= 0; j--) {
                if (n[j] < n[j + 1]) {

                    List<Integer> temp = new ArrayList<>(Arrays.asList(n).subList(0, j));
                    while (!queue.isEmpty() && queue.peek() < n[j]) {
                        queue.poll();
                    }
                    temp.add(queue.peek());
                    queue2.remove(queue.poll());
                    queue2.add(n[j]);
                    while (!queue2.isEmpty()) {
                        temp.add(queue2.poll());
                    }
                    result.add(temp);
                    for (int t = 0; t < n.length; t++) {
                        n[t] = temp.get(t);
                    }
                    break;

                } else {
                    queue.add(n[j]);
                    queue2.add(n[j]);
                }

            }

        }
        System.out.println(result);
    }

    public static int factorialUsingForLoop(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}