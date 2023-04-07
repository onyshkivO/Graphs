package org.example.lab14;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class GraphPresenting {
    private static int[][] incidence;
    private static int[][] adjacency;
    private static int vertices;
    private static int edges;


    public static void initGraph(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line != null) {
                vertices = Integer.parseInt(line.split(" ")[0]);
                edges = Integer.parseInt(line.split(" ")[1]);
                incidence = new int[vertices][edges];
                adjacency = new int[vertices][vertices];
            } else {
                System.out.println("empty input file");
                return;
            }
            int lineNumber = 0;
            line = reader.readLine();
            while (line != null) {
                makeIncidenceMatrix(line, lineNumber);
                makeAdjacencyMatrix(line);
                line = reader.readLine();
                lineNumber++;
            }
        }
    }

    public static void makeIncidenceMatrix(String line, int lineNumber) {
        int from = Integer.parseInt(line.split(" ")[0]);
        int to = Integer.parseInt(line.split(" ")[1]);

        if (from == to) {
            incidence[from - 1][lineNumber] = 2;
        } else {
            incidence[from - 1][lineNumber] = -1;
            incidence[to - 1][lineNumber] = 1;
        }
    }

    public static void makeAdjacencyMatrix(String line) {
        int from = Integer.parseInt(line.split(" ")[0]);
        int to = Integer.parseInt(line.split(" ")[1]);
        adjacency[from - 1][to - 1]++;
    }

    public static String adjacencyMatrixToString() {
        StringBuilder result = new StringBuilder();
        result.append("| v\\v |");
        for (int i = 1; i <= vertices; i++) {
            result.append(String.format(" v%-2d|", i));
        }
        for (int i = 0; i < adjacency.length; i++) {
            result.append(String.format("\n| v%-2d |", i + 1));
            Arrays.stream(adjacency[i]).forEach(value -> result.append(String.format(" %2d |", value)));

        }
        return result.toString();
    }

    public static String incidenceMatrixToString() {
        StringBuilder result = new StringBuilder();
        result.append("| v\\e |");
        for (int i = 1; i <= edges; i++) {
            result.append(String.format(" e%-2d|", i));
        }
        for (int i = 0; i < incidence.length; i++) {
            result.append(String.format("\n| v%-2d |", i + 1));
            Arrays.stream(incidence[i]).forEach(value -> result.append(String.format(" %2d |", value)));
        }
        return result.toString();
    }

    public static boolean isReflex() {
        for (int i = 0; i < vertices; i++) {
            if (adjacency[i][i] != 1) return false;
        }
        return true;
    }

    public static boolean isTransitive() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (adjacency[i][j] == 1) {
                    for (int k = 0; k < vertices; k++) {
                        if (adjacency[j][k] == 1 && adjacency[i][k] != 1) {
                            return false;}
                    }
                }
            }
        }
        return true;
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
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("incorrect input file");
            throw new RuntimeException(e);
        }

        String fileToSave;
        int menu;
        do {
            System.out.println("Chose operation:");
            System.out.println("1: Print adjacency(суміжності) matrix into console");
            System.out.println("2: Check is matrix is reflexive");
            System.out.println("3: Check is matrix is transitive");
            System.out.println("0 : Shutdown");
            System.out.print("Input: ");
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    printMatrix(adjacencyMatrixToString());
                    break;
                case 2:
                    System.out.println(isReflex()?"Yes, matrix is reflexive":"No, matrix is not reflexive");
                    break;
                case 3:
                    System.out.println(isTransitive()?"Yes, matrix is transitive":"No, matrix is not transitive");
                    break;
                default:
                    break;
            }
        } while (menu != 0);
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
