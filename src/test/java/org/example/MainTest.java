package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MainTest {
    protected static final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeAll
    static void setOut() {
        System.setOut(new PrintStream(output));
    }

    @BeforeEach
    void resetOutput() {
        output.reset();
    }

    @Test
    void firstTest() {
        ByteArrayInputStream in = new ByteArrayInputStream("true false".getBytes());
        System.setIn(in);
        Main.first();

        String actual = output.toString().replaceAll("\n", "").replaceAll("\r", "");


        String expected = "Input p value: Input p value: p and q: false" +
                "p or q: true" +
                "p xor q: true" +
                "p implications(p->q) q: false" +
                "p implications(q->p) q: true" +
                "p equivalence q: false";
        assertEquals(expected, actual);
    }

    //1100011100
    //1010101110
    @Test
    void secondTest() {
        ByteArrayInputStream in = new ByteArrayInputStream("1100011100\n1010101110".getBytes());
        System.setIn(in);
        Main.second();
        String actual = output.toString().replaceAll("\n", "").replaceAll("\r", "");


        String expected = "Input a: Input b: [1, 1, 1, 0, 1, 1, 1, 1, 1, 0]" +
                "[1, 0, 0, 0, 0, 0, 1, 1, 0, 0]" +
                "[0, 1, 1, 0, 1, 1, 0, 0, 1, 0]";
        assertEquals(expected, actual);
    }
}
