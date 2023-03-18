package org.example.lab8_9;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GraphPresentingTest {

    protected static final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeAll
    static void setOut() {
        System.setOut(new PrintStream(output));
    }

    @BeforeEach
    void resetOutput() {
        output.reset();
    }






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

    @Test
    void BFSTest() throws IOException {
        GraphPresenting.initGraph("graph_01_1.txt");
        GraphPresenting.BFS(1);

        String actual = output.toString();
        String expected = "| vertex | BFS number | queue \n" +
                "|     v1 |          1 | [1]\n" +
                "|     v5 |          2 | [1, 5]\n" +
                "|    v10 |          3 | [1, 5, 10]\n" +
                "|        |            | [5, 10]\n" +
                "|     v2 |          4 | [5, 10, 2]\n" +
                "|     v4 |          5 | [5, 10, 2, 4]\n" +
                "|        |            | [10, 2, 4]\n" +
                "|     v8 |          6 | [10, 2, 4, 8]\n" +
                "|        |            | [2, 4, 8]\n" +
                "|     v3 |          7 | [2, 4, 8, 3]\n" +
                "|        |            | [4, 8, 3]\n" +
                "|     v7 |          8 | [4, 8, 3, 7]\n" +
                "|        |            | [8, 3, 7]\n" +
                "|        |            | [3, 7]\n" +
                "|     v6 |          9 | [3, 7, 6]\n" +
                "|        |            | [7, 6]\n" +
                "|        |            | [6]\n" +
                "|     v9 |         10 | [6, 9]\n" +
                "|        |            | [9]\n" +
                "|        |            | []\n";
        assertEquals(expected,actual);
    }

    @Test
    void DFSTest() throws IOException {
        GraphPresenting.initGraph("graph_01_1.txt");
        GraphPresenting.DFS(1);

        String actual = output.toString();
        String expected = "| vertex | BFS number | stack \n" +
                "|     v1 |          1 | [1]\n" +
                "|     v5 |          2 | [1, 5]\n" +
                "|     v2 |          3 | [1, 5, 2]\n" +
                "|     v3 |          4 | [1, 5, 2, 3]\n" +
                "|     v6 |          5 | [1, 5, 2, 3, 6]\n" +
                "|     v9 |          6 | [1, 5, 2, 3, 6, 9]\n" +
                "|        |            | [1, 5, 2, 3, 6]\n" +
                "|        |            | [1, 5, 2, 3]\n" +
                "|        |            | [1, 5, 2]\n" +
                "|        |            | [1, 5]\n" +
                "|     v4 |          7 | [1, 5, 4]\n" +
                "|     v7 |          8 | [1, 5, 4, 7]\n" +
                "|        |            | [1, 5, 4]\n" +
                "|     v8 |          9 | [1, 5, 4, 8]\n" +
                "|    v10 |         10 | [1, 5, 4, 8, 10]\n" +
                "|        |            | [1, 5, 4, 8]\n" +
                "|        |            | [1, 5, 4]\n" +
                "|        |            | [1, 5]\n" +
                "|        |            | [1]\n" +
                "|        |            | []\n";
        assertEquals(expected,actual);
    }



}