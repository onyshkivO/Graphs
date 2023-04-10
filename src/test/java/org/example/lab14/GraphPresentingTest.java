package org.example.lab14;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GraphPresentingTest {
    @BeforeAll
    static void  initGraph() throws IOException {
        GraphPresenting.initGraph("for14True.txt");
    }

    @Test
    void isReflexTest(){
        assertTrue(GraphPresenting.isReflex());
    }
    @Test
    void isTransitiveTest(){
        assertTrue(GraphPresenting.isTransitive());
    }
}