package org.example.lab6;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GraphPresentingTest {
    @BeforeAll
    static void  initGraph() throws IOException {
        GraphPresenting.initGraph("graph_01_1.txt");
    }
    @Test
    void incidenceTest() throws IOException {
        String excepted ="| v\\e | e1 | e2 | e3 | e4 | e5 | e6 | e7 | e8 | e9 | e10| e11| e12| e13| e14| e15| e16| e17| e18| e19| e20| e21|\n" +
                "| v1  | -1 |  1 | -1 |  1 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |\n" +
                "| v2  |  0 |  0 |  0 |  0 |  2 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 | -1 |  1 | -1 |  1 |  0 |  0 |  0 |  0 |\n" +
                "| v3  |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  1 | -1 | -1 |  1 |  0 |  0 |\n" +
                "| v4  |  0 |  0 |  0 |  0 |  0 | -1 |  1 | -1 |  1 | -1 |  1 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |\n" +
                "| v5  |  1 | -1 |  0 |  0 |  0 |  1 | -1 |  0 |  0 |  0 |  0 |  0 |  0 |  1 | -1 |  0 |  0 |  0 |  0 |  0 |  0 |\n" +
                "| v6  |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  1 | -1 | -1 |  1 |\n" +
                "| v7  |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  1 | -1 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |\n" +
                "| v8  |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  1 | -1 | -1 |  1 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |\n" +
                "| v9  |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  1 | -1 |\n" +
                "| v10 |  0 |  0 |  1 | -1 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  1 | -1 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |  0 |";
        assertEquals(excepted,GraphPresenting.incidenceMatrixToString());
    }

    @Test
    void adjacencyTest(){
        String excepted ="| v\\v | v1 | v2 | v3 | v4 | v5 | v6 | v7 | v8 | v9 | v10|\n" +
                "| v1  |  0 |  0 |  0 |  0 |  1 |  0 |  0 |  0 |  0 |  1 |\n" +
                "| v2  |  0 |  1 |  1 |  0 |  1 |  0 |  0 |  0 |  0 |  0 |\n" +
                "| v3  |  0 |  1 |  0 |  0 |  0 |  1 |  0 |  0 |  0 |  0 |\n" +
                "| v4  |  0 |  0 |  0 |  0 |  1 |  0 |  1 |  1 |  0 |  0 |\n" +
                "| v5  |  1 |  1 |  0 |  1 |  0 |  0 |  0 |  0 |  0 |  0 |\n" +
                "| v6  |  0 |  0 |  1 |  0 |  0 |  0 |  0 |  0 |  1 |  0 |\n" +
                "| v7  |  0 |  0 |  0 |  1 |  0 |  0 |  0 |  0 |  0 |  0 |\n" +
                "| v8  |  0 |  0 |  0 |  1 |  0 |  0 |  0 |  0 |  0 |  1 |\n" +
                "| v9  |  0 |  0 |  0 |  0 |  0 |  1 |  0 |  0 |  0 |  0 |\n" +
                "| v10 |  1 |  0 |  0 |  0 |  0 |  0 |  0 |  1 |  0 |  0 |";
        assertEquals(excepted,GraphPresenting.adjacencyMatrixToString());
    }

}