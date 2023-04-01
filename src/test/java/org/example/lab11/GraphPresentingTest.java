package org.example.lab11;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphPresentingTest {
    @BeforeAll
    static void  initGraph() throws IOException {
        GraphPresenting.initGraph("lab10_myGraph2.txt");
    }
    @Test
    void incidenceTest() throws IOException {

        String excepted ="| v\\v | v0 | v1 | v2 | v3 | v4 | v5 | v6 | v7 | v8 | v9 |  v |\n" +
                "| v0  |  0 |  5 |  6 |  9 |  4 |  3 |  1 |  4 |  2 |  4 |  5 |\n" +
                "| v1  |  5 |  0 |  1 |  4 |  3 |  2 |  4 |  5 |  3 |  5 |  6 |\n" +
                "| v2  |  6 |  1 |  0 |  3 |  4 |  3 |  5 |  6 |  4 |  6 |  7 |\n" +
                "| v3  |  9 |  4 |  3 |  0 |  7 |  6 |  8 |  6 |  7 |  8 |  4 |\n" +
                "| v4  |  4 |  3 |  4 |  7 |  0 |  1 |  3 |  2 |  2 |  4 |  4 |\n" +
                "| v5  |  3 |  2 |  3 |  6 |  1 |  0 |  2 |  3 |  1 |  3 |  4 |\n" +
                "| v6  |  1 |  4 |  5 |  8 |  3 |  2 |  0 |  3 |  1 |  3 |  4 |\n" +
                "| v7  |  4 |  5 |  6 |  6 |  2 |  3 |  3 |  0 |  2 |  4 |  2 |\n" +
                "| v8  |  2 |  3 |  4 |  7 |  2 |  1 |  1 |  2 |  0 |  2 |  3 |\n" +
                "| v9  |  4 |  5 |  6 |  8 |  4 |  3 |  3 |  4 |  2 |  0 |  4 |\n" +
                "|  v  |  5 |  6 |  7 |  4 |  4 |  4 |  4 |  2 |  3 |  4 |  0 |";
        GraphPresenting.floyd();
        assertEquals(excepted,GraphPresenting.minLengthMatrixToString());
    }


}