package org.example.lab5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTests {
    protected static final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeAll
    static void setOut() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void solution1Test() {
        String[] excepted = new String[]{"a1a", "a1b", "a1c", "a2a", "a2b", "a2c", "b1a", "b1b", "b1c", "b2a", "b2b",
                "b2c", "c1a", "c1b", "c1c", "c2a", "c2b", "c2c"};
        String[] actual = Solution1.production("abc", "12", "abc");

        assertArrayEquals(excepted, actual);
    }


    @Test
    void solution2Test() {

        String excepted = "U:123456789" +
                "A:            [1, 0, 0, 0, 1, 1, 0, 1, 0]      1568" +
                "B:            [0, 0, 0, 0, 1, 1, 1, 0, 0]       567" +
                "notA:         [0, 1, 1, 1, 0, 0, 1, 0, 1]     23479" +
                "aAndB:        [0, 0, 0, 0, 1, 1, 0, 0, 0]        56" +
                "aOrB:         [1, 0, 0, 0, 1, 1, 1, 1, 0]     15678" +
                "aDifferenceB: [1, 0, 0, 0, 0, 0, 0, 1, 0]        18" +
                "aXorB:        [1, 0, 0, 0, 0, 0, 1, 1, 0]       178";
        int[] A = new int[]{1, 0, 0, 0, 1, 1, 0, 1, 0};
        int[] B = new int[]{0, 0, 0, 0, 1, 1, 1, 0, 0};
        String U = "123456789";
        Solution2.determine(A, B, U);
        String actual = output.toString().replaceAll("\r", "").replaceAll("\n", "").replaceAll("\t", "");
        assertEquals(excepted, actual);
    }

}