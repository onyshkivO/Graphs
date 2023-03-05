package org.example.lab4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Tests {
    @Test
    void permutationTest() {
        Integer[] array = new Integer[]{1, 2, 3};
        List<List<Integer>> actual = Solution.permutation(array);
        List<List<Integer>> expected = List.of(List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3), List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1));
        assertEquals(expected, actual);

    }

    @Test
    void combinationTest() {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5};
        List<List<Integer>> actual = Solution2.combination(array, 3);
        List<List<Integer>> expected = List.of(List.of(1, 2, 3), List.of(1, 2, 4), List.of(1, 2, 5), List.of(1, 3, 4), List.of(1, 3, 5)
                , List.of(1, 4, 5), List.of(2, 3, 4), List.of(2, 3, 5), List.of(2, 4, 5), List.of(3, 4, 5));
        assertEquals(expected, actual);
    }
}