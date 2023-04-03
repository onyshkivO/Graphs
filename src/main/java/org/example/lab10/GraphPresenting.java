package org.example.lab10;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class GraphPresenting {
    private static int[][] weightInt;
    private static String[][] weight;

    private static int vertices;
    private static int edges;


    public static void initGraph(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line != null) {
                vertices = Integer.parseInt(line.split(" ")[0]);
                edges = Integer.parseInt(line.split(" ")[1]);
                weightInt = new int[vertices][vertices];
                weight = new String[vertices][vertices];
                for (int i =0;i<vertices;i++){
                    Arrays.fill(weight[i],"∞");
                }

                for (int i =0;i<vertices;i++){
                    weight[i][i]="0";
                }


            } else {
                System.out.println("empty input file");
                return;
            }
            line = reader.readLine();
            while (line != null) {
                makeWeightMatrix(line);
                line = reader.readLine();
            }
        }
    }

    public static void makeWeightMatrix(String line) {
        int from = Integer.parseInt(line.split(" ")[0]);
        int to = Integer.parseInt(line.split(" ")[1]);
        int lineWeight = Integer.parseInt(line.split(" ")[2]);
        weight[from][to]=String.valueOf(lineWeight);
        weightInt[from][to]=lineWeight;
    }

    public static String weightMatrixToString() {
        StringBuilder result = new StringBuilder();
        result.append("| v\\v |");
        for (int i = 0; i < vertices-1; i++) {
            result.append(String.format(" v%-2d|", i));
        }
        result.append("  v |");
        for (int i = 0; i < weight.length-1; i++) {
            result.append(String.format("\n| v%-2d |", i));
            Arrays.stream(weight[i]).forEach(value -> result.append(String.format(" %2s |", value)));

        }
        result.append("\n|  v  |" );
        Arrays.stream(weight[weight.length-1]).forEach(value -> result.append(String.format(" %2s |", value)));
        return result.toString();
    }






    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input path to file(or name): ");
        String filePath = scanner.nextLine();
        try {
            initGraph(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("incorrect input file");
            throw new RuntimeException(e);
        }
        String fileToSave;
        int menu;
        do {
            System.out.println("Chose operation:");
            System.out.println("1: Print weight matrix into console");
            System.out.println("2: Save weight matrix into file");
            System.out.println("0 : Shutdown");
            System.out.print("Input: ");
            menu=scanner.nextInt();
            switch (menu){
                case 1:
                    printMatrix(weightMatrixToString());
                    break;
                case 2:
                    System.out.print("Input file to save(without .txt): ");
                    scanner.nextLine();
                    fileToSave= scanner.nextLine()+".txt";
                    saveMatrixToFile(weightMatrixToString(),fileToSave);
                    break;
                default: break;
            }
        }while (menu!=0);
    }






    public static void printMatrix(String matrix){
        System.out.println(matrix);
    }
    public static void saveMatrixToFile(String matrix,String filePath){
        try(PrintWriter printWriter = new PrintWriter(filePath)){
            printWriter.println(matrix);
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("Cannot find file to write");
        }

    }



}
