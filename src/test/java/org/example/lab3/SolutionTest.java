package org.example.lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void permutationTest() {
        assertEquals(3024,Solution.permutation(9,4));
    }
}