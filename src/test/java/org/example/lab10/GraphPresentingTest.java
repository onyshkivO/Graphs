package org.example.lab10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphPresentingTest {
    @BeforeAll
    static void  initGraph() throws IOException {
        GraphPresenting.initGraph("lab10_myGraph.txt");
    }
    @Test
    void incidenceTest() throws IOException {
        String excepted ="| v\\v | v0 | v1 | v2 | v3 | v4 | v5 | v6 | v7 | v8 | v9 |  v |\n" +
                "| v0  |  0 |  6 |  ∞ |  ∞ |  ∞ |  ∞ |  1 |  ∞ |  ∞ |  ∞ |  ∞ |\n" +
                "| v1  |  6 |  0 |  1 |  ∞ |  ∞ |  2 |  ∞ |  ∞ |  ∞ |  ∞ |  ∞ |\n" +
                "| v2  |  ∞ |  1 |  0 |  3 |  4 |  ∞ |  ∞ |  ∞ |  ∞ |  ∞ |  ∞ |\n" +
                "| v3  |  ∞ |  ∞ |  3 |  0 |  ∞ |  ∞ |  ∞ |  ∞ |  ∞ |  ∞ |  4 |\n" +
                "| v4  |  ∞ |  ∞ |  4 |  ∞ |  0 |  1 |  ∞ |  2 |  ∞ |  ∞ |  ∞ |\n" +
                "| v5  |  ∞ |  2 |  ∞ |  ∞ |  1 |  0 |  2 |  ∞ |  1 |  ∞ |  ∞ |\n" +
                "| v6  |  1 |  ∞ |  ∞ |  ∞ |  ∞ |  2 |  0 |  ∞ |  1 |  3 |  ∞ |\n" +
                "| v7  |  ∞ |  ∞ |  ∞ |  ∞ |  2 |  ∞ |  ∞ |  0 |  2 |  ∞ |  2 |\n" +
                "| v8  |  ∞ |  ∞ |  ∞ |  ∞ |  ∞ |  1 |  1 |  2 |  0 |  2 |  3 |\n" +
                "| v9  |  ∞ |  ∞ |  ∞ |  ∞ |  ∞ |  ∞ |  3 |  ∞ |  2 |  0 |  4 |\n" +
                "|  v  |  ∞ |  ∞ |  ∞ |  4 |  ∞ |  ∞ |  ∞ |  2 |  3 |  4 |  0 |";
        assertEquals(excepted,GraphPresenting.weightMatrixToString());
    }


}