package org.example.lab12;

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
    void distanceTest() throws IOException {
        String excepted ="\n" +
                "v0  -> v1  | 5  \n" +
                "v0  -> v2  | 6  \n" +
                "v0  -> v3  | 9  \n" +
                "v0  -> v4  | 4  \n" +
                "v0  -> v5  | 3  \n" +
                "v0  -> v6  | 1  \n" +
                "v0  -> v7  | 4  \n" +
                "v0  -> v8  | 2  \n" +
                "v0  -> v9  | 4  \n" +
                "v0  -> v   | 5  \n";
        GraphPresenting.deykstry("v0");
        assertEquals(excepted,GraphPresenting.printDistance("v0"));
    }


}