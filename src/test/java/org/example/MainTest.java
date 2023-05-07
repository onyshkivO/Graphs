package org.example;

import org.example.lab15.Main;
import org.example.lab15.NQueens;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;


class MainTest {


    @Test
    void test() {
        List<List<String>>  expected =new ArrayList<>();
        expected.add(List.of("..Q.","Q...","...Q",".Q.."));
        expected.add(List.of(".Q..","...Q","Q...","..Q."));
        assertEquals(expected, NQueens.solveNQueens(4));
    }


}
