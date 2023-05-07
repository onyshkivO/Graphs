package org.example.lab15;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       List<List<String>> res = NQueens.solveNQueens(4);
       for(List<String> part : res){
           for(String s: part) System.out.println(s);
           System.out.println();
       }
    }






}
