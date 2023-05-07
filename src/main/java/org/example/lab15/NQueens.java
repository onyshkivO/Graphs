package org.example.lab15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] part : board) {
            Arrays.fill(part, '.');
        }
        backtrack(board, 0, res);
        return res;
    }

    public static void backtrack(char[][] board, int col, List<List<String>> res) {
        if (col == board[0].length) {
            List<String> tmp = new ArrayList<>();
            for (char[] part : board) {
                tmp.add(String.valueOf(part));
            }
            res.add(tmp);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, col)) {
                board[i][col] = 'Q';
                backtrack(board, col + 1, res);
                board[i][col] = '.';

            }
        }

    }


    public static boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') return false;
        }
        for (int i = row, j = col; i < board.length && j>-1; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row, j = col; i > -1 && j > -1; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
