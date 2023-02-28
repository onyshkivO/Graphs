package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    protected static final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeAll
    static void setOut() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void createTable(){
        Main.createTable("1100011100","1010101110","1100110000");

        String actual = output.toString().replaceAll("\n", "").replaceAll("\r", "");


        String expected = "--------------------------------" +
                "| p | q | r | p ^ (q && r) |" +
                "--------------------------------" +
                "| 1 | 1 | 1 |       0      |" +
                "| 1 | 0 | 1 |       1      |" +
                "| 0 | 1 | 0 |       0      |" +
                "| 0 | 0 | 0 |       0      |" +
                "| 0 | 1 | 1 |       1      |" +
                "| 1 | 0 | 1 |       1      |" +
                "| 1 | 1 | 0 |       1      |" +
                "| 1 | 1 | 0 |       1      |" +
                "| 0 | 1 | 0 |       0      |" +
                "| 0 | 0 | 0 |       0      |" +
                "--------------------------------";
        assertEquals(expected, actual);

    }

}