package org.example.lab11;

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
                for (int i = 0; i < vertices; i++) {
                    Arrays.fill(weight[i], "∞");
                    Arrays.fill(weightInt[i], Integer.MAX_VALUE);
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
            for (int i = 0; i < vertices; i++) {
                weight[i][i] = "0";
                weightInt[i][i] = 0;

            }
        }
    }

    public static void makeWeightMatrix(String line) {
        int from = Integer.parseInt(line.split(" ")[0]);
        int to = Integer.parseInt(line.split(" ")[1]);
        int lineWeight = Integer.parseInt(line.split(" ")[2]);
        weight[from][to] = String.valueOf(lineWeight);
       // weight[to][from] = String.valueOf(lineWeight);
        weightInt[from][to] = lineWeight;
        // weightInt[to][from] = lineWeight;
    }

    public static String weightMatrixToString() {
        StringBuilder result = new StringBuilder();
        result.append("| v\\v |");
        for (int i = 0; i < vertices - 1; i++) {
            result.append(String.format(" v%-2d|", i));
        }
        result.append("  v |");
        for (int i = 0; i < weight.length - 1; i++) {
            result.append(String.format("\n| v%-2d |", i));
            Arrays.stream(weight[i]).forEach(value -> result.append(String.format(" %2s |", value)));

        }
        result.append("\n|  v  |");
        Arrays.stream(weight[weight.length - 1]).forEach(value -> result.append(String.format(" %2s |", value)));
        return result.toString();
    }

    public static String minLengthMatrixToString() {
        StringBuilder result = new StringBuilder();
        result.append("| v\\v |");
        for (int i = 0; i < vertices - 1; i++) {
            result.append(String.format(" v%-2d|", i));
        }
        result.append("  v |");
        for (int i = 0; i < weightInt.length - 1; i++) {
            result.append(String.format("\n| v%-2d |", i));
            Arrays.stream(weightInt[i]).forEach(value -> result.append(String.format(" %2d |", value)));

        }
        result.append("\n|  v  |");
        Arrays.stream(weightInt[weightInt.length - 1]).forEach(value -> result.append(String.format(" %2d |", value)));
        return result.toString();
    }


    public static void floyd() {
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (weightInt[i][k] == Integer.MAX_VALUE || weightInt[k][j] == Integer.MAX_VALUE) {
                        weightInt[i][j] = Math.min(weightInt[i][j], Integer.MAX_VALUE);
                    } else
                        weightInt[i][j] = Math.min(weightInt[i][j], weightInt[i][k] + weightInt[k][j]);
                }
            }
        }
    }


    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input path to file(or name): ");
        String filePath = scanner.nextLine();
        try {
            initGraph(filePath);
            floyd();
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
            System.out.println("3: Print min length matrix into console");
            System.out.println("4: Save min length matrix into file");
            System.out.println("5: Show min length between two vertices");
            System.out.println("0 : Shutdown");
            System.out.print("Input: ");
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    printMatrix(weightMatrixToString());
                    break;
                case 2:
                    System.out.print("Input file to save(without .txt): ");
                    scanner.nextLine();
                    fileToSave = scanner.nextLine() + ".txt";
                    saveMatrixToFile(weightMatrixToString(), fileToSave);
                    break;
                case 3:
                    printMatrix(minLengthMatrixToString());
                    break;
                case 4:
                    System.out.print("Input file to save(without .txt): ");
                    scanner.nextLine();
                    fileToSave = scanner.nextLine() + ".txt";
                    saveMatrixToFile(minLengthMatrixToString(), fileToSave);
                    break;
                case 5:
                    System.out.print("Input first vertex: ");
                    scanner.nextLine();
                    String v1 = scanner.nextLine();
                    System.out.print("Input second vertex: ");
                    String v2 = scanner.nextLine();
                    System.out.printf("Length between %s and %s = %d\n",v1,v2,lengthBetweenTwoVertices(v1,v2));
                default:
                    break;
            }
        } while (menu != 0);
    }
    public static int lengthBetweenTwoVertices(String v1,String v2){
        int pos1=v1.equals("v")?10:Integer.parseInt(v1.substring(1));
        int pos2=v2.equals("v")?10:Integer.parseInt(v2.substring(1));
        return weightInt[pos1][pos2];
    }

    public static void printMatrix(String matrix) {
        System.out.println(matrix);
    }

    public static void saveMatrixToFile(String matrix, String filePath) {
        try (PrintWriter printWriter = new PrintWriter(filePath)) {
            printWriter.println(matrix);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Cannot find file to write");
        }

    }


}
